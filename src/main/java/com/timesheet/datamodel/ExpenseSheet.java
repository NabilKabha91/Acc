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
@Table(name = "expenseSheet")
public class ExpenseSheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ItemsScreen items;
	
	@Column(name = "date")
	private Date date = new Date();
	

	@Column(name = "today_date")
	private Date todayDate = new Date();

	
		
	@ManyToOne(fetch=FetchType.LAZY)
	private AddExpenseSheet  addExpenseSheet;

	@Column(name = "qT")
	private Double qT;

	@Column(name = "price")
	private Double price;


	@Column(name = "cost")
	private Double cost;
	@ManyToOne(fetch = FetchType.LAZY)
	private ServicesProducts servicesProducts;

	@Column(name = "invoice")
	private Double invoice;


	
	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers  suppliers;

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private CostCenter costCenter;
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


	public ItemsScreen getItems() {
		return items;
	}

	public void setItems(ItemsScreen items) {
		this.items = items;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}




	public AddExpenseSheet getAddExpenseSheet() {
		return addExpenseSheet;
	}

	public void setAddExpenseSheet(AddExpenseSheet addExpenseSheet) {
		this.addExpenseSheet = addExpenseSheet;
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

	public ServicesProducts getServicesProducts() {
		return servicesProducts;
	}

	public void setServicesProducts(ServicesProducts servicesProducts) {
		this.servicesProducts = servicesProducts;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public Date getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	

	







}
