package com.feding.kesimpl.cms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.cms.mapper.PrefrenceAreaMapper;
import com.feding.kesimpl.cms.model.PrefrenceArea;
import com.feding.kesimpl.cms.model.PrefrenceAreaProductRelation;
import com.feding.kesimpl.cms.service.PrefrenceAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 优选专区 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class PrefrenceAreaServiceImpl extends ServiceImpl<PrefrenceAreaMapper, PrefrenceArea> implements PrefrenceAreaService {
    private static final Logger log = LoggerFactory.getLogger(PrefrenceAreaServiceImpl.class);
    @Autowired
    private PrefrenceAreaMapper prefrenceAreaMapper;
    @Override
    public List<PrefrenceArea> getPrefrenceAreaList() {
        return prefrenceAreaMapper.selectList(null);
    }


}
