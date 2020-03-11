package com.feding.kesimpl.ums.service.impl;

import com.feding.kesimpl.ums.model.Role;
import com.feding.kesimpl.ums.mapper.RoleMapper;
import com.feding.kesimpl.ums.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
