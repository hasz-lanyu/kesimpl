package com.feding.kesimpl.admin.oms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.feding.kesimpl.oms.model.CompanyAddress;
import com.feding.kesimpl.oms.service.CompanyAddressService;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RestController
@CrossOrigin
@RequestMapping("companyAddress")
public class OmsCompanyAddressController {
    private static final Logger log = LoggerFactory.getLogger(OmsCompanyAddressController.class);

    @Reference
    private CompanyAddressService companyAddressService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object CompanyAddressList(){
       List<CompanyAddress> result = companyAddressService.getCompanyAddressList();
       return new CommonResult().success(result);
    }
}
