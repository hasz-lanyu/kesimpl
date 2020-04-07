package com.feding.kesimpl.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.pms.model.Product;
import com.feding.kesimpl.pms.model.ProductBo;
import com.feding.kesimpl.pms.service.ProductService;
import com.feding.kesimpl.pms.to.ProductPageListParam;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Reference
    private ProductService productService;


    /**
     * 分页查询商品
     *
     * @param productPageListParam
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object pageProductList(ProductPageListParam productPageListParam) {
        IPage<Product> pageProductList = productService.getPageProductList(productPageListParam);
        PageVo<Product> pageVo = new PageVo<>(pageProductList.getCurrent(), pageProductList.getSize(), pageProductList.getTotal(), pageProductList.getRecords());
        return new CommonResult().success(pageVo);
    }

    @RequestMapping("/updateInfo/{productId}")
    public CommonResult productInfo(@PathVariable("productId") Long productId) {
        try {
            Product product = productService.getProductInfoById(productId);
            return new CommonResult().success(product);
        } catch (Exception e) {
            log.debug("商品查询异常id:[{}]错误:{}", productId, e.getMessage());
        }
        return new CommonResult().failed();

    }

    /**
     * 添加商品
     *
     * @param productBo
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object createProduct(@RequestBody ProductBo productBo) {
        productService.addProductInfo(productBo);
        return new CommonResult().success("添加成功");
    }

    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    public Object updateDeleteStatus(@RequestParam("ids") List<Long> ids, Long deleteStatus) {
        log.info("ids长度：{} 元素：{}",ids.size(),ids);
        if (CollectionUtils.isEmpty(ids)) {
            return CommonResult.FAILED;
        }
        Boolean flag = productService.updateDeleteStatus(ids, deleteStatus);

        if (flag) {
            return new CommonResult().success("200");
        }
        return CommonResult.FAILED;
    }


}
