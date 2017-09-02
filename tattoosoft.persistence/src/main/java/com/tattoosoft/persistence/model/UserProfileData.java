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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * UserProfileData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_profile_data", catalog = "tattoosoft")

public class UserProfileData extends AbstractPersistentEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private ProfileField profileField;
	private String textValue;
	private String blobValue;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;

	// Constructors

	/** default constructor */
	public UserProfileData() {
	}

	/** minimal constructor */
	public UserProfileData(User user, ProfileField profileField, String status, Date createTimestamp) {
		this.user = user;
		this.profileField = profileField;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public UserProfileData(User user, ProfileField profileField, String textValue, String blobValue, String status,
			Date createTimestamp, Date updateTimestamp) {
		this.user = user;
		this.profileField = profileField;
		this.textValue = textValue;
		this.blobValue = blobValue;
		this.status = status;
		this.createTimestamp = createTimestamp;
		this.updateTimestamp = updateTimestamp;
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
	@JoinColumn(name = "user_id", nullable = false)

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id", nullable = false)

	public ProfileField getProfileField() {
		return this.profileField;
	}

	public void setProfileField(ProfileField profileField) {
		this.profileField = profileField;
	}

	@Column(name = "text_value", length = 16777215)

	public String getTextValue() {
		return this.textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	@Column(name = "blob_value")

	public String getBlobValue() {
		return this.blobValue;
	}

	public void setBlobValue(String blobValue) {
		this.blobValue = blobValue;
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

}
