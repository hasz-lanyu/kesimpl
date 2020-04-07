package com.feding.kesimpl.admin.oms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.admin.oms.vo.OrderDetailVo;
import com.feding.kesimpl.admin.pms.vo.PageVo;
import com.feding.kesimpl.oms.model.Order;
import com.feding.kesimpl.oms.model.OrderItem;
import com.feding.kesimpl.oms.model.OrderOperateHistory;
import com.feding.kesimpl.oms.service.OrderItemService;
import com.feding.kesimpl.oms.service.OrderOperateHistoryService;
import com.feding.kesimpl.oms.service.OrderService;
import com.feding.kesimpl.oms.vo.OrderSearchParamVo;
import com.feding.kesimpl.to.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OmsOrderController {
    private static final Logger log = LoggerFactory.getLogger(OmsOrderController.class);
    @Reference
    private OrderService orderService;
    @Reference
    private OrderItemService orderItemService;

    @Reference
    private OrderOperateHistoryService orderOperateHistoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object orderPageList(OrderSearchParamVo orderSearchParamVo) {
        IPage<Order> orderPages = orderService.getOrderPageList(orderSearchParamVo);
        PageVo<Order> pageVo = new PageVo<Order>(orderPages.getCurrent(), orderPages.getSize(), orderPages.getTotal(), orderPages.getRecords());
        return new CommonResult().success(pageVo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getOrder(@PathVariable("id") Long id) {
        Order order = orderService.getById(id);
        Long orderId = order.getId();
        List<OrderItem> orderItemList = orderItemService.getOrderItemListByOrderId(orderId);
        List<OrderOperateHistory> orderOperateHistoryList =orderOperateHistoryService.getOrderOperateHistoryListByOrderId(orderId);
        OrderDetailVo detailVo = new OrderDetailVo(orderItemList,orderOperateHistoryList);
        BeanUtils.copyProperties(order,detailVo);
        return new CommonResult().success(detailVo);

    }
}
