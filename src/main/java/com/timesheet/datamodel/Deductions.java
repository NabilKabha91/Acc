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
@Table(name = "deductions")
public class Deductions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "deductions_type")
	private String deductionsType;
	@Column(name = "deductions_value")
	private Long deductionsValue;
	@Column(name = "period")
	private String period;
	@Column(name = "beginning_deductions_date")
	private Date beginningDeductionsDate ;
	

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		Deductions other = (Deductions) obj;
		
		
	
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

	

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDeductionsType() {
		return deductionsType;
	}

	public void setDeductionsType(String deductionsType) {
		this.deductionsType = deductionsType;
	}

	public Long getDeductionsValue() {
		return deductionsValue;
	}

	public void setDeductionsValue(Long deductionsValue) {
		this.deductionsValue = deductionsValue;
	}

	public Date getBeginningDeductionsDate() {
		return beginningDeductionsDate;
	}

	public void setBeginningDeductionsDate(Date beginningDeductionsDate) {
		this.beginningDeductionsDate = beginningDeductionsDate;
	}

	



	



	






	

	
	
	


}
