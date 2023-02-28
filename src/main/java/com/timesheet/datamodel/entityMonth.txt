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
@Table(name = "closed_month")
public class Month implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1300921551601339698L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "month")
	private int month;

	@Column(name = "year")
	private int year;

	@Column(name = "close")
	private boolean close;

	@OneToOne(fetch=FetchType.LAZY)
	private Office office;

	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;

	@Column(name = "monthAr")
	private String monthAr;
	
	@Column(name = "monthEn")
	private String monthEn;
	
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
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the close
	 */
	public boolean isClose() {
		return close;
	}

	/**
	 * @param close
	 *            the close to set
	 */
	public void setClose(boolean close) {
		this.close = close;
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

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Month [id=" + id + ", month=" + month + ", year=" + year + ", close=" + close + "]";
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
		result = prime * result + (close ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + month;
		result = prime * result + year;
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
		Month other = (Month) obj;
		if (close != other.close)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/**
	 * @return the monthAr
	 */
	public String getMonthAr() {
		return monthAr;
	}

	/**
	 * @param monthAr the monthAr to set
	 */
	public void setMonthAr(String monthAr) {
		this.monthAr = monthAr;
	}

	/**
	 * @return the monthEn
	 */
	public String getMonthEn() {
		return monthEn;
	}

	/**
	 * @param monthEn the monthEn to set
	 */
	public void setMonthEn(String monthEn) {
		this.monthEn = monthEn;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	

}