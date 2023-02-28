package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.timesheet.utils.Utils;

@Entity
@Table(name = "restrictions")
public class Restrictions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "today_date")
	private Date todayDate = new Date();
	private Suppliers suppliers;
	@Column(name = "closeMonth")
	private Long closeMonth;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@Column(name = "restrictions")
	private Long restrictions;
	
	@Column(name = "totDebit")
	private Double totDebit;
	
	@Column(name = "totCredit")
	private Double totCredit;
	
	@Column(name = "document_type")
	private String documentType
;
	
	@Column(name = "title_restriction")
	private String titleRestriction
;
	
	public String getTitleRestriction() {
		return titleRestriction;
	}

	public void setTitleRestriction(String titleRestriction) {
		this.titleRestriction = titleRestriction;
	}

	@Column(columnDefinition = "double default '0'")
	private double exchangeRate
;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfCurrencies definitionOfCurrencies;
	
	
	public boolean isIsduplicated() {
		return isduplicated;
	}

	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
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

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Restrictions other = (Restrictions) obj;
		
	
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
	
	
		return true;
	}

	/**
	 * @return the picName
	 */

	/**
	 * @return the isDeleted
	 */
	
	

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	






	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




	


	public Date getTodayDate() {
		return todayDate;
	}


	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	public Double getTotDebit() {
		return totDebit;
	}

	public void setTotDebit(Double totDebit) {
		this.totDebit = totDebit;
	}

	public Double getTotCredit() {
		return totCredit;
	}

	public void setTotCredit(Double totCredit) {
		this.totCredit = totCredit;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Long getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Long restrictions) {
		this.restrictions = restrictions;
	}

	public DefinitionOfCurrencies getDefinitionOfCurrencies() {
		return definitionOfCurrencies;
	}

	public void setDefinitionOfCurrencies(DefinitionOfCurrencies definitionOfCurrencies) {
		this.definitionOfCurrencies = definitionOfCurrencies;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Long getCloseMonth() {
		return closeMonth;
	}

	public void setCloseMonth(Long closeMonth) {
		this.closeMonth = closeMonth;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}


	

	

	





	


}
