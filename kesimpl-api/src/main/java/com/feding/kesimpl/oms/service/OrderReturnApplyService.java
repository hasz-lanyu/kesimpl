package com.feding.kesimpl.oms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.oms.model.OrderReturnApply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feding.kesimpl.oms.vo.OrderReturnApplyParamVo;

/**
 * <p>
 * 订单退货申请 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface OrderReturnApplyService extends IService<OrderReturnApply> {

    IPage<OrderReturnApply> getOrderReturnApplyPageList(OrderReturnApplyParamVo orderReturnApplyParamVo);
}
