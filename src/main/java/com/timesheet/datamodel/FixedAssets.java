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
@Table(name = "fixedassets")
public class FixedAssets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date_of_purchase")
	private Date dateOfPurchase;
	@Column(name = "consumption_date")
	private Date  consumptionDate;
	@Column(name = "assets_name")
	private String assetsName;
	@Column(name = "assets_group")
	private String assetsGroup;

	@Column(name = "depreciation_percentage")
	private Double depreciationPercentage =0.0;
	@Column(name = "purchase_cost")
	private Double purchaseCost
;
	
	@Column(name = "useful_life")
	private Double usefulLife
;
	@Column(name = "from_date")
	private Date fromDate;
	@Column(name = "to_date")
	private Date  toDate;

	@Column(name = "usage_period")
	private Double usagePeriod
;
	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;


	
	public boolean isIsduplicated() {
		return isduplicated;
	}
	

	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

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
		FixedAssets other = (FixedAssets) obj;
		
	
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


	

	
	

	public String getAssetsName() {
		return assetsName;
	}


	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}


	public String getAssetsGroup() {
		return assetsGroup;
	}


	public void setAssetsGroup(String assetsGroup) {
		this.assetsGroup = assetsGroup;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}


	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}


	public Date getConsumptionDate() {
		return consumptionDate;
	}


	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}


	public Double getDepreciationPercentage() {
		return depreciationPercentage;
	}


	public void setDepreciationPercentage(Double depreciationPercentage) {
		this.depreciationPercentage = depreciationPercentage;
	}


	public Double getPurchaseCost() {
		return purchaseCost;
	}


	public void setPurchaseCost(Double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}


	public Suppliers getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}


	public Double getUsefulLife() {
		usefulLife=1/getDepreciationPercentage();
		return usefulLife;
	}


	public void setUsefulLife(Double usefulLife) {
		this.usefulLife = usefulLife;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		
		
		return toDate;
	}


	public Double getUsagePeriod() {
		
		long startTime = getConsumptionDate().getTime();
		long endTime = getDateOfPurchase().getTime();
		long diffTime =  startTime - endTime;

		float month=(diffTime/(1000*60*60*24));
		float yea=month/30;
		usagePeriod=(double) ((yea/12));
		return usagePeriod;
	}


	public void setUsagePeriod(Double usagePeriod) {
		
		
		this.usagePeriod = usagePeriod;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
}
