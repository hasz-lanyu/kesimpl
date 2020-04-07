package com.feding.kesimpl.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.cms.mapper.SubjectMapper;
import com.feding.kesimpl.cms.model.Subject;
import com.feding.kesimpl.cms.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 专题表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Autowired
    private  SubjectMapper subjectMapper;
    @Override
    public List<Subject> getSubjectList() {
        return subjectMapper.selectList(null);
    }
}
