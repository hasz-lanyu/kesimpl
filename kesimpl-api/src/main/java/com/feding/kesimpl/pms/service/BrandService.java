package com.feding.kesimpl.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.feding.kesimpl.pms.model.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feding.kesimpl.pms.to.BrandPageListParam;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface BrandService extends IService<Brand> {

    IPage<Brand> getBrandPageList(BrandPageListParam brandPageListParam);
}
