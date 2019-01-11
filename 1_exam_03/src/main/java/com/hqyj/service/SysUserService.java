package com.hqyj.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hqyj.pojo.SysUser;

/**  
* Title: LoginUserService.java 
* Description: 
* Copyright: Copyright (c) 2018    
* @author zhh  
* @date 2019年1月2日  
* @version 1.0  
*/
public interface SysUserService {
	
	public static final String SUCCESS = "success";
	public SysUser findByNameAndPwd(String username,String password);

	public List<SysUser> queryAllUser();
	
	public String permitLogin(HttpServletRequest request);

}
