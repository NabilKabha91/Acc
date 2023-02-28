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

import com.timesheet.presentation.web.Grouping;
import com.timesheet.utils.Utils;

@Entity
@Table(name = "addPurchaseOrder")
public class AddPurchaseOrder implements Serializable {

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
	@Column(name = "initial_tax_amount")
	private Double initialTaxAmount;
	
	@Column(name = "initial_amount")
	private Double initialAmount;
	
	@Column(name = "cost_unit")
	private Double costUnit;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ItemsScreen itemsScreen;

	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "initial_value_before_tax")
	private Double initialValueBeforeTax;
	@Column(name = "bank")
	private String bank;
	@Column(name = "value_before_tax")
	private Double valueBeforeTax;
	
	@Column(name = "tax_amount")
	private Double taxAmount;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "initial_total")
	private Double initialTotal;
	@Column(name = "unitprice")
	private Double unitPrice;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	@Column(name = "clause")
	private String clause;
	@ManyToOne(fetch=FetchType.LAZY)
	private ServicesProducts servicesProducts;

	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfTax definitionOfTax;

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Column(name = "amount")
	private Double amount;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;

	@ManyToOne(fetch = FetchType.LAZY)
	private PurchaseOrder purchaseOrder;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "close_Financial")
	private Date closeFinancial;
	
	private Long groupingId;

	@ManyToOne(fetch=FetchType.LAZY)
	private ComercialDiscount comercialDiscount;

	@Column(name = "amount_discount")
	private Double amountdiscount ;
	
	@Column(name = "unit")
	private String unit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Unit units;
	
	@Column(name = "inital_amount_discount")
	private Double initalamountdiscount ;
	

	public boolean isIsduplicated() {
		return isduplicated;
	}
	

	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@Column(name = "select_Company")
	private Long selectCompany;

	public Long getId() {
		return id;
	}

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

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddPurchaseOrder other = (AddPurchaseOrder) obj;
		
	
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
	
	
		return true;
	}

	

	

	

	public Double getTotal() {
		total=getValueBeforeTax()+ getTaxAmount();
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

	public Date getCloseFinancial() {
		return closeFinancial;
	}

	public void setCloseFinancial(Date closeFinancial) {
		this.closeFinancial = closeFinancial;
	}

	public Long getSelectCompany() {
		return selectCompany;
	}

	public void setSelectCompany(Long selectCompany) {
		this.selectCompany = selectCompany;
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
		return definitionOfTax;
	}


	public void setDefinitionOfTax(DefinitionOfTax definitionOfTax) {
		this.definitionOfTax = definitionOfTax;
	}

	
	public Double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	


		public Double getValueBeforeTax() {
			if(purchaseOrder.getCommodityServices()==2) {

			if(description != null) {
				if(getUnitPrice() != null && getQuantity()!= null) {
						if(purchaseOrder.getDefinitionOfCurrencies().isChekBox()==true) {

							valueBeforeTax=(double) (getQuantity()*getUnitPrice())*(purchaseOrder.getExchangeRate());
						}else {
							valueBeforeTax=(double) (getQuantity()*getUnitPrice())*(purchaseOrder.getExchangeRate());

						}
				}else {
					valueBeforeTax = 0.0;
				}
				
			}else {
				valueBeforeTax = 0.0;
			}
			}
		else if(purchaseOrder.getCommodityServices()==3) {
			valueBeforeTax=getAmount()-getAmountdiscount();
			}
		else if(purchaseOrder.getCommodityServices()==1) {
			if(itemsScreen != null) {
				if(getCostUnit()!= null && getQuantity()!= null) {
					if(purchaseOrder.getDefinitionOfCurrencies().isChekBox()==true) {

					valueBeforeTax=(double) (getQuantity()*getCostUnit())*(purchaseOrder.getExchangeRate());
					}else {
						valueBeforeTax=(double) (getQuantity()*getCostUnit())*(purchaseOrder.getExchangeRate());

					}
				}else {
					valueBeforeTax =  0.0;
				}
					
				
			}else {
				valueBeforeTax = 0.0;
			}
		}
			
		return valueBeforeTax;
	}



	public void setValueBeforeTax(Double valueBeforeTax) {
		this.valueBeforeTax = valueBeforeTax;
	}



		public Double getTaxAmount() {
			if(purchaseOrder.getDefinitionOfCurrencies().isChekBox()==true) {
				taxAmount=getInitialTaxAmount()*(purchaseOrder.getExchangeRate());

			}else {
				taxAmount=getInitialTaxAmount()*(purchaseOrder.getExchangeRate());

			}
	 	
			return taxAmount;
		}


		

		public void setTaxAmount(Double taxAmount) {
			this.taxAmount = taxAmount;
		}


		


		public PurchaseOrder getPurchaseOrder() {
			return purchaseOrder;
		}


		public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
			this.purchaseOrder = purchaseOrder;
		}


		public String getBank() {
			return bank;
		}



		public void setBank(String bank) {
			this.bank = bank;
		}



		public Double getPrice() {
			if(servicesProducts!=null) {
			if(servicesProducts.getSellPrice()!= null) {
				price=servicesProducts.getSellPrice();
			}else {
				
			}
			}
			return price;
		}



		public void setPrice(Double price) {
			this.price = price;
		}


		public Suppliers getSuppliers() {
			return suppliers;
		}


		public void setSuppliers(Suppliers suppliers) {
			this.suppliers = suppliers;
		}


		public String getClause() {
			return clause;
		}


		public void setClause(String clause) {
			this.clause = clause;
		}


		


		public Company getCompany() {
			return company;
		}


		public void setCompany(Company company) {
			this.company = company;
		}


		public Long getGroupingId() {
			return groupingId;
		}


		public void setGroupingId(Long groupingId) {
			this.groupingId = groupingId;
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
			
			if(purchaseOrder.getCommodityServices()==2) {

			if(description != null) {
				if(getUnitPrice() != null && getQuantity()!= null) {
			
					initialValueBeforeTax=(double) (getQuantity()*getUnitPrice());
				}else {
					initialValueBeforeTax = 0.0;
				}
				
			}else {
				initialValueBeforeTax = 0.0;
			}
			}
			else if(purchaseOrder.getCommodityServices()==3) {
				initialValueBeforeTax=getInitialAmount()-getInitalamountdiscount();
			}
			else if(purchaseOrder.getCommodityServices()==1) {
				if(itemsScreen != null) {
					if(getCostUnit()!= null && getQuantity()!= null) {
						initialValueBeforeTax=(double) (getQuantity()*getCostUnit());
					}else {
						initialValueBeforeTax =  0.0;
					}
					
				}else {
					initialValueBeforeTax = 0.0;
				}
			}
			return initialValueBeforeTax;
		}


		public void setInitialValueBeforeTax(Double initialValueBeforeTax) {
			this.initialValueBeforeTax = initialValueBeforeTax;
		}


		public String getBarcode() {
			return barcode;
		}


		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}


		public ComercialDiscount getComercialDiscount() {
			return comercialDiscount;
		}


		public void setComercialDiscount(ComercialDiscount comercialDiscount) {
			this.comercialDiscount = comercialDiscount;
		}


		public Double getInitialAmount() {
			if(purchaseOrder.getCommodityServices()==3) {
			if(servicesProducts != null) {
				if(getPrice()!= null && getQuantity()!= null) {
					initialAmount=(double) (getQuantity()*getPrice());
				}else {
					initialAmount =  0.0;
				}
				
			}else {
				initialAmount = 0.0;
			}
			}
			return initialAmount;	
			}


		public void setInitialAmount(Double initialAmount) {
			this.initialAmount = initialAmount;
		}


		public Double getAmount() {
			Long sellPrice;
			if(purchaseOrder.getCommodityServices()==3) {

			if(servicesProducts != null) {
			if(getPrice()!= null && getQuantity()!= null) {
				if(purchaseOrder.getDefinitionOfCurrencies().isChekBox()==true) {

					amount=(double) (getQuantity()*getPrice())*(purchaseOrder.getExchangeRate());
				}else {
					amount=(double) (getQuantity()*getPrice())*(purchaseOrder.getExchangeRate());

				}
			}else {
				amount =  0.0;
			}
			
		}else {
			amount = 0.0;
		}
			}
	return amount;
					}


		public void setAmount(Double amount) {
			this.amount = amount;
		}


		public Double getAmountdiscount() {
			if(purchaseOrder.getCommodityServices()==3) {

			if(comercialDiscount != null) {

				amountdiscount=(double) (getAmount()*comercialDiscount.getTaxAmount());
			
			
		}else {
			amountdiscount = 0.0;
		}
			}
			return amountdiscount;
		}


		public Double getInitalamountdiscount() {
			if(purchaseOrder.getCommodityServices()==3) {

	if(comercialDiscount != null) {
				
				initalamountdiscount=getInitialAmount()*comercialDiscount.getTaxAmount();
			}else {
				initalamountdiscount = 0.0;
			}
			}
			return initalamountdiscount;
		}


		public void setAmountdiscount(Double amountdiscount) {
			this.amountdiscount = amountdiscount;
		}


		public void setInitalamountdiscount(Double initalamountdiscount) {
			this.initalamountdiscount = initalamountdiscount;
		}


		public Double getCostUnit() {
			return costUnit;
		}


		public void setCostUnit(Double costUnit) {
			this.costUnit = costUnit;
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


		public ItemsScreen getItemsScreen() {
			return itemsScreen;
		}


		public void setItemsScreen(ItemsScreen itemsScreen) {
			this.itemsScreen = itemsScreen;
		}


		public Unit getUnits() {
			return units;
		}


		public void setUnits(Unit units) {
			this.units = units;
		}


	





		
	
}
