package com.sxmccitlab.pcash.action.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sxmccitlab.common.MenuComparator;
import com.sxmccitlab.common.PcashConstants;
import com.sxmccitlab.pcash.action.IStaffAction;
import com.sxmccitlab.pcash.bo.IStaffBO;
import com.sxmccitlab.pcash.po.Menu;
import com.sxmccitlab.pcash.po.Right;
import com.sxmccitlab.pcash.po.Role;
import com.sxmccitlab.pcash.po.Staff;

public class StaffAction extends ActionSupport implements IStaffAction {
	private Log log = LogFactory.getLog(getClass());
	private IStaffBO staffBO;
	private Staff staff;
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		this.clearActionErrors();
		this.clearFieldErrors();
		super.validate();
		if ( "".equals(staff.getStaffCode()) ) {
						
			this.addFieldError("msg.staffCode", "�������빤�ţ�");
		}
		
		if ( "".equals(staff.getPassword()) ) {
			
			this.addFieldError("msg.password", "�����������룡");
		}
		
		if ( ! staff.getStaffCode().matches("41[0-9]{6}") ) {
			this.addFieldError("msg.staffCode", "�����StaffCode��ʽ����ȷ��");
		}
	}
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String addStaff() {
		staffBO.add(staff);
		return "success";
	}

	public IStaffBO getStaffBO() {
		return staffBO;
	}

	public void setStaffBO(IStaffBO staffBO) {
		this.staffBO = staffBO;
	}

	public String login() {
		
		Staff staff2 = null;
		if ( (staff2=staffBO.login(staff)) != null ) {
			this.addActionMessage("��¼�ɹ���");
			ActionContext.getContext().getSession().put("staff", staff2);
			
			Set <Role> roles;
			Set <Right> rights = new HashSet<Right>();
			Set <Menu> menus = new HashSet<Menu>();
			
			roles = staff2.getRoles();
			java.util.Iterator<Role> iter1 = roles.iterator();
			java.util.Iterator<Right> iter2;

			while (iter1.hasNext()) {
				Role role = iter1.next();
				System.out.println(role.getRoleName());

				iter2 = role.getRights().iterator();
				while (iter2.hasNext()) {
					Right right = iter2.next();
					Menu menu = right.getMenu();
					rights.add(right);
					menus.add(menu);
					//System.out.println("menu:" + menu.getMenuCode() + ":" + menu.getMenuName());
				}
			}
			
			Iterator iter = menus.iterator();
			while (iter.hasNext()) {
				Menu menu = (Menu)iter.next();
				log.info("menu:" + menu.getMenuCode() + ":" + menu.getMenuName());
			}
			
			//�Բ˵�����
			ArrayList menuList = (ArrayList)this.sortMenus(menus);
			
			//�����в˵��һ���˵�����
			ArrayList list = (ArrayList) this.extraLayeredMenus(menuList);
			/*
			//��ȡһ���˵��Ͷ����˵����ֱ����topMenus��MenuList��
			ArrayList topMenus = (ArrayList)this.sublayerMenus(menuList);
			*/
			
			
			ActionContext.getContext().getSession().put("roles", roles);
			ActionContext.getContext().getSession().put("rights", rights);
			ActionContext.getContext().getSession().put("menus", list);
			//ActionContext.getContext().getSession().put("subMenus", menuList);
			
			log.info("big list: " + list.size());
			//log.info("staffName = " + ((Staff)ActionContext.getContext().getSession().get("staff")).getStaffName());
			/*
			List accountTypeList = (List)ActionContext.getContext().getApplication().get(PcashConstants.GLOBAL_ACCOUNT_TYPES);
			List voucherTypeList = (List)ActionContext.getContext().getApplication().get(PcashConstants.GLOBAL_VOUCHER_TYPES);
			log.info("********ȡAccountType�б�ɹ������ȣ�" + accountTypeList.size());
			log.info("********ȡVoucherType�б�ɹ������ȣ�" + voucherTypeList.size());
			*/
			return "success";
		}
		this.addActionError("��¼ʧ�ܣ��û��������벻��ȷ!");
		return "input";
	}

	public String logout() {
		Map session = ActionContext.getContext().getSession();
		if (session != null) {
			session.clear();
		}
		
		return "login";
	}

	public String register() {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateStaff() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private List sortMenus(Set menus) {
		if (menus == null || menus.size() == 0) {
			return null;
		}
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		Iterator iter = menus.iterator();
		while (iter.hasNext()) {
			Menu menu = (Menu)iter.next();
			list.add(menu);
			//System.out.println("menu:" + menu.getMenuCode() + ":" + menu.getMenuName()+ ":" + menu.getId());
		}
		Collections.sort(list, new MenuComparator());
		for (Iterator iter2 = list.iterator(); iter2.hasNext();) {
			Menu menu = (Menu)iter2.next();
			log.info("menu:" + menu.getMenuCode() + ":" + menu.getMenuName()+ ":" + menu.getId());
		}
		return list;
	}
	
	private List<Menu> sublayerMenus(List<Menu> menus) {
		if (menus == null || menus.size() == 0) {
			return null;
		}
		
		ArrayList<Menu> topMenus = new ArrayList<Menu>();
		for (Iterator iter2 = menus.iterator(); iter2.hasNext();) {
			Menu menu = (Menu)iter2.next();
			if (menu.getMenuCode().trim().length() == 2) {
				topMenus.add(menu);
				//menus.remove(menu);
			}
			log.info("menu:" + menu.getMenuCode() + ":" + menu.getMenuName()+ ":" + menu.getId());
		}
		menus.removeAll(topMenus);
		return topMenus;
	}
	
	/**
	 * �����в˵��һ���˵����࣬������������ж����˵��б���List��ʽ����
	 * @param menus
	 * @return
	 */
	private List<List> extraLayeredMenus(List<Menu> menus) {
		if (menus == null || menus.size() == 0) {
			return null;
		}
		//���ڴ�Ű�һ���˵�����Ķ����˵��б�
		ArrayList list = new ArrayList();
		
		ArrayList<Menu> mList = new ArrayList<Menu>();
		for (Iterator iter1 = menus.iterator(); iter1.hasNext();) {
			Menu menu = (Menu) iter1.next();
			//mList.add(menu);
			if (menu.getMenuCode().trim().length() == 2) {
				if (mList != null && mList.size()>0) {
					list.add(mList);
					mList = new ArrayList<Menu>();
				}
			}
			mList.add(menu);
		}
		log.info("���ڴ�Ű�һ���˵�����Ķ����˵��б�: " + list.size());
		for (Iterator iter1 = list.iterator(); iter1.hasNext();) {
			for (Iterator iter2 = ((List)iter1.next()).iterator(); iter2.hasNext();) {
				Menu m = (Menu) iter2.next();
				log.info("Menu:"+ m.getMenuCode() + "," + m.getMenuName());
			}
				
		}
		return list;
	}
}
