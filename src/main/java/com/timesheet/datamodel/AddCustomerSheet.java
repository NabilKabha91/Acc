package com.timesheet.datamodel;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "addCustomerSheet")
public class AddCustomerSheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String description;
	@Column(name = "commission ")
	private Double commission ;

	@Column(name = "price")
	private Double price;
	@Column(name = "net_income")
	private Double netIncome;
	@Column(name = "initial_total")
	private Double initialTotal;

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
    @ManyToOne(fetch = FetchType.LAZY)
	private Employee employees;
    
	@ManyToOne(fetch = FetchType.LAZY)
	private ServicesProducts servicesProducts;

	@ManyToOne(fetch=FetchType.LAZY)
	private CostCenter costCenter;

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;

	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerSheet customerSheet;


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
		AddCustomerSheet other = (AddCustomerSheet) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

	public Double getPrice() {
		return price;
	}

	public Double getInitialTotal() {
		return initialTotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ServicesProducts getServicesProducts() {
		return servicesProducts;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public User getUser() {
		return user;
	}

	public Office getOffice() {
		return office;
	}

	public Company getCompany() {
		return company;
	}

	public boolean isAddDefinitionOfCurrencies() {
		return addDefinitionOfCurrencies;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setInitialTotal(Double initialTotal) {
		this.initialTotal = initialTotal;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setServicesProducts(ServicesProducts servicesProducts) {
		this.servicesProducts = servicesProducts;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setAddDefinitionOfCurrencies(boolean addDefinitionOfCurrencies) {
		this.addDefinitionOfCurrencies = addDefinitionOfCurrencies;
	}

	public String getDescription() {
		return description;
	}

	public CustomerSheet getCustomerSheet() {
		return customerSheet;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCustomerSheet(CustomerSheet customerSheet) {
		this.customerSheet = customerSheet;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Double getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(Double netIncome) {
		this.netIncome = netIncome;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	
}
