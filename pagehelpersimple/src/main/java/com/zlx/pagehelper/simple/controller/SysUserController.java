package com.zlx.pagehelper.simple.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlx.pagehelper.simple.model.SysUser;
import com.zlx.pagehelper.simple.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping(value = "all",produces = {"application/json;charset=utf-8"})
    public List<SysUser> queryAll(){
        return sysUserService.queryAll();
    }

    @GetMapping(value = "list",produces = {"application/json;charset=utf-8"})
    public PageInfo<SysUser> findPage(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "3") int pageSize){
//        PageHelper.startPage(pageNum,pageSize);
        PageInfo<SysUser> list = sysUserService.getPage(pageNum,pageSize);
        return list;
    }
}
