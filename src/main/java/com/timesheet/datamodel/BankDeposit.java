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
import com.timesheet.presentation.web.Grouping;

@Entity
@Table(name = "bankdeposit")
public class BankDeposit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "note")
	private String note;
	
	@Column(name = "bank_notice_number")
	private Long bankNoticeNumber
;
	
	@Column(name = "closeMonth")
	private Long closeMonth;
	@Column(name = "today_date")
	private Date todayDate = new Date();
	//@ManyToOne(fetch=FetchType.LAZY)
	
	private Long groupingIdTo;
	
	@Column(name = "amount")
	private Double amount;
	
	private Long groupingIdFrom;

	 
	@Column(name = "document_type")
	private String documentType
;
	@Column(name = "inital_amount")
	private Double initalAmount;
	@Column(name = "note_Debit_number")
	private Long bankdepositNumber;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfCurrencies definitionOfCurrencies;
	
	@Column(columnDefinition = "double default '0'")
	private double exchangeRate
;
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
	 * @return the email
	 */
	




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
		BankDeposit other = (BankDeposit) obj;
		
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



	
	public Long getBankNoticeNumber() {
		return bankNoticeNumber;
	}

	public void setBankNoticeNumber(Long bankNoticeNumber) {
		this.bankNoticeNumber = bankNoticeNumber;
	}

	public Date getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}



	public Long getGroupingIdTo() {
		return groupingIdTo;
	}

	public void setGroupingIdTo(Long groupingIdTo) {
		this.groupingIdTo = groupingIdTo;
	}

	public Long getGroupingIdFrom() {
		return groupingIdFrom;
	}

	public void setGroupingIdFrom(Long groupingIdFrom) {
		this.groupingIdFrom = groupingIdFrom;
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

	public Long getBankdepositNumber() {
		return bankdepositNumber;
	}

	public void setBankdepositNumber(Long bankdepositNumber) {
		this.bankdepositNumber = bankdepositNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DefinitionOfCurrencies getDefinitionOfCurrencies() {
		return definitionOfCurrencies;
	}

	public void setDefinitionOfCurrencies(DefinitionOfCurrencies definitionOfCurrencies) {
		this.definitionOfCurrencies = definitionOfCurrencies;
	}

	public Double getInitalAmount() {
		return initalAmount;
	}

	public void setInitalAmount(Double initalAmount) {
		this.initalAmount = initalAmount;
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

	



	

	

	


	


}
