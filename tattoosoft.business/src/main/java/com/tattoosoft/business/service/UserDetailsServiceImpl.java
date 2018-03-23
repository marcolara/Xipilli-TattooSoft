package com.tattoosoft.business.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tattoosoft.persistence.dao.RoleDAO;
import com.tattoosoft.persistence.dao.UserDAO;
import com.tattoosoft.persistence.model.Role;
import com.tattoosoft.persistence.model.User;

@Service("userDetailsService")
@Primary
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private RoleDAO roleDAO;

	@Override
	public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUniqueByProperty(UserDAO.EMAIL_ADDRESS, username.toUpperCase());
        if (user == null) {
            throw new UsernameNotFoundException("Username not found.");
        }
        List<Role> roles = roleDAO.findByUsername(user.getEmailAddress());
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (roles != null) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getDataKey()));
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), "***", authorities);
	}
}
