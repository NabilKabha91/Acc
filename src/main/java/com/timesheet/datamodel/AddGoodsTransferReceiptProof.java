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
@Table(name = "addGoodsTransferReceiptProof")
public class AddGoodsTransferReceiptProof implements Serializable {

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
	@Column(name = "quantity_total")
	private Double quantityTotal;
	
	@Column(name = "quantity_remaining")
	private Double quantityRemaining;

	@Column(name = "quantity_Received")
	private Double quantityReceived;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private GoodsTransferReceiptProof goodsTransferReceiptProof;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private GoodsTransferSlips goodsTransferSlips;

	@ManyToOne(fetch=FetchType.LAZY)
	private AddGoodsTransferSlips addGoodsTransferSlips;

	@ManyToOne(fetch=FetchType.LAZY)
	private ItemsScreen itemsScreen;
	
	@Column(name = "item")
	private String item;

	
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
		AddGoodsTransferReceiptProof other = (AddGoodsTransferReceiptProof) obj;
		
	
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


	public GoodsTransferReceiptProof getGoodsTransferReceiptProof() {
		return goodsTransferReceiptProof;
	}


	public void setGoodsTransferReceiptProof(GoodsTransferReceiptProof goodsTransferReceiptProof) {
		this.goodsTransferReceiptProof = goodsTransferReceiptProof;
	}


	public GoodsTransferSlips getGoodsTransferSlips() {
		return goodsTransferSlips;
	}


	public AddGoodsTransferSlips getAddGoodsTransferSlips() {
		return addGoodsTransferSlips;
	}


	public void setGoodsTransferSlips(GoodsTransferSlips goodsTransferSlips) {
		this.goodsTransferSlips = goodsTransferSlips;
	}


	public void setAddGoodsTransferSlips(AddGoodsTransferSlips addGoodsTransferSlips) {
		this.addGoodsTransferSlips = addGoodsTransferSlips;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public Double getQuantityReceived() {
		return quantityReceived;
	}


	public void setQuantityReceived(Double quantityReceived) {
		this.quantityReceived = quantityReceived;
	}


	public Double getQuantityTotal() {
		return quantityTotal;
	}


	public Double getQuantityRemaining() {
		return quantityRemaining;
	}


	public void setQuantityTotal(Double quantityTotal) {
		this.quantityTotal = quantityTotal;
	}


	public void setQuantityRemaining(Double quantityRemaining) {
		this.quantityRemaining = quantityRemaining;
	}







	











	

	


	


	


		
}
