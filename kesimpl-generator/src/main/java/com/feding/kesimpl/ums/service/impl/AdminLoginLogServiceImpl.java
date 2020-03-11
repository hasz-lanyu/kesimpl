package com.feding.kesimpl.ums.service.impl;

import com.feding.kesimpl.ums.model.AdminLoginLog;
import com.feding.kesimpl.ums.mapper.AdminLoginLogMapper;
import com.feding.kesimpl.ums.service.AdminLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class AdminLoginLogServiceImpl extends ServiceImpl<AdminLoginLogMapper, AdminLoginLog> implements AdminLoginLogService {

}
