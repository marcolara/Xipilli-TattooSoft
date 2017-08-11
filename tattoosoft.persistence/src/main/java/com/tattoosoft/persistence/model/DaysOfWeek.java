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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xipilli.persistence.model.AbstractPersistentEntity;

/**
 * DaysOfWeek entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "days_of_week", catalog = "tattoosoft")
public class DaysOfWeek extends AbstractPersistentEntity implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String abbreviation;
	private String fullName;
	private String isWeekday;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;
	private Set<ShopHours> shopHourses = new HashSet<ShopHours>(0);

	// Constructors

	/** default constructor */
	public DaysOfWeek() {
	}

	/** minimal constructor */
	public DaysOfWeek(String abbreviation, String fullName, String isWeekday,
			String status, Date createTimestamp) {
		this.abbreviation = abbreviation;
		this.fullName = fullName;
		this.isWeekday = isWeekday;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public DaysOfWeek(String abbreviation, String fullName, String isWeekday,
			String status, Date createTimestamp, Date updateTimestamp,
			Set<ShopHours> shopHourses) {
		this.abbreviation = abbreviation;
		this.fullName = fullName;
		this.isWeekday = isWeekday;
		this.status = status;
		this.createTimestamp = createTimestamp;
		this.updateTimestamp = updateTimestamp;
		this.shopHourses = shopHourses;
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

	@Column(name = "abbreviation", nullable = false, length = 3)
	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Column(name = "full_name", nullable = false, length = 45)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "is_weekday", nullable = false, length = 1)
	public String getIsWeekday() {
		return this.isWeekday;
	}

	public void setIsWeekday(String isWeekday) {
		this.isWeekday = isWeekday;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "daysOfWeek")
	public Set<ShopHours> getShopHourses() {
		return this.shopHourses;
	}

	public void setShopHourses(Set<ShopHours> shopHourses) {
		this.shopHourses = shopHourses;
	}

}
