package com.feding.kesimpl.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.pms.model.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    List<ProductCategory> getProductCategoryList();

    IPage<ProductCategory> getProductCategoryPageList(Long id ,Long pageNum, Long pageSize);
}
