/**
 * 
 */
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




/**
 * @author Malek Yaseen
 *
 */
@Table(name = "sheetDetail")
@Entity
public class SheetDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6515984821274251361L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	private AgentsInfo agent;

	@OneToOne(fetch = FetchType.LAZY)
	private ServiceType serviceType;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@Column
	@Temporal(TemporalType.TIME)
	private Date fromHour;

	@Column
	@Temporal(TemporalType.TIME)
	private Date toHour;

	@Column
	@Temporal(TemporalType.DATE)
	private Date todayDate;

	@OneToOne
	private YearsInfo year;

	@Column(columnDefinition = "float")
	private Long totalHours;

	@Column(columnDefinition = "float")
	private Long totalOverTime;

	@Column(columnDefinition = "float")
	private Long officialHours;
	
	@OneToOne
	private UserType userType;
	
	
	@OneToOne(fetch=FetchType.LAZY)
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
	 * @return the agent
	 */
	public AgentsInfo getAgent() {
		return agent;
	}

	/**
	 * @param agent
	 *            the agent to set
	 */
	public void setAgent(AgentsInfo agent) {
		this.agent = agent;
	}

	/**
	 * @return the serviceType
	 */
	public ServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType
	 *            the serviceType to set
	 */
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
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

	/**
	 * @return the fromHour
	 */
	public Date getFromHour() {
		return fromHour;
	}

	/**
	 * @param fromHour
	 *            the fromHour to set
	 */
	public void setFromHour(Date fromHour) {
		this.fromHour = fromHour;
	}

	/**
	 * @return the toHour
	 */
	public Date getToHour() {
		return toHour;
	}

	/**
	 * @param toHour
	 *            the toHour to set
	 */
	public void setToHour(Date toHour) {
		this.toHour = toHour;
	}

	/**
	 * @return the todayDate
	 */
	public Date getTodayDate() {
		return todayDate;
	}

	/**
	 * @param todayDate
	 *            the todayDate to set
	 */
	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	/**
	 * @return the year
	 */
	public YearsInfo getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(YearsInfo year) {
		this.year = year;
	}

	/**
	 * @return the totalHours
	 */
	public Long getTotalHours() {
		return totalHours;
	}

	/**
	 * @param totalHours
	 *            the totalHours to set
	 */
	public void setTotalHours(Long totalHours) {
		this.totalHours = totalHours;
	}

	/**
	 * @return the totalOverTime
	 */
	public Long getTotalOverTime() {
		return totalOverTime;
	}

	/**
	 * @param totalOverTime
	 *            the totalOverTime to set
	 */
	public void setTotalOverTime(Long totalOverTime) {
		this.totalOverTime = totalOverTime;
	}

	/**
	 * @return the officialHours
	 */
	public Long getOfficialHours() {
		return officialHours;
	}

	/**
	 * @param officialHours
	 *            the officialHours to set
	 */
	public void setOfficialHours(Long officialHours) {
		this.officialHours = officialHours;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
}
