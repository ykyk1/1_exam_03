package com.hqyj.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.dao.SysUserDao;
import com.hqyj.pojo.SysUser;

import utils.MyToken;

/**  
* Title: LoginUserServiceImpl.java 
* Description: 
* Copyright: Copyright (c) 2018    
* @author zhh  
* @date 2019年1月2日  
* @version 1.0  
*/
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao dao;
	
	
	/**
	 * 实现用户查询，判断是否存在该账号
	 * 存在返回为真
	 */
	@Transactional
	public SysUser findByNameAndPwd(String username, String password) {
		return dao.findbynameandpwd(username, password);
	}

	@Override
	public List<SysUser> queryAllUser() {
		return dao.queryAllUser();
	}

	@Override
	public String permitLogin(HttpServletRequest request) {
		
			String code = request.getSession().getAttribute("code").toString();
			if (code.equalsIgnoreCase(request.getParameter("piccode"))) {
				Subject currentUser = SecurityUtils.getSubject();
				// 登录逻辑
				if (!currentUser.isAuthenticated()) {
					// 是否被登录过
					// UsernamePasswordToken用于存放当前的账号和密码
					MyToken token = new MyToken(request.getParameter("username"),request.getParameter("password") ,"sysUser");
					token.setRememberMe(true);
					try {
						// 执行登录逻辑
						currentUser.login(token);
					}
					// ... catch more exceptions here (maybe custom ones specific to your
					// application?
					catch (AuthenticationException ae) {
						// unexpected condition? error?
						return "fail";
					}
				}
				// 登录
				return "success";
			} else {
				return "error";
			}
	}

}
