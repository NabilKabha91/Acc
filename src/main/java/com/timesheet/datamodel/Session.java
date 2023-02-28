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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "session ", uniqueConstraints = { @UniqueConstraint(name = "myconst", columnNames = { "user_id" }) })
public class Session implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2498123384350004477L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date date;

	@Column
	private String sessionId;

	@OneToOne(fetch=FetchType.LAZY)
	private User user;

	@OneToOne(fetch=FetchType.LAZY)
	private Company company;
	
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session(Long id, String sessionId, User user) {
		super();
		this.id = id;
		this.date = new Date();
		this.sessionId = sessionId;
		this.user = user;
	}

	public Session(String sessionId, User user) {
		super();

		this.date = new Date();
		this.sessionId = sessionId;
		this.user = user;
	}

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}