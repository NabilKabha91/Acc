package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.timesheet.utils.Utils;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String userName;

	@Column
	private String nameAr;

	@Column
	private String nameEn;

	@Column
	private String email;

	@Column
	private String phoneNumber;

	@Column
	private String password;

	@Column
	private String picName;

	@Temporal(TemporalType.DATE)
	@Column
	private Date expire;

	@Temporal(TemporalType.DATE)
	@Column
	private Date passworExpire;

	@Column
	private boolean isSuperUser;

	@Column
	private boolean isAdmin;
	
	
	@Column
	private String companyTotal;
	
	@Column(columnDefinition = "int default '0'")
	private boolean customerPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean servicesAndProductsPermissions;
	
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean billPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean suppliersPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean purchasebillsPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean bankDataPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean billManagementPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean definitionOfCurrenciesPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean definitionOfTaxPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean comericalDiscountPermissions;
	
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean unitPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean itemsScreenPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean orderItemPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean warehouseReleaseDocumentPermissions;
	

	
	@Column(columnDefinition = "int default '0'")
	private boolean chartOfAccountsPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean entriesPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean reciptVoucherPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean paymentVoucherPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean debitNotePermissions;
	
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean creditNotePermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean bankDepositPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean statementOfAccountPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean trialBalancePermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean accounting;
	
	@Column(columnDefinition = "int default '0'")
	private boolean inventory;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean fixedAsset;
	
	@Column(columnDefinition = "int default '0'")
	private boolean hr;
	
	@Column(columnDefinition = "int default '0'")
	private boolean sallon;
	
	@Column(columnDefinition = "int default '0'")
	private boolean patient;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean employeesPermissions;
	
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean allowancesPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean deductionsPermissions;
	
	@Column(columnDefinition = "int default '0'")
	private boolean salariesStatementsPermissions;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean incomeStatementPermissions;
	

	
	@Column(columnDefinition = "int default '0'")
	private boolean statementOfFinancialPositionPermissions;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User parentUser;

	@OneToOne(fetch = FetchType.LAZY)
	private Office office;

	@OneToOne(fetch = FetchType.LAZY)
	private UserType userType;

	@Basic(optional = true)
	@Lob
	@Column(name = "pic", nullable = true)
	private byte[] pic;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '1'")
	private boolean isActivated;

	@OneToOne(fetch = FetchType.LAZY)
	private Company company;

	
	public String getName() {
		if (Utils.isArabic()) {
			return nameAr;
		}
		return nameEn;
	}

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
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the nameAr
	 */
	public String getNameAr() {
		return nameAr;
	}

	/**
	 * @param nameAr
	 *            the nameAr to set
	 */
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	/**
	 * @return the nameEn
	 */
	public String getNameEn() {
		return nameEn;
	}

	/**
	 * @param nameEn
	 *            the nameEn to set
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the expire
	 */
	public Date getExpire() {
		return expire;
	}

	/**
	 * @param expire
	 *            the expire to set
	 */
	public void setExpire(Date expire) {
		this.expire = expire;
	}

	/**
	 * @return the isSuperUser
	 */
	public boolean isSuperUser() {
		return isSuperUser;
	}

	/**
	 * @param isSuperUser
	 *            the isSuperUser to set
	 */
	public void setSuperUser(boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin
	 *            the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the parentUser
	 */
	public User getParentUser() {
		return parentUser;
	}

	/**
	 * @param parentUser
	 *            the parentUser to set
	 */
	public void setParentUser(User parentUser) {
		this.parentUser = parentUser;
	}

	/**
	 * @return the passworExpire
	 */
	public Date getPassworExpire() {
		return passworExpire;
	}

	/**
	 * @param passworExpire
	 *            the passworExpire to set
	 */
	public void setPassworExpire(Date passworExpire) {
		this.passworExpire = passworExpire;
	}

	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office
	 *            the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", nameAr=" + nameAr + ", nameEn=" + nameEn + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", password=" + password + ", expire=" + expire
				+ ", isSuperUser=" + isSuperUser + ", isAdmin=" + isAdmin + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((expire == null) ? 0 : expire.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + (isSuperUser ? 1231 : 1237);
		result = prime * result + ((nameAr == null) ? 0 : nameAr.hashCode());
		result = prime * result + ((nameEn == null) ? 0 : nameEn.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expire == null) {
			if (other.expire != null)
				return false;
		} else if (!expire.equals(other.expire))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (isSuperUser != other.isSuperUser)
			return false;
		if (nameAr == null) {
			if (other.nameAr != null)
				return false;
		} else if (!nameAr.equals(other.nameAr))
			return false;
		if (nameEn == null) {
			if (other.nameEn != null)
				return false;
		} else if (!nameEn.equals(other.nameEn))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * @return the picName
	 */
	public String getPicName() {
		return picName;
	}

	/**
	 * @param picName
	 *            the picName to set
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the isActivated
	 */
	public boolean isActivated() {
		return isActivated;
	}

	/**
	 * @param isActivated the isActivated to set
	 */
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public boolean isCustomerPermissions() {
		return customerPermissions;
	}

	public void setCustomerPermissions(boolean customerPermissions) {
		this.customerPermissions = customerPermissions;
	}

	public boolean isServicesAndProductsPermissions() {
		return servicesAndProductsPermissions;
	}

	public void setServicesAndProductsPermissions(boolean servicesAndProductsPermissions) {
		this.servicesAndProductsPermissions = servicesAndProductsPermissions;
	}

	public boolean isBillPermissions() {
		return billPermissions;
	}

	public void setBillPermissions(boolean billPermissions) {
		this.billPermissions = billPermissions;
	}

	public boolean isSuppliersPermissions() {
		return suppliersPermissions;
	}

	public void setSuppliersPermissions(boolean suppliersPermissions) {
		this.suppliersPermissions = suppliersPermissions;
	}

	public boolean isPurchasebillsPermissions() {
		return purchasebillsPermissions;
	}

	public void setPurchasebillsPermissions(boolean purchasebillsPermissions) {
		this.purchasebillsPermissions = purchasebillsPermissions;
	}

	public boolean isBankDataPermissions() {
		return bankDataPermissions;
	}

	public void setBankDataPermissions(boolean bankDataPermissions) {
		this.bankDataPermissions = bankDataPermissions;
	}

	public boolean isBillManagementPermissions() {
		return billManagementPermissions;
	}

	public void setBillManagementPermissions(boolean billManagementPermissions) {
		this.billManagementPermissions = billManagementPermissions;
	}

	public boolean isDefinitionOfCurrenciesPermissions() {
		return definitionOfCurrenciesPermissions;
	}

	public void setDefinitionOfCurrenciesPermissions(boolean definitionOfCurrenciesPermissions) {
		this.definitionOfCurrenciesPermissions = definitionOfCurrenciesPermissions;
	}

	public boolean isDefinitionOfTaxPermissions() {
		return definitionOfTaxPermissions;
	}

	public void setDefinitionOfTaxPermissions(boolean definitionOfTaxPermissions) {
		this.definitionOfTaxPermissions = definitionOfTaxPermissions;
	}

	public boolean isComericalDiscountPermissions() {
		return comericalDiscountPermissions;
	}

	public void setComericalDiscountPermissions(boolean comericalDiscountPermissions) {
		this.comericalDiscountPermissions = comericalDiscountPermissions;
	}

	public boolean isUnitPermissions() {
		return unitPermissions;
	}

	public void setUnitPermissions(boolean unitPermissions) {
		this.unitPermissions = unitPermissions;
	}

	public boolean isItemsScreenPermissions() {
		return itemsScreenPermissions;
	}

	public void setItemsScreenPermissions(boolean itemsScreenPermissions) {
		this.itemsScreenPermissions = itemsScreenPermissions;
	}

	public boolean isOrderItemPermissions() {
		return orderItemPermissions;
	}

	public void setOrderItemPermissions(boolean orderItemPermissions) {
		this.orderItemPermissions = orderItemPermissions;
	}

	public boolean isWarehouseReleaseDocumentPermissions() {
		return warehouseReleaseDocumentPermissions;
	}

	public void setWarehouseReleaseDocumentPermissions(boolean warehouseReleaseDocumentPermissions) {
		this.warehouseReleaseDocumentPermissions = warehouseReleaseDocumentPermissions;
	}

	public boolean isChartOfAccountsPermissions() {
		return chartOfAccountsPermissions;
	}

	public void setChartOfAccountsPermissions(boolean chartOfAccountsPermissions) {
		this.chartOfAccountsPermissions = chartOfAccountsPermissions;
	}

	public boolean isEntriesPermissions() {
		return entriesPermissions;
	}

	public void setEntriesPermissions(boolean entriesPermissions) {
		this.entriesPermissions = entriesPermissions;
	}

	public boolean isReciptVoucherPermissions() {
		return reciptVoucherPermissions;
	}

	public void setReciptVoucherPermissions(boolean reciptVoucherPermissions) {
		this.reciptVoucherPermissions = reciptVoucherPermissions;
	}

	public boolean isPaymentVoucherPermissions() {
		return paymentVoucherPermissions;
	}

	public void setPaymentVoucherPermissions(boolean paymentVoucherPermissions) {
		this.paymentVoucherPermissions = paymentVoucherPermissions;
	}

	public boolean isDebitNotePermissions() {
		return debitNotePermissions;
	}

	public void setDebitNotePermissions(boolean debitNotePermissions) {
		this.debitNotePermissions = debitNotePermissions;
	}

	public boolean isCreditNotePermissions() {
		return creditNotePermissions;
	}

	public void setCreditNotePermissions(boolean creditNotePermissions) {
		this.creditNotePermissions = creditNotePermissions;
	}

	public boolean isBankDepositPermissions() {
		return bankDepositPermissions;
	}

	public void setBankDepositPermissions(boolean bankDepositPermissions) {
		this.bankDepositPermissions = bankDepositPermissions;
	}

	

	public boolean isStatementOfAccountPermissions() {
		return statementOfAccountPermissions;
	}

	public void setStatementOfAccountPermissions(boolean statementOfAccountPermissions) {
		this.statementOfAccountPermissions = statementOfAccountPermissions;
	}

	public boolean isTrialBalancePermissions() {
		return trialBalancePermissions;
	}

	public void setTrialBalancePermissions(boolean trialBalancePermissions) {
		this.trialBalancePermissions = trialBalancePermissions;
	}

	public boolean isEmployeesPermissions() {
		return employeesPermissions;
	}

	public void setEmployeesPermissions(boolean employeesPermissions) {
		this.employeesPermissions = employeesPermissions;
	}

	public boolean isAllowancesPermissions() {
		return allowancesPermissions;
	}

	public void setAllowancesPermissions(boolean allowancesPermissions) {
		this.allowancesPermissions = allowancesPermissions;
	}

	public boolean isDeductionsPermissions() {
		return deductionsPermissions;
	}

	public void setDeductionsPermissions(boolean deductionsPermissions) {
		this.deductionsPermissions = deductionsPermissions;
	}

	public boolean isSalariesStatementsPermissions() {
		return salariesStatementsPermissions;
	}

	public void setSalariesStatementsPermissions(boolean salariesStatementsPermissions) {
		this.salariesStatementsPermissions = salariesStatementsPermissions;
	}

	public boolean isIncomeStatementPermissions() {
		return incomeStatementPermissions;
	}

	public void setIncomeStatementPermissions(boolean incomeStatementPermissions) {
		this.incomeStatementPermissions = incomeStatementPermissions;
	}

	public boolean isStatementOfFinancialPositionPermissions() {
		return statementOfFinancialPositionPermissions;
	}

	public void setStatementOfFinancialPositionPermissions(boolean statementOfFinancialPositionPermissions) {
		this.statementOfFinancialPositionPermissions = statementOfFinancialPositionPermissions;
	}

	public boolean isAccounting() {
		return accounting;
	}

	public boolean isFixedAsset() {
		return fixedAsset;
	}

	public boolean isHr() {
		return hr;
	}

	public boolean isPatient() {
		return patient;
	}

	public void setAccounting(boolean accounting) {
		this.accounting = accounting;
	}

	public void setFixedAsset(boolean fixedAsset) {
		this.fixedAsset = fixedAsset;
	}

	public void setHr(boolean hr) {
		this.hr = hr;
	}

	public void setPatient(boolean patient) {
		this.patient = patient;
	}

	public boolean isInventory() {
		return inventory;
	}

	public void setInventory(boolean inventory) {
		this.inventory = inventory;
	}

	public boolean isSallon() {
		return sallon;
	}

	public void setSallon(boolean sallon) {
		this.sallon = sallon;
	}

	public String getCompanyTotal() {
		return companyTotal;
	}

	public void setCompanyTotal(String companyTotal) {
		this.companyTotal = companyTotal;
	}


	


}
