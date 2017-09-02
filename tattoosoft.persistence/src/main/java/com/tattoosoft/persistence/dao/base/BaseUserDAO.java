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

import com.tattoosoft.persistence.model.User;
import com.xipilli.persistence.dao.AbstractBaseDAO;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * DAO providing persistence and search support for User entities. Save, update,
 * and delete transactions are managed by the custom tattoosoft base dao that
 * this extends. Common finder support is also implements at the base level.
 *
 * @see com.tattoosoft.persistence.reveng.tmp.User
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8.5\dao\daohome.vm
 */
public class BaseUserDAO extends AbstractBaseDAO<User> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(BaseUserDAO.class);
	public static final String SPRING_BEAN_ID = BaseUserDAO.class.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String CONFIRMED = "confirmed";
	public static final String BANNED = "banned";
	public static final String CONFIRMATION_TOKEN = "confirmationToken";
	public static final String CURR_PSW = "currPsw";
	public static final String TEMP_PSW = "tempPsw";
	public static final String TEMP_PSW_USED = "tempPswUsed";
	public static final String STATUS = "status";

	public BaseUserDAO() {
		super(User.class, ID);
	}

	/******
	 * Property finder convenience methods:
	 **************************************************/
	public List<User> findByEmailAddress(Object emailAddress) {
		return findByProperty(EMAIL_ADDRESS, emailAddress);
	}

	public User findUniqueByEmailAddress(Object emailAddress) {
		return findUniqueByProperty(EMAIL_ADDRESS, emailAddress);
	}

	public List<User> findByConfirmed(Object confirmed) {
		return findByProperty(CONFIRMED, confirmed);
	}

	public User findUniqueByConfirmed(Object confirmed) {
		return findUniqueByProperty(CONFIRMED, confirmed);
	}

	public List<User> findByBanned(Object banned) {
		return findByProperty(BANNED, banned);
	}

	public User findUniqueByBanned(Object banned) {
		return findUniqueByProperty(BANNED, banned);
	}

	public List<User> findByConfirmationToken(Object confirmationToken) {
		return findByProperty(CONFIRMATION_TOKEN, confirmationToken);
	}

	public User findUniqueByConfirmationToken(Object confirmationToken) {
		return findUniqueByProperty(CONFIRMATION_TOKEN, confirmationToken);
	}

	public List<User> findByCurrPsw(Object currPsw) {
		return findByProperty(CURR_PSW, currPsw);
	}

	public User findUniqueByCurrPsw(Object currPsw) {
		return findUniqueByProperty(CURR_PSW, currPsw);
	}

	public List<User> findByTempPsw(Object tempPsw) {
		return findByProperty(TEMP_PSW, tempPsw);
	}

	public User findUniqueByTempPsw(Object tempPsw) {
		return findUniqueByProperty(TEMP_PSW, tempPsw);
	}

	public List<User> findByTempPswUsed(Object tempPswUsed) {
		return findByProperty(TEMP_PSW_USED, tempPswUsed);
	}

	public User findUniqueByTempPswUsed(Object tempPswUsed) {
		return findUniqueByProperty(TEMP_PSW_USED, tempPswUsed);
	}

	public List<User> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public User findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
