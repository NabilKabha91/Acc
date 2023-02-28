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
@Table(name = "addmaterials")
public class AddMaterials implements Serializable {

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
	@Column(name = "tax")
	private Long tax;
	@Column(name = "cost_unit")
	private Double costUnit;
	
	@Column(name = "value_before_tax")
	private Double valueBeforeTax;
	
	@Column(name = "initial_tax_amount")
	private Double initialTaxAmount;
	
	
	@Column(name = "initial_value_before_tax")
	private Double initialValueBeforeTax;
	
	@Column(name = "tax_amount")
	private Double taxAmount;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "initial_total")
	private Double initialTotal;

	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ItemsScreen itemsScreen;

	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfTax definitionOfTax;

	
	@ManyToOne(fetch = FetchType.LAZY)
	private PurchaseBills purchaseBills;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SellOrder sellOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	private PurchaseOrder purchaseOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Materials materials;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Unit units;
	
	
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
		AddMaterials other = (AddMaterials) obj;
		
	
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
 if(purchaseBills!=null) {
		if(purchaseBills.getDefinitionOfCurrencies().isChekBox()==true) {
			total=getInitialTotal()*(purchaseBills.getExchangeRate());

		}else {

			
			total=(getInitialTotal())*(purchaseBills.getExchangeRate());


		}
 }else {
			total=0.0;
		}
//}
 /**if(sellOrder!=null) {
	if(sellOrder.getDefinitionOfCurrencies().isChekBox()==true) {
		total=getInitialTotal()*(sellOrder.getExchangeRate());

	}else {

		
		total=(getInitialTotal())*(sellOrder.getExchangeRate());


	}
}
if(purchaseOrder!=null) {
	if(purchaseOrder.getDefinitionOfCurrencies().isChekBox()==true) {
		total=getInitialTotal()*(purchaseOrder.getExchangeRate());

	}else {

		
		total=(getInitialTotal())*(purchaseOrder.getExchangeRate());


	}
}**/
	//	total=getValueBeforeTax()+ getTaxAmount();
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




	


	public ItemsScreen getItemsScreen() {
		return itemsScreen;
	}


	public void setItemsScreen(ItemsScreen itemsScreen) {
		this.itemsScreen = itemsScreen;
	}


	public Long getTax() {
		return tax;
	}


	public void setTax(Long tax) {
		this.tax = tax;
	}


	public DefinitionOfTax getDefinitionOfTax() {
		if(itemsScreen.getDefinitionOfTax()!= null) {
			definitionOfTax=itemsScreen.getDefinitionOfTax();

		}else {
		}
		return definitionOfTax;
	}


	public void setDefinitionOfTax(DefinitionOfTax definitionOfTax) {
		this.definitionOfTax = definitionOfTax;
	}

	

	


		public Double getValueBeforeTax() {
			
			Long sellPrice;
		//	if(purchaseBills!=null) {

				if(itemsScreen != null) {

				if(getCostUnit()!= null && getQuantity()!= null) {

					if(purchaseBills.getDefinitionOfCurrencies().isChekBox()==true) {

					valueBeforeTax=(double) (getQuantity()*getCostUnit())*(purchaseBills.getExchangeRate());
					}else {
						valueBeforeTax=(double) (getQuantity()*getCostUnit())*(purchaseBills.getExchangeRate());

					}
				}else {
					valueBeforeTax =  0.0;
				}
					
				
			}else {
				valueBeforeTax = 0.0;
			}
				
			
return valueBeforeTax;
	}



	public void setValueBeforeTax(Double valueBeforeTax) {
		this.valueBeforeTax = valueBeforeTax;
	}



		public Double getTaxAmount() {
			
			if(purchaseBills!=null) {

			if(purchaseBills.getDefinitionOfCurrencies().isChekBox()==true) {
				taxAmount=getInitialTaxAmount()*(purchaseBills.getExchangeRate());

			}else {
				taxAmount=getInitialTaxAmount()*(purchaseBills.getExchangeRate());

			}
			}else {
				taxAmount=0.0;
			}
		 
			return taxAmount;

			/**if(sellOrder!=null) {
			if(sellOrder.getDefinitionOfCurrencies().isChekBox()==true) {
				taxAmount=getInitialTaxAmount()*(sellOrder.getExchangeRate());

			}else {
				taxAmount=getInitialTaxAmount()*(sellOrder.getExchangeRate());

			}
			}
		if(purchaseOrder!=null) {
				if(purchaseOrder.getDefinitionOfCurrencies().isChekBox()==true) {
					taxAmount=getInitialTaxAmount()*(purchaseOrder.getExchangeRate());

				}else {
					taxAmount=getInitialTaxAmount()*(purchaseOrder.getExchangeRate());

				}
				}**/
		}



		public void setTaxAmount(Double taxAmount) {
			this.taxAmount = taxAmount;
		}








		


	


		public Materials getMaterials() {
			return materials;
		}


		public void setMaterials(Materials materials) {
			this.materials = materials;
		}


		public Suppliers getSuppliers() {
			return suppliers;
		}


		public void setSuppliers(Suppliers suppliers) {
			this.suppliers = suppliers;
		}


		public Company getCompany() {
			return company;
		}


		public void setCompany(Company company) {
			this.company = company;
		}


		public Double getInitialTotal() {
			initialTotal=getInitialValueBeforeTax()+ getInitialTaxAmount();

			return initialTotal;
		}


		public void setInitialTotal(Double initialTotal) {
			this.initialTotal = initialTotal;
		}


		public Double getInitialTaxAmount() {
			if(definitionOfTax != null) {
		 		
				Double es=0.0;
				es=definitionOfTax.getTaxAmount();
				initialTaxAmount=(getInitialValueBeforeTax()*es);

			}else {
				initialTaxAmount = 0.0;
			}
			return initialTaxAmount;
		}


		public void setInitialTaxAmount(Double initialTaxAmount) {
			this.initialTaxAmount = initialTaxAmount;
		}


		public Double getInitialValueBeforeTax() {
			if(itemsScreen != null) {
				if(getCostUnit()!= null && getQuantity()!= null) {
					initialValueBeforeTax=(double) (getQuantity()*getCostUnit());
				}else {
					initialValueBeforeTax =  0.0;
				}
				
			}else {
				initialValueBeforeTax = 0.0;
			}
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

		

		public String getUnit() {
			if(itemsScreen.getUnit().getUnitName()!= null) {
				unit=itemsScreen.getUnit().getUnitName();
			}else {
			}
			return unit;
			
		}


		public void setUnit(String unit) {
			this.unit = unit;
		}


		public Double getCostUnit() {
			return costUnit;
		}


		public void setCostUnit(Double costUnit) {
			this.costUnit = costUnit;
		}


		public Unit getUnits() {
			if(itemsScreen.getUnit()!= null) {
				units=itemsScreen.getUnit();

			}else {
			}
			return units;
		}


		public void setUnits(Unit units) {
			this.units = units;
		}


		public PurchaseBills getPurchaseBills() {
			return purchaseBills;
		}


		public void setPurchaseBills(PurchaseBills purchaseBills) {
			this.purchaseBills = purchaseBills;
		}


		public SellOrder getSellOrder() {
			return sellOrder;
		}


		public void setSellOrder(SellOrder sellOrder) {
			this.sellOrder = sellOrder;
		}


		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public PurchaseOrder getPurchaseOrder() {
			return purchaseOrder;
		}


		public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
			this.purchaseOrder = purchaseOrder;
		}


	


		
}
