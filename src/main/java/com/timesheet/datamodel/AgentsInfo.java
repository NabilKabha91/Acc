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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agents_Info")
public class AgentsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8879809539644819646L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "agent_name_ar")
	private String AgentNameAr;
	@Column(name = "agent_name_en")
	private String AgentNameEn;
	@Column(name = "address")
	private String Address;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "pox")
	private String pox;
	@Column(name = "fax_number")
	private String faxNumber;
	@Column(name = "email")
	private String email;
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;

	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "agentsInfo", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<YearsInfo> years;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPox() {
		return pox;
	}

	public void setPox(String pox) {
		this.pox = pox;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAgentNameAr() {
		return AgentNameAr;
	}

	public void setAgentNameAr(String agentNameAr) {
		AgentNameAr = agentNameAr;
	}

	public String getAgentNameEn() {
		return AgentNameEn;
	}

	public void setAgentNameEn(String agentNameEn) {
		AgentNameEn = agentNameEn;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public List<YearsInfo> getYears() {
		return years;
	}

	public void setYears(List<YearsInfo> years) {
		this.years = years;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
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
		result = prime * result + ((AgentNameAr == null) ? 0 : AgentNameAr.hashCode());
		result = prime * result + ((AgentNameEn == null) ? 0 : AgentNameEn.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		AgentsInfo other = (AgentsInfo) obj;
		if (AgentNameAr == null) {
			if (other.AgentNameAr != null)
				return false;
		} else if (!AgentNameAr.equals(other.AgentNameAr))
			return false;
		if (AgentNameEn == null) {
			if (other.AgentNameEn != null)
				return false;
		} else if (!AgentNameEn.equals(other.AgentNameEn))
			return false;
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
		return true;
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

}
