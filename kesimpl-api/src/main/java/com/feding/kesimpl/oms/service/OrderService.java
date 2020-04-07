package com.feding.kesimpl.oms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.oms.model.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feding.kesimpl.oms.vo.OrderSearchParamVo;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface OrderService extends IService<Order> {

    IPage<Order> getOrderPageList(OrderSearchParamVo orderSearchParamVo);

}
