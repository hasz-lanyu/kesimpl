package com.feding.kesimpl.pms.mapper;

import com.feding.kesimpl.pms.model.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 *
 */

public interface ProductMapper extends BaseMapper<Product> {

}
