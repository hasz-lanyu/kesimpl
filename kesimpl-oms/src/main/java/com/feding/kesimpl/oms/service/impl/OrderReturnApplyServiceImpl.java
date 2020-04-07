package com.feding.kesimpl.oms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.constant.GlobalConst;
import com.feding.kesimpl.oms.mapper.OrderReturnApplyMapper;
import com.feding.kesimpl.oms.model.OrderReturnApply;
import com.feding.kesimpl.oms.service.OrderReturnApplyService;
import com.feding.kesimpl.oms.vo.OrderReturnApplyParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 订单退货申请 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyMapper, OrderReturnApply> implements OrderReturnApplyService {
    @Autowired
    private OrderReturnApplyMapper orderReturnApplyMapper;

    @Override
    public IPage<OrderReturnApply> getOrderReturnApplyPageList(OrderReturnApplyParamVo orderReturnApplyParamVo) {
        Page<OrderReturnApply> page = new Page<>(orderReturnApplyParamVo.getPageNum(), orderReturnApplyParamVo.getPageSize());
        QueryWrapper<OrderReturnApply> wrapper = new QueryWrapper<OrderReturnApply>();
        if (orderReturnApplyParamVo.getCreateTime() != null && !GlobalConst.SPACE.equals(orderReturnApplyParamVo.getCreateTime())) {
            wrapper.like("create_time", orderReturnApplyParamVo.getCreateTime());
        }
        if (orderReturnApplyParamVo.getHandleMan() != null && !GlobalConst.SPACE.equals(orderReturnApplyParamVo.getHandleMan())) {
            wrapper.like("handle_man", orderReturnApplyParamVo.getHandleMan());
        }
        if (orderReturnApplyParamVo.getHandleTime() != null && !GlobalConst.SPACE.equals(orderReturnApplyParamVo.getHandleTime())) {
            wrapper.like("handle_time", orderReturnApplyParamVo.getHandleTime());
        }
        if (orderReturnApplyParamVo.getId() != null && !GlobalConst.SPACE.equals(orderReturnApplyParamVo.getId())) {
            wrapper.like("order_id",orderReturnApplyParamVo.getId());
        }
        if (orderReturnApplyParamVo.getStatus()!=null &&!GlobalConst.SPACE.equals(orderReturnApplyParamVo.getStatus())){
            wrapper.like("status",orderReturnApplyParamVo.getStatus());
        }
        return orderReturnApplyMapper.selectPage(page,wrapper);
    }
}
