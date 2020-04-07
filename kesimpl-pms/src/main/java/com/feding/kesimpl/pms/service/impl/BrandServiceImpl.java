package com.feding.kesimpl.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.pms.mapper.BrandMapper;
import com.feding.kesimpl.pms.model.Brand;
import com.feding.kesimpl.pms.service.BrandService;
import com.feding.kesimpl.pms.to.BrandPageListParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 品牌分页查询
     * keyword:查询条件
     * @param brandPageListParam
     * @return
     */
    @Override
    public IPage<Brand> getBrandPageList(BrandPageListParam brandPageListParam) {
        Page<Brand> page =new Page<>(brandPageListParam.getPageNum(),brandPageListParam.getPageSize());
        QueryWrapper<Brand> fuzzyWrapper = null;
        if (StringUtils.isNotBlank(brandPageListParam.getKeyword())){
            fuzzyWrapper = new QueryWrapper<>();
            fuzzyWrapper.like("name",brandPageListParam.getKeyword());
        }
        return brandMapper.selectPage(page,fuzzyWrapper);
    }
}
