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
 * ShopDiscipline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop_discipline", catalog = "tattoosoft")

public class ShopDiscipline extends AbstractPersistentEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private ShopLocation shopLocation;
	private Discipline discipline;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;

	// Constructors

	/** default constructor */
	public ShopDiscipline() {
	}

	/** minimal constructor */
	public ShopDiscipline(ShopLocation shopLocation, Discipline discipline, String status, Date createTimestamp) {
		this.shopLocation = shopLocation;
		this.discipline = discipline;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public ShopDiscipline(ShopLocation shopLocation, Discipline discipline, String status, Date createTimestamp,
			Date updateTimestamp) {
		this.shopLocation = shopLocation;
		this.discipline = discipline;
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
	@JoinColumn(name = "discipline_id", nullable = false)

	public Discipline getDiscipline() {
		return this.discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
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
