package com.feding.kesimpl.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.pms.model.ProductAttribute;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface ProductAttributeService extends IService<ProductAttribute> {

    IPage<ProductAttribute> getProductAttributePageList(Long productAttributeCategoryId, Long pageNum, Long pageSize, Long type);
}
