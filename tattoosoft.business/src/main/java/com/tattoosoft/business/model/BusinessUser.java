package com.tattoosoft.business.model;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.xipilli.persistence.dao.IBaseDAO;
import com.tattoosoft.persistence.model.User;

public class BusinessUser implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Collection<GrantedAuthority> authorities;
	private String password;
	private String username;
	private boolean accountNonLocked = true;
	private boolean enabled = true;
	
	public BusinessUser(User user, Collection<GrantedAuthority> authorities){
		this.authorities = authorities;
		this.username = user.getEmailAddress();
		this.password = user.getCurrPsw();
		this.accountNonLocked = !IBaseDAO.STATUS_LOCKED.equals(user.getStatus());
		this.enabled = IBaseDAO.STATUS_ACTIVE.equals(user.getStatus());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	@JsonIgnore
    @JsonProperty(value = "password")
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	
}
