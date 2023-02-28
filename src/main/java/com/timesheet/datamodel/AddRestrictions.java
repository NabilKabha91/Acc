package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;
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

import com.timesheet.presentation.web.AuditException;
import com.timesheet.presentation.web.Grouping;
import com.timesheet.presentation.web.GroupingBusiness;
import com.timesheet.presentation.web.ListCustomerAndSuppliers;
import org.apache.commons.lang3.StringUtils;

import com.timesheet.utils.Utils;

@Entity
@Table(name = "addrestrictions")
public class AddRestrictions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "debit")
	private Double debit = 0.0;

	@Column(name = "inital_credit")
	private Double initalCredit;

	@Column(name = "inital_debit")
	private Double initalDebit;

	@Column(name = "credit")
	private Double credit = 0.0;

	@ManyToOne(fetch = FetchType.LAZY)
	private CostCenter costCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	private Analytical analytical;
	private String grpName;

	private String customerAndSuppliers;

	private String customerAndSuppliersId;

//	private String grpDesc;

	private Long groupingId;

	private SelectItem nameId;

	private SelectItem account;

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;

	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Restrictions restrictions;

	private String suppliersId;

	private String customerId;
	private String type;

	private ListCustomerAndSuppliers listCustomerAndSupplier;

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
	private String grp;
	private String nameGrp;

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
		AddRestrictions other = (AddRestrictions) obj;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	public Restrictions getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
	}

	public Long getGroupingId() {
		return groupingId;
	}

	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
	}

	public SelectItem getAccount() {
		if (StringUtils.isNotEmpty(getGrpName())) {

			account = new SelectItem();

			account.setLabel(getGrpName());
			account.setValue(getGrp());
		}

		return account;
	}

	public void setAccount(SelectItem account) {
		if (account != null) {

			grpName = account.getLabel().toString();
			grp = account.getValue().toString();

		}
		this.account = account;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public SelectItem getNameId() {
		if (StringUtils.isNotEmpty(getCustomerAndSuppliers())) {

			nameId = new SelectItem();

			nameId.setLabel(getCustomerAndSuppliers());
			nameId.setValue(getCustomerAndSuppliersId());

		}

		return nameId;
	}

	public void setNameId(SelectItem nameId) {
		if (nameId != null) {

			customerAndSuppliers = nameId.getLabel().toString();
			customerAndSuppliersId = nameId.getValue().toString();
			String[] parts = customerAndSuppliersId.split("-");

			if (parts[0].equals("1")) {
				customerId = parts[1];
				type = parts[0];

			} else {
				suppliersId = parts[1];
				type = parts[0];

			}
			/**
			 * for( String part : parts ) {
			 * 
			 * customer_id=part; }
			 **/
		}
		this.nameId = nameId;
	}

	public ListCustomerAndSuppliers getListCustomerAndSupplier() {
		return listCustomerAndSupplier;
	}

	public void setListCustomerAndSupplier(ListCustomerAndSuppliers listCustomerAndSupplier) {
		this.listCustomerAndSupplier = listCustomerAndSupplier;
	}

	public String getCustomerAndSuppliers() {
		return customerAndSuppliers;
	}

	public void setCustomerAndSuppliers(String customerAndSuppliers) {
		this.customerAndSuppliers = customerAndSuppliers;
	}

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public String getCustomerAndSuppliersId() {
		return customerAndSuppliersId;
	}

	public void setCustomerAndSuppliersId(String customerAndSuppliersId) {
		this.customerAndSuppliersId = customerAndSuppliersId;
	}

	public String getSuppliersId() {
		return suppliersId;
	}

	public void setSuppliersId(String suppliersId) {
		this.suppliersId = suppliersId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getInitalCredit() {
		if (restrictions.getDefinitionOfCurrencies() != null) {
			if (restrictions.getDefinitionOfCurrencies().isChekBox() == true) {

				initalCredit = getCredit() * (restrictions.getExchangeRate());

			} else {
				initalCredit = getCredit() * (restrictions.getExchangeRate());

			}
		}

		return initalCredit;
	}

	public void setInitalCredit(Double initalCredit) {
		this.initalCredit = initalCredit;
	}

	public Double getInitalDebit() {
		if (restrictions.getDefinitionOfCurrencies() != null) {
			if (restrictions.getDefinitionOfCurrencies().isChekBox() == true) {
				initalDebit = getDebit() * (restrictions.getExchangeRate());

			} else {
				initalDebit = getDebit() * (restrictions.getExchangeRate());

			}
		}

		return initalDebit;
	}

	public void setInitalDebit(Double initalDebit) {
		this.initalDebit = initalDebit;
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


	public String getNameGrp() {
	
		return nameGrp;

	}

	public void setNameGrp(String nameGrp) {
		this.nameGrp = nameGrp;
	}




}
