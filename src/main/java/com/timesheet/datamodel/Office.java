package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table
@Entity
public class Office implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5702478816641447774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "varchar(1000) ")
	private String nameAr;

	@Column(columnDefinition = "varchar(1000) ")
	private String nameEn;
	@Column(columnDefinition = "varchar(40) ")
	private String phoneNumber;
	@Column(columnDefinition = "varchar(40) ")
	private String email;
	@Column(columnDefinition = "varchar(1000) ")
	private String address;
	@Column(columnDefinition = "varchar(10) ")
	private String po;
	@Column(columnDefinition = "varchar(100) ")
	private String logoName;

	@Column(columnDefinition = "double default '0'")
	private double officeHour;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<WorkingDays> workingDays = new ArrayList<WorkingDays>();

	@Column(columnDefinition = "int default '0'")
	private int countUser;
	
	@Column(columnDefinition = "int default '0'")
	private int countCompany;

	@Basic(optional = true)
	@Lob
	@Column(name = "logo", nullable = true)
	private byte[] logo;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Office [id=" + id + ", nameAr=" + nameAr + ", nameEn=" + nameEn + ", email=" + email + "]";
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameAr == null) ? 0 : nameAr.hashCode());
		result = prime * result + ((nameEn == null) ? 0 : nameEn.hashCode());
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
		Office other = (Office) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameAr == null) {
			if (other.nameAr != null)
				return false;
		} else if (!nameAr.equals(other.nameAr))
			return false;
		if (nameEn == null) {
			if (other.nameEn != null)
				return false;
		} else if (!nameEn.equals(other.nameEn))
			return false;
		return true;
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
	 * @return the nameAr
	 */
	public String getNameAr() {
		return nameAr;
	}

	/**
	 * @param nameAr
	 *            the nameAr to set
	 */
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	/**
	 * @return the nameEn
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @param nameEn
	 *            the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the po
	 */
	public String getPo() {
		return po;
	}

	/**
	 * @param po
	 *            the po to set
	 */
	public void setPo(String po) {
		this.po = po;
	}

	/**
	 * @return the officeHour
	 */
	public double getOfficeHour() {
		return officeHour;
	}

	/**
	 * @param officeHour
	 *            the officeHour to set
	 */
	public void setOfficeHour(double officeHour) {
		this.officeHour = officeHour;
	}

	/**
	 * @return the countUser
	 */
	public int getCountUser() {
		return countUser;
	}

	/**
	 * @param countUser
	 *            the countUser to set
	 */
	public void setCountUser(int countUser) {
		this.countUser = countUser;
	}

	/**
	 * @return the workingDays
	 */
	public List<WorkingDays> getWorkingDays() {
		return workingDays;
	}

	/**
	 * @param workingDays
	 *            the workingDays to set
	 */
	public void setWorkingDays(List<WorkingDays> workingDays) {
		this.workingDays = workingDays;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	/**
	 * @return the logoName
	 */
	public String getLogoName() {
		return logoName;
	}

	/**
	 * @param logoName the logoName to set
	 */
	public void setLogoName(String logoName) {
		this.logoName = logoName;
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

	public int getCountCompany() {
		return countCompany;
	}

	public void setCountCompany(int countCompany) {
		this.countCompany = countCompany;
	}

}
