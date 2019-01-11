package com.hqyj.action;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.pojo.WebUser;
import com.hqyj.service.WebUserService;

import utils.MyToken;

/**
 * Title: LoginAction.java Description: Copyright: Copyright (c) 2018
 * 
 * @author zhh
 * @date 2019年1月2日
 * @version 1.0
 */
@Controller
@RequestMapping("/WebUserAction")
public class WebUserAction {

	@Autowired
	private WebUserService service;

	@RequestMapping("/domain")
	public String domain() {
		return "web/main";
	}

	public static void main(String[] args) {
		// 加密算法
		// 原始密码
		// 盐值
		// 加密次数
		System.out.println(new SimpleHash("MD5", "111", "lyk", 1024));
	}

	@RequestMapping("/dologin")
	@ResponseBody
	public String dologin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {

		Subject currentUser = SecurityUtils.getSubject();
		// 登录逻辑
		// 是否被登录过
		if (!currentUser.isAuthenticated()) {
			// UsernamePasswordToken用于存放当前的账号和密码

			MyToken token = new MyToken(username, password,"webUser");
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				WebUser user = service.findByNameAndPwd(username, password);
				model.addAttribute("user", user);
			} catch (AuthenticationException ae) {
				request.setAttribute("message", "用户名或密码错误，请重新登陆");
				return "fail";
			}
		}
		return "success";
	}

}
