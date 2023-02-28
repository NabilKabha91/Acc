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
@Table(name = "suppliers")
public class Suppliers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "suppliers_name_ar")
	private String suppliersNameAr;
	@Column(name = "suppliers_name_en")
	private String suppliersNameEn;
	@Column(name = "tax_number")
	private Long taxNumber;
	@Column(name = "suppliers_id_number")
	private Long suppliersIdNumber;
	@Column(name = "responsible_person")
	private String responsiblePerson;
	@Column(name = "address")
	private String Address;
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
	
	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "suppliers", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<PurchaseOrder> purchaseOrderList;
	
	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "suppliers", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<WarehouseEntryVoucher> warehouseEntryVoucherList;
	
	@OneToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "suppliers", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<PurchaseBills> purchaseBillsList;
	
	private Long grpname;

	
	@Column(name = "ref")
	private String  ref;   

	@Column(name = "suppliers_type")
	private Long suppliersType;
	
	@Column(name = "sale_tax_number")
	private String saleTaxNumber
;
	@Column(name = "company_activity_nature")
	private String  companyActivityNature;   

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	private Double balance;

	
	@Column(name = "issuing_authority")
	private String 	issuingAuthority
;
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	
	private String grpDesc;

	private Long groupingId;

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@Column(name = "code_number")
	private Long codeNumber;
	
	@Column(name = "previous_code")
	private Long previousCode
;
	@Column(name = "opening_balances")
	private Double openingBalances
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
		Suppliers other = (Suppliers) obj;
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
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	


	public String getSuppliersNameAr() {
		return suppliersNameAr;
	}

	public void setSuppliersNameAr(String suppliersNameAr) {
		this.suppliersNameAr = suppliersNameAr;
	}

	public String getSuppliersNameEn() {
		return suppliersNameEn;
	}

	public void setSuppliersNameEn(String suppliersNameEn) {
		this.suppliersNameEn = suppliersNameEn;
	}

	public Long getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(Long taxNumber) {
		this.taxNumber = taxNumber;
	}

	
	public Long getSuppliersIdNumber() {
		return suppliersIdNumber;
	}

	public void setSuppliersIdNumber(Long suppliersIdNumber) {
		this.suppliersIdNumber = suppliersIdNumber;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
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

	public Long getSuppliersType() {
		return suppliersType;
	}

	public void setSuppliersType(Long suppliersType) {
		this.suppliersType = suppliersType;
	}

	public Long getGroupingId() {
		return groupingId;
	}

	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
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

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public List<PurchaseOrder> getPurchaseOrderList() {
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}

	public List<WarehouseEntryVoucher> getWarehouseEntryVoucherList() {
		return warehouseEntryVoucherList;
	}

	public void setWarehouseEntryVoucherList(List<WarehouseEntryVoucher> warehouseEntryVoucherList) {
		this.warehouseEntryVoucherList = warehouseEntryVoucherList;
	}

	public Long getGrpname() {
		return grpname;
	}

	public void setGrpname(Long grpname) {
		this.grpname = grpname;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public List<PurchaseBills> getPurchaseBillsList() {
		return purchaseBillsList;
	}

	public void setPurchaseBillsList(List<PurchaseBills> purchaseBillsList) {
		this.purchaseBillsList = purchaseBillsList;
	}



	
	


}
