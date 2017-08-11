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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xipilli.persistence.model.AbstractPersistentEntity;

/**
 * ShopEmployee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop_employee", catalog = "tattoosoft")
public class ShopEmployee extends AbstractPersistentEntity implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private ShopEmployeeGroup shopEmployeeGroup;
	private String title;
	private Date hireDate;
	private Date releaseDate;
	private Date birthDate;
	private byte[] picture;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;

	// Constructors

	/** default constructor */
	public ShopEmployee() {
	}

	/** minimal constructor */
	public ShopEmployee(User user, ShopEmployeeGroup shopEmployeeGroup,
			String status, Date createTimestamp) {
		this.user = user;
		this.shopEmployeeGroup = shopEmployeeGroup;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public ShopEmployee(User user, ShopEmployeeGroup shopEmployeeGroup,
			String title, Date hireDate, Date releaseDate, Date birthDate,
			byte[] picture, String status, Date createTimestamp,
			Date updateTimestamp) {
		this.user = user;
		this.shopEmployeeGroup = shopEmployeeGroup;
		this.title = title;
		this.hireDate = hireDate;
		this.releaseDate = releaseDate;
		this.birthDate = birthDate;
		this.picture = picture;
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
	@JoinColumn(name = "shop_employee_group_id", nullable = false)
	public ShopEmployeeGroup getShopEmployeeGroup() {
		return this.shopEmployeeGroup;
	}

	public void setShopEmployeeGroup(ShopEmployeeGroup shopEmployeeGroup) {
		this.shopEmployeeGroup = shopEmployeeGroup;
	}

	@Column(name = "title", length = 128)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "hire_date", length = 19)
	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Column(name = "release_date", length = 19)
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Column(name = "birth_date", length = 19)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "picture")
	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
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

}
