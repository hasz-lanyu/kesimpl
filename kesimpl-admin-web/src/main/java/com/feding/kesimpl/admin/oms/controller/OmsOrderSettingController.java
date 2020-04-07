package com.feding.kesimpl.admin.oms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.feding.kesimpl.oms.model.OrderSetting;
import com.feding.kesimpl.oms.service.OrderSettingService;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RestController
@RequestMapping("/orderSetting")
@CrossOrigin
public class OmsOrderSettingController {
    private static final Logger log = LoggerFactory.getLogger(OmsOrderSettingController.class);

    @Reference
    private OrderSettingService orderSettingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOrderSetting(@PathVariable("id") Long id) {
        OrderSetting orderSetting = orderSettingService.getOrderSettingById(id);
        return new CommonResult().success(orderSetting);

    }

    @RequestMapping("/update/{id}")
    public Object updateOrderSetting(@PathVariable("id") Long id, @RequestBody OrderSetting orderSetting) {

        boolean flag = orderSettingService.updateOrderSettingById(id, orderSetting);
        if (flag){
            return CommonResult.FAILED;
        }


        return CommonResult.SUCCESS;
    }

}
