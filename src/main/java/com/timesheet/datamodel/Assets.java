package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name ="assets")
public class Assets  implements Serializable {
private static final long serialVersionUID = -8455061850556612696L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "assetName")
private String assetName ;

private Long groupingId;

@Column(name = "purchaeValue")
private Double purchaseValue ; 

@Column(name = "depreciationValue")
private double depreciationValue ; 

@Column(name = "startUse")
private Date startUse;

@Column(name = "deprectiationDate")
private Date deprectiationDate;

@ManyToOne(fetch=FetchType.LAZY)
private Suppliers suppliers;

@ManyToOne(fetch=FetchType.LAZY)
private Company company;

public Long getId() {
	return id;
}
@Column(columnDefinition = "int default '0'")
private boolean isDeleted;

public void setId(Long id) {
	this.id = id;
}

public String getAssetName() {
	return assetName;
}

public void setAssetName(String assetName) {
	this.assetName = assetName;
}

public Long getGroupingId() {
	return groupingId;
}

public void setGroupingId(Long groupingId) {
	this.groupingId = groupingId;
}

public  Double getPurchaseValue() {
	return purchaseValue;
}

public void setPurchaseValue(Double purchaseValue) {
	this.purchaseValue = purchaseValue;
}

public double getDepreciationValue() {
	return depreciationValue;
}

public void setDepreciationValue(double depreciationValue) {
	this.depreciationValue = depreciationValue;
}

public Date getStartUse() {
	return startUse;
}

public Suppliers getSuppliers() {
	return suppliers;
}

public void setSuppliers(Suppliers suppliers) {
	this.suppliers = suppliers;
}

public void setStartUse(Date startUse) {
	this.startUse = startUse;
}

public Company getCompany() {
	return company;
}

public void setCompany(Company company) {
	this.company = company;
}

public Date getDeprectiationDate() {
	return deprectiationDate;
}

public void setDeprectiationDate(Date deprectiationDate) {
	this.deprectiationDate = deprectiationDate;
}

public boolean isDeleted() {
	return isDeleted;
}

public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}





	

}
