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
@Table(name = "bankdata")
public class BankData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_bank_ar")
	private String nameBankAr;
	@Column(name = "name_bank_en")
	private String nameBankEn;
	
	@Column(name = "branch")
	private String branch;
	@Column(name = "account_beneficiary")
	private String accountBeneficiary; 

	
	@Column(name = "swift")
	private String swift;
	@Column(name = "iban")
	private String iban;
	
	@Column(name = "account_num")
	private Long accountNum;

	@Column(name = "nickname")
	private String nickName;
	@Column(name = "branch_en")
	private String branchEn;
	 
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	
	
	
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	
	
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
		BankData other = (BankData) obj;
		
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

	public String getNameBankAr() {
		return nameBankAr;
	}

	public void setNameBankAr(String nameBankAr) {
		this.nameBankAr = nameBankAr;
	}

	public String getNameBankEn() {
		return nameBankEn;
	}

	public void setNameBankEn(String nameBankEn) {
		this.nameBankEn = nameBankEn;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountBeneficiary() {
		return accountBeneficiary;
	}

	public void setAccountBeneficiary(String accountBeneficiary) {
		this.accountBeneficiary = accountBeneficiary;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getBranchEn() {
		return branchEn;
	}

	public void setBranchEn(String branchEn) {
		this.branchEn = branchEn;
	}



	

	


	


}
