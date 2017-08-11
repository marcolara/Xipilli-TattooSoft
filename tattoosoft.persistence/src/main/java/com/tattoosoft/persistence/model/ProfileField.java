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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xipilli.persistence.model.AbstractPersistentEntity;

/**
 * ProfileField entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "profile_field", catalog = "tattoosoft")
public class ProfileField extends AbstractPersistentEntity implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private String fieldName;
	private String fieldType;
	private Integer sortOrder;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;
	private Set<UserProfileData> userProfileDatas = new HashSet<UserProfileData>(
			0);

	// Constructors

	/** default constructor */
	public ProfileField() {
	}

	/** minimal constructor */
	public ProfileField(Role role, String fieldName, String fieldType,
			Integer sortOrder, String status, Date createTimestamp) {
		this.role = role;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.sortOrder = sortOrder;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public ProfileField(Role role, String fieldName, String fieldType,
			Integer sortOrder, String status, Date createTimestamp,
			Date updateTimestamp, Set<UserProfileData> userProfileDatas) {
		this.role = role;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.sortOrder = sortOrder;
		this.status = status;
		this.createTimestamp = createTimestamp;
		this.updateTimestamp = updateTimestamp;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "field_name", nullable = false, length = 45)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "field_type", nullable = false, length = 128)
	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Column(name = "sort_order", nullable = false)
	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "status", nullable = false, length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "create_timestamp", nullable = false, length = 19)
	public Date getCreateTimestamp() {
		return this.createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	@Column(name = "update_timestamp", length = 19)
	public Date getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileField")
	public Set<UserProfileData> getUserProfileDatas() {
		return this.userProfileDatas;
	}

	public void setUserProfileDatas(Set<UserProfileData> userProfileDatas) {
		this.userProfileDatas = userProfileDatas;
	}

}
