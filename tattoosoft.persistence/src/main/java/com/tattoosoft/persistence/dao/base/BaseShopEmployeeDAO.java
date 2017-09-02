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

import com.tattoosoft.persistence.model.ShopEmployee;
import com.xipilli.persistence.dao.AbstractBaseDAO;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * DAO providing persistence and search support for ShopEmployee entities. Save,
 * update, and delete transactions are managed by the custom tattoosoft base dao
 * that this extends. Common finder support is also implements at the base
 * level.
 *
 * @see com.tattoosoft.persistence.reveng.tmp.ShopEmployee
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8.5\dao\daohome.vm
 */
public class BaseShopEmployeeDAO extends AbstractBaseDAO<ShopEmployee> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(BaseShopEmployeeDAO.class);
	public static final String SPRING_BEAN_ID = BaseShopEmployeeDAO.class.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String TITLE = "title";
	public static final String PICTURE = "picture";
	public static final String STATUS = "status";

	public BaseShopEmployeeDAO() {
		super(ShopEmployee.class, ID);
	}

	/******
	 * Property finder convenience methods:
	 **************************************************/
	public List<ShopEmployee> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public ShopEmployee findUniqueByTitle(Object title) {
		return findUniqueByProperty(TITLE, title);
	}

	public List<ShopEmployee> findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public ShopEmployee findUniqueByPicture(Object picture) {
		return findUniqueByProperty(PICTURE, picture);
	}

	public List<ShopEmployee> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public ShopEmployee findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
