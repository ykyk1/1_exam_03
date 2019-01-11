package com.hqyj.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqyj.pojo.SysUser;
import com.hqyj.pojo.WebUser;
import com.hqyj.service.SysUserService;
import com.hqyj.service.WebUserService;

import utils.MyToken;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private WebUserService webUserService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.
	 * shiro.subject.PrincipalCollection)
	 */
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String username = (String) principals.getPrimaryPrincipal();
//
//		Set<String> roles = new HashSet<>();
//
//		Set<UserRole> userRoles = service.findRoleByUsername(username);
//		Set<String> permissions = new HashSet<>();
//		for (UserRole role : userRoles) {
//			roles.add(role.getRole_name());
//
////			if (role.getRole_name().equals("admin")) {
////				permissions.add("user:create");
////			}
////			permissions.add("user:delete");
//		}
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
////		info.addStringPermissions(permissions);
//
//		return info;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache
	 * .shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 实现数据库查询
		MyToken t = (MyToken) token;

		String pwd = new SimpleHash("MD5", t.getPassword(), t.getUsername(), 1024).toString();
		if (t.getType() == "sysUser") {
			SysUser user = sysUserService.findByNameAndPwd(t.getUsername(), pwd);
			if (user != null) {// 用户名密码正确
				AuthenticationInfo info = new SimpleAuthenticationInfo(t.getUsername(), t.getPassword(), getName());
				return info;
			} else {// 用户名或密码错误
				throw new AuthenticationException();
			}
		}
		if (t.getType() == "webUser") {
			WebUser user = webUserService.findByNameAndPwd(t.getUsername(), pwd);
			if (user != null) {// 用户名密码正确
				AuthenticationInfo info = new SimpleAuthenticationInfo(t.getUsername(), t.getPassword(), getName());
				return info;
			} else {// 用户名或密码错误
				throw new AuthenticationException();
			}
		}
		return null;

	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}
