package com.feding.kesimpl.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.pms.model.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feding.kesimpl.pms.model.ProductBo;
import com.feding.kesimpl.pms.to.ProductPageListParam;

import java.util.List;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface ProductService extends IService<Product> {

    IPage<Product> getPageProductList(ProductPageListParam productPageListParam);

    Product getProductInfoById(Long productId);

    void addProductInfo(ProductBo productBo);

    Boolean updateDeleteStatus(List<Long> ids, Long deleteStatus);
}
