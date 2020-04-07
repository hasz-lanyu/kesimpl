package com.feding.kesimpl.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.cms.mapper.PrefrenceAreaProductRelationMapper;
import com.feding.kesimpl.cms.model.PrefrenceAreaProductRelation;
import com.feding.kesimpl.cms.service.PrefrenceAreaProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优选专区和产品关系表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@com.alibaba.dubbo.config.annotation.Service
@Component
public class PrefrenceAreaProductRelationServiceImpl extends ServiceImpl<PrefrenceAreaProductRelationMapper, PrefrenceAreaProductRelation> implements PrefrenceAreaProductRelationService {
    @Autowired
    private PrefrenceAreaProductRelationMapper prefrenceAreaProductRelationMapper;

    @Override
    public Boolean addPrefrenceAreaRelation(PrefrenceAreaProductRelation newPrefrenceAreaProductRelation) {
        return prefrenceAreaProductRelationMapper.insert(newPrefrenceAreaProductRelation) == 1 ? true : false;
    }
}
