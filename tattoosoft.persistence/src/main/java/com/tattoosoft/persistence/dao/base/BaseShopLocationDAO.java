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
import com.tattoosoft.persistence.model.ShopLocation;
/**
 * DAO providing persistence and search support for ShopLocation entities. Save,
 * update, and delete transactions are managed by the custom tattoosoft base dao
 * that this extends. Common finder support is also implements at the base
 * level.
 *
 * @see tattoosoft.persistence.reveng.tmp.ShopLocation
 *
 *      Generated using template: -
 *      tattoosoft-persistence\reveng\tattoosoft-myeclipse_templates_8
 *      .5\dao\daohome.vm
 */
public class BaseShopLocationDAO extends AbstractBaseDAO<ShopLocation> {
	// <revengLogSuppress/>
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory
			.getLogger(BaseShopLocationDAO.class);
	public static final String SPRING_BEAN_ID = BaseShopLocationDAO.class
			.getSimpleName();
	// id property constant
	public static final String ID = "id";
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ADDRESS1 = "address1";
	public static final String ADDRESS2 = "address2";
	public static final String CITY_TOWN = "cityTown";
	public static final String ZIP_POSTAL_CODE = "zipPostalCode";
	public static final String PHONE = "phone";
	public static final String FAX = "fax";
	public static final String CONTACT_EMAIL = "contactEmail";
	public static final String SHOP_URL = "shopUrl";
	public static final String STATUS = "status";

	public BaseShopLocationDAO() {
		super(ShopLocation.class, ID);
	}

	/****** Property finder convenience methods: **************************************************/
	public List<ShopLocation> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public ShopLocation findUniqueByName(Object name) {
		return findUniqueByProperty(NAME, name);
	}

	public List<ShopLocation> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public ShopLocation findUniqueByDescription(Object description) {
		return findUniqueByProperty(DESCRIPTION, description);
	}

	public List<ShopLocation> findByAddress1(Object address1) {
		return findByProperty(ADDRESS1, address1);
	}

	public ShopLocation findUniqueByAddress1(Object address1) {
		return findUniqueByProperty(ADDRESS1, address1);
	}

	public List<ShopLocation> findByAddress2(Object address2) {
		return findByProperty(ADDRESS2, address2);
	}

	public ShopLocation findUniqueByAddress2(Object address2) {
		return findUniqueByProperty(ADDRESS2, address2);
	}

	public List<ShopLocation> findByCityTown(Object cityTown) {
		return findByProperty(CITY_TOWN, cityTown);
	}

	public ShopLocation findUniqueByCityTown(Object cityTown) {
		return findUniqueByProperty(CITY_TOWN, cityTown);
	}

	public List<ShopLocation> findByZipPostalCode(Object zipPostalCode) {
		return findByProperty(ZIP_POSTAL_CODE, zipPostalCode);
	}

	public ShopLocation findUniqueByZipPostalCode(Object zipPostalCode) {
		return findUniqueByProperty(ZIP_POSTAL_CODE, zipPostalCode);
	}

	public List<ShopLocation> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public ShopLocation findUniqueByPhone(Object phone) {
		return findUniqueByProperty(PHONE, phone);
	}

	public List<ShopLocation> findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	public ShopLocation findUniqueByFax(Object fax) {
		return findUniqueByProperty(FAX, fax);
	}

	public List<ShopLocation> findByContactEmail(Object contactEmail) {
		return findByProperty(CONTACT_EMAIL, contactEmail);
	}

	public ShopLocation findUniqueByContactEmail(Object contactEmail) {
		return findUniqueByProperty(CONTACT_EMAIL, contactEmail);
	}

	public List<ShopLocation> findByShopUrl(Object shopUrl) {
		return findByProperty(SHOP_URL, shopUrl);
	}

	public ShopLocation findUniqueByShopUrl(Object shopUrl) {
		return findUniqueByProperty(SHOP_URL, shopUrl);
	}

	public List<ShopLocation> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public ShopLocation findUniqueByStatus(Object status) {
		return findUniqueByProperty(STATUS, status);
	}
}
