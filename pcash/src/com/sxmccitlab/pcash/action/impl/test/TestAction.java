package com.sxmccitlab.pcash.action.impl.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sxmccitlab.pcash.dao.IRegionDAO;
import com.sxmccitlab.pcash.po.Region;
public class TestAction extends ActionSupport {
	Log log = LogFactory.getLog(getClass());
	private static final long serialVersionUID = 5812031073419318214L;
	private IRegionDAO regionDAO;
	
	public IRegionDAO getRegionDAO() {
		return regionDAO;
	}

	public void setRegionDAO(IRegionDAO regionDAO) {
		this.regionDAO = regionDAO;
	}

	public String add(){
		Region region = new Region("01","太原分公司",null);
		regionDAO.add(region);
		log.info("*********测试添加Region成功！");
		return "success";
	}

}
