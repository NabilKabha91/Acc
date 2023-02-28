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
@Table(name = "receivepayment")
public class ReceivePayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "total")
	private Double total;
	@Column(name = "today_date")
	private Date todayDate = new Date();
	
	@Column(name = "closeMonth")
	private Long closeMonth;
	@Column(name = "payment_method")
	private Long paymentMethod;
	
	@Column(name = "batch_type")
	private Long batchType;
	
	@Column(name = "value")
	private Double value=0.0;	
	
	@Column(name = "value_written")
	private String valueWritten
;
	@ManyToOne(fetch=FetchType.LAZY)
	private CostCenter costCenter;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Analytical analytical;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	@Column(name = "receive_payment_number")
	private Long receivePaymentNumber;
	
	@Column(name = "amount_receved")
	private Double amountReceved;	
	
	private int intPart;
	
	private Double decimalPart;
	
	private Long groupingId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(name = "document_type")
	private String documentType
;
	@Column(name = "note")
	private String note
;
	@Column(name = "amount_written")
	private String amountWritten
;
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfCurrencies definitionOfCurrencies;
	
	private ServicesProducts servicesProducts;

	@ManyToOne(fetch=FetchType.LAZY)
	private BillManagement billManagement;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Bills bills;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private BankData bankData;

	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "close_Financial")
	private Date closeFinancial;
	
	public boolean isIsduplicated() {
		return isduplicated;
	}

	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@Column(name = "select_Company")
	private Long selectCompany;
	
	
	
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
		ReceivePayment other = (ReceivePayment) obj;
		
	
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

	public Date getCloseFinancial() {
		return closeFinancial;
	}

	public void setCloseFinancial(Date closeFinancial) {
		this.closeFinancial = closeFinancial;
	}

	public Long getSelectCompany() {
		return selectCompany;
	}

	public void setSelectCompany(Long selectCompany) {
		this.selectCompany = selectCompany;
	}




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	


	

	public ServicesProducts getServicesProducts() {
		return servicesProducts;
	}


	public void setServicesProducts(ServicesProducts servicesProducts) {
		this.servicesProducts = servicesProducts;
	}


	public Date getTodayDate() {
		return todayDate;
	}


	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}



	public void setValueBeforeTax(Long valueBeforeTax) {
	}



	

	public BillManagement getBillManagement() {
		return billManagement;
	}


	public void setBillManagement(BillManagement billManagement) {
		this.billManagement = billManagement;
	}


	public BankData getBankData() {
		return bankData;
	}


	public void setBankData(BankData bankData) {
		this.bankData = bankData;
	}


	public DefinitionOfCurrencies getDefinitionOfCurrencies() {
		return definitionOfCurrencies;
	}


	public void setDefinitionOfCurrencies(DefinitionOfCurrencies definitionOfCurrencies) {
		this.definitionOfCurrencies = definitionOfCurrencies;
	}


	


	public Long getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(Long paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public Double getAmountReceved() {
		return amountReceved;
	}


	public void setAmountReceved(Double amountReceved) {
		this.amountReceved = amountReceved;
	}


	public Bills getBills() {
		return bills;
	}


	public void setBills(Bills bills) {
		this.bills = bills;
	}





	public Long getGroupingId() {
		return groupingId;
	}


	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
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


	public Long getReceivePaymentNumber() {
		return receivePaymentNumber;
	}


	public void setReceivePaymentNumber(Long receivePaymentNumber) {
		this.receivePaymentNumber = receivePaymentNumber;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public Long getBatchType() {
		return batchType;
	}


	public void setBatchType(Long batchType) {
		this.batchType = batchType;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public String getValueWritten() {
		return valueWritten;
	}


	public void setValueWritten(String valueWritten) {
		this.valueWritten = valueWritten;
	}


	public String getAmountWritten() {
		return amountWritten;
	}


	public void setAmountWritten(String amountWritten) {
		this.amountWritten = amountWritten;
	}


	public int getIntPart() {
		return intPart;
	}


	public void setIntPart(int intPart) {
		this.intPart = intPart;
	}


	public Double getDecimalPart() {
		return decimalPart;
	}


	public void setDecimalPart(Double decimalPart) {
		this.decimalPart = decimalPart;
	}


	public CostCenter getCostCenter() {
		return costCenter;
	}


	public Analytical getAnalytical() {
		return analytical;
	}


	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}


	public void setAnalytical(Analytical analytical) {
		this.analytical = analytical;
	}


	public Long getCloseMonth() {
		return closeMonth;
	}


	public void setCloseMonth(Long closeMonth) {
		this.closeMonth = closeMonth;
	}


	










}
