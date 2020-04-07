package com.feding.kesimpl.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.pms.mapper.ProductAttributeMapper;
import com.feding.kesimpl.pms.model.ProductAttribute;
import com.feding.kesimpl.pms.service.ProductAttributeService;
import net.bytebuddy.description.modifier.ParameterManifestation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements ProductAttributeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductAttributeServiceImpl.class);
    @Autowired
    private ProductAttributeMapper productAttributeMapper;


    @Override
    public IPage<ProductAttribute> getProductAttributePageList(Long productAttributeCategoryId, Long pageNum, Long pageSize, Long type) {
        Page<ProductAttribute> page = new Page<>(pageNum,pageSize);
        QueryWrapper<ProductAttribute> wrapper = new QueryWrapper<>();
        Map<String,Object> params = new HashMap<>();
        params.put("product_attribute_category_id",productAttributeCategoryId);
        params.put("type",type);
       /* wrapper.eq("type",type);
        wrapper.eq("type",type);*/
       wrapper.allEq(params);
        return productAttributeMapper.selectPage(page,wrapper);
    }
}
