package com.sxmccitlab.pcash.dao;

import java.io.Serializable;
import java.util.List;

import com.sxmccitlab.common.exception.DBException;

public interface IBaseDAO {
	public Integer genSequence(String seqName) throws DBException;

	/**
	 * ����POJO����
	 */
	public void save(Object o);

	
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
	 * ����SQL��ѯ���������
	 * @param sql SQL���
	 * @throws DBException
	 * ���ݿ���ʴ���ʱ�׳�
	 */
	public int queryCount(String sql) throws DBException;
}
