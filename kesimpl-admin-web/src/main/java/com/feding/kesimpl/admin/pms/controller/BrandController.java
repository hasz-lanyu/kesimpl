package com.feding.kesimpl.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.pms.model.Brand;
import com.feding.kesimpl.pms.service.BrandService;
import com.feding.kesimpl.pms.to.BrandPageListParam;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/brand")
public class BrandController {
    private static final Logger log = LoggerFactory.getLogger(BrandController.class);
    @Reference
    private BrandService brandService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult brandPageList(BrandPageListParam brandPageListParam) {
        try {
            IPage<Brand> brandPageList =brandService.getBrandPageList(brandPageListParam);
            PageVo<Brand> brandPageVo = new PageVo<>(brandPageList.getCurrent(),brandPageList.getSize(),brandPageList.getTotal(),brandPageList.getRecords());
            return new CommonResult().success(brandPageVo);
        } catch (Exception e) {
            log.error("远程调用失败=[{}]",e.getMessage());
        }
        return new CommonResult().failed();

    }
}
