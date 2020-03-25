package com.zlx.pagehelper.mapper;

import com.zlx.pagehelper.model.SysUser;
import com.zlx.pagehelper.util.PageRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysUserMapper {

    List<SysUser> selectAll();

    List<SysUser> selectPage(PageRequest pageRequest);
}
