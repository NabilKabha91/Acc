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
@Table(name = "goodsTransferReceiptProof")
public class GoodsTransferReceiptProof implements Serializable {

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
	
	@Column(name = "payment_method")
	private Long paymentMethod;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private GoodsTransferSlips goodsTransferSlips;

	
	@Column(name = "goodsTransferReceiptProof_number")
	private Long goodsTransferReceiptProofNumber;
	
	@Column(name = "amount_receved")
	private Double amountReceved;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private OrdarsItem ordarsItem;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Warehouses fromWarehouses;

	@ManyToOne(fetch=FetchType.LAZY)
	private Warehouses toWarehouses;

	@Column(name = "quantity_to")
	private Long quantityTo;
	@Column(name = "quantity_from")
	private Long quantityFrom;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(name = "document_type")
	private String documentType
;
	@Column(name = "note")
	private String note
;

	
	
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
		GoodsTransferReceiptProof other = (GoodsTransferReceiptProof) obj;
		
	
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

	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public OrdarsItem getOrdarsItem() {
		return ordarsItem;
	}


	public void setOrdarsItem(OrdarsItem ordarsItem) {
		this.ordarsItem = ordarsItem;
	}


	public Long getQuantityTo() {
		return quantityTo;
	}


	public void setQuantityTo(Long quantityTo) {
		this.quantityTo = quantityTo;
	}


	public Long getQuantityFrom() {
		return quantityFrom;
	}


	public void setQuantityFrom(Long quantityFrom) {
		this.quantityFrom = quantityFrom;
	}



	public Long getGoodsTransferReceiptProofNumber() {
		return goodsTransferReceiptProofNumber;
	}

	public void setGoodsTransferReceiptProofNumber(Long goodsTransferReceiptProofNumber) {
		this.goodsTransferReceiptProofNumber = goodsTransferReceiptProofNumber;
	}

	public Warehouses getFromWarehouses() {
		return fromWarehouses;
	}

	public Warehouses getToWarehouses() {
		return toWarehouses;
	}

	public void setFromWarehouses(Warehouses fromWarehouses) {
		this.fromWarehouses = fromWarehouses;
	}

	public void setToWarehouses(Warehouses toWarehouses) {
		this.toWarehouses = toWarehouses;
	}

	public GoodsTransferSlips getGoodsTransferSlips() {
		return goodsTransferSlips;
	}

	public void setGoodsTransferSlips(GoodsTransferSlips goodsTransferSlips) {
		this.goodsTransferSlips = goodsTransferSlips;
	}

}
