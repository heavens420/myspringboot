package com.zlx.shiro.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.zlx.shiro.bean.Permission;
import com.zlx.shiro.bean.Role;
import com.zlx.shiro.service.PermissionService;
import com.zlx.shiro.service.RoleService;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleService roleService;


    @Resource
    private PermissionService permissionService;

    @RequestMapping("/getrole")
    @ResponseBody
    public Role getRole(@RequestParam(defaultValue = "1") int id){
        return roleService.queryRoleById(id);
    }

    @ResponseBody
    @RequestMapping("getrolelist")
    public List<Role> getRoleList(@RequestParam(defaultValue = "7") int id){
        return roleService.queryRoleListById(id);
    }
    @RequestMapping("permissionList")
    @ResponseBody
    public List<Permission> queryPermissionList(@RequestParam(defaultValue = "1") int id){

        return permissionService.queryPermissionList(id);
    }


}
