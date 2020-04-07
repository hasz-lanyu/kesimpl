package com.feding.kesimpl.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.pms.model.ProductAttributeCategory;
import com.feding.kesimpl.pms.service.ProductAttributeCategoryService;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/productAttribute")
public class ProductAttributeCategoryController {
    private static final Logger log = LoggerFactory.getLogger(ProductAttributeCategoryController.class);
    @Reference
    private ProductAttributeCategoryService productAttributeCategoryService;

    @RequestMapping("/category/list")
    public Object productAttributeCategoryPageList(@RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
                                                   @RequestParam(value = "pageSize", defaultValue = "10") Long pageSize) {
        try {
            IPage<ProductAttributeCategory> iPage = productAttributeCategoryService.getProductAttributeCategoryPageList(pageNum, pageSize);
            PageVo<ProductAttributeCategory> productAttributeCategoryPageVo =new PageVo<>(iPage.getCurrent(),iPage.getSize(),iPage.getTotal(),iPage.getRecords());
            return new CommonResult().success(productAttributeCategoryPageVo);
        } catch (Exception e) {
            log.error("分页查询失败：",e.getMessage());
        }
        return  CommonResult.FAILED ;
    }
}
