package com.feding.kesimpl.sms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.sms.mapper.FlashPromotionProductRelationMapper;
import com.feding.kesimpl.sms.model.FlashPromotionProductRelation;
import com.feding.kesimpl.sms.service.FlashPromotionProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 商品限时购与商品关系表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class FlashPromotionProductRelationServiceImpl extends ServiceImpl<FlashPromotionProductRelationMapper, FlashPromotionProductRelation> implements FlashPromotionProductRelationService {
    @Autowired
    private FlashPromotionProductRelationMapper flashPromotionProductRelationMapper;

    @Override
    public Boolean addFlashPromotionProductRaltion(FlashPromotionProductRelation flashPromotionProductRelation) {
        return flashPromotionProductRelationMapper.insert(flashPromotionProductRelation) == 1;
    }
}
