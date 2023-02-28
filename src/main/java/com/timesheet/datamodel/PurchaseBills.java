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
@Table(name = "purchasebills")
public class PurchaseBills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "bills_suppliers_number")
	private Long billsSuppliersNumber;
	@Column(name = "bills_date")
	private Date billsDate;
	@Column(name = "today_date")
	private Date todayDate = new Date();
	@Column(name = "due_date")
	private Date  dueDate;
	@Column(name = "description")
	private String description;

	@Column(name = "document_type")
	private String documentType
;
	@Column(name = "purchase_bills_number")
	private Long purchaseBillsNumber;
	@Column(name = "bank")
	private String bank;
	
	@Column(name = "closeMonth")
	private Long closeMonth;
	@Column(columnDefinition = "double default '0'")
	private double exchangeRate
;
	@Column(name = "account_beneficiary")
	private String accountBeneficiary;

	@Column(name = "total_characters")
	private String totalCharacters ;
	
	@Column(name = "total")
	private Double total;
	
	
	@Column(name = "commodity_services")
	private Long commodityServices;
	
	@Column(name = "total_final")
	private Double totalFinal;
	
	@Column(name = "total_discount_Tax")
	private Double totaldiscountTax;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DiscountTax discountTax;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(name = "sale_tax_number")
	private String saleTaxNumber
;
	@Column(name = "national_company_number")
	private Long nationalCompanyNumber;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private WarehouseEntryVoucher warehouseEntryVoucher;


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliersCode;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfCurrencies definitionOfCurrencies;
	
	private ServicesProducts servicesProducts;

	@ManyToOne(fetch=FetchType.LAZY)
	private BillManagement billManagement;
	
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
		PurchaseBills other = (PurchaseBills) obj;
		
	
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


	public Date getBillsDate() {
		return billsDate;
	}

	public void setBillsDate(Date billsDate) {
		this.billsDate = billsDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public String getAccountBeneficiary() {
		return accountBeneficiary;
	}


	public void setAccountBeneficiary(String accountBeneficiary) {
		this.accountBeneficiary = accountBeneficiary;
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


	public String getTotalCharacters() {
		return totalCharacters;
	}


	public void setTotalCharacters(String totalCharacters) {
		this.totalCharacters = totalCharacters;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public Long getBillsSuppliersNumber() {
		return billsSuppliersNumber;
	}

	public void setBillsSuppliersNumber(Long billsSuppliersNumber) {
		this.billsSuppliersNumber = billsSuppliersNumber;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Long getPurchaseBillsNumber() {
		return purchaseBillsNumber;
	}

	public void setPurchaseBillsNumber(Long purchaseBillsNumber) {
		this.purchaseBillsNumber = purchaseBillsNumber;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getSaleTaxNumber() {
		return saleTaxNumber;
	}

	public void setSaleTaxNumber(String saleTaxNumber) {
		this.saleTaxNumber = saleTaxNumber;
	}

	public Long getNationalCompanyNumber() {
		return nationalCompanyNumber;
	}

	public void setNationalCompanyNumber(Long nationalCompanyNumber) {
		this.nationalCompanyNumber = nationalCompanyNumber;
	}

	public Double getTotalFinal() {
		return totalFinal;
	}

	public void setTotalFinal(Double totalFinal) {
		this.totalFinal = totalFinal;
	}

	public Double getTotaldiscountTax() {
		return totaldiscountTax;
	}

	public void setTotaldiscountTax(Double totaldiscountTax) {
		this.totaldiscountTax = totaldiscountTax;
	}

	public DiscountTax getDiscountTax() {
		return discountTax;
	}

	public void setDiscountTax(DiscountTax discountTax) {
		this.discountTax = discountTax;
	}

	public Long getCommodityServices() {
		return commodityServices;
	}

	public void setCommodityServices(Long commodityServices) {
		this.commodityServices = commodityServices;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Suppliers getSuppliersCode() {
		return suppliersCode;
	}

	public void setSuppliersCode(Suppliers suppliersCode) {
		this.suppliersCode = suppliersCode;
	}

	public WarehouseEntryVoucher getWarehouseEntryVoucher() {
		return warehouseEntryVoucher;
	}

	public void setWarehouseEntryVoucher(WarehouseEntryVoucher warehouseEntryVoucher) {
		this.warehouseEntryVoucher = warehouseEntryVoucher;
	}

	public Long getCloseMonth() {
		return closeMonth;
	}

	public void setCloseMonth(Long closeMonth) {
		this.closeMonth = closeMonth;
	}

	

}
