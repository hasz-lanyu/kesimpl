package com.feding.kesimpl.admin.oms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.oms.model.OrderReturnApply;
import com.feding.kesimpl.oms.service.OrderReturnApplyService;
import com.feding.kesimpl.oms.vo.OrderReturnApplyParamVo;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@CrossOrigin
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {
    private static final Logger log = LoggerFactory.getLogger(OmsOrderReturnApplyController.class);
    @Reference
    private OrderReturnApplyService orderReturnApplyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object orderReturnApplyPageList( OrderReturnApplyParamVo orderReturnApplyParamVo) {
        IPage<OrderReturnApply> pages = orderReturnApplyService.getOrderReturnApplyPageList(orderReturnApplyParamVo);
        return new CommonResult().success(new PageVo<OrderReturnApply>(pages.getCurrent(), pages.getSize(), pages.getTotal(), pages.getRecords()));
    }
    @RequestMapping("/{id}")
    public Object getOrderReturnApply(@PathVariable("id")Long id){
        OrderReturnApply byId = orderReturnApplyService.getById(id);
        return new CommonResult().success(byId);
    }
}
