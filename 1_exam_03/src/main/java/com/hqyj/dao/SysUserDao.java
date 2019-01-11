package com.hqyj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.pojo.SysUser;

public interface SysUserDao {
	public SysUser findbynameandpwd(@Param("username")String username,
			@Param("password")String password);


	public List<SysUser> queryAllUser();
}
