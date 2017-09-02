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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * StateProvinceRegion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "state_province_region", catalog = "tattoosoft")

public class StateProvinceRegion extends AbstractPersistentEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Country country;
	private String dataKey;
	private String dataName;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;
	private Set<ShopLocation> shopLocations = new HashSet<ShopLocation>(0);

	// Constructors

	/** default constructor */
	public StateProvinceRegion() {
	}

	/** minimal constructor */
	public StateProvinceRegion(Country country, String dataKey, String dataName, String status, Date createTimestamp) {
		this.country = country;
		this.dataKey = dataKey;
		this.dataName = dataName;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public StateProvinceRegion(Country country, String dataKey, String dataName, String status, Date createTimestamp,
			Date updateTimestamp, Set<ShopLocation> shopLocations) {
		this.country = country;
		this.dataKey = dataKey;
		this.dataName = dataName;
		this.status = status;
		this.createTimestamp = createTimestamp;
		this.updateTimestamp = updateTimestamp;
		this.shopLocations = shopLocations;
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
	@JoinColumn(name = "country_id", nullable = false)

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "data_key", nullable = false, length = 45)

	public String getDataKey() {
		return this.dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	@Column(name = "data_name", nullable = false, length = 200)

	public String getDataName() {
		return this.dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stateProvinceRegion")

	public Set<ShopLocation> getShopLocations() {
		return this.shopLocations;
	}

	public void setShopLocations(Set<ShopLocation> shopLocations) {
		this.shopLocations = shopLocations;
	}

}
