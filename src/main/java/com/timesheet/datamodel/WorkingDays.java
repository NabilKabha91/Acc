package com.timesheet.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "working_days")
public class WorkingDays implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5278638712169655048L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int day;

	@Column
	private String dayName;

	@Column(columnDefinition = "double default '0'")
	private Double workingHours;

	@Column(name = "active_day", columnDefinition = "BIT not null  default b'0'")
	private boolean activeDay;

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
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the dayName
	 */
	public String getDayName() {
		return dayName;
	}

	/**
	 * @param dayName
	 *            the dayName to set
	 */
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}



	/**
	 * @return the workingHours
	 */
	public Double getWorkingHours() {
		return workingHours;
	}

	/**
	 * @param workingHours the workingHours to set
	 */
	public void setWorkingHours(Double workingHours) {
		this.workingHours = workingHours;
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
		result = prime * result + day;
		result = prime * result + ((dayName == null) ? 0 : dayName.hashCode());
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
		WorkingDays other = (WorkingDays) obj;
		if (day != other.day)
			return false;
		if (dayName == null) {
			if (other.dayName != null)
				return false;
		} else if (!dayName.equals(other.dayName))
			return false;
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
		return "WorkingDays [id=" + id + ", day=" + day + ", dayName=" + dayName + ", workingHours=" + workingHours
				+ "]";
	}

	/**
	 * @return the activeDay
	 */
	public boolean isActiveDay() {
		return activeDay;
	}

	/**
	 * @param activeDay
	 *            the activeDay to set
	 */
	public void setActiveDay(boolean activeDay) {
		this.activeDay = activeDay;
	}

}