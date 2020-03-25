package com.zlx.shiro.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.zlx.shiro.bean.Permission;
import com.zlx.shiro.bean.Role;
import com.zlx.shiro.bean.User;
import com.zlx.shiro.service.PermissionService;
import com.zlx.shiro.service.RoleService;
import com.zlx.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("执行授权逻辑");

        User user = (User)SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        //获取当前登录用户的所有角色 一用户可多角色
        List<Role> roles = roleService.queryRoleListById(user.getId());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRole(role.get(0).getName());
        roles.stream().forEach(role -> {
            //添加角色名称
            simpleAuthorizationInfo.addRole(role.getName());
            System.out.println(role.getName());
        });
        //查询当前登录用户所有角色的权限
        List<Permission> permissions = permissionService.queryPermissionList(user.getId());
        permissions.stream().forEach(permission -> {
            //添加权限名称
            simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
            System.out.println(permission.getPermissionName());
        });
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("执行认证逻辑");

        //获取controller得到的用户 此用户是currentUser.login(token)
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        System.out.println(usernamePasswordToken.getUsername()+":"+usernamePasswordToken.getPassword());
//        String name = "hh";
//        String password = "888";

        User user = userService.queryUserByName(usernamePasswordToken.getUsername());
        if(user == null){
            return null;//触发UnknownAccountExceeption
        }

        //把phone当密码 验证密码
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("",user.getPassword(),"");

        System.out.println("password:"+user.getPassword());
        System.out.println(user);
        return simpleAuthenticationInfo;
    }
}
