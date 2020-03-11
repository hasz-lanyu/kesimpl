package com.feding.kesimpl.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.sms.mapper.CouponHistoryMapper;
import com.feding.kesimpl.sms.model.CouponHistory;
import com.feding.kesimpl.sms.service.CouponHistoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券使用、领取历史表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistory> implements CouponHistoryService {

}
