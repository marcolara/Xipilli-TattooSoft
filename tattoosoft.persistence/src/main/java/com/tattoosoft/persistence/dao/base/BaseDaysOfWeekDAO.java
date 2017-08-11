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
import com.tattoosoft.persistence.model.DaysOfWeek;
/**
 * DAO providing persistence and search support for DaysOfWeek entities. Save,
 * update, and delete transactions are managed by the custom tattoosoft base dao
 * that this extends. Common finder support is also implements at the base
 * level.
 *
 * @see tattoosoft.persistence.reveng.tmp.DaysOfWeek
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8
 *      .5\dao\daohome.vm
 */
public class BaseDaysOfWeekDAO extends AbstractBaseDAO<DaysOfWeek> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory
			.getLogger(BaseDaysOfWeekDAO.class);
	public static final String SPRING_BEAN_ID = BaseDaysOfWeekDAO.class
			.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String ABBREVIATION = "abbreviation";
	public static final String FULL_NAME = "fullName";
	public static final String IS_WEEKDAY = "isWeekday";
	public static final String STATUS = "status";

	public BaseDaysOfWeekDAO() {
		super(DaysOfWeek.class, ID);
	}

	/****** Property finder convenience methods: **************************************************/
	public List<DaysOfWeek> findByAbbreviation(Object abbreviation) {
		return findByProperty(ABBREVIATION, abbreviation);
	}

	public DaysOfWeek findUniqueByAbbreviation(Object abbreviation) {
		return findUniqueByProperty(ABBREVIATION, abbreviation);
	}

	public List<DaysOfWeek> findByFullName(Object fullName) {
		return findByProperty(FULL_NAME, fullName);
	}

	public DaysOfWeek findUniqueByFullName(Object fullName) {
		return findUniqueByProperty(FULL_NAME, fullName);
	}

	public List<DaysOfWeek> findByIsWeekday(Object isWeekday) {
		return findByProperty(IS_WEEKDAY, isWeekday);
	}

	public DaysOfWeek findUniqueByIsWeekday(Object isWeekday) {
		return findUniqueByProperty(IS_WEEKDAY, isWeekday);
	}

	public List<DaysOfWeek> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public DaysOfWeek findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
