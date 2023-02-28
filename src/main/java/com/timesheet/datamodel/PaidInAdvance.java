package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.timesheet.utils.Utils;

@Entity
@Table(name = "paidinadvance")
public class PaidInAdvance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "type_of_contract")
	private String typeOfContract;

	
	@Column(name = "contract_value")
	private Double contractValue;
 

	@Column(name = "contract_starting_date")
	private Date contractStartingDate;
	
	@Column(name = "contract_ending_date")
	private Date contractEndingDate ;
	
	@Column(name = "month_no")
	private Double monthNo;
	
	@Column(name = "monthly_revenue")
	private Double monthlyRevenue
;
	@Column(name = "income_entry_method")
	private String incomeEntryMethod
;

	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	
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
		PaidInAdvance other = (PaidInAdvance) obj;
		
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

	

	

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public String getTypeOfContract() {
		return typeOfContract;
	}

	public void setTypeOfContract(String typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	public Double getContractValue() {
		return contractValue;
	}

	public void setContractValue(Double contractValue) {
		this.contractValue = contractValue;
	}

	public Date getContractStartingDate() {
		return contractStartingDate;
	}

	public void setContractStartingDate(Date contractStartingDate) {
		this.contractStartingDate = contractStartingDate;
	}

	public Date getContractEndingDate() {
		return contractEndingDate;
	}

	public void setContractEndingDate(Date contractEndingDate) {
		this.contractEndingDate = contractEndingDate;
	}

	public Double getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(Double monthNo) {
		this.monthNo = monthNo;
	}

	public Double getMonthlyRevenue() {
		return monthlyRevenue;
	}

	public void setMonthlyRevenue(Double monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}

	public String getIncomeEntryMethod() {
		return incomeEntryMethod;
	}

	public void setIncomeEntryMethod(String incomeEntryMethod) {
		this.incomeEntryMethod = incomeEntryMethod;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	

	


	


}
