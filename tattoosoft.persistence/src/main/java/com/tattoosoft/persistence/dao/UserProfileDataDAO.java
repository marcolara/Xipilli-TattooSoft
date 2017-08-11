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

import com.tattoosoft.persistence.dao.base.BaseUserProfileDataDAO;
import com.tattoosoft.persistence.model.UserProfileData;
import com.tattoosoft.persistence.model.UserRole;

/**
 * @author malara
 *
 */
@Component("UserProfileDataDAO")
public class UserProfileDataDAO extends BaseUserProfileDataDAO {
    public List<UserProfileData> findByUserRole(UserRole userRole) {
        String hqlString = "from UserProfileData as upr "
                + "join fetch upr.user as u "
                + "join fetch upr.profileField as pf "
                + "join fetch pf.role as r "
                + "where u.id = :userId "
                + "and r.id = :roleId ";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlString);
        query.setParameter("userId", userRole.getUser().getId());
        query.setParameter("roleId", userRole.getRole().getId());
        return query.list();
    }

    public UserProfileData findUniqueByUserRoleAndFieldCode(UserRole userRole, String code) {
        String hqlString = "from UserProfileData as upr "
                + "join fetch upr.user as u "
                + "join fetch upr.profileField as pf "
                + "join fetch pf.role as r "
                + "where pf.fieldName = :fieldName "
                + "and u.id = :userId "
                + "and r.id = :roleId ";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlString);
        query.setParameter("fieldName", code);
        query.setParameter("userId", userRole.getUser().getId());
        query.setParameter("roleId", userRole.getRole().getId());
        return this.resolveUnique(query.list());
    }
}
