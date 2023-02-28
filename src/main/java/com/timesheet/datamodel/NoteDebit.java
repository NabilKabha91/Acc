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
@Table(name = "notedebit")
public class NoteDebit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "closeMonth")
	private Long closeMonth;
	@Column(name = "today_date")
	private Date todayDate = new Date();
	//@ManyToOne(fetch=FetchType.LAZY)
	
	private Long groupingId;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "groupingId1")
	private Long groupingId1;
	
	@Column(name = "groupingId2")
	private Long groupingId2;
	
	@Column(name = "groupingId3")
	private Long groupingId3;
	public Long getGroupingId3() {
		return groupingId3;
	}

	public void setGroupingId3(Long groupingId3) {
		this.groupingId3 = groupingId3;
	}

	public Long getGroupingId1() {
		return groupingId1;
	}

	public void setGroupingId1(Long groupingId1) {
		this.groupingId1 = groupingId1;
	}

	public Long getGroupingId2() {
		return groupingId2;
	}

	public void setGroupingId2(Long groupingId2) {
		this.groupingId2 = groupingId2;
	}

	@Column(name = "inital_amount")
	private Double initalAmount;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfCurrencies definitionOfCurrencies;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseBills purchaseBills;

	@Column(name = "suppliers_customer")
	private Long suppliersCustomer;
	
	@Column(name = "document_type")
	private String documentType
;
	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	
	
	@Column(name = "bill")
	private Long bill;
	
	@Column(name = "returnValueAndCostOne",columnDefinition = "double default '0'")
	private double returnValueAndCostOne;
	
	@Column(columnDefinition = "double default '0'")
	private double exchangeRate
;
	



	
	@Column(name = "note_Debit_number")
	private Long notedebitNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(name = "note")
	private String note
;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Bills bills;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
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
		NoteDebit other = (NoteDebit) obj;
		
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



	public Long getGroupingId() {
		return groupingId;
	}

	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
	}

	public DefinitionOfCurrencies getDefinitionOfCurrencies() {
		return definitionOfCurrencies;
	}

	public void setDefinitionOfCurrencies(DefinitionOfCurrencies definitionOfCurrencies) {
		this.definitionOfCurrencies = definitionOfCurrencies;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getNotedebitNumber() {
		return notedebitNumber;
	}

	public void setNotedebitNumber(Long notedebitNumber) {
		this.notedebitNumber = notedebitNumber;
	}

	public Double getInitalAmount() {
		
	
		return initalAmount;
	}

	public void setInitalAmount(Double initalAmount) {
		this.initalAmount = initalAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Long getSuppliersCustomer() {
		return suppliersCustomer;
	}

	public void setSuppliersCustomer(Long suppliersCustomer) {
		this.suppliersCustomer = suppliersCustomer;
	}

	public Long getBill() {
		return bill;
	}

	public void setBill(Long bill) {
		this.bill = bill;
	}

	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public PurchaseBills getPurchaseBills() {
		return purchaseBills;
	}

	public void setPurchaseBills(PurchaseBills purchaseBills) {
		this.purchaseBills = purchaseBills;
	}

	public Long getCloseMonth() {
		return closeMonth;
	}

	public void setCloseMonth(Long closeMonth) {
		this.closeMonth = closeMonth;
	}

	public double getReturnValueAndCostOne() {
		return returnValueAndCostOne;
	}

	public void setReturnValueAndCostOne(double returnValueAndCostOne) {
		this.returnValueAndCostOne = returnValueAndCostOne;
	}



	
	





	

	

	


	


}
