package com.feding.kesimpl.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.oms.mapper.OrderSettingMapper;
import com.feding.kesimpl.oms.model.OrderSetting;
import com.feding.kesimpl.oms.service.OrderSettingService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单设置表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements OrderSettingService {

}
