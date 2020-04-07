package com.feding.kesimpl.admin.oms.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.oms.model.OrderReturnReason;
import com.feding.kesimpl.oms.service.OrderReturnReasonService;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@RequestMapping("/returnReason")
@CrossOrigin
public class OmsOrderReturnReasonController {
        private static final Logger log = LoggerFactory.getLogger(OmsOrderReturnReasonController.class);
    @Reference
    private OrderReturnReasonService orderReturnReasonService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object orderReturnReasonPageList(@RequestParam(value = "pageNum" ,defaultValue = "1") Long pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "5") Long pageSize){
       IPage<OrderReturnReason> pages = orderReturnReasonService.getOrderReturnReasonPageList(pageNum,pageSize);
       return new CommonResult().success(new PageVo<OrderReturnReason>(pages.getCurrent(),pages.getSize(),pages.getTotal(),pages.getRecords()));
    }

}
