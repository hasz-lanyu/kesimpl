package com.feding.kesimpl.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.cms.model.PrefrenceAreaProductRelation;
import com.feding.kesimpl.cms.model.SubjectProductRelation;
import com.feding.kesimpl.cms.service.PrefrenceAreaProductRelationService;
import com.feding.kesimpl.cms.service.SubjectProductRelationService;
import com.feding.kesimpl.pms.mapper.*;
import com.feding.kesimpl.pms.model.*;
import com.feding.kesimpl.pms.service.ProductService;
import com.feding.kesimpl.pms.to.ProductPageListParam;
import com.feding.kesimpl.sms.model.FlashPromotionProductRelation;
import com.feding.kesimpl.sms.service.FlashPromotionProductRelationService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Transactional(readOnly = true)
@Service
@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MemberPriceMapper memberPriceMapper;

    @Autowired
    private ProductAttributeValueMapper productAttributeValueMapper;

    @Autowired
    private ProductFullReductionMapper productFullReductionMapper;

    @Autowired
    private ProductLadderMapper productLadderMapper;

    @Reference
    private PrefrenceAreaProductRelationService prefrenceAreaProductRelationService;

    @Reference
    private SubjectProductRelationService subjectProductRelationService;

    @Reference
    private FlashPromotionProductRelationService flashPromotionProductRelationService;

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 分页条件查询
     *
     * @param productPageListParam
     * @return
     */
    @Override
    public IPage<Product> getPageProductList(ProductPageListParam productPageListParam) {
        Page<Product> page = new Page<>(productPageListParam.getPageNum(), productPageListParam.getPageSize());
        QueryWrapper<Product> fuzzyWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(productPageListParam.getKeyword())) {
            fuzzyWrapper.like("name", productPageListParam.getKeyword());
        }
        if (StringUtils.isNotBlank(productPageListParam.getBrandId())) {
            fuzzyWrapper.like("brand_id", productPageListParam.getBrandId());
        }
        if (StringUtils.isNotBlank(productPageListParam.getProductSn())) {
            fuzzyWrapper.like("product_sn", productPageListParam.getProductSn());
        }
        if (StringUtils.isNotBlank(productPageListParam.getPublishStatus())) {
            fuzzyWrapper.like("publish_Status", productPageListParam.getPublishStatus());
        }
        if (StringUtils.isNotBlank(productPageListParam.getVerifyStatus())) {
            fuzzyWrapper.like("verify_status", productPageListParam.getVerifyStatus());
        }
        if (StringUtils.isNotBlank(productPageListParam.getProductCategoryId())) {
            fuzzyWrapper.like("product_category_id", productPageListParam.getProductCategoryId());
        }
        return productMapper.selectPage(page, fuzzyWrapper);
    }

    /**
     * 根据商品id查询商品信息
     *
     * @param productId 商品id
     * @return 商品信息
     */
    @Override
    public Product getProductInfoById(Long productId) {
        return productMapper.selectById(productId);
    }


    /**
     * 商品添加
     *
     * @param productBo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void addProductInfo(ProductBo productBo) {
        ProductServiceImpl productServiceProxy = (ProductServiceImpl) AopContext.currentProxy();
        //添加商品基础属性
        Product product = new Product();
        BeanUtils.copyProperties(productBo, product);
        productServiceProxy.addProductBase(product);
        //添加会员价格
        try {
            productServiceProxy.addMemberPrice(productBo.getMemeberPriceList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //添加sku规格参数
            productServiceProxy.addProductAttributeValue(productBo.getProductAttributeValueList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //促销-满减
            productServiceProxy.addProductFullReduction(productBo.getProductFullReductionList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //满足-打折
            productServiceProxy.addProductLadder(productBo.getProductLadderList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //sku库存预警
            //关联优选 (专题 微服务调用)
            productServiceProxy.addPrefrenceAreaProductRelation(productBo.getPrefrenceAreaProductRelationList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //关联主题(专题 微服务调用)
            productServiceProxy.addSubjectProductRelation(productBo.getSubjectProductRelationList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //限购
            FlashPromotionProductRelation flashPromotionProductRelation = new FlashPromotionProductRelation();
            BeanUtils.copyProperties(productBo, flashPromotionProductRelation);
            productServiceProxy.addFlashPromotionProductRelation(flashPromotionProductRelation);
        } catch (BeansException e) {
            e.printStackTrace();
        }

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addFlashPromotionProductRelation(FlashPromotionProductRelation flashPromotionProductRelation) {
        flashPromotionProductRelationService.addFlashPromotionProductRaltion(flashPromotionProductRelation);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addSubjectProductRelation(List<SubjectProductRelation> subjectProductRelations) {
        if (!CollectionUtils.isEmpty(subjectProductRelations)) {
            for (SubjectProductRelation subjectProductRelation : subjectProductRelations) {
                subjectProductRelation.setId(threadLocal.get());
                this.subjectProductRelationService.addSubjectProductRelation(subjectProductRelation);
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPrefrenceAreaProductRelation(List<PrefrenceAreaProductRelation> prefrenceAreaProductRelations) {
        if (!CollectionUtils.isEmpty(prefrenceAreaProductRelations)) {
            prefrenceAreaProductRelations.forEach(prefrenceAreaProductRelation -> {
                prefrenceAreaProductRelation.setProductId(threadLocal.get());
                prefrenceAreaProductRelationService.addPrefrenceAreaRelation(prefrenceAreaProductRelation);
            });
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addProductLadder(List<ProductLadder> productLadders) {
        if (!CollectionUtils.isEmpty(productLadders)) {
            productLadders.forEach(productLadder -> {
                productLadder.setProductId(threadLocal.get());
                productLadderMapper.insert(productLadder);
            });
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addProductFullReduction(List<ProductFullReduction> productFullReductions) {
        if (!CollectionUtils.isEmpty(productFullReductions)) {
            productFullReductions.forEach(productFullReduction -> {
                productFullReduction.setProductId(threadLocal.get());
                productFullReductionMapper.insert(productFullReduction);
            });
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addProductAttributeValue(List<ProductAttributeValue> productAttributeValues) {
        if (!CollectionUtils.isEmpty(productAttributeValues)) {
            productAttributeValues.forEach(productAttributeValue -> {
                productAttributeValue.setProductId(threadLocal.get());
                productAttributeValueMapper.insert(productAttributeValue);
            });
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addMemberPrice(List<MemberPrice> memberPrices) {
        if (!CollectionUtils.isEmpty(memberPrices)) {
            for (MemberPrice memberPrice : memberPrices) {
                memberPrice.setProductId(threadLocal.get());
                memberPriceMapper.insert(memberPrice);
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addProductBase(Product product) {
        //添加sku基础属性
        productMapper.insert(product);
        Long productId = product.getId();
        threadLocal.set(productId);

    }

    @Transactional
    @Override
    public Boolean updateDeleteStatus(List<Long> ids, Long deleteStatus) {
        int result = 0;
        for (Long id : ids) {
            UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", id).set("delete_status", deleteStatus);
            productMapper.update(null, updateWrapper);
            result++;
        }

        return result == ids.size();
    }
}
