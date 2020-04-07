package com.feding.kesimpl.cms.service;

import com.feding.kesimpl.cms.model.PrefrenceArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feding.kesimpl.cms.model.PrefrenceAreaProductRelation;

import java.util.List;

/**
 * <p>
 * 优选专区 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface PrefrenceAreaService extends IService<PrefrenceArea> {

    List<PrefrenceArea> getPrefrenceAreaList();


}
