/***
 **  @(#) tattoosoft.com
 **
 **  (C) Copyright 2011 tattoosoft.com, All rights reserved.
 **
 **
 **  THIS COMPUTER SOFTWARE IS THE PROPERTY OF tattoosoft.
 **
 **  This program code and all derivatives thereof are the sole property of
 **  tattoosoft.  Recipient and/or user, by accepting this source
 **  code, agrees that neither this source code nor any part thereof
 **  shall be reproduced, copied, adapted, distributed, used, displayed
 **  or transferred to any party, or used or disclosed to others for
 **  development, consulting, or any other purpose except as specifically
 **   authorized in writing by tattoosoft.
 **
 **  @version tattoosoft-common 1.0
 **  (C) Copyright 2012 tattoosoft.com, All rights reserved.
 **
 **/
package com.tattoosoft.persistence.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.tattoosoft.persistence.dao.base.BaseUserDAO;
import com.tattoosoft.persistence.model.User;

/**
 * @author malara
 *
 */
@Component("UserDAO")
public class UserDAO extends BaseUserDAO {
	public List<User> findByPrivateDomain(String privateDomain){
		String hqlString = "from User as u "
				+ "join fetch u.shopLocationEmployees as sle "
				+ "join fetch sle.shop as s "
				+ "where u.emailAddress = :privateDomain ";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlString);
		query.setParameter("privateDomain", privateDomain);
		return query.list();
	}
}
