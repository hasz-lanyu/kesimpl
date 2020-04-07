package com.feding.kesimpl.oms.service;

import com.feding.kesimpl.oms.model.OrderOperateHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单操作历史记录 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistory> {

    List<OrderOperateHistory> getOrderOperateHistoryListByOrderId(Long orderId);
}
