package com.sxmccitlab.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.sxmccitlab.common.exception.DBException;
import com.sxmccitlab.common.pagehandle.PaginationSupport;

/**
 * ͨ��IDAO�ӿ�
 * 
 * @author Bob Guo
 * 
 */
public interface ICommonDAO {

	public Integer genSequence(String seqName) throws DBException;

	/**
	 * ����POJO����
	 */
	public void save(Object o);

	public Object saveObject(Object o);

	/**
	 * ����POJO����
	 */
	public void create(Object o);

	/**
	 * ɾ��POJO����
	 */
	public void delete(Object o);

	public void deleteALL(List o);

	/**
	 * ��ѯPOJO����
	 */
	public Object retrive(Class clazz, Serializable id);

	/**
	 * ��ѯPOJO����s
	 */
	public List retriveAll(Class clazz);

	/**
	 * ����������ѯPOJO����s
	 */
	public List retriveByFilter(String filter);

	/**
	 * ����POJO����
	 */
	public void update(Object o);

	/**
	 * ����POJO����s
	 */
	public void updateAll(List objs);

	/**
	 * ����SQL��ѯ�����
	 * 
	 * @param resultSQL
	 *            SQL���
	 * @throws DBException
	 * 
	 *             ���ݿ���ʴ���ʱ�׳�
	 */
	public int queryCount(String sql) throws DBException;

	/**
	 * ���ݷ�ҳԭ���ѯ����
	 * 
	 * @param detachedCriteria
	 * @param pageSize
	 * @param startIndex
	 * @param orderList
	 * @return
	 * @throws DAOException
	 */

	public PaginationSupport findPageByCriteria(
			final DetachedCriteria detachedCriteria, final int pageSize,
			final int startIndex, final List orderList);

	public List retriveBySql(String sql) throws DBException;

	public void executeSql(String sql) throws DBException;

	public int updateSql(String sql) throws DBException;

	public Map getMenuTotal(String countfilter) throws Exception;

	public List getFullInfo(String filter, final int pageSize,
			final int startIndex) throws Exception;

}
