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
@Table(name = "materials")
public class Materials implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "materials_number")
	private Long materialsNumber;
	@Column(name = "materials_date")
	private Date materialsDate;
	@Column(name = "today_date")
	private Date todayDate = new Date();
	@Column(name = "due_date")
	private Date  dueDate;

	
	private String ee;
	


	@Column(name = "total_characters")
	private String totalCharacters ;
	
	@Column(columnDefinition = "double default '0'")
	private double exchangeRate
;
	
	@Column(name = "total")
	private Double total;
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(name = "document_type")
	private String documentType
;
	
	@Column(name = "materials_num")
	private Long materialsNum;

	@ManyToOne(fetch=FetchType.LAZY)
	private Suppliers suppliers;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private DefinitionOfCurrencies definitionOfCurrencies;
	
	private ServicesProducts servicesProducts;

	@ManyToOne(fetch=FetchType.LAZY)
	private BillManagement billManagement;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private BankData bankData;

	
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
		Materials other = (Materials) obj;
		
	
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

	

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}







	public Date getTodayDate() {
		return todayDate;
	}


	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}


	





	public BillManagement getBillManagement() {
		return billManagement;
	}


	public void setBillManagement(BillManagement billManagement) {
		this.billManagement = billManagement;
	}


	public BankData getBankData() {
		return bankData;
	}


	public void setBankData(BankData bankData) {
		this.bankData = bankData;
	}


	public DefinitionOfCurrencies getDefinitionOfCurrencies() {
		
	
		return definitionOfCurrencies;
	}


	public void setDefinitionOfCurrencies(DefinitionOfCurrencies definitionOfCurrencies) {
		this.definitionOfCurrencies = definitionOfCurrencies;
	}


	public String getTotalCharacters() {
		return totalCharacters;
	}


	public void setTotalCharacters(String totalCharacters) {
		this.totalCharacters = totalCharacters;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	public double getExchangeRate() {
		return exchangeRate;
	}


	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}


	public String getEe() {
		
	if(definitionOfCurrencies.isChekBox()==true) {
			
			ee=definitionOfCurrencies.getDefinitionOfCurrenciesName();
		}
		else {

		}
		return ee;
	}


	public void setEe(String ee) {
		this.ee = ee;
	}


	public ServicesProducts getServicesProducts() {
		return servicesProducts;
	}


	public void setServicesProducts(ServicesProducts servicesProducts) {
		this.servicesProducts = servicesProducts;
	}


	public Long getMaterialsNumber() {
		return materialsNumber;
	}


	public void setMaterialsNumber(Long materialsNumber) {
		this.materialsNumber = materialsNumber;
	}


	public Date getMaterialsDate() {
		return materialsDate;
	}


	public void setMaterialsDate(Date materialsDate) {
		this.materialsDate = materialsDate;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public Long getMaterialsNum() {
		return materialsNum;
	}

	public void setMaterialsNum(Long materialsNum) {
		this.materialsNum = materialsNum;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	


}
