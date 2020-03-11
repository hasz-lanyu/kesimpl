package com.feding.kesimpl.ums.service.impl;

import com.feding.kesimpl.ums.model.Admin;
import com.feding.kesimpl.ums.mapper.AdminMapper;
import com.feding.kesimpl.ums.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
