package com.feding.kesimpl.ums.service;

import com.feding.kesimpl.ums.model.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author hasz
 * @since 2020-03-11
 */
public interface AdminService extends IService<Admin> {

    Admin login(String username, String password);

    Admin getUserInfo(String username);


    Boolean userRegister(Admin admin);
}
