package com.timesheet.datamodel;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.springframework.util.CollectionUtils;

@Entity
@Table
public class YearUsersType implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2329277674305912888L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<YearsUserTypeInfo> yinfo;

	@OneToOne
	private ServiceType serviceType;

	@Column
	private Float totalExpectedHours;
	
	@Column
	private Float totalHourAvg;
	
	@Column
	private Float totalEstimatedCosts;

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

	public List<YearsUserTypeInfo> getYinfo() {
		return yinfo;
	}

	public void setYinfo(List<YearsUserTypeInfo> yinfo) {
		this.yinfo = yinfo;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Float getTotalExpectedHours() {
		if (!CollectionUtils.isEmpty(yinfo)) {
			totalExpectedHours = (float) this.yinfo.stream().mapToLong(item -> (null != item.getExpectedTime() ? item.getExpectedTime() : 0)).sum();
		}
		return totalExpectedHours;
	}

	public void setTotalExpectedHours(Float totalExpectedHours) {
		this.totalExpectedHours = totalExpectedHours;
	}

	/**
	 * @return the totalHourAvg
	 */
	public Float getTotalHourAvg() {
		float estHour = getTotalExpectedHours();
		totalHourAvg = estHour != 0 ? getTotalEstimatedCosts() / estHour : 0;
		return totalHourAvg;
	}

	/**
	 * @param totalHourAvg the totalHourAvg to set
	 */
	public void setTotalHourAvg(Float totalHourAvg) {
		this.totalHourAvg = totalHourAvg;
	}

	/**
	 * @return the totalEstimatedCosts
	 */
	public Float getTotalEstimatedCosts() {
		if (!CollectionUtils.isEmpty(yinfo)) {
			totalEstimatedCosts = (float) this.yinfo.stream().mapToLong(item -> (null != item.getEstimatedCosts() ? item.getEstimatedCosts() : 0)).sum();
		}
		return totalEstimatedCosts;
	}

	/**
	 * @param totalEstimatedCosts the totalEstimatedCosts to set
	 */
	public void setTotalEstimatedCosts(Float totalEstimatedCosts) {
		this.totalEstimatedCosts = totalEstimatedCosts;
	}

}
