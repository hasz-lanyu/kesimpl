package com.feding.kesimpl.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.pms.mapper.ProductCategoryMapper;
import com.feding.kesimpl.pms.model.ProductCategory;
import com.feding.kesimpl.pms.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 查询所有分类 不含父子组合
     *
     * @return
     */
    @Override
    public List<ProductCategory> getProductCategoryList() {
        return productCategoryMapper.selectList(null);
    }

    /**
     * 分页分类
     * @param id 父类id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public IPage<ProductCategory> getProductCategoryPageList(Long id, Long pageNum, Long pageSize) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        return productCategoryMapper.selectPage(new Page<ProductCategory>(pageNum, pageSize), wrapper);
    }
}
