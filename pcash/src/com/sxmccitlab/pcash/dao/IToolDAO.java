package com.sxmccitlab.pcash.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;

import com.sxmccitlab.common.PaginationSupport;



public interface IToolDAO {
	
	/**
	 * ����һ��sql����޸�һ������ 
	 * @param sql
	 * @return int
	 */
	public int updateObject(String sql);
	
	/**
	 * ����һ������
	 * @param object
	 */
	public void saveObject(Object object);
	
	/**
	 * ��������L����O
	 * @param l ��������ΪLong
	 * @param object
	 * @return
	 * @throws DataAccessException
	 */
	public Object getObjectFromKey(Long l,Object o) throws DataAccessException;  

	/**
	 * ɾ��һ������
	 * @param object
	 */
	public void deleteObject(Object object);
	
	/**
	 * �޸�һ������
	 * @param object
	 */
	public void updateObject(Object object);
	public int updateObject1(String sql);
	
	/* ��ҳ��ѯ����
	 * @param detachedCriteria ��ѯ����
	 * @param pageSize         ÿҳ�ļ�¼��
	 * @param startIndex       ��ʼ����
	 * @return ��ҳ����PaginationSupport
	 */
	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int startIndex, final int pageSize) ;
	public PaginationSupport findPageByHql(final String hql, final int startIndex, final int pageSize);
	
	/**
	 * ����sql���ȡ�õ�һ���ֶ�ֵ
	 * @param sql
	 * @return
	 */
	public String getStr(final String sql);
	
	/**
	 * �õ�ϵͳ��ǰʱ��
	 * @return
	 */
	public Date getCurrentSystemDate();	
	
	public List callProc(final String proName,final List inArgs,final List outArgs);
	//ִ��HQL��ѯ���
	public List queryHqlStringSearch(String strHql);
//	ִ��SQL��ѯ���
	public List querySQLStringSearch(final String strSql);
//	ִ��SQL��ѯ��ɾ�����
	public int updateSQLString(final String strSql);
	
	public PaginationSupport findPageBySql(final String sql0,final String sql, final int startIndex, final int pageSize);

}
