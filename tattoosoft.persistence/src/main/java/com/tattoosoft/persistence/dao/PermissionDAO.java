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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.tattoosoft.persistence.dao.base.BasePermissionDAO;
import com.tattoosoft.persistence.model.Permission;
import com.tattoosoft.persistence.model.Role;
import com.tattoosoft.persistence.model.RolePermission;
import com.tattoosoft.persistence.model.User;
import com.tattoosoft.persistence.model.UserRole;

/**
 * @author malara
 *
 */
@Component("PermissionDAO")
public class PermissionDAO extends BasePermissionDAO {
	
	public List<Permission> findByUsername(String username) {
		List<Permission> permissions = new ArrayList<Permission>();
		String hqlString = "from User as u "
				+ "join fetch u.userRoles as ur "
				+ "join fetch ur.role as r "
				+ "join fetch r.rolePermissions as rp "
				+ "join fetch rp.permission as p "
				+ "where u.emailAddress = :username ";
		Query query = sessionFactory.getCurrentSession().createQuery(hqlString);
		query.setParameter("username", username);
		List<User> list = query.list();
		for (User user : list){
			for (UserRole userRoles : user.getUserRoles()){
				Role role = userRoles.getRole();
				for (RolePermission rolePermission : role.getRolePermissions()){
					permissions.add(rolePermission.getPermission());
				}
			}
		}
		return permissions;
	}
	
}
