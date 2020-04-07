package com.feding.kesimpl.cms.service;

import com.feding.kesimpl.cms.model.PrefrenceAreaProductRelation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 优选专区和产品关系表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface PrefrenceAreaProductRelationService extends IService<PrefrenceAreaProductRelation> {

    Boolean addPrefrenceAreaRelation(PrefrenceAreaProductRelation newPrefrenceAreaProductRelation);
}
