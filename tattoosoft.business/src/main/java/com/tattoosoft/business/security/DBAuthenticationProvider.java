package com.tattoosoft.business.security;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xipilli.persistence.dao.IBaseDAO;
import com.tattoosoft.business.exception.TempPasswordExpiredException;
import com.tattoosoft.business.model.BusinessUser;
import com.tattoosoft.business.security.exception.AccountUnconfirmedException;
import com.tattoosoft.persistence.dao.PermissionDAO;
import com.tattoosoft.persistence.dao.RoleDAO;
import com.tattoosoft.persistence.dao.UserDAO;
import com.tattoosoft.persistence.model.Permission;
import com.tattoosoft.persistence.model.Role;
import com.tattoosoft.persistence.model.User;

@Component("authenticationProvider")
@Transactional
public class DBAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private PermissionDAO permissionDAO;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName().toUpperCase();
		String password = (String) authentication.getCredentials();

		User user = userDAO.findUniqueByEmailAddress(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username not found.");
		}

		// check if the password used was a temp password
		Timestamp ts = new Timestamp(new Date(System.currentTimeMillis()).getTime());
		boolean isTempPassword = new BCryptPasswordEncoder().matches(password, user.getTempPsw());
		if (isTempPassword && ts.after(user.getTempPswExp())) {
			throw new TempPasswordExpiredException("Temporary password has expired.");
		}

		if (!isTempPassword && !new BCryptPasswordEncoder().matches(password, user.getCurrPsw())) {
			throw new BadCredentialsException("Wrong password.");
		}

		if (user.getBanned()) {
			throw new LockedException("Account has been locked.");
		}

		if (!user.getConfirmed()) {
			throw new AccountUnconfirmedException("Account is not confirmed.");
		}

		if (!IBaseDAO.STATUS_ACTIVE.equals(user.getStatus())) {
			throw new DisabledException("Account is not active.");
		}

		List<Role> roles = roleDAO.findByUsername(user.getEmailAddress());
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		if (roles != null) {
			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getDataKey()));
			}
		}
		return new UsernamePasswordAuthenticationToken(new BusinessUser(user, authorities), password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// copied it from AbstractUserDetailsAuthenticationProvider
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
