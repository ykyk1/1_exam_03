package com.hqyj.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.hqyj.pojo.WebUser;

public interface WebUserDao {
	public WebUser findbynameandpwd(@Param("username")String username,
			@Param("password")String password);


	public List<WebUser> queryAllUser();
}
