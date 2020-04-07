package com.feding.kesimpl.admin.oms.vo;

import com.feding.kesimpl.oms.model.Order;
import com.feding.kesimpl.oms.model.OrderItem;
import com.feding.kesimpl.oms.model.OrderOperateHistory;

import java.util.List;

public class OrderDetailVo extends Order{
    private static final long serialVersionUID = 5462761015328378920L;
    private List<OrderItem> orderItemList;
    private List<OrderOperateHistory> historyList;

    public OrderDetailVo(List<OrderItem> orderItemList, List<OrderOperateHistory> historyList) {
        this.orderItemList = orderItemList;
        this.historyList = historyList;
    }

    public OrderDetailVo() {

    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<OrderOperateHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<OrderOperateHistory> historyList) {
        this.historyList = historyList;
    }
}
