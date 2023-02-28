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
import com.timesheet.presentation.web.Grouping;

@Entity
@Table(name = "servicesandproducts")
public class ServicesAndProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_product_or_service")
	private String nameProductOrService;
	@Column(name = "code_product_or_service")
	private String codeProductOrService;
	@Column(name = "sell_price")
	private Long sellPrice;

	//@ManyToOne(fetch=FetchType.LAZY)
	private Long groupingId;

	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfTax definitionOfTax;


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
		ServicesAndProducts other = (ServicesAndProducts) obj;
		
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

	public String getNameProductOrService() {
		return nameProductOrService;
	}

	public void setNameProductOrService(String nameProductOrService) {
		this.nameProductOrService = nameProductOrService;
	}

	public String getCodeProductOrService() {
		return codeProductOrService;
	}

	public void setCodeProductOrService(String codeProductOrService) {
		this.codeProductOrService = codeProductOrService;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Long sellPrice) {
		this.sellPrice = sellPrice;
	}

	

	public Long getGroupingId() {
		return groupingId;
	}

	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public DefinitionOfTax getDefinitionOfTax() {
		return definitionOfTax;
	}

	public void setDefinitionOfTax(DefinitionOfTax definitionOfTax) {
		this.definitionOfTax = definitionOfTax;
	}

	



	

	

	


	


}
