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
@Table(name = "addWarehouseReceipt")
public class AddWarehouseReceipt implements Serializable {

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
	private SellOrder sellOrder;
	@ManyToOne(fetch=FetchType.LAZY)
	private AddSellOrder addSellOrder;
	
	@Column(name = "total_final")
	private Double totalFinal;
	
	@Column(name = "quantity_received")
	private Double quantityReceived =0.0;
	
	@Column(name = "quantity_total")
	private Double quantityTotal;
	
	@Column(name = "quantity_remaining")
	private Double quantityRemaining;
	
	@Column(name = "th")
	private Double th;
	
	@Column(name = "width")
	private Double width;
	
	@Column(name = "length")
	private Double length;
	
	@Column(name = "pcs")
	private Double pcs;
	@Column(name = "lM")
	private Double lM;
	@Column(name = "m2")
	private Double m2;
	@Column(name = "m3")
	private Double m3;
	@Column(name = "pcs_Actual")
	private Double pcsActual;
	@ManyToOne(fetch=FetchType.LAZY)
	private Analytical analytical;

	public Double getQuantityReceived() {
		return quantityReceived;
	}


	public void setQuantityReceived(Double quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	@Column(name = "item")
	private String item;



	@ManyToOne(fetch=FetchType.LAZY)
	private CostCenter costCenter;
	

	private Long groupingId;

	@ManyToOne(fetch=FetchType.LAZY)
	private WarehouseReceipt warehouseReceipt;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ItemsScreen itemsScreen;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Warehouses warehouses;
	
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
		AddWarehouseReceipt other = (AddWarehouseReceipt) obj;
		
	
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
	
	public Double getQuantity() {
		

		
			return quantity;
		}
		
	

	
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


	

	

	public Double getTotal() {


		return total;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	




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


	public WarehouseReceipt getWarehouseReceipt() {
		return warehouseReceipt;
	}


	public void setWarehouseReceipt(WarehouseReceipt warehouseReceipt) {
		this.warehouseReceipt = warehouseReceipt;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public Double getQuantityTotal() {
		return quantityTotal;
	}


	public void setQuantityTotal(Double quantityTotal) {
		this.quantityTotal = quantityTotal;
	}


	public Long getGroupingId() {
		return groupingId;
	}


	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
	}


	public Warehouses getWarehouses() {
		return warehouses;
	}


	public void setWarehouses(Warehouses warehouses) {
		this.warehouses = warehouses;
	}


	public SellOrder getSellOrder() {
		return sellOrder;
	}


	public void setSellOrder(SellOrder sellOrder) {
		this.sellOrder = sellOrder;
	}


	public Double getQuantityRemaining() {
		return quantityRemaining;
	}


	public void setQuantityRemaining(Double quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}


	public AddSellOrder getAddSellOrder() {
		return addSellOrder;
	}


	public void setAddSellOrder(AddSellOrder addSellOrder) {
		this.addSellOrder = addSellOrder;
	}


	public Double getTotalFinal() {
		return totalFinal;
	}


	public void setTotalFinal(Double totalFinal) {
		this.totalFinal = totalFinal;
	}


	public CostCenter getCostCenter() {
		return costCenter;
	}


	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}


	public Analytical getAnalytical() {
		return analytical;
	}


	public void setAnalytical(Analytical analytical) {
		this.analytical = analytical;
	}


	public Double getTh() {
		return th;
	}


	public Double getWidth() {
		return width;
	}


	public Double getLength() {
		return length;
	}


	public Double getPcs() {
		return pcs;
	}


	public void setTh(Double th) {
		this.th = th;
	}


	public void setWidth(Double width) {
		this.width = width;
	}


	public void setLength(Double length) {
		this.length = length;
	}


	public void setPcs(Double pcs) {
		this.pcs = pcs;
	}


	public Double getPcsActual() {
		return pcsActual;
	}


	public void setPcsActual(Double pcsActual) {
		this.pcsActual = pcsActual;
	}


	public Double getlM() {
		return lM;
	}


	public void setlM(Double lM) {
		this.lM = lM;
	}


	public Double getM2() {
		return m2;
	}


	public void setM2(Double m2) {
		this.m2 = m2;
	}


	public Double getM3() {
		return m3;
	}


	public void setM3(Double m3) {
		this.m3 = m3;
	}

		
}
