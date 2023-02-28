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
@Table(name = "company")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "national_company_number")
	private Long nationalCompanyNumber;
	@Column(name = "registration_Id")
	private Long registrationId;
	@Column(name = "legal_company_name")
	private String  legalCompanyName;
	
	@Column(name = "legal_company_name_en")
	private String  legalCompanyNameEn;
	
	@Column(name = "company_commercial_name")
	private String companyCommercialName;
	@Column(name = "company_type")
	private String companyType;
	@Column(name = "company_activity_nature")
	private String  companyActivityNature;   
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "company_goal")
	private String companyGoal;
	@Column(name = "address")
	private String address;
	
	@Column(name = "file_size")
	private Long fileSize;
	
	@Column(name = "actual_size")
	private Long actualSize
;
	
	
	@Column(name = "company_capital")
	private String companyCapital;
	
	@Column(name = "bill_number")
	private Long billNumber;
	
	@Column(name = "count_system")
	private Long countSystem;
	
	@Column(name = "inventory_costing")
	private Long inventoryCosting;
	
	@Column(name = "address_en")
	private String addressEn;
	
	@Column(name = "pox")
	private String pox;
	@Column(name = "fax_number")
	private String faxNumber;
	
	@Column(name = "pic_name")
	private String picName;
	
	
	@Column(name = "tax_number")
	private String taxNumber;

	@Column(name = "sale_tax_number")
	private String saleTaxNumber
;

	@Column(name = "issuing_authority")
	private String issuingAuthority;
	
	
	@Column(name = "date_of_issuance")
	private Date dateOfIssuance;
	
	
	@Column(name = "expiary_date")
	private Date expiaryDate;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@Column(columnDefinition = "int default '1'")
	private boolean isActivated;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "close_Financial")
	private Date closeFinancial;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Company parentCompany;
	
	public boolean isIsduplicated() {
		return isduplicated;
	}

	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

	@OneToOne(fetch=FetchType.LAZY)
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

	/**
	 * @return the userName
	 */
	

	/**
	 * @return the nameAr
	 */
	

	/**
	 * @return the nameEn
	 */


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
		Company other = (Company) obj;
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
	
	public String getLegalCompanyName() {
		return legalCompanyName;
	}

	public void setLegalCompanyName(String legalCompanyName) {
		this.legalCompanyName = legalCompanyName;
	}

	public String getCompanyCommercialName() {
		return companyCommercialName;
	}

	public void setCompanyCommercialName(String companyCommercialName) {
		this.companyCommercialName = companyCommercialName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyActivityNature() {
		return companyActivityNature;
	}

	public void setCompanyActivityNature(String companyActivityNature) {
		this.companyActivityNature = companyActivityNature;
	}
	

	

	

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public String getCompanyGoal() {
		return companyGoal;
	}

	public void setCompanyGoal(String companyGoal) {
		this.companyGoal = companyGoal;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPox() {
		return pox;
	}

	public void setPox(String pox) {
		this.pox = pox;
	}

	public String getFaxNumber() {
		return faxNumber ;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

		public Long getNationalCompanyNumber() {
		return nationalCompanyNumber;
	}

	public void setNationalCompanyNumber(Long nationalCompanyNumber) {
		this.nationalCompanyNumber = nationalCompanyNumber;
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

	public Company getParentCompany() {
		return parentCompany;
	}

	public void setParentCompany(Company parentCompany) {
		this.parentCompany = parentCompany;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getSaleTaxNumber() {
		
		return saleTaxNumber;
	}

	public void setSaleTaxNumber(String saleTaxNumber) {
		this.saleTaxNumber = saleTaxNumber;
	}

	public String getLegalCompanyNameEn() {
		return legalCompanyNameEn;
	}

	public void setLegalCompanyNameEn(String legalCompanyNameEn) {
		this.legalCompanyNameEn = legalCompanyNameEn;
	}

	public String getAddressEn() {
		return addressEn;
	}

	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}

	public Date getDateOfIssuance() {
		return dateOfIssuance;
	}

	public void setDateOfIssuance(Date dateOfIssuance) {
		this.dateOfIssuance = dateOfIssuance;
	}

	public Date getExpiaryDate() {
		return expiaryDate;
	}

	public void setExpiaryDate(Date expiaryDate) {
		this.expiaryDate = expiaryDate;
	}

	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	public String getCompanyCapital() {
		return companyCapital;
	}

	public void setCompanyCapital(String companyCapital) {
		this.companyCapital = companyCapital;
	}

	public Long getCountSystem() {
		return countSystem;
	}

	public void setCountSystem(Long countSystem) {
		this.countSystem = countSystem;
	}

	public Long getInventoryCosting() {
		return inventoryCosting;
	}

	public void setInventoryCosting(Long inventoryCosting) {
		this.inventoryCosting = inventoryCosting;
	}

	public Long getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Long getActualSize() {
		return actualSize;
	}

	public void setActualSize(Long actualSize) {
		this.actualSize = actualSize;
	}




}
