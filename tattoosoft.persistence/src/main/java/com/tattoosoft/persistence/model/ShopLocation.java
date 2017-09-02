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
 * ShopLocation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop_location", catalog = "tattoosoft")

public class ShopLocation extends AbstractPersistentEntity implements java.io.Serializable {

	// Fields

	private Integer id;
	private Country country;
	private StateProvinceRegion stateProvinceRegion;
	private String name;
	private String description;
	private String address1;
	private String address2;
	private String cityTown;
	private String zipPostalCode;
	private String phone;
	private String fax;
	private String contactEmail;
	private String logo;
	private String shopUrl;
	private String status;
	private Date createTimestamp;
	private Date updateTimestamp;
	private Set<ShopDiscipline> shopDisciplines = new HashSet<ShopDiscipline>(0);
	private Set<ShopHours> shopHourses = new HashSet<ShopHours>(0);
	private Set<ShopEmployeeGroup> shopEmployeeGroups = new HashSet<ShopEmployeeGroup>(0);

	// Constructors

	/** default constructor */
	public ShopLocation() {
	}

	/** minimal constructor */
	public ShopLocation(Country country, StateProvinceRegion stateProvinceRegion, String name, String address1,
			String cityTown, String zipPostalCode, String phone, String status, Date createTimestamp) {
		this.country = country;
		this.stateProvinceRegion = stateProvinceRegion;
		this.name = name;
		this.address1 = address1;
		this.cityTown = cityTown;
		this.zipPostalCode = zipPostalCode;
		this.phone = phone;
		this.status = status;
		this.createTimestamp = createTimestamp;
	}

	/** full constructor */
	public ShopLocation(Country country, StateProvinceRegion stateProvinceRegion, String name, String description,
			String address1, String address2, String cityTown, String zipPostalCode, String phone, String fax,
			String contactEmail, String logo, String shopUrl, String status, Date createTimestamp, Date updateTimestamp,
			Set<ShopDiscipline> shopDisciplines, Set<ShopHours> shopHourses,
			Set<ShopEmployeeGroup> shopEmployeeGroups) {
		this.country = country;
		this.stateProvinceRegion = stateProvinceRegion;
		this.name = name;
		this.description = description;
		this.address1 = address1;
		this.address2 = address2;
		this.cityTown = cityTown;
		this.zipPostalCode = zipPostalCode;
		this.phone = phone;
		this.fax = fax;
		this.contactEmail = contactEmail;
		this.logo = logo;
		this.shopUrl = shopUrl;
		this.status = status;
		this.createTimestamp = createTimestamp;
		this.updateTimestamp = updateTimestamp;
		this.shopDisciplines = shopDisciplines;
		this.shopHourses = shopHourses;
		this.shopEmployeeGroups = shopEmployeeGroups;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_province_region_id", nullable = false)

	public StateProvinceRegion getStateProvinceRegion() {
		return this.stateProvinceRegion;
	}

	public void setStateProvinceRegion(StateProvinceRegion stateProvinceRegion) {
		this.stateProvinceRegion = stateProvinceRegion;
	}

	@Column(name = "name", nullable = false, length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "address_1", nullable = false, length = 128)

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address_2", length = 128)

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city_town", nullable = false, length = 128)

	public String getCityTown() {
		return this.cityTown;
	}

	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}

	@Column(name = "zip_postal_code", nullable = false, length = 10)

	public String getZipPostalCode() {
		return this.zipPostalCode;
	}

	public void setZipPostalCode(String zipPostalCode) {
		this.zipPostalCode = zipPostalCode;
	}

	@Column(name = "phone", nullable = false, length = 45)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "fax", length = 45)

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "contact_email", length = 200)

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Column(name = "logo")

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "shop_url", length = 200)

	public String getShopUrl() {
		return this.shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shopLocation")

	public Set<ShopDiscipline> getShopDisciplines() {
		return this.shopDisciplines;
	}

	public void setShopDisciplines(Set<ShopDiscipline> shopDisciplines) {
		this.shopDisciplines = shopDisciplines;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shopLocation")

	public Set<ShopHours> getShopHourses() {
		return this.shopHourses;
	}

	public void setShopHourses(Set<ShopHours> shopHourses) {
		this.shopHourses = shopHourses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shopLocation")

	public Set<ShopEmployeeGroup> getShopEmployeeGroups() {
		return this.shopEmployeeGroups;
	}

	public void setShopEmployeeGroups(Set<ShopEmployeeGroup> shopEmployeeGroups) {
		this.shopEmployeeGroups = shopEmployeeGroups;
	}

}
