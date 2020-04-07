package com.feding.kesimpl.oms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.oms.mapper.OrderOperateHistoryMapper;
import com.feding.kesimpl.oms.model.OrderOperateHistory;
import com.feding.kesimpl.oms.service.OrderOperateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 订单操作历史记录 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory> implements OrderOperateHistoryService {
    @Autowired
    private OrderOperateHistoryMapper orderOperateHistoryMapper;

    @Override
    public List<OrderOperateHistory> getOrderOperateHistoryListByOrderId(Long orderId) {
        return orderOperateHistoryMapper.selectList(new QueryWrapper<OrderOperateHistory>().eq("order_id", orderId));
    }
}
