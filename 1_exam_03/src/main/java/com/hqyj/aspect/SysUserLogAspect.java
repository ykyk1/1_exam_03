package com.hqyj.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hqyj.dao.SysUserLogDao;
import com.hqyj.pojo.SysUserLog;
import com.hqyj.service.SysUserService;

@Component
@Aspect
public class SysUserLogAspect {

	@Resource
	private SysUserLogDao logDao;

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
	private Executor doLogThread = Executors.newSingleThreadExecutor();

	@AfterReturning(value = "execution(* com.hqyj.service.SysUserService.permitLogin(..))", returning = "r")
	public void doLog(JoinPoint jp,String r) {
		if (SysUserService.SUCCESS.equals(r)) {
			Object[] args = jp.getArgs();
			if (args[0] instanceof HttpServletRequest) {
				HttpServletRequest request = (HttpServletRequest) args[0];
				String username = request.getParameter("username");
				String address = request.getRemoteAddr();
				SysUserLog sul = new SysUserLog();
				sul.setSysUserLogId(UUID.randomUUID().toString());
				sul.setSysUsername(username);
				Date date = new Date();
				sul.setSysUserLoginDate(sdf.format(date));
				sul.setSysUserAddress(address);
				doLogThread.execute(() -> {
					logDao.insertSysUserLog(sul);

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
		}
	}

}
