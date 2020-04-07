package com.feding.kesimpl.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feding.kesimpl.ums.mapper.AdminMapper;
import com.feding.kesimpl.ums.model.Admin;
import com.feding.kesimpl.ums.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.lang.model.element.VariableElement;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
@Service
@Component
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin login(String username, String password) {
        String encodingPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<Admin>();
        adminQueryWrapper.eq("username", username).eq("password", encodingPassword);
        Admin admin = adminMapper.selectOne(adminQueryWrapper);
        if (admin != null &&
                username.equals(admin.getUsername()) &&
                encodingPassword.equals(admin.getPassword())) {
            admin.setLoginTime(new Date());
            adminMapper.updateById(admin);
            return admin;
        }

        return null;
    }

    @Override
    public Admin getUserInfo(String username) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<Admin>();
        adminQueryWrapper.eq("username", username);
        return adminMapper.selectOne(adminQueryWrapper);
    }

    @Override
    public Boolean userRegister(Admin admin) {
        admin.setCreateTime(new Date());
        admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        return adminMapper.updateById(admin) == 1 ? true : false;
    }


}
