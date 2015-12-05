package com.sxmccitlab.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetUtils {

	/**
	 * 求两个Set的并集
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static Set union(Set set1, Set set2) {
		if ((set1 == null || set1.size() == 0)
				&& (set1 == null || set1.size() == 0)) {
			return null;
		}
		Set set = new HashSet();
		if (set2 != null) {
			set.addAll(set1);
		}

		if (set2 != null) {
			set.addAll(set2);
		}
		return set;
	}

	/**
	 * 求两个Set的交集
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static Set intersect(Set set1, Set set2) {
		if ((set1 == null || set1.size() == 0)
				&& (set1 == null || set1.size() == 0)) {
			return null;
		}
		Set<Object> set = new HashSet<Object>();
		Iterator iter = set1.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (set2.contains(obj)) {
				set.add(obj);
			}
		}
		return set;
	}

	/**
	 * 求两个Set的差集
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public static Set minus(Set set1, Set set2) {
		if ((set1 == null || set1.size() == 0)
				&& (set1 == null || set1.size() == 0)) {
			return null;
		}
		Set<Object> set = new HashSet<Object>();
		Iterator iter = set1.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (!set2.contains(obj)) {
				set.add(obj);
			}
		}
		
		iter = set2.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (!set1.contains(obj)) {
				set.add(obj);
			}
		}
		return set;
	}

	public static void main(String[] args) {

		Set set1 = new HashSet();
		set1.add("hello");
		set1.add(123);
		set1.add("hello");
		set1.add("world");

		Set set2 = new HashSet();
		set2.add("hello2");
		set2.add(123);
		set2.add("hello");
		set2.add("world2");

		Iterator iter = set1.iterator();
		System.out.print("set1: ");
		while (iter.hasNext()) {
			System.out.print( iter.next() + ",");
		}
		System.out.println();
		
		iter = set2.iterator();
		System.out.print("set2: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + ",");
		}
		System.out.println();
		
		Set set = union(set1, set2);
		iter = set.iterator();
		System.out.print("set1 union set2: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + ",");
		}
		System.out.println();
		
		set = intersect(set1,set2);
		iter = set.iterator();
		System.out.print("set1 intersect set2: " );
		while (iter.hasNext()) {
			System.out.print(iter.next() + ",");
		}
		System.out.println();
		
		set = minus(set1,set2);
		iter = set.iterator();
		System.out.print("set1 minus set2:");
		while (iter.hasNext()) {
			System.out.print(iter.next() + ",");
		}
	}
}
