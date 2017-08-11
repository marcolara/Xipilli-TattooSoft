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
 * ShopHours entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop_hours", catalog = "tattoosoft")
public class ShopHours extends AbstractPersistentEntity implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private ShopLocation shopLocation;
	private DaysOfWeek daysOfWeek;
	private Date openAt;
	private Date closeAt;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;

	// Constructors

	/** default constructor */
	public ShopHours() {
	}

	/** minimal constructor */
	public ShopHours(ShopLocation shopLocation, DaysOfWeek daysOfWeek,
			Date openAt, Date closeAt, String status, Date createTimestamp) {
		this.shopLocation = shopLocation;
		this.daysOfWeek = daysOfWeek;
		this.openAt = openAt;
		this.closeAt = closeAt;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public ShopHours(ShopLocation shopLocation, DaysOfWeek daysOfWeek,
			Date openAt, Date closeAt, String status, Date createTimestamp,
			Date updateTimestamp) {
		this.shopLocation = shopLocation;
		this.daysOfWeek = daysOfWeek;
		this.openAt = openAt;
		this.closeAt = closeAt;
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
	@JoinColumn(name = "shop_location_id", nullable = false)
	public ShopLocation getShopLocation() {
		return this.shopLocation;
	}

	public void setShopLocation(ShopLocation shopLocation) {
		this.shopLocation = shopLocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "days_of_week_id", nullable = false)
	public DaysOfWeek getDaysOfWeek() {
		return this.daysOfWeek;
	}

	public void setDaysOfWeek(DaysOfWeek daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	@Column(name = "open_at", nullable = false, length = 8)
	public Date getOpenAt() {
		return this.openAt;
	}

	public void setOpenAt(Date openAt) {
		this.openAt = openAt;
	}

	@Column(name = "close_at", nullable = false, length = 8)
	public Date getCloseAt() {
		return this.closeAt;
	}

	public void setCloseAt(Date closeAt) {
		this.closeAt = closeAt;
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
