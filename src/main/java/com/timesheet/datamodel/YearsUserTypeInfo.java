package com.timesheet.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class YearsUserTypeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7459042128735659554L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private UserType userType;
	@Column(name = "expected_time")
	private Long expectedTime;
	@Column
	private Long hourAvg;
	@Column
	private Long estimatedCosts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Long getExpectedTime() {
		return (null != expectedTime ? expectedTime : 0);
	}

	public void setExpectedTime(Long expectedTime) {
		this.expectedTime = expectedTime;
	}

	/**
	 * @return the hourAvg
	 */
	public Long getHourAvg() {
		return (null != hourAvg ? hourAvg : 0);
	}

	/**
	 * @param hourAvg the hourAvg to set
	 */
	public void setHourAvg(Long hourAvg) {
		this.hourAvg = hourAvg;
	}

	/**
	 * @return the expectedFinance
	 */
	public Long getEstimatedCosts() {
		estimatedCosts = (null != hourAvg ? hourAvg : 0) * (null != expectedTime ? expectedTime : 0);
		return estimatedCosts;
	}

	/**
	 * @param expectedFinance the expectedFinance to set
	 */
	public void setEstimatedCosts(Long estimatedCosts) {
		this.estimatedCosts = estimatedCosts;
	}

}
