package com.feding.kesimpl.oms.service;

import com.feding.kesimpl.oms.model.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单中所包含的商品 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface OrderItemService extends IService<OrderItem> {

    List<OrderItem> getOrderItemListByOrderId(Long orderId);
}
