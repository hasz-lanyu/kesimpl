package com.feding.kesimpl.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.pms.mapper.ProductAttributeMapper;
import com.feding.kesimpl.pms.model.ProductAttribute;
import com.feding.kesimpl.pms.service.ProductAttributeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute> implements ProductAttributeService {

}
