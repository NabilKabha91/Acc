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
@Table(name = "addRequestWarehouseReleaseDocument")
public class AddRequestWarehouseReleaseDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "quantity")
	private Double quantity;
	
	@Column(name = "total")
	private Double total;



	@ManyToOne(fetch=FetchType.LAZY)
	private RequestWarehouseReleaseDocument requestwarehouseReleaseDocument;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private WarehouseReleaseDocument warehouseReleaseDocument;
	

	
	@ManyToOne(fetch=FetchType.LAZY)
	private ItemsScreen itemsScreen;
	

	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;



	
	@ManyToOne(fetch=FetchType.LAZY)
	private Analytical analytical;
	@ManyToOne(fetch=FetchType.LAZY)
	private CostCenter costCenter;
	
	public boolean isIsduplicated() {
		return isduplicated;
	}
//	
//
	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;

	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;

	private boolean addDefinitionOfCurrencies;

	
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
		AddRequestWarehouseReleaseDocument other = (AddRequestWarehouseReleaseDocument) obj;
		
	
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
	


	

	

	public Double getTotal() {


		return total;
	}
	


	public Double getQuantity() {
		return quantity;
	}


	public void setQuantity(Double quantity) {
		this.quantity = quantity;
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
//
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
//
//	
	




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	


	
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public boolean isAddDefinitionOfCurrencies() {
		return addDefinitionOfCurrencies;
	}


	public void setAddDefinitionOfCurrencies(boolean addDefinitionOfCurrencies) {
		this.addDefinitionOfCurrencies = addDefinitionOfCurrencies;
	}


	public ItemsScreen getItemsScreen() {
		return itemsScreen;
	}


	public void setItemsScreen(ItemsScreen itemsScreen) {
		this.itemsScreen = itemsScreen;
	}


	public WarehouseReleaseDocument getWarehouseReleaseDocument() {
		return warehouseReleaseDocument;
	}


	public void setWarehouseReleaseDocument(WarehouseReleaseDocument warehouseReleaseDocument) {
		this.warehouseReleaseDocument = warehouseReleaseDocument;
	}


	public RequestWarehouseReleaseDocument getRequestwarehouseReleaseDocument() {
		return requestwarehouseReleaseDocument;
	}


	public void setRequestwarehouseReleaseDocument(RequestWarehouseReleaseDocument requestwarehouseReleaseDocument) {
		this.requestwarehouseReleaseDocument = requestwarehouseReleaseDocument;
	}


	public Analytical getAnalytical() {
		return analytical;
	}


	public void setAnalytical(Analytical analytical) {
		this.analytical = analytical;
	}


	public CostCenter getCostCenter() {
		return costCenter;
	}


	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}











	

	


	


	


		
}
