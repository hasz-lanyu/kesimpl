package com.feding.kesimpl.oms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.oms.model.OrderReturnReason;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 退货原因表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface OrderReturnReasonService extends IService<OrderReturnReason> {

    IPage<OrderReturnReason> getOrderReturnReasonPageList(Long pageNum, Long pageSize);
}
