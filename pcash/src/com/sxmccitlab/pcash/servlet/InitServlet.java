package com.sxmccitlab.pcash.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sxmccitlab.common.PcashConstants;

import com.sxmccitlab.pcash.dao.impl.AccountTypeDAO;
import com.sxmccitlab.pcash.dao.impl.RegionDAO;
import com.sxmccitlab.pcash.dao.impl.RoleDAO;
import com.sxmccitlab.pcash.dao.impl.UnitDAO;
import com.sxmccitlab.pcash.dao.impl.VoucherTypeDAO;

public class InitServlet extends HttpServlet {
	private Log log= LogFactory.getLog(getClass());
	
	/**
	 * Constructor of the object.
	 */
	public InitServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		log.info("InitServlet load...");
		ServletContext sc = getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		initGlobalData(ac);
		//Service1 service = (Service1) ac.getBean("yourServiceId");
		//List list = service.getList();
	}
	
	private void initGlobalData(WebApplicationContext webAppContext) {
		//初始化AccountType列表
		AccountTypeDAO accountTypeDAO = (AccountTypeDAO)webAppContext.getBean("accountTypeDAO");
		List accountTypeList = accountTypeDAO.query(PcashConstants.INIT_ACCOUNT_TYPES_HQL);
		getServletContext().setAttribute(PcashConstants.GLOBAL_ACCOUNT_TYPES, accountTypeList);
		log.info("************加载AccountType列表成功，长度：" + accountTypeList.size());
		
		//初始化VoucherType列表
		VoucherTypeDAO voucherTypeDAO = (VoucherTypeDAO)webAppContext.getBean("voucherTypeDAO");
		List voucherTypeList = voucherTypeDAO.query(PcashConstants.INIT_VOUCHER_TYPES_HQL);
		getServletContext().setAttribute(PcashConstants.GLOBAL_VOUCHER_TYPES, voucherTypeList);
		log.info("************加载VoucherType列表成功，长度：" + voucherTypeList.size());
		
		//初始化Unit列表
		UnitDAO unitDAO = (UnitDAO)webAppContext.getBean("unitDAO");
		List unitList = unitDAO.query(PcashConstants.INIT_UNITS_HQL);
		getServletContext().setAttribute(PcashConstants.GLOBAL_UNITS, unitList);
		log.info("************加载Unit列表成功，长度：" + unitList.size());
		
		//初始化Region列表
		RegionDAO regionDAO = (RegionDAO)webAppContext.getBean("regionDAO");
		List regionList = voucherTypeDAO.query(PcashConstants.INIT_REGIONS_HQL);
		getServletContext().setAttribute(PcashConstants.GLOBAL_REGIONS, regionList);
		log.info("************加载Region列表成功，长度：" + regionList.size());
		
		//初始化Role列表
		RoleDAO roleDAO = (RoleDAO)webAppContext.getBean("roleDAO");
		List roleList = voucherTypeDAO.query(PcashConstants.INIT_ROLES_HQL);
		getServletContext().setAttribute(PcashConstants.GLOBAL_ROLES, roleList);
		log.info("************加载Role列表成功，长度：" + roleList.size());
		
		
		
	}
}
