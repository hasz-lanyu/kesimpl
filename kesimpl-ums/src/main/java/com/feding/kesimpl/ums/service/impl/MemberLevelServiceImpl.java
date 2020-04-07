package com.feding.kesimpl.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.ums.mapper.MemberLevelMapper;
import com.feding.kesimpl.ums.model.MemberLevel;
import com.feding.kesimpl.ums.service.MemberLevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements MemberLevelService {
    private static final Logger log = LoggerFactory.getLogger(MemberLevelServiceImpl.class);

    @Autowired
    private MemberLevelMapper memberLevelMapper;

    @Override
    public List<MemberLevel> getMemberLevelByDefaultStatus(Long defaultStatus) {
        QueryWrapper<MemberLevel> wrapper = new QueryWrapper<>();
        wrapper.eq("default_status", defaultStatus);
        return memberLevelMapper.selectList(wrapper);
    }
}
