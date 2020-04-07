package com.feding.kesimpl.oms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.oms.mapper.OrderReturnReasonMapper;
import com.feding.kesimpl.oms.model.OrderReturnReason;
import com.feding.kesimpl.oms.service.OrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 退货原因表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReason> implements OrderReturnReasonService {
    @Autowired
    private OrderReturnReasonMapper orderReturnReasonMapper;

    @Override
    public IPage<OrderReturnReason> getOrderReturnReasonPageList(Long pageNum, Long pageSize) {
        Page<OrderReturnReason> page = new Page<>(pageNum,pageSize);
        return orderReturnReasonMapper.selectPage(page,null);
    }
}
