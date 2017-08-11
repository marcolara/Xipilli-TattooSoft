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
import com.tattoosoft.persistence.model.ProfileField;
/**
 * DAO providing persistence and search support for ProfileField entities. Save,
 * update, and delete transactions are managed by the custom tattoosoft base dao
 * that this extends. Common finder support is also implements at the base
 * level.
 *
 * @see tattoosoft.persistence.reveng.tmp.ProfileField
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8
 *      .5\dao\daohome.vm
 */
public class BaseProfileFieldDAO extends AbstractBaseDAO<ProfileField> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory
			.getLogger(BaseProfileFieldDAO.class);
	public static final String SPRING_BEAN_ID = BaseProfileFieldDAO.class
			.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String FIELD_NAME = "fieldName";
	public static final String FIELD_TYPE = "fieldType";
	public static final String SORT_ORDER = "sortOrder";
	public static final String STATUS = "status";

	public BaseProfileFieldDAO() {
		super(ProfileField.class, ID);
	}

	/****** Property finder convenience methods: **************************************************/
	public List<ProfileField> findByFieldName(Object fieldName) {
		return findByProperty(FIELD_NAME, fieldName);
	}

	public ProfileField findUniqueByFieldName(Object fieldName) {
		return findUniqueByProperty(FIELD_NAME, fieldName);
	}

	public List<ProfileField> findByFieldType(Object fieldType) {
		return findByProperty(FIELD_TYPE, fieldType);
	}

	public ProfileField findUniqueByFieldType(Object fieldType) {
		return findUniqueByProperty(FIELD_TYPE, fieldType);
	}

	public List<ProfileField> findBySortOrder(Object sortOrder) {
		return findByProperty(SORT_ORDER, sortOrder);
	}

	public ProfileField findUniqueBySortOrder(Object sortOrder) {
		return findUniqueByProperty(SORT_ORDER, sortOrder);
	}

	public List<ProfileField> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public ProfileField findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
