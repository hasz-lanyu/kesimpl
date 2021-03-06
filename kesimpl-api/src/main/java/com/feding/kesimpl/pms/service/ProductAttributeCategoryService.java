package com.feding.kesimpl.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.pms.model.ProductAttribute;
import com.feding.kesimpl.pms.model.ProductAttributeCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface ProductAttributeCategoryService extends IService<ProductAttributeCategory> {

    IPage<ProductAttributeCategory> getProductAttributeCategoryPageList(Long pageNum, Long pageSize);
}
