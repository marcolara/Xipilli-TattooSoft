package com.tattoosoft.business.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xipilli.persistence.dao.IBaseDAO;
import com.tattoosoft.business.form.AccountForm;
import com.tattoosoft.business.form.field.ProfileFormField;
import com.tattoosoft.persistence.dao.CountryDAO;
import com.tattoosoft.persistence.dao.ProfileFieldDAO;
import com.tattoosoft.persistence.dao.ShopEmployeeDAO;
import com.tattoosoft.persistence.dao.ShopLocationDAO;
import com.tattoosoft.persistence.dao.StateProvinceRegionDAO;
import com.tattoosoft.persistence.dao.UserDAO;
import com.tattoosoft.persistence.model.User;

@Service("registrationService")
@Transactional
public class RegistrationService {
    // Services
    @Autowired
    private AccountService accountService;

    // User
    @Autowired
    @Qualifier("UserDAO")
    private UserDAO userDAO;


    @Autowired
    @Qualifier("ShopLocationDAO")
    private ShopLocationDAO shopLocationDAO;

    @Autowired
    @Qualifier("ShopEmployeeDAO")
    private ShopEmployeeDAO shopEmployeeDAO;

    @Autowired
    @Qualifier("StateProvinceRegionDAO")
    private StateProvinceRegionDAO stateProvinceRegionDAO;
    @Autowired
    @Qualifier("CountryDAO")
    private CountryDAO countryDAO;

    @Autowired
    @Qualifier("ProfileFieldDAO")
    private ProfileFieldDAO profileFieldDAO;

    @Autowired
    @Qualifier("emailService")
    EmailService emailService;

    @Autowired
    @Qualifier("encoder")
    BCryptPasswordEncoder encoder;

    public User registerAccount(AccountForm form) {
        // if the user is not registered
        User user = userDAO.findUniqueByProperty(UserDAO.EMAIL_ADDRESS, form.getEmailAddress());
        if (user == null) {
            user = new User();
            user.setBanned(false);
            user.setConfirmed(false);
            user.setEmailAddress(form.getEmailAddress());
            user.setBanned(IBaseDAO.FALSE);
            user.setStatus(IBaseDAO.STATUS_INACTIVE);
            user.setCurrPsw(encoder.encode(form.getAccountPassword()));
            user.setConfirmationToken(encoder.encode(form.getEmailAddress()));
            user.setConfirmed(IBaseDAO.FALSE);
            userDAO.saveNew(user);
            // add role
            accountService.addRole(user, AccountService.ROLE_USER);
        }

        if (!accountService.userHasRole(user, AccountService.ROLE_USER)){
            accountService.addRole(user, AccountService.ROLE_USER);
        }

        Iterator<ProfileFormField> itr = form.getProfileFields().iterator();
        while(itr.hasNext()) {
            ProfileFormField field = itr.next();
            accountService.updateProfileValue(user, AccountService.ROLE_USER, field.getFieldCode(), field.getValue());
        }
        emailService.sendConfirmationEmail(user);
        return user;
    }
    
    public void recoverPasswordByEmail(String email) {
    	this.recoverPassword(userDAO.findUniqueByEmailAddress(email));
    }

    public void recoverPassword(User user) {
    	if (user != null){
            String tmpPassword = RandomStringUtils.randomAscii(8);
            user.setTempPsw(new BCryptPasswordEncoder().encode(tmpPassword));
            user.setTempPswExp(new Timestamp(new Date(System.currentTimeMillis()+2520*60*1000).getTime()));
            userDAO.attachDirty(user);
            emailService.sendPasswordRecoveryEmail(tmpPassword, user);
    	}
    }

    public void confirmAccountByEmail(String email) {
        this.confirmAccount(userDAO.findUniqueByProperty(UserDAO.EMAIL_ADDRESS, email));
    }

    public void confirmAccount(User user) {
        user.setConfirmed(UserDAO.ENABLED_YES);
        user.setStatus(UserDAO.STATUS_ACTIVE);
        user.setConfirmationToken(null);
        userDAO.attachDirty(user);
        emailService.sendRegistrationEmail(user);
    }

    public User getUserByEmailAddress(String emailAddress) {
        return userDAO.findUniqueByProperty(UserDAO.EMAIL_ADDRESS, emailAddress);
    }
}
