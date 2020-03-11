package com.feding.kesimpl.pms.service.impl;

import com.feding.kesimpl.pms.model.ProductLadder;
import com.feding.kesimpl.pms.mapper.ProductLadderMapper;
import com.feding.kesimpl.pms.service.ProductLadderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品) 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class ProductLadderServiceImpl extends ServiceImpl<ProductLadderMapper, ProductLadder> implements ProductLadderService {

}
