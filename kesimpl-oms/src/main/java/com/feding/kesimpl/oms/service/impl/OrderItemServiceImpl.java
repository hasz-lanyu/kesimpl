package com.feding.kesimpl.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.oms.mapper.OrderItemMapper;
import com.feding.kesimpl.oms.model.OrderItem;
import com.feding.kesimpl.oms.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
