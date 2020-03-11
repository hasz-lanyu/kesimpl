package com.feding.kesimpl.oms.service.impl;

import com.feding.kesimpl.oms.model.CartItem;
import com.feding.kesimpl.oms.mapper.CartItemMapper;
import com.feding.kesimpl.oms.service.CartItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

}
