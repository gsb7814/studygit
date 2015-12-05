package com.sxmccitlab.pcash.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Object staff = ActionContext.getContext().getSession().get("staff");
		if ( staff != null ) {
			System.out.println("login scceeded!"+staff);
			return invocation.invoke();
		}
		ActionContext.getContext().getSession().put("message", "请登录后使用本系统！");
		System.out.println("login failed!");
		return "login";
	}

}
