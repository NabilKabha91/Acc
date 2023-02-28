package com.timesheet.datamodel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author saeed
 *
 */
@Entity
@Table(name = "years_info")
public class YearsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1737500492857977529L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "year")
	private Date year;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<YearUsersType> yearUsersTypeList;

	@OneToOne
	private AgentsInfo agentsInfo;

	@OneToOne
	private User owner;
	
	private boolean isClose;
	
	@Column(name = "contract_type")
	private Long contractType;

	@Transient
	private List<ServiceType> yearServicesType;

	@PostLoad
	public void fillServiceList() {
		ServiceType service;
		yearServicesType = new ArrayList<ServiceType>();
		for (YearUsersType year : yearUsersTypeList) {
			service = new ServiceType();
			service = year.getServiceType();
			yearServicesType.add(service);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public AgentsInfo getAgentsInfo() {
		return agentsInfo;
	}

	public void setAgentsInfo(AgentsInfo agentsInfo) {
		this.agentsInfo = agentsInfo;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @return the yearUsersTypeList
	 */
	public List<YearUsersType> getYearUsersTypeList() {
		return yearUsersTypeList;
	}

	/**
	 * @param yearUsersTypeList
	 *            the yearUsersTypeList to set
	 */
	public void setYearUsersTypeList(List<YearUsersType> yearUsersTypeList) {
		this.yearUsersTypeList = yearUsersTypeList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "YearsInfo [id=" + id + ", year=" + year + "]";
	}

	public String toStringDate() {
		return (new SimpleDateFormat("dd/MM/yyyy")).format(year);
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
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		YearsInfo other = (YearsInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	public List<ServiceType> getYearServicesType() {
		return yearServicesType;
	}

	public void setYearServicesType(List<ServiceType> yearServicesType) {
		this.yearServicesType = yearServicesType;
	}

	public boolean isClose() {
		return isClose;
	}

	public void setClose(boolean isClose) {
		this.isClose = isClose;
	}

	public Long getContractType() {
		return contractType;
	}

	public void setContractType(Long contractType) {
		this.contractType = contractType;
	}
	
}
