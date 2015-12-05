package com.sxmccitlab.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.sxmccitlab.pcash.po.Menu;

@SuppressWarnings("unchecked")
public class MenuComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		Menu menu1 = (Menu)o1;
		Menu menu2 = (Menu)o2;
		char [] padding = "0000".toCharArray();
		String s1 = StringUtils.rPad(menu1.getMenuCode().trim(), padding, 4);
		String s2 = StringUtils.rPad(menu2.getMenuCode().trim(), padding, 4);
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);
		if ( num1 < num2) {
			return -1;
		} else if ( num1 == num2) {
			return 0;
		}
		return 1;
	}
	
	public static void main(String args[]) {
		ArrayList menuList = new ArrayList();
		
		menuList.add(new Menu("0202", "m2-2", "#", 5L));
		menuList.add(new Menu("04", "m4", "#", 6L));
		menuList.add(new Menu("0401", "m4-1", "#", 7L));
		
		menuList.add(new Menu("01", "m1", "#", 1L));
		menuList.add(new Menu("0102", "m1-2", "#", 3L));
		menuList.add(new Menu("0101", "m1-1", "#", 2L));

		menuList.add(new Menu("02", "m2", "#", 4L));
		
		Collections.sort(menuList, new MenuComparator());
		for (Iterator iter2 = menuList.iterator(); iter2.hasNext();) {
			Menu menu = (Menu)iter2.next();
			System.out.println("menu:" + menu.getMenuCode() + ":" + menu.getMenuName()+ ":" + menu.getId());
		}
		
	}
	
	
}