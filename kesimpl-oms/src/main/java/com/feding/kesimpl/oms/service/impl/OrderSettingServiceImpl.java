package com.feding.kesimpl.oms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.oms.mapper.OrderSettingMapper;
import com.feding.kesimpl.oms.model.OrderSetting;
import com.feding.kesimpl.oms.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 订单设置表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Transactional(readOnly = true)
@Service
@Component
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements OrderSettingService {
    @Autowired
    private OrderSettingMapper orderSettingMapper;

    @Override
    public OrderSetting getOrderSettingById(Long id) {
        return orderSettingMapper.selectById(id);
    }

    @Transactional
    @Override
    public boolean updateOrderSettingById(Long id, OrderSetting orderSetting) {
        return orderSettingMapper.updateById(orderSetting) == 1;
    }
}
