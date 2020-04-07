package com.feding.kesimpl.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.pms.model.ProductCategory;
import com.feding.kesimpl.pms.service.ProductCategoryService;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
    private static final Logger log = LoggerFactory.getLogger(ProductCategoryController.class);

    @Reference
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    public CommonResult productCategoryList() {
        List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList();
        //分类结果集
        List<ProductCategory> result = new ArrayList<>();
        //一级分类
        Map<Long, ProductCategory> fistLevel = new HashMap<>();
        //二级分类
        Map<Long, ProductCategory> secondLevel = new HashMap<>();

/*        productCategoryList.forEach(productCategory -> {
            if (productCategory.getParentId() == 0) {
                fistLevel.put(productCategory.getId(), productCategory);
                result.add(productCategory);
            }
        });
        productCategoryList.forEach(fistCategory -> {
            if (fistCategory.getParentId() != 0) {
                ProductCategory productCategory = fistLevel.get(fistCategory.getParentId());
                if (productCategory!=null){
                    productCategory.getChildren().add(fistCategory);
                }

                productCategoryList.forEach(secondCategory -> {
                    if (secondCategory.getParentId().equals(fistCategory.getId())){
                        fistCategory.getChildren().add(secondCategory);

                    }

                });

            }
        });*/


        for (ProductCategory productCategory : productCategoryList) {
            if (productCategory.getLevel() == 0) {
                fistLevel.put(productCategory.getId(), productCategory);
                result.add(productCategory);
            }
            if (productCategory.getLevel() == 1) {
                secondLevel.put(productCategory.getId(), productCategory);
            }
        }

        for (ProductCategory productCategory : productCategoryList) {
            switch (productCategory.getLevel()) {
                case 1:
                    ProductCategory fistCategory = fistLevel.get(productCategory.getParentId());
                    if (fistCategory != null) {
                        fistCategory.getChildren().add(productCategory);
                        break;
                    }
                case 2:
                    ProductCategory secondCategory = secondLevel.get(productCategory.getParentId());
                    if (secondCategory != null) {
                        secondCategory.getChildren().add(productCategory);
                        break;
                    }

            }
        }
        return new CommonResult().success(result);

    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public Object productCategoryPageList(@PathVariable("id")Long id,
                                          @RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "5") Long pageSize) {
        IPage<ProductCategory> pages = this.productCategoryService.getProductCategoryPageList(id,pageNum, pageSize);
        PageVo<ProductCategory> pageVo = new PageVo<>(pages.getCurrent(), pages.getSize(), pages.getTotal(), pages.getRecords());
        return new CommonResult().success(pageVo);


    }

}
