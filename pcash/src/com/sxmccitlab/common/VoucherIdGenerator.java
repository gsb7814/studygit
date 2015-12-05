package com.sxmccitlab.common;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class VoucherIdGenerator implements IdentifierGenerator, Configurable {

	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public void configure(Type arg0, Properties arg1, Dialect arg2)
			throws MappingException {
		// TODO Auto-generated method stub

	}

}
