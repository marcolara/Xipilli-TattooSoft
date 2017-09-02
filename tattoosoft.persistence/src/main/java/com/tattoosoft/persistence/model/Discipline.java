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
 * Discipline entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "discipline", catalog = "tattoosoft")

public class Discipline extends AbstractPersistentEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private ServiceGroup serviceGroup;
	private String code;
	private String name;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;
	private Set<ShopDiscipline> shopDisciplines = new HashSet<ShopDiscipline>(0);

	// Constructors

	/** default constructor */
	public Discipline() {
	}

	/** minimal constructor */
	public Discipline(ServiceGroup serviceGroup, String code, String name, String status, Date createTimestamp) {
		this.serviceGroup = serviceGroup;
		this.code = code;
		this.name = name;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public Discipline(ServiceGroup serviceGroup, String code, String name, String status, Date createTimestamp,
			Date updateTimestamp, Set<ShopDiscipline> shopDisciplines) {
		this.serviceGroup = serviceGroup;
		this.code = code;
		this.name = name;
		this.status = status;
		this.createTimestamp = createTimestamp;
		this.updateTimestamp = updateTimestamp;
		this.shopDisciplines = shopDisciplines;
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
	@JoinColumn(name = "service_group_id", nullable = false)

	public ServiceGroup getServiceGroup() {
		return this.serviceGroup;
	}

	public void setServiceGroup(ServiceGroup serviceGroup) {
		this.serviceGroup = serviceGroup;
	}

	@Column(name = "code", nullable = false, length = 45)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "discipline")

	public Set<ShopDiscipline> getShopDisciplines() {
		return this.shopDisciplines;
	}

	public void setShopDisciplines(Set<ShopDiscipline> shopDisciplines) {
		this.shopDisciplines = shopDisciplines;
	}

}
