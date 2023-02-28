package com.timesheet.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_type")

public class ServiceType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2279945377787299126L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "service_name_ar")
	private String serviceNameAr;

	@Column(name = "service_name_en")
	private String serviceNameEn;

	@Column(name = "overTime", columnDefinition = "BIT not null  default b'0'")
	private boolean overTime;

	@OneToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;

	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the serviceNameAr
	 */
	public String getServiceNameAr() {
		return serviceNameAr;
	}

	/**
	 * @param serviceNameAr
	 *            the serviceNameAr to set
	 */
	public void setServiceNameAr(String serviceNameAr) {
		this.serviceNameAr = serviceNameAr;
	}

	/**
	 * @return the serviceNameEn
	 */
	public String getServiceNameEn() {
		return serviceNameEn;
	}

	/**
	 * @param serviceNameEn
	 *            the serviceNameEn to set
	 */
	public void setServiceNameEn(String serviceNameEn) {
		this.serviceNameEn = serviceNameEn;
	}

	/**
	 * @return the overTime
	 */
	public boolean isOverTime() {
		return overTime;
	}

	/**
	 * @param overTime
	 *            the overTime to set
	 */
	public void setOverTime(boolean overTime) {
		this.overTime = overTime;
	}

	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office
	 *            the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceType other = (ServiceType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceType [id=" + id + "]";
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
