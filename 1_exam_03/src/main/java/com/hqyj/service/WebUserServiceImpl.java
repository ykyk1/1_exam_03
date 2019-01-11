package com.hqyj.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.dao.WebUserDao;
import com.hqyj.pojo.WebUser;

/**  
* Title: LoginUserServiceImpl.java 
* Description: 
* Copyright: Copyright (c) 2018    
* @author zhh  
* @date 2019年1月2日  
* @version 1.0  
*/
@Service
public class WebUserServiceImpl implements WebUserService {
	@Autowired
	private WebUserDao dao;
	
	
	/**
	 * 实现用户查询，判断是否存在该账号
	 * 存在返回为真
	 */
	@Transactional
	public WebUser findByNameAndPwd(String username, String password) {
		return dao.findbynameandpwd(username, password);
	}




	@Override
	public List<WebUser> queryAllUser() {
		return dao.queryAllUser();
	}

}
