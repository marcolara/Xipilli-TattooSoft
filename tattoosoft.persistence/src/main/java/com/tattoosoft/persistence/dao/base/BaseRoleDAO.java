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

import com.tattoosoft.persistence.model.Role;
import com.xipilli.persistence.dao.AbstractBaseDAO;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * DAO providing persistence and search support for Role entities. Save, update,
 * and delete transactions are managed by the custom tattoosoft base dao that
 * this extends. Common finder support is also implements at the base level.
 *
 * @see com.tattoosoft.persistence.reveng.tmp.Role
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8.5\dao\daohome.vm
 */
public class BaseRoleDAO extends AbstractBaseDAO<Role> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(BaseRoleDAO.class);
	public static final String SPRING_BEAN_ID = BaseRoleDAO.class.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String DATA_KEY = "dataKey";
	public static final String DATA_NAME = "dataName";
	public static final String DESCRIPTION = "description";
	public static final String STATUS = "status";

	public BaseRoleDAO() {
		super(Role.class, ID);
	}

	/******
	 * Property finder convenience methods:
	 **************************************************/
	public List<Role> findByDataKey(Object dataKey) {
		return findByProperty(DATA_KEY, dataKey);
	}

	public Role findUniqueByDataKey(Object dataKey) {
		return findUniqueByProperty(DATA_KEY, dataKey);
	}

	public List<Role> findByDataName(Object dataName) {
		return findByProperty(DATA_NAME, dataName);
	}

	public Role findUniqueByDataName(Object dataName) {
		return findUniqueByProperty(DATA_NAME, dataName);
	}

	public List<Role> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public Role findUniqueByDescription(Object description) {
		return findUniqueByProperty(DESCRIPTION, description);
	}

	public List<Role> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public Role findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
