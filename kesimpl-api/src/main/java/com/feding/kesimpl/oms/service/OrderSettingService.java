package com.feding.kesimpl.oms.service;

import com.feding.kesimpl.oms.model.OrderSetting;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单设置表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface OrderSettingService extends IService<OrderSetting> {

    OrderSetting getOrderSettingById(Long id);

    boolean updateOrderSettingById(Long id, OrderSetting orderSetting);
}
