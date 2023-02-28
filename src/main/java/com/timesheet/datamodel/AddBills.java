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

import com.etech.common.exception.CommonException;
import com.etech.common.util.EncodeingUtilities;
import com.timesheet.utils.Utils;

@Entity
@Table(name = "addbills")
public class AddBills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String description;
	@Column(name = "quantity")
	private Double quantity;
	@Column(name = "total")
	private Double total;
	
	@Column(name = "lM")
	private Double lM;
	@Column(name = "m2")
	private Double m2;
	@Column(name = "m3")
	private Double m3;
	
	@Column(name = "tax")
	private Long tax;

	@ManyToOne(fetch = FetchType.LAZY)
	private ItemsScreen itemsScreen;

	@ManyToOne(fetch = FetchType.LAZY)
	private ItemsScreen itemsScreen2;

	@Column(name = "bank")
	private String bank;

	@Column(name = "value_before_tax")
	private Double valueBeforeTax;

	@Column(name = "initial_tax_amount")
	private Double initialTaxAmount;

	
	
	@Column(name = "initial_value_before_tax")
	private Double initialValueBeforeTax;

	@Column(name = "tax_amount")
	private Double taxAmount;

	@ManyToOne(fetch = FetchType.LAZY)
	private Unit units;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "cost_unit")
	private Double costUnit;

	@Column(name = "initial_amount")
	private Double initialAmount;

	@Column(name = "price")
	private Double price;

	@Column(name = "initial_total")
	private Double initialTotal;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	private ServicesProducts servicesProducts;

	@ManyToOne(fetch = FetchType.LAZY)
	private ComercialDiscount comercialDiscount;

	@Column(name = "amount_discount")
	private Double amountdiscount;

	@Column(name = "inital_amount_discount")
	private Double initalamountdiscount;

	@ManyToOne(fetch = FetchType.LAZY)
	private DefinitionOfTax definitionOfTax;

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;

	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Bills bills;

	
	@Column(name = "th")
	private Double th;
	
	@Column(name = "width")
	private Double width;
	
	@Column(name = "length")
	private Double length;
	
	@Column(name = "pcs")
	private Double pcs;
	public boolean isIsduplicated() {
		return isduplicated;
	}

	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	private Office office;

	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	private boolean addDefinitionOfCurrencies;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	@Column(columnDefinition = "double default '0'")
	private double ReturnQuantity
;
	
	@Column(columnDefinition = "double default '0'")
	private double ReturnPieces
;
	@Column(name = "ReturnValue")
	private Double returnValue;
	@Column(name = " returnValueAefterTax")
	private Double returnValueAefterTax;
	@Column(name = " returnTotal")
	private Double returnTotal;
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
		AddBills other = (AddBills) obj;

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


		if (bills.getDefinitionOfCurrencies().isChekBox() == true) {
			total = getInitialTotal() * (bills.getExchangeRate());

		} else {

			total = getInitialTotal() * (bills.getExchangeRate());

		}
		// total=getValueBeforeTax()+ getTaxAmount();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ServicesProducts getServicesProducts() {
		return servicesProducts;
	}

	public void setServicesProducts(ServicesProducts servicesProducts) {
		this.servicesProducts = servicesProducts;
	}

	public Long getTax() {
		return tax;
	}

	public void setTax(Long tax) {
		this.tax = tax;
	}

	public DefinitionOfTax getDefinitionOfTax() {
		if (bills.getCommodityServices() == 2) {

			if (servicesProducts.getDefinitionOfTax() != null) {
				definitionOfTax = servicesProducts.getDefinitionOfTax();

			} else {
			}
		} else if (bills.getCommodityServices() == 1) {
			if (itemsScreen.getDefinitionOfTax() != null) {
				definitionOfTax = itemsScreen.getDefinitionOfTax();

			} else {
			}
		}
		return definitionOfTax;
	}

	public void setDefinitionOfTax(DefinitionOfTax definitionOfTax) {
		this.definitionOfTax = definitionOfTax;
	}

	public Double getValueBeforeTax() {
		valueBeforeTax = getAmount() - getAmountdiscount();

		return valueBeforeTax;
	}

	public void setValueBeforeTax(Double valueBeforeTax) {
		this.valueBeforeTax = valueBeforeTax;
	}

	public Double getTaxAmount() {
		if (bills.getDefinitionOfCurrencies().isChekBox() == true) {
			taxAmount = getInitialTaxAmount() * (bills.getExchangeRate());

		} else {
			taxAmount = getInitialTaxAmount() * (bills.getExchangeRate());

		}

		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Double getPrice() {
		if (bills.getCommodityServices() == 2) {

			if (servicesProducts.getSellPrice() != null) {
				price = servicesProducts.getSellPrice();
			} else {
			}
		}
		return price;

	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Double getInitialTotal() {

		
		initialTotal = getInitialValueBeforeTax() + getInitialTaxAmount();

		return initialTotal;
	}

	public void setInitialTotal(Double initialTotal) {
		this.initialTotal = initialTotal;
	}

	public Double getInitialTaxAmount() {
		if (definitionOfTax != null) {

			Double es = 0.0;
			es = definitionOfTax.getTaxAmount();
			initialTaxAmount = (getInitialValueBeforeTax() * es);
		} else {
			initialTaxAmount = 0.0;
		}
		return initialTaxAmount;
	}

	public void setInitialTaxAmount(Double initialTaxAmount) {
		this.initialTaxAmount = initialTaxAmount;
	}

	public Double getInitialValueBeforeTax() {
		initialValueBeforeTax = getInitialAmount() - getInitalamountdiscount();
		return initialValueBeforeTax;
	}

	public void setInitialValueBeforeTax(Double initialValueBeforeTax) {
		this.initialValueBeforeTax = initialValueBeforeTax;
	}

	public boolean isAddDefinitionOfCurrencies() {
		return addDefinitionOfCurrencies;
	}

	public void setAddDefinitionOfCurrencies(boolean addDefinitionOfCurrencies) {
		this.addDefinitionOfCurrencies = addDefinitionOfCurrencies;
	}

	public Double getAmount() {

		if (bills.getCommodityServices() == 2) {
			if (servicesProducts != null) {
				if (getPrice() != null && getQuantity() != null) {
					if (bills.getDefinitionOfCurrencies().isChekBox() == true) {

						amount = (double) (getQuantity() * getPrice()) * (bills.getExchangeRate());
					} else {
						amount = (double) (getQuantity() * getPrice()) * (bills.getExchangeRate());

					}
				} else {
					amount = 0.0;
				}
			} else {
				amount = 0.0;
			}
		} else if (bills.getCommodityServices() == 1) {

			if (itemsScreen != null) {
				if (getCostUnit() != null && getQuantity() != null) {
					if (bills.getDefinitionOfCurrencies().isChekBox() == true) {

						amount = (double) (getQuantity() * getCostUnit()) * (bills.getExchangeRate());
					} else {
						amount = (double) (getQuantity() * getCostUnit()) * (bills.getExchangeRate());

					}
				} else {
					amount = 0.0;
				}
			}

			else {
				amount = 0.0;
			}
		}
		return amount;

	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getInitialAmount() {
		if (bills.getCommodityServices() == 2) {

			if (servicesProducts != null) {

				if (getPrice() != null && getQuantity() != null) {
					initialAmount = (double) (getQuantity() * getPrice());
				} else {
					initialAmount = 0.0;
				}
			}
		} else if (bills.getCommodityServices() == 1) {

			if (itemsScreen != null) {
				if (getCostUnit() != null && getQuantity() != null) {

					initialAmount = (double) (getQuantity() * getCostUnit());
				} else {
					initialAmount = 0.0;
				}
			} else {

				initialAmount = 0.0;
			}
		}

		return initialAmount;
	}

	public void setInitialAmount(Double initialAmount) {
		this.initialAmount = initialAmount;
	}

	public ComercialDiscount getComercialDiscount() {
		return comercialDiscount;
	}

	public void setComercialDiscount(ComercialDiscount comercialDiscount) {
		this.comercialDiscount = comercialDiscount;
	}

	public Double getAmountdiscount() {
		if (comercialDiscount != null) {

			amountdiscount = (double) (getAmount() * comercialDiscount.getTaxAmount());

		} else {
			amountdiscount = 0.0;
		}
		return amountdiscount;
	}

	public void setAmountdiscount(Double amountdiscount) {
		this.amountdiscount = amountdiscount;
	}

	public Double getInitalamountdiscount() {
		if (comercialDiscount != null) {

			initalamountdiscount = getInitialAmount() * comercialDiscount.getTaxAmount();
		} else {
			initalamountdiscount = 0.0;
		}
		return initalamountdiscount;
	}

	public void setInitalamountdiscount(Double initalamountdiscount) {
		this.initalamountdiscount = initalamountdiscount;
	}

	public ItemsScreen getItemsScreen() {

		return itemsScreen;
	}

	public void setItemsScreen(ItemsScreen itemsScreen) {
		this.itemsScreen = itemsScreen;
	}

	public Double getCostUnit() {
		if (itemsScreen.getSalesPrice() != null) {
			costUnit = itemsScreen.getSalesPrice();
		} else {

		}
		return costUnit;
	}

	public void setCostUnit(Double costUnit) {
		this.costUnit = costUnit;
	}

	public Unit getUnits() {
		if (itemsScreen.getUnit() != null) {
			units = itemsScreen.getUnit();
		} else {
		}
		return units;
	}

	public void setUnits(Unit units) {
		this.units = units;
	}

	public ItemsScreen getItemsScreen2() {
		if (itemsScreen != null) {
			itemsScreen2 = itemsScreen;
		}
		return itemsScreen2;
	}

	public void setItemsScreen2(ItemsScreen itemsScreen2) {
		this.itemsScreen2 = itemsScreen2;
	}

	public Double getTh() {
		return th;
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

	public void setLength(Double length) {
		this.length = length;
	}

	public void setPcs(Double pcs) {
		this.pcs = pcs;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public double getReturnQuantity() {
		return ReturnQuantity;
	}

	public void setReturnQuantity(double returnQuantity) {
		ReturnQuantity = returnQuantity;
	}

	public double getReturnPieces() {
		return ReturnPieces;
	}

	public void setReturnPieces(double returnPieces) {
		ReturnPieces = returnPieces;
	}

	public Double getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(Double returnValue) {
		this.returnValue = returnValue;
	}

	public Double getReturnValueAefterTax() {
		return returnValueAefterTax;
	}

	public void setReturnValueAefterTax(Double returnValueAefterTax) {
		this.returnValueAefterTax = returnValueAefterTax;
	}

	public Double getReturnTotal() {
		return returnTotal;
	}

	public void setReturnTotal(Double returnTotal) {
		this.returnTotal = returnTotal;
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
