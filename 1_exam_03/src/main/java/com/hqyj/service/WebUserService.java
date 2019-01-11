package com.hqyj.service;

import java.util.List;
import java.util.Set;

import com.hqyj.pojo.WebUser;

/**  
* Title: LoginUserService.java 
* Description: 
* Copyright: Copyright (c) 2018    
* @author zhh  
* @date 2019年1月2日  
* @version 1.0  
*/
public interface WebUserService {
	public WebUser findByNameAndPwd(String username,String password);


	public List<WebUser> queryAllUser();

}
