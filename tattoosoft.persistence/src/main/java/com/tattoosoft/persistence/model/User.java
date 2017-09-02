/***
 **  @(#) xipilli.com
 **
 **  (C) Copyright 2011 xipilli.com, All rights reserved.
 **
 **
 **  THIS COMPUTER SOFTWARE IS THE PROPERTY OF xipilli.
 **
 **  This program code and all derivatives thereof are the sole property of
 **  xipilli.com.  Recipient and/or user, by accepting this source
 **  code, agrees that neither this source code nor any part thereof
 **  shall be reproduced, copied, adapted, distributed, used, displayed
 **  or transferred to any party, or used or disclosed to others for
 **  development, consulting, or any other purpose except as specifically
 **   authorized in writing by xipilli.com.
 **
 **  @version xipilli-persistence 1.0
 **  (C) Copyright 2011 xipilli.com, All rights reserved.
 **
 **/
package com.tattoosoft.persistence.model;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import com.xipilli.persistence.model.AbstractPersistentEntity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "tattoosoft", uniqueConstraints = @UniqueConstraint(columnNames = "email_address"))

public class User extends AbstractPersistentEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private String emailAddress;
	private Boolean confirmed;
	private Boolean banned;
	private String confirmationToken;
	private String currPsw;
	private String tempPsw;
	private Date tempPswExp;
	private Boolean tempPswUsed;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;
	private Set<ShopEmployee> shopEmployees = new HashSet<ShopEmployee>(0);
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	private Set<UserProfileData> userProfileDatas = new HashSet<UserProfileData>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String emailAddress, Boolean confirmed, Boolean banned, Boolean tempPswUsed, String status,
			Date createTimestamp) {
		this.emailAddress = emailAddress;
		this.confirmed = confirmed;
		this.banned = banned;
		this.tempPswUsed = tempPswUsed;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public User(String emailAddress, Boolean confirmed, Boolean banned, String confirmationToken, String currPsw,
			String tempPsw, Date tempPswExp, Boolean tempPswUsed, String status, Date createTimestamp,
			Date updateTimestamp, Set<ShopEmployee> shopEmployees, Set<UserRole> userRoles,
			Set<UserProfileData> userProfileDatas) {
		this.emailAddress = emailAddress;
		this.confirmed = confirmed;
		this.banned = banned;
		this.confirmationToken = confirmationToken;
		this.currPsw = currPsw;
		this.tempPsw = tempPsw;
		this.tempPswExp = tempPswExp;
		this.tempPswUsed = tempPswUsed;
		this.status = status;
		this.createTimestamp = createTimestamp;
		this.updateTimestamp = updateTimestamp;
		this.shopEmployees = shopEmployees;
		this.userRoles = userRoles;
		this.userProfileDatas = userProfileDatas;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "email_address", unique = true, nullable = false, length = 120)

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "confirmed", nullable = false)

	public Boolean getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	@Column(name = "banned", nullable = false)

	public Boolean getBanned() {
		return this.banned;
	}

	public void setBanned(Boolean banned) {
		this.banned = banned;
	}

	@Column(name = "confirmation_token")

	public String getConfirmationToken() {
		return this.confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	@Column(name = "curr_psw")

	public String getCurrPsw() {
		return this.currPsw;
	}

	public void setCurrPsw(String currPsw) {
		this.currPsw = currPsw;
	}

	@Column(name = "temp_psw")

	public String getTempPsw() {
		return this.tempPsw;
	}

	public void setTempPsw(String tempPsw) {
		this.tempPsw = tempPsw;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "temp_psw_exp", length = 19)

	public Date getTempPswExp() {
		return this.tempPswExp;
	}

	public void setTempPswExp(Date tempPswExp) {
		this.tempPswExp = tempPswExp;
	}

	@Column(name = "temp_psw_used", nullable = false)

	public Boolean getTempPswUsed() {
		return this.tempPswUsed;
	}

	public void setTempPswUsed(Boolean tempPswUsed) {
		this.tempPswUsed = tempPswUsed;
	}

	@Column(name = "status", nullable = false, length = 1)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_timestamp", nullable = false, length = 19)

	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update_timestamp", length = 19)

	public Date getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

	public Set<ShopEmployee> getShopEmployees() {
		return this.shopEmployees;
	}

	public void setShopEmployees(Set<ShopEmployee> shopEmployees) {
		this.shopEmployees = shopEmployees;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

	public Set<UserProfileData> getUserProfileDatas() {
		return this.userProfileDatas;
	}

	public void setUserProfileDatas(Set<UserProfileData> userProfileDatas) {
		this.userProfileDatas = userProfileDatas;
	}

}
