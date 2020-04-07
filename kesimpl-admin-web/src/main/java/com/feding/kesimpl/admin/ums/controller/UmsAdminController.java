package com.feding.kesimpl.admin.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.feding.kesimpl.admin.ums.vo.UmsAdminLoginParam;

import com.feding.kesimpl.admin.ums.vo.UmsAdminParam;
import com.feding.kesimpl.admin.utils.JwtTokenUtil;
import com.feding.kesimpl.to.CommonResult;
import com.feding.kesimpl.ums.model.Admin;
import com.feding.kesimpl.ums.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台用户管理
 * Created by atguigu 4/26.
 */
@CrossOrigin
@Controller
@Api(tags = "AdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    private static final Logger log = LoggerFactory.getLogger(UmsAdminController.class);

    @Reference
    private AdminService adminService;
    @Value("${kesimpl.jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${kesimpl.jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody @Valid UmsAdminParam umsAdminParam, BindingResult result) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(umsAdminParam,admin);
        Boolean isSuccess = adminService.userRegister(admin);

        return new CommonResult().success(admin);

    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody @Valid UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        Admin admin = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        String token = jwtTokenUtil.generateToken(admin);
        if (StringUtils.isBlank(token)) {
            log.debug("账号或密码有误==[{}]", token);
        }
        Map<String, String> data = new HashMap();
        data.put("token", token);
        data.put("tokenHead", tokenHead);
        return new CommonResult().success(data);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
    @ResponseBody
    public Object refreshToken(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader);
        if (StringUtils.isBlank(token)) {
            return new CommonResult().validateFailed("登录已过时");
        }
        boolean flag = jwtTokenUtil.canRefresh(token);
        if (flag) {
            String newToken = jwtTokenUtil.refreshToken(token.substring(tokenHead.length()));
            if (StringUtils.isNotBlank(newToken)) {
                Map<String, String> tokenMap = new HashMap<>();
                tokenMap.put("tokenHead", this.tokenHead);
                tokenMap.put("token", newToken);
                return new CommonResult().success(tokenMap);
            }
        }
        return new CommonResult().failed();
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public Object getAdminInfo(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader);
        if (StringUtils.isBlank(token)){
            return new CommonResult().validateFailed("登录已过期");
        }
        String username = jwtTokenUtil.getUserNameFromToken(token.substring(tokenHead.length()));
        if (StringUtils.isNotBlank(username)){
            Admin admin = adminService.getUserInfo(username);
            Map<String, Object> data = new HashMap<>();
            data.put("username", admin.getUsername());
            data.put("roles", new String[]{"TEST"});
            data.put("icon", admin.getIcon());
            return new CommonResult().success(data);
        }
        log.debug("token解析失败=[{}]",username);
        return new CommonResult().failed();
    }
/*
    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Object logout() {
        //TODO 用户退出

        return new CommonResult().success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        //TODO 分页查询用户信息

        //TODO 响应需要包含分页信息；详细查看swagger规定
        return new CommonResult().failed();
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object getItem(@PathVariable Long id){

        //TODO 获取指定用户信息
        return new CommonResult().failed();
    }

    @ApiOperation("更新指定用户信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable Long id,@RequestBody Admin admin){

        //TODO 更新指定用户信息
        return new CommonResult().failed();
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@PathVariable Long id){
        //TODO 删除指定用户信息
        return new CommonResult().failed();
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateRole(@RequestParam("adminId") Long adminId,
                             @RequestParam("roleIds") List<Long> roleIds){
        //TODO 给用户分配角色
        return new CommonResult().failed();
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}",method = RequestMethod.GET)
    @ResponseBody
    public Object getRoleList(@PathVariable Long adminId){
        //TODO 获取指定用户的角色

        return new CommonResult().success(null);
    }

    @ApiOperation("给用户分配(增减)权限")
    @RequestMapping(value = "/permission/update",method = RequestMethod.POST)
    @ResponseBody
    public Object updatePermission(@RequestParam Long adminId,
                                   @RequestParam("permissionIds") List<Long> permissionIds){
        //TODO 给用户分配(增减)权限

        return new CommonResult().failed();
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}",method = RequestMethod.GET)
    @ResponseBody
    public Object getPermissionList(@PathVariable Long adminId){
        //TODO 获取用户所有权限（包括+-权限）
        return new CommonResult().failed();
    }*/
}
