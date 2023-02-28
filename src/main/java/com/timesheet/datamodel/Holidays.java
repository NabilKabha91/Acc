package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Holidays implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1300921551601339698L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endtDate;

	@Column(name = "allDay")
	private boolean allDay;

	@OneToOne(fetch = FetchType.LAZY)
	private Office office;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endtDate
	 */
	public Date getEndtDate() {
		return endtDate;
	}

	/**
	 * @param endtDate
	 *            the endtDate to set
	 */
	public void setEndtDate(Date endtDate) {
		this.endtDate = endtDate;
	}

	/**
	 * @return the allDay
	 */
	public boolean isAllDay() {
		return allDay;
	}

	/**
	 * @param allDay
	 *            the allDay to set
	 */
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}