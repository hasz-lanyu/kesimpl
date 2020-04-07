package com.feding.kesimpl.oms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.constant.GlobalConst;
import com.feding.kesimpl.oms.mapper.OrderMapper;
import com.feding.kesimpl.oms.model.Order;
import com.feding.kesimpl.oms.service.OrderService;
import com.feding.kesimpl.oms.vo.OrderSearchParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public IPage<Order> getOrderPageList(OrderSearchParamVo orderSearchParamVo) {
        Page<Order> orderPage = new Page<>(orderSearchParamVo.getPageNum(), orderSearchParamVo.getPageSize());
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        if (orderSearchParamVo.getCreateTime() != null && !GlobalConst.SPACE.equals(orderSearchParamVo.getCreateTime())) {
            wrapper.like("create_time", orderSearchParamVo.getCreateTime());
        }
        if (orderSearchParamVo.getOrderType() != null) {
            wrapper.like("order_type", orderSearchParamVo.getOrderType());
        }
        if (orderSearchParamVo.getOrderSn() != null && !GlobalConst.SPACE.equals(orderSearchParamVo.getOrderSn())) {
            wrapper.like("order_sn", orderSearchParamVo.getOrderSn());
        }
        if (orderSearchParamVo.getReceiverKeyword() != null&& !GlobalConst.SPACE.equals(orderSearchParamVo.getReceiverKeyword())) {
            wrapper.like("receiver_name", orderSearchParamVo.getReceiverKeyword())
                    .or().
                    like("receiver_phone", orderSearchParamVo.getReceiverKeyword());
        }
        if (orderSearchParamVo.getSourceType() != null) {
            wrapper.like("source_type", orderSearchParamVo.getSourceType());
        }
        if (orderSearchParamVo.getStatus() != null) {
            wrapper.like("status", orderSearchParamVo.getStatus());
        }
        return orderMapper.selectPage(orderPage, wrapper);
    }
}
