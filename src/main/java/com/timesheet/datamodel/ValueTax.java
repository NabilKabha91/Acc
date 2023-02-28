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
@Table(name = "ValueTax")
public class ValueTax implements Serializable ,Comparable<ValueTax> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "qT")
	private Double qT;

	@Column(name = "price")
	private Double price;


	@Column(name = "cost")
	private Double cost;

	@Column(name = "net_income")
	private Double netIncome;
	@Column(name = "invoice")
	private Double invoice;
	
	private Date  date;
	
	@Column(name = "description")
	private String description;

	@Column(name = "Visa")
	private Double visa;

	@Column(name = "cash")
	private Double cash;
	@Column(name = "document_number")
	private Long documentNumber
;
	
	@Column(name = "customer_suppliers")
	private Long customerSuppliers
;
	
	@Column(name = "document_type")
	private String documentType;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Bills bills;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private BillsExchange billsExchange;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseBills purchaseBills;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ReceivePayment receivePayment;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Restrictions restrictions;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Materials materials;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ServicesProducts servicesProducts;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;
	
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	@Column(name = "amount_Before_Tax")
	private Double amountBeforeTax =0.0;
	
	@Column(name = "tax")
	private Double tax =0.0;
	

	@Column(name = "amount_After_Tax")
	private Double amountAfterTax =0.0;
	

	@Column(name = "credit")
	private Double credit =0.0;
	
	@Column(name = "total")
	private Double total =0.0;
	
	@Column(name = "pre_total")
	private Double preTotal =0.0;
	
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "close_Financial")
	private Date closeFinancial;
	
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
		ValueTax other = (ValueTax) obj;
		
	
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
	
	
	@Override
	public int compareTo(ValueTax comparestu) {
   
		if(comparestu.getDate() !=null) {
	    return this.getDate().compareTo(comparestu.getDate());
		}
		return 0;
		
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


	
	

	







	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Long getDocumentNumber() {
		return documentNumber;
	}


	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	


	public Double getAmountBeforeTax() {
		return amountBeforeTax;
	}


	public void setAmountBeforeTax(Double amountBeforeTax) {
		this.amountBeforeTax = amountBeforeTax;
	}


	public Double getCredit() {
		return credit;
	}


	public void setCredit(Double credit) {
		this.credit = credit;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Bills getBills() {
		return bills;
	}


	public void setBills(Bills bills) {
		this.bills = bills;
	}


	public ReceivePayment getReceivePayment() {
		return receivePayment;
	}


	public void setReceivePayment(ReceivePayment receivePayment) {
		this.receivePayment = receivePayment;
	}


	public Restrictions getRestrictions() {
		return restrictions;
	}


	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
	}


	public Suppliers getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}


	public BillsExchange getBillsExchange() {
		return billsExchange;
	}


	public void setBillsExchange(BillsExchange billsExchange) {
		this.billsExchange = billsExchange;
	}


	public PurchaseBills getPurchaseBills() {
		return purchaseBills;
	}


	public void setPurchaseBills(PurchaseBills purchaseBills) {
		this.purchaseBills = purchaseBills;
	}





	public Double getPreTotal() {
		return preTotal;
	}


	public void setPreTotal(Double preTotal) {
		this.preTotal = preTotal;
	}


	public Materials getMaterials() {
		return materials;
	}


	public void setMaterials(Materials materials) {
		this.materials = materials;
	}


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}


	public Double getAmountAfterTax() {
		return amountAfterTax;
	}


	public void setAmountAfterTax(Double amountAfterTax) {
		this.amountAfterTax = amountAfterTax;
	}


	public Long getCustomerSuppliers() {
		return customerSuppliers;
	}


	public void setCustomerSuppliers(Long customerSuppliers) {
		this.customerSuppliers = customerSuppliers;
	}


	public ServicesProducts getServicesProducts() {
		return servicesProducts;
	}


	public void setServicesProducts(ServicesProducts servicesProducts) {
		this.servicesProducts = servicesProducts;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Double getqT() {
		return qT;
	}


	public Double getPrice() {
		return price;
	}


	public Double getCost() {
		return cost;
	}


	public Double getInvoice() {
		return invoice;
	}


	public void setqT(Double qT) {
		this.qT = qT;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public void setInvoice(Double invoice) {
		this.invoice = invoice;
	}


	public Double getNetIncome() {
		return netIncome;
	}


	public void setNetIncome(Double netIncome) {
		this.netIncome = netIncome;
	}


	public Double getVisa() {
		return visa;
	}


	public void setVisa(Double visa) {
		this.visa = visa;
	}


	public Double getCash() {
		return cash;
	}


	public void setCash(Double cash) {
		this.cash = cash;
	}






	


}
