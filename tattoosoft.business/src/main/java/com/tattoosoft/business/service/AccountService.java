package com.tattoosoft.business.service;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xipilli.persistence.dao.IBaseDAO;
import com.tattoosoft.persistence.dao.ProfileFieldDAO;
import com.tattoosoft.persistence.dao.RoleDAO;
import com.tattoosoft.persistence.dao.ShopLocationDAO;
import com.tattoosoft.persistence.dao.UserProfileDataDAO;
import com.tattoosoft.persistence.dao.UserRoleDAO;
import com.tattoosoft.persistence.model.ProfileField;
import com.tattoosoft.persistence.model.User;
import com.tattoosoft.persistence.model.UserProfileData;
import com.tattoosoft.persistence.model.UserRole;

@Service("accountService")
@Transactional
public class AccountService {
    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "SHOP_ADMIN";
    public static final String ROLE_EMPLOYEE = "SHOP_EMPLOYEE";

    @Autowired
    @Qualifier("UserRoleDAO")
    private UserRoleDAO userRoleDAO;

    @Autowired
    @Qualifier("RoleDAO")
    private RoleDAO roleDAO;

    @Autowired
    @Qualifier("UserProfileDataDAO")
    private UserProfileDataDAO userProfileDataDAO;

    @Autowired
    @Qualifier("ProfileFieldDAO")
    private ProfileFieldDAO profileFieldDAO;

    @Autowired
    @Qualifier("ShopLocationDAO")
    private ShopLocationDAO shopLocationDAO;

    private void _updateRole(User user, String role, String status) {
        UserRole userRole;
        if (!userHasRole(user, role)){
            userRole = new UserRole();
            userRole.setRole(roleDAO.findUniqueByDataKey(role));
            userRole.setUser(user);
        } else {
            Criterion userCriterion = Restrictions.eq("user", user);
            Criterion roleCriterion = Restrictions.eq("role", roleDAO.findUniqueByDataKey(role));
            userRole = userRoleDAO.findUniqueByCriterion(userCriterion, roleCriterion);
        }
        userRole.setStatus(status);
        userRoleDAO.attachDirty(userRole);
    }

    public void addRole(User user, String role) {
        _updateRole(user, role, IBaseDAO.STATUS_ACTIVE);
    }

    public void disableRole(User user, String role) {
        _updateRole(user, role, IBaseDAO.STATUS_INACTIVE);
    }

    public boolean userHasRole(User user, String role) {
        return getUserRole(user, role) != null;
    }

    public UserRole getUserRole(User user, String role) {
        Criterion userCriterion = Restrictions.eq("user", user);
        Criterion roleCriterion = Restrictions.eq("role", roleDAO.findUniqueByDataKey(role));
        return userRoleDAO.findUniqueByCriterion(userCriterion, roleCriterion);
    }

    public void updateProfileValue(User user, String role, String fieldCode, String value) {
        UserRole userRole = getUserRole(user, role);
        UserProfileData foundData = userProfileDataDAO.findUniqueByUserRoleAndFieldCode(userRole, fieldCode);
        if (foundData == null) {
            ProfileField field = new ProfileField();
            field.setRole(roleDAO.findUniqueByDataKey(role));
            field.setFieldName(fieldCode);
            field = profileFieldDAO.findUniqueByExample(field);
            if (field != null) {
                foundData = new UserProfileData();
                foundData.setUser(user);
                foundData.setProfileField(profileFieldDAO.findUniqueByExample(field));
            }
        }
        foundData.setTextValue(value);
        foundData.setStatus(IBaseDAO.STATUS_ACTIVE);
        userProfileDataDAO.attachDirty(foundData);
    }
}
