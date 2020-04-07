package com.feding.kesimpl.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.pms.mapper.ProductAttributeCategoryMapper;
import com.feding.kesimpl.pms.model.ProductAttribute;
import com.feding.kesimpl.pms.model.ProductAttributeCategory;
import com.feding.kesimpl.pms.service.ProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory> implements ProductAttributeCategoryService {
    @Autowired
    private ProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Override
    public IPage<ProductAttributeCategory> getProductAttributeCategoryPageList(Long pageNum, Long pageSize) {
        Page<ProductAttributeCategory> page = new Page<>(pageNum,pageSize);
        return productAttributeCategoryMapper.selectPage(page,null);
    }
}
