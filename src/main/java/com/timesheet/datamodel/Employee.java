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
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "employee_name_ar")
	private String employeeNameAr;
	@Column(name = "employee_name_en")
	private String employeeNameEn;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_hiring")
	private Date dateHiring;
	@Column(name = "date_end")
	private Date dateEnd;
	
	@Column(name = "Job_number")
	private Long jobNumber;
	@Column(columnDefinition = "double default '0'")
	private double socialSecurityRate;
	@Column(columnDefinition = "double default '0'")
	private double thePercentageOfTheCompanySocialSecurity;
	@Column(name = "bonuse")
	private String bonuse;
	@Column(name = "deduction")
	private String deduction;
	@Column(name = "national_employee_number")
	private Long nationalEmployeeNumber;
	@Column(name = "security_number")
	private Long securityNumber;
	@Column(name = "bonusevalue")
	private Long bonuseVal;
	@Column(name = "deductionvalue")
	private Long deductionVal;
	@Column(name = "bonuse_total")
	private String bonuseTotal;
	@Column(name = "deduction_total")
	private String deductionTotal;
	@Column(columnDefinition = "double default '0'")
	private double employeeShareOfGuarantee;
	@Column(columnDefinition = "double default '0'")
	private double netSalaryTransferredBank;
	@Column(columnDefinition = "double default '0'")
	private double basicSalary;
	@OneToOne(fetch=FetchType.LAZY)
	private Bonuses bonuses;
    @Column(columnDefinition = "double default '0'")
	private double companyContributionToTheGuarantee;
    @Column(columnDefinition = "double default '0'")
   	private double theValueOfTheGuaranteeThatMustBeSupplied;
    @Column(name = "social_status")
	private Long socialStatus;
    
    @Column(name = "iban")
	private String iban;
	@ManyToOne(fetch=FetchType.LAZY)
	private CostCenter costCenter;
	@Column(name = "account_num")
	private Long accountNum;
	
	@Column(columnDefinition = "double default '0'")
	private double taxableIncome;
    
	@Column(name = "commission ")
	private Double commission ;
	
	   @Column(columnDefinition = "double default '0'")
	   	private double taxWithholding;

	   
	@OneToOne(fetch=FetchType.LAZY)
	private Deductions deductions;

	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

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
		Employee other = (Employee) obj;
		
		
	
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

	public String getEmployeeNameAr() {
		return employeeNameAr;
	}

	public void setEmployeeNameAr(String employeeNameAr) {
		this.employeeNameAr = employeeNameAr;
	}

	public String getEmployeeNameEn() {
		return employeeNameEn;
	}

	public void setEmployeeNameEn(String employeeNameEn) {
		this.employeeNameEn = employeeNameEn;
	}

	public Date getDateHiring() {
		return dateHiring;
	}

	public void setDateHiring(Date dateHiring) {
		this.dateHiring = dateHiring;
	}

	

	public Long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Long jobNumber) {
		this.jobNumber = jobNumber;
	}

	

	

	


	
	

	public double getThePercentageOfTheCompanySocialSecurity() {
		return thePercentageOfTheCompanySocialSecurity;
	}

	public void setThePercentageOfTheCompanySocialSecurity(double thePercentageOfTheCompanySocialSecurity) {
		this.thePercentageOfTheCompanySocialSecurity = thePercentageOfTheCompanySocialSecurity;
	}

	public Long getNationalEmployeeNumber() {
		return nationalEmployeeNumber;
	}

	public void setNationalEmployeeNumber(Long nationalEmployeeNumber) {
		this.nationalEmployeeNumber = nationalEmployeeNumber;
	}

	public Long getSecurityNumber() {
		return securityNumber;
	}

	public void setSecurityNumber(Long securityNumber) {
		this.securityNumber = securityNumber;
	}

	public String getBonuse() {
		return bonuse;
	}

	public void setBonuse(String bonuse) {
		this.bonuse = bonuse;
	}

	public Bonuses getBonuses() {
		return bonuses;
	}

	public void setBonuses(Bonuses bonuses) {
		this.bonuses = bonuses;
	}

	public String getDeduction() {
		return deduction;
	}

	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}

	public Deductions getDeductions() {
		return deductions;
	}

	public void setDeductions(Deductions deductions) {
		this.deductions = deductions;
	}

	public Long getBonuseVal() {
		return bonuseVal;
	}

	public void setBonuseVal(Long bonuseVal) {
		this.bonuseVal = bonuseVal;
	}

	public Long getDeductionVal() {
		return deductionVal;
	}

	public void setDeductionVal(Long deductionVal) {
		this.deductionVal = deductionVal;
	}

	public String getBonuseTotal() {
		return bonuseTotal;
	}

	public void setBonuseTotal(String bonuseTotal) {
		this.bonuseTotal = bonuseTotal;
	}

	public String getDeductionTotal() {
		return deductionTotal;
	}

	public void setDeductionTotal(String deductionTotal) {
		this.deductionTotal = deductionTotal;
	}

	

	public double getSocialSecurityRate() {
		return socialSecurityRate;
	}

	public void setSocialSecurityRate(double socialSecurityRate) {
		this.socialSecurityRate = socialSecurityRate;
	}



	public double getEmployeeShareOfGuarantee() {
		return employeeShareOfGuarantee;
	}

	public void setEmployeeShareOfGuarantee(double employeeShareOfGuarantee) {
		this.employeeShareOfGuarantee = employeeShareOfGuarantee;
	}

	


	

	public double getNetSalaryTransferredBank() {
		return netSalaryTransferredBank;
	}

	public void setNetSalaryTransferredBank(double netSalaryTransferredBank) {
		this.netSalaryTransferredBank = netSalaryTransferredBank;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getCompanyContributionToTheGuarantee() {
		return companyContributionToTheGuarantee;
	}

	public void setCompanyContributionToTheGuarantee(double companyContributionToTheGuarantee) {
		this.companyContributionToTheGuarantee = companyContributionToTheGuarantee;
	}

	public double getTheValueOfTheGuaranteeThatMustBeSupplied() {
		return theValueOfTheGuaranteeThatMustBeSupplied;
	}

	public void setTheValueOfTheGuaranteeThatMustBeSupplied(double theValueOfTheGuaranteeThatMustBeSupplied) {
		this.theValueOfTheGuaranteeThatMustBeSupplied = theValueOfTheGuaranteeThatMustBeSupplied;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getSocialStatus() {
		return socialStatus;
	}

	public void setSocialStatus(Long socialStatus) {
		this.socialStatus = socialStatus;
	}

	public double getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public double getTaxWithholding() {
		return taxWithholding;
	}

	public void setTaxWithholding(double taxWithholding) {
		this.taxWithholding = taxWithholding;
	}

	public String getIban() {
		return iban;
	}

	public Long getAccountNum() {
		return accountNum;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	

	

	

	







	
	

	



	



	




	

	
	
	


}
