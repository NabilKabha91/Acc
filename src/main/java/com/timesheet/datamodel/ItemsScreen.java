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
@Table(name = "itemsScreen")
public class ItemsScreen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_item")
	private String nameItem;
	
	@Column(name = "name_item_en")
	private String nameItemEn;
	
	@Column(name = "code_item")
	private String codeItem;
	
	@Column(name = "item_group")
	private String itemGroup;

	@Column(name = "weighted_Average")
	private Double weightedAverage;

	@Column(name = "total_Average")
	private Double totalAverage;
	
	
	@Column(name = "finish_type")
	private String finishType;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "quantity")
	private Double quantity;
	
	@Column(name = "quantityTotal")
	private Double quantityTotal;



	@Column(name = "item_cost")
	private Double itemCost;
	
	@Column(name = "sales_price")
	private Double salesPrice;
	
	@Column(name = "demand_limit")
	private Double demandLimit;

	@Column(name = "ref")
	private String ref;
	
	@Column(name = "tax_amount")
	private Double taxAmount =0.0;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	private Long groupingId;
	private Long groupingId1;

	private Long groupingId2;

	private String unitName;
	private String unitNameTotal;

	private Long grpname;
	private Long grpname1;

	private String grpDesc;
	private String grpDesc1;

	@Column(name = "tax_amount_total")
	private Double taxAmountTotal =0.0;
	
	
	private Long rawMaterials;
	
	private Long finishGood;
	public Double getTaxAmountTotal() {
		return taxAmountTotal;
	}

	public void setTaxAmountTotal(Double taxAmountTotal) {
		this.taxAmountTotal = taxAmountTotal;
	}

	public Long getGroupingId1() {
		return groupingId1;
	}

	public void setGroupingId1(Long groupingId1) {
		this.groupingId1 = groupingId1;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfTax definitionOfTax;


	@ManyToOne(fetch=FetchType.LAZY)
	private Unit unit;

	
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
		ItemsScreen other = (ItemsScreen) obj;
		
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

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public String getCodeItem() {
		return codeItem;
	}

	public void setCodeItem(String codeItem) {
		this.codeItem = codeItem;
	}

	public Double getDemandLimit() {
		return demandLimit;
	}

	public void setDemandLimit(Double demandLimit) {
		this.demandLimit = demandLimit;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getNameItemEn() {
		return nameItemEn;
	}

	public void setNameItemEn(String nameItemEn) {
		this.nameItemEn = nameItemEn;
	}

	public Long getGrpname() {
		return grpname;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public String getGrpDesc1() {
		return grpDesc1;
	}

	public void setGrpname(Long grpname) {
		this.grpname = grpname;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public void setGrpDesc1(String grpDesc1) {
		this.grpDesc1 = grpDesc1;
	}

	public Long getGrpname1() {
		return grpname1;
	}

	public void setGrpname1(Long grpname1) {
		this.grpname1 = grpname1;
	}

	public String getFinishType() {
		return finishType;
	}

	public String getColor() {
		return color;
	}

	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitNameTotal() {
		return unitNameTotal;
	}

	public void setUnitNameTotal(String unitNameTotal) {
		this.unitNameTotal = unitNameTotal;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public Double getQuantityTotal() {
		return quantityTotal;
	}

	public void setQuantityTotal(Double quantityTotal) {
		this.quantityTotal = quantityTotal;
	}

	public Long getGroupingId2() {
		return groupingId2;
	}

	public void setGroupingId2(Long groupingId2) {
		this.groupingId2 = groupingId2;
	}

	public Double getWeightedAverage() {
		return weightedAverage;
	}

	public void setWeightedAverage(Double weightedAverage) {
		this.weightedAverage = weightedAverage;
	}

	public Long getRawMaterials() {
		return rawMaterials;
	}

	public void setRawMaterials(Long rawMaterials) {
		this.rawMaterials = rawMaterials;
	}

	public Long getFinishGood() {
		return finishGood;
	}

	public void setFinishGood(Long finishGood) {
		this.finishGood = finishGood;
	}

	public Double getTotalAverage() {
		return totalAverage;
	}

	public void setTotalAverage(Double totalAverage) {
		this.totalAverage = totalAverage;
	}

	



	

	

	


	


}
