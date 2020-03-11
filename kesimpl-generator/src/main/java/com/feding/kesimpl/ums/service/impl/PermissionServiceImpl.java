package com.feding.kesimpl.ums.service.impl;

import com.feding.kesimpl.ums.model.Permission;
import com.feding.kesimpl.ums.mapper.PermissionMapper;
import com.feding.kesimpl.ums.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
