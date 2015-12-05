package com.sxmccitlab.pcash.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sxmccitlab.pcash.dao.IVoucherDAO;
import com.sxmccitlab.pcash.po.Voucher;

/**
 	* A data access object (DAO) providing persistence and search support for TVoucher entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.sxmccitlab.pcash.po.Voucher
  * @author MyEclipse Persistence Tools 
 */

public class VoucherDAO extends HibernateDaoSupport implements IVoucherDAO  {
		 private static final Log log = LogFactory.getLog(VoucherDAO.class);
		//property constants
	public static final String VOUCHER_TYPE_CODE = "voucherTypeCode";
	public static final String DEBIT_SUM = "debitSum";
	public static final String CREDIT_SUM = "creditSum";
	public static final String STAFF_CODE = "staffCode";
	public static final String UNIT_CODE = "unitCode";
	public static final String ID = "id";



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.po.IVoucherDAO#save(com.sxmccitlab.pcash.po.Voucher)
	 */
    public void save(Voucher transientInstance) {
        log.debug("saving TVoucher instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.po.IVoucherDAO#delete(com.sxmccitlab.pcash.po.Voucher)
	 */
	public void delete(Voucher persistentInstance) {
        log.debug("deleting TVoucher instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.po.IVoucherDAO#findById(java.lang.String)
	 */
    public Voucher findById( java.lang.String id) {
        log.debug("getting TVoucher instance with id: " + id);
        try {
            Voucher instance = (Voucher) getHibernateTemplate()
                    .get("com.sxmccitlab.pcash.po.TVoucher", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Voucher instance) {
        log.debug("finding TVoucher instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding TVoucher instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TVoucher as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByVoucherTypeCode(Object voucherTypeCode
	) {
		return findByProperty(VOUCHER_TYPE_CODE, voucherTypeCode
		);
	}
	
	public List findByDebitSum(Object debitSum
	) {
		return findByProperty(DEBIT_SUM, debitSum
		);
	}
	
	public List findByCreditSum(Object creditSum
	) {
		return findByProperty(CREDIT_SUM, creditSum
		);
	}
	
	public List findByStaffCode(Object staffCode
	) {
		return findByProperty(STAFF_CODE, staffCode
		);
	}
	
	public List findByUnitCode(Object unitCode
	) {
		return findByProperty(UNIT_CODE, unitCode
		);
	}
	
	public List findById(Object id
	) {
		return findByProperty(ID, id
		);
	}
	

	public List findAll() {
		log.debug("finding all TVoucher instances");
		try {
			String queryString = "from TVoucher";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.po.IVoucherDAO#merge(com.sxmccitlab.pcash.po.Voucher)
	 */
    public Voucher merge(Voucher detachedInstance) {
        log.debug("merging TVoucher instance");
        try {
            Voucher result = (Voucher) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.po.IVoucherDAO#attachDirty(com.sxmccitlab.pcash.po.Voucher)
	 */
    public void attachDirty(Voucher instance) {
        log.debug("attaching dirty TVoucher instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.sxmccitlab.pcash.po.IVoucherDAO#attachClean(com.sxmccitlab.pcash.po.Voucher)
	 */
    public void attachClean(Voucher instance) {
        log.debug("attaching clean TVoucher instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IVoucherDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IVoucherDAO) ctx.getBean("TVoucherDAO");
	}
}