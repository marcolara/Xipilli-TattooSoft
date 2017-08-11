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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xipilli.persistence.dao.AbstractBaseDAO;
import com.tattoosoft.persistence.model.ServiceGroup;
/**
 * DAO providing persistence and search support for ServiceGroup entities. Save,
 * update, and delete transactions are managed by the custom tattoosoft base dao
 * that this extends. Common finder support is also implements at the base
 * level.
 *
 * @see tattoosoft.persistence.reveng.tmp.ServiceGroup
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8
 *      .5\dao\daohome.vm
 */
public class BaseServiceGroupDAO extends AbstractBaseDAO<ServiceGroup> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory
			.getLogger(BaseServiceGroupDAO.class);
	public static final String SPRING_BEAN_ID = BaseServiceGroupDAO.class
			.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String STATUS = "status";

	public BaseServiceGroupDAO() {
		super(ServiceGroup.class, ID);
	}

	/****** Property finder convenience methods: **************************************************/
	public List<ServiceGroup> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public ServiceGroup findUniqueByCode(Object code) {
		return findUniqueByProperty(CODE, code);
	}

	public List<ServiceGroup> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public ServiceGroup findUniqueByName(Object name) {
		return findUniqueByProperty(NAME, name);
	}

	public List<ServiceGroup> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public ServiceGroup findUniqueByDescription(Object description) {
		return findUniqueByProperty(DESCRIPTION, description);
	}

	public List<ServiceGroup> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public ServiceGroup findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
