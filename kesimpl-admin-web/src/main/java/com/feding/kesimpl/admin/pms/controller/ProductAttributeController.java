package com.feding.kesimpl.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.pms.model.ProductAttribute;
import com.feding.kesimpl.pms.service.ProductAttributeService;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/productAttribute")
public class ProductAttributeController {
    private static final Logger log = LoggerFactory.getLogger(ProductAttributeController.class);
    @Reference
    private ProductAttributeService productAttributeService;

    @RequestMapping(value = "/list/{productAttributeCategoryId}",method = RequestMethod.GET)
    public Object productAttributePageList(@PathVariable("productAttributeCategoryId") Long productAttributeCategoryId,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10") Long pageSize,
                                           @RequestParam(value = "type", required = true) Long type) {
        try {
            IPage<ProductAttribute> productAttributeIPage = productAttributeService.getProductAttributePageList(productAttributeCategoryId, pageNum, pageSize, type);
            PageVo<ProductAttribute> pageVo = new PageVo<>(productAttributeIPage.getCurrent(), productAttributeIPage.getSize(), productAttributeIPage.getTotal(), productAttributeIPage.getRecords());
            return  new CommonResult().success(pageVo);
        } catch (Exception e) {
            log.error("商品分页查询异常={}",e.getMessage());
        }
        return CommonResult.FAILED;

    }
}
