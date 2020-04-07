package com.feding.kesimpl.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.cms.mapper.SubjectProductRelationMapper;
import com.feding.kesimpl.cms.model.SubjectProductRelation;
import com.feding.kesimpl.cms.service.SubjectProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 专题商品关系表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class SubjectProductRelationServiceImpl extends ServiceImpl<SubjectProductRelationMapper, SubjectProductRelation> implements SubjectProductRelationService {
    @Autowired
    private SubjectProductRelationMapper subjectProductRelationMapper;

    @Override
    public Boolean addSubjectProductRelation(SubjectProductRelation newSubjectProductRelation) {
        return subjectProductRelationMapper.insert(newSubjectProductRelation) == 1 ? true : false;
    }
}
