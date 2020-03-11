package com.feding.kesimpl.ums.service.impl;

import com.feding.kesimpl.ums.model.AdminPermissionRelation;
import com.feding.kesimpl.ums.mapper.AdminPermissionRelationMapper;
import com.feding.kesimpl.ums.service.AdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class AdminPermissionRelationServiceImpl extends ServiceImpl<AdminPermissionRelationMapper, AdminPermissionRelation> implements AdminPermissionRelationService {

}
