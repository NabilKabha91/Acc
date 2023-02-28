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
@Table(name = "bills")
public class Bills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "bills_number")
	private Long billsNumber;
	@Column(name = "bills_date")
	private Date billsDate;
	@Column(name = "today_date")
	private Date todayDate = new Date();
	@Column(name = "due_date")
	private Date  dueDate;
	@Column(name = "description")
	private String description;
	@Column(name = "quantity")
	private Double quantity;
	@Column(name = "total")
	private Double total;
	@Column(name = "tax")
	private Long tax;
	@Column(name = "value_before_tax")
	private Double valueBeforeTax;
	@Column(name = "total_final")
	private Double totalFinal;
	
	
	
	@Column(name = "total_comercial_Profit_Tax")
	private Double totalcomercialProfitTax;
	
	@Column(name = "total_quality_assurance")
	private Double totalqualityAssurance;
	
	@Column(name = "sale_tax_number")
	private String saleTaxNumber
;
	@Column(name = "test")
	private Long test;
	@Column(name = "legal_company_name_en")
	private String  legalCompanyNameEn;
	@Column(name = "legal_company_name")
	private String  legalCompanyName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "address_en")
	private String addressEN;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "email")
	private String email;
	
	@Column(name = "national_company_number")
	private Long nationalCompanyNumber;
	
	
	@Column(name = "commodity_services")
	private Long commodityServices;
	
	@Column(name = "bank")
	private String bank;
	
	private String ee;
	
	@Column(name = "account_beneficiary")
	private String accountBeneficiary;

	@Column(name = "total_characters")
	private String totalCharacters ;
	
	@Column(columnDefinition = "double default '0'")
	private double exchangeRate
;

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private SellOrder sellOrder;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private WarehouseReceipt warehouseReceipt;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(name = "document_type")
	private String documentType
;
	
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer1;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ComercialProfitTax comercialProfitTax;

	@ManyToOne(fetch=FetchType.LAZY)
	private QualityAssurance qualityAssurance;
	@ManyToOne(fetch=FetchType.LAZY)
	private QualityAssurance qualityAssurance2;
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
		Bills other = (Bills) obj;
		
	
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
	
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}



	public Double getTotal() {
		
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


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

	public Long getBillsNumber() {
		return billsNumber;
	}

	public void setBillsNumber(Long billsNumber) {
		this.billsNumber = billsNumber;
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




	public Long getTax() {
		return tax;
	}


	public void setTax(Long tax) {
		this.tax = tax;
	}


	public Date getTodayDate() {
		return todayDate;
	}


	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}


	public Double getValueBeforeTax() {
		Double es;
		es=servicesProducts.getSellPrice();
		valueBeforeTax=getQuantity()*es;
		return valueBeforeTax;
	}


	public void setValueBeforeTax(Double valueBeforeTax) {
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


	public double getExchangeRate() {
		return exchangeRate;
	}


	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}


	public String getEe() {
		
	if(definitionOfCurrencies.isChekBox()==true) {
			
			ee=definitionOfCurrencies.getDefinitionOfCurrenciesName();
		}
		else {

		}
		return ee;
	}


	public void setEe(String ee) {
		this.ee = ee;
	}


	public ServicesProducts getServicesProducts() {
		return servicesProducts;
	}


	public void setServicesProducts(ServicesProducts servicesProducts) {
		this.servicesProducts = servicesProducts;
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


	public String getLegalCompanyName() {
		return legalCompanyName;
	}


	public void setLegalCompanyName(String legalCompanyName) {
		this.legalCompanyName = legalCompanyName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public ComercialProfitTax getComercialProfitTax() {
		return comercialProfitTax;
	}


	public void setComercialProfitTax(ComercialProfitTax comercialProfitTax) {
		this.comercialProfitTax = comercialProfitTax;
	}


	public Double getTotalcomercialProfitTax() {
		return totalcomercialProfitTax;
	}


	public void setTotalcomercialProfitTax(Double totalcomercialProfitTax) {
		this.totalcomercialProfitTax = totalcomercialProfitTax;
	}


	public Double getTotalFinal() {
		return totalFinal;
	}


	public void setTotalFinal(Double totalFinal) {
		this.totalFinal = totalFinal;
	}


	public Customer getCustomer1() {
		return customer1;
	}


	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}


	public Long getCommodityServices() {
		return commodityServices;
	}


	public void setCommodityServices(Long commodityServices) {
		this.commodityServices = commodityServices;
	}


	public SellOrder getSellOrder() {
		return sellOrder;
	}


	public WarehouseReceipt getWarehouseReceipt() {
		return warehouseReceipt;
	}


	public void setSellOrder(SellOrder sellOrder) {
		this.sellOrder = sellOrder;
	}


	public void setWarehouseReceipt(WarehouseReceipt warehouseReceipt) {
		this.warehouseReceipt = warehouseReceipt;
	}


	public Long getTest() {
		return test;
	}


	public void setTest(Long test) {
		this.test = test;
	}


	public String getLegalCompanyNameEn() {
		return legalCompanyNameEn;
	}


	public void setLegalCompanyNameEn(String legalCompanyNameEn) {
		this.legalCompanyNameEn = legalCompanyNameEn;
	}


	public String getAddressEN() {
		return addressEN;
	}


	public void setAddressEN(String addressEN) {
		this.addressEN = addressEN;
	}


	public QualityAssurance getQualityAssurance() {
		return qualityAssurance;
	}


	public void setQualityAssurance(QualityAssurance qualityAssurance) {
		this.qualityAssurance = qualityAssurance;
	}


	public Double getTotalqualityAssurance() {
		return totalqualityAssurance;
	}


	public void setTotalqualityAssurance(Double totalqualityAssurance) {
		this.totalqualityAssurance = totalqualityAssurance;
	}


	public QualityAssurance getQualityAssurance2() {
		return qualityAssurance2;
	}


	public void setQualityAssurance2(QualityAssurance qualityAssurance2) {
		this.qualityAssurance2 = qualityAssurance2;
	}


	


}
