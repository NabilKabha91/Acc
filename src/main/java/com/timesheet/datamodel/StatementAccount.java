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
@Table(name = "StatementAccount")
public class StatementAccount implements Serializable ,Comparable<StatementAccount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date  date;	
	@Column(name = "description")
	private String description;
	@Column(name = "expenseName")
	private String expenseName;
	@Column(name = "expenseNumber")
	private String expenseNumber;
	@Column(name = "document_number")
	private Long documentNumber;
	@Column(name = "analyticalCost")
	private Long analyticalCost;
	@Column(name = "document_type")
	private String documentType;
	private Long grouping_id;
	@Column(name = "cost")
	private Long cost;
	@Column(name = "TH")
	private double th;
	@Column(name = "LM")
	private double lm;
	@Column(name = "M2")
	private double m2;
	@Column(name = "M3")
	private double m3;
	@Column(name = "vat")
	private double vat;
	private String warehouses;
	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	@ManyToOne(fetch=FetchType.LAZY)
	private CostCenter costCenter;
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;	
	@ManyToOne(fetch=FetchType.LAZY)
	private Bills bills;
	@ManyToOne(fetch=FetchType.LAZY)
	private BillsExchange billsExchange;
	@ManyToOne(fetch=FetchType.LAZY)
	private PurchaseBills purchaseBills;	
	@ManyToOne(fetch=FetchType.LAZY)
	private Analytical analytical;
	@ManyToOne(fetch=FetchType.LAZY)
	private ReceivePayment receivePayment;	
	@ManyToOne(fetch=FetchType.LAZY)
	private Restrictions restrictions;
	@ManyToOne(fetch=FetchType.LAZY)
	private Materials materials;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "suppliersName")
	private String suppliersName;
	
	
	
	@Column(name = "code_item")
	private String codeItem;
	
	@Column(name = "item_group")
	private String itemGroup;
	
	@Column(name = "name_item")
	private String nameItem;
	
	@Column(name = "finish_type")
	private String finishType;
	
	@Column(name = "color")
	private String color;
	public Customer getCustomer() {
		return customer;
	}

	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	@Column(name = "debit")
	private Double debit =0.0;
	
	@Column(name = "credit")
	private Double credit =0.0;
	
	@Column(name = "debitTransaction")
	private Double debitTransaction =0.0;
	
	@Column(name = "creditTransaction")
	private Double creditTransaction =0.0;
	
	@Column(name = "debitEndingBalance")
	private Double debitEndingBalance =0.0;
	
	@Column(name = "creditEndingBalance")
	private Double creditEndingBalance =0.0;
	
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
	private String  uint;
	
	
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
		StatementAccount other = (StatementAccount) obj;
		
	
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
	public int compareTo(StatementAccount comparestu) {
   
		if(comparestu.getDate() !=null) {
	    return this.getDate().compareTo(comparestu.getDate());
		}else {
		
			return 0;

		}
		
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


	public Double getDebit() {
		return debit;
	}


	public void setDebit(Double debit) {
		this.debit = debit;
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


	public Long getGrouping_id() {
		return grouping_id;
	}


	public void setGrouping_id(Long grouping_id) {
		this.grouping_id = grouping_id;
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


	public Analytical getAnalytical() {
		return analytical;
	}


	public void setAnalytical(Analytical analytical) {
		this.analytical = analytical;
	}


	public Long getAnalyticalCost() {
		return analyticalCost;
	}


	public void setAnalyticalCost(Long analyticalCost) {
		this.analyticalCost = analyticalCost;
	}


	public CostCenter getCostCenter() {
		return costCenter;
	}


	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}


	public Long getCost() {
		return cost;
	}


	public void setCost(Long cost) {
		this.cost = cost;
	}


	public String getExpenseName() {
		return expenseName;
	}


	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}


	public String getExpenseNumber() {
		return expenseNumber;
	}


	public void setExpenseNumber(String expenseNumber) {
		this.expenseNumber = expenseNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getSuppliersName() {
		return suppliersName;
	}


	public void setSuppliersName(String suppliersName) {
		this.suppliersName = suppliersName;
	}


	public Double getDebitTransaction() {
		return debitTransaction;
	}


	public Double getCreditTransaction() {
		return creditTransaction;
	}


	public Double getDebitEndingBalance() {
		return debitEndingBalance;
	}


	public Double getCreditEndingBalance() {
		return creditEndingBalance;
	}


	public void setDebitTransaction(Double debitTransaction) {
		this.debitTransaction = debitTransaction;
	}


	public void setCreditTransaction(Double creditTransaction) {
		this.creditTransaction = creditTransaction;
	}


	public void setDebitEndingBalance(Double debitEndingBalance) {
		this.debitEndingBalance = debitEndingBalance;
	}


	public void setCreditEndingBalance(Double creditEndingBalance) {
		this.creditEndingBalance = creditEndingBalance;
	}


	public String getCodeItem() {
		return codeItem;
	}


	public void setCodeItem(String codeItem) {
		this.codeItem = codeItem;
	}


	public String getItemGroup() {
		return itemGroup;
	}


	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}


	public String getNameItem() {
		return nameItem;
	}


	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}


	public String getFinishType() {
		return finishType;
	}


	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getUint() {
		return uint;
	}


	public void setUint(String uint) {
		this.uint = uint;
	}


	public String getWarehouses() {
		return warehouses;
	}


	public void setWarehouses(String warehouses) {
		this.warehouses = warehouses;
	}


	public double getTh() {
		return th;
	}


	public void setTh(double th) {
		this.th = th;
	}


	public double getLm() {
		return lm;
	}


	public void setLm(double lm) {
		this.lm = lm;
	}


	public double getM2() {
		return m2;
	}


	public void setM2(double m2) {
		this.m2 = m2;
	}


	public double getM3() {
		return m3;
	}


	public void setM3(double m3) {
		this.m3 = m3;
	}


	public double getVat() {
		return vat;
	}


	public void setVat(double vat) {
		this.vat = vat;
	}

	

}
