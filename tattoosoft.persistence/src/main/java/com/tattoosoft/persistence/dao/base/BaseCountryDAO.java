/***
**  @(#) tattoosoft.com
**
**  (C) Copyright 2011 tattoosoft.com, All rights reserved.
**
**
**  THIS COMPUTER SOFTWARE IS THE PROPERTY OF TATTOOSOFT.
**
**  This program code and all derivatives thereof are the sole property of
**  tattoosoft.com.  Recipient and/or user, by accepting this source
**  code, agrees that neither this source code nor any part thereof
**  shall be reproduced, copied, adapted, distributed, used, displayed
**  or transferred to any party, or used or disclosed to others for
**  development, consulting, or any other purpose except as specifically
**   authorized in writing by tattoosoft.com.
**
**  @version tattoosoft.persistence 1.0
**  (C) Copyright 2011 tattoosoft.com, All rights reserved.
**
**/
package com.tattoosoft.persistence.dao.base;

import com.tattoosoft.persistence.model.Country;
import com.xipilli.persistence.dao.AbstractBaseDAO;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * DAO providing persistence and search support for Country entities. Save,
 * update, and delete transactions are managed by the custom tattoosoft base dao
 * that this extends. Common finder support is also implements at the base
 * level.
 *
 * @see com.tattoosoft.persistence.reveng.tmp.Country
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8.5\dao\daohome.vm
 */
public class BaseCountryDAO extends AbstractBaseDAO<Country> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(BaseCountryDAO.class);
	public static final String SPRING_BEAN_ID = BaseCountryDAO.class.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String DATA_KEY = "dataKey";
	public static final String DATA_NAME = "dataName";
	public static final String STATUS = "status";

	public BaseCountryDAO() {
		super(Country.class, ID);
	}

	/******
	 * Property finder convenience methods:
	 **************************************************/
	public List<Country> findByDataKey(Object dataKey) {
		return findByProperty(DATA_KEY, dataKey);
	}

	public Country findUniqueByDataKey(Object dataKey) {
		return findUniqueByProperty(DATA_KEY, dataKey);
	}

	public List<Country> findByDataName(Object dataName) {
		return findByProperty(DATA_NAME, dataName);
	}

	public Country findUniqueByDataName(Object dataName) {
		return findUniqueByProperty(DATA_NAME, dataName);
	}

	public List<Country> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public Country findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
