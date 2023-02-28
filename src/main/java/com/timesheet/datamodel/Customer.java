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
import javax.persistence.Transient;

import com.timesheet.utils.Utils;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "customer_name_ar")
	private String customerNameAr;
	@Column(name = "customer_name_en")
	private String customerNameEn;
	@Column(name = "tax_number")
	private Long taxNumber;
	@Column(name = "customer_id_number")
	private Long customerIdNumber;
	@Column(name = "responsible_person")
	private String responsiblePerson;
	@Column(name = "address")
	private String address;
	@Column(name = "issuing_authority")
	private String 	issuingAuthority
;
	@Column(name = "address_en")
	private String addressEN;
	private String grpDesc;
	
	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<Bills> billsList;
	
 
	
	@Column(name = "code_number")
	private Long codeNumber;
	
	@Column(name = "previous_code")
	private Long previousCode
;
	 
	private Long groupingId;

 @OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<SellOrder> sellOrderList;
	
 
	
	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<WarehouseReceipt> warehouseReceiptList;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "fax_number")
	private String faxNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "credit_limit")
	private Long creditLimit;
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "sale_tax_number")
	private String saleTaxNumber
;
	@Column(name = "company_activity_nature")
	private String  companyActivityNature;   

	private Long grpname;

	@Column(name = "ref")
	private String  ref;   

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	

	private Double balance;

	@Column(name = "opening_balances")
	private Double openingBalances
;

	
	@Column(name = "delegate")
	private String delegate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Analytical analytical;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DelegateCoding delegateCoding;
	
	
	@Column(name = "delegate_final")
	private String delegateFinal;
	
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
	 */






	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Customer other = (Customer) obj;
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
	 * @return the picName
	 */

	/**
	 * @return the isDeleted
	 */
	


	public String getCompanyActivityNature() {
		return companyActivityNature;
	}

	public void setCompanyActivityNature(String companyActivityNature) {
		this.companyActivityNature = companyActivityNature;
	}
	

	

	

	

	


	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
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

	

	public String getCustomerNameAr() {
		return customerNameAr;
	}

	public void setCustomerNameAr(String customerNameAr) {
		this.customerNameAr = customerNameAr;
	}

	public String getCustomerNameEn() {
		return customerNameEn;
	}

	public void setCustomerNameEn(String customerNameEn) {
		this.customerNameEn = customerNameEn;
	}

	public Long getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(Long taxNumber) {
		this.taxNumber = taxNumber;
	}

	public Long getCustomerIdNumber() {
		return customerIdNumber;
	}

	public void setCustomerIdNumber(Long customerIdNumber) {
		this.customerIdNumber = customerIdNumber;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public Long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Long creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getSaleTaxNumber() {
		return saleTaxNumber;
	}

	public void setSaleTaxNumber(String saleTaxNumber) {
		this.saleTaxNumber = saleTaxNumber;
	}

	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	public String getDelegate() {
		return delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}

	public Long getCodeNumber() {
		return codeNumber;
	}

	public Long getPreviousCode() {
		return previousCode;
	}

	public void setCodeNumber(Long codeNumber) {
		this.codeNumber = codeNumber;
	}

	public void setPreviousCode(Long previousCode) {
		this.previousCode = previousCode;
	}

	public Double getOpeningBalances() {
		return openingBalances;
	}

	public void setOpeningBalances(Double openingBalances) {
		this.openingBalances = openingBalances;
	}

	public List<SellOrder> getSellOrderList() {
		return sellOrderList;
	}

	public void setSellOrderList(List<SellOrder> sellOrderList) {
		this.sellOrderList = sellOrderList;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public List<WarehouseReceipt> getWarehouseReceiptList() {
		return warehouseReceiptList;
	}

	public void setWarehouseReceiptList(List<WarehouseReceipt> warehouseReceiptList) {
		this.warehouseReceiptList = warehouseReceiptList;
	}

	public Long getGroupingId() {
		return groupingId;
	}

	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public Long getGrpname() {
		return grpname;
	}

	public void setGrpname(Long grpname) {
		this.grpname = grpname;
	}

	public Analytical getAnalytical() {
		return analytical;
	}

	public void setAnalytical(Analytical analytical) {
		this.analytical = analytical;
	}

	public DelegateCoding getDelegateCoding() {
		return delegateCoding;
	}

	public void setDelegateCoding(DelegateCoding delegateCoding) {
		this.delegateCoding = delegateCoding;
	}

	public String getDelegateFinal() {
		return delegateFinal;
	}

	public void setDelegateFinal(String delegateFinal) {
		this.delegateFinal = delegateFinal;
	}

	public List<Bills> getBillsList() {
		return billsList;
	}

	public void setBillsList(List<Bills> billsList) {
		this.billsList = billsList;
	}

	public String getAddressEN() {
		return addressEN;
	}

	public void setAddressEN(String addressEN) {
		this.addressEN = addressEN;
	}




	

	


	
	


}
