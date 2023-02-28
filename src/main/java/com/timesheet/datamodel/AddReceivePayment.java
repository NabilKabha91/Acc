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
@Table(name = "addreceivepayment")
public class AddReceivePayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "open_balance")
	private Double openBalance;
	
	@Column(name = "payment")
	private Double payment=0.0;
	
	@Column(name = "total_bill")
	private Double totalBill;
	
	@Column(name = "today_date")
	private Date todayDate = new Date();
	
	@Column(name = "date")
	private Date date ;
	
	@Column(name = "due_date")
	private Date dueDate ;
	
	@Column(name = "document_name")
	private String documentName ;
	
	@Column(name = "paymentTax")
	private Double paymentTax=0.0;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;

	@Column(name = "payment_previously")
	private Double paymentPreviously;
	
	@Column(name = "balance_previously")
	private Double balancePreviously;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Bills bills;
	@ManyToOne(fetch=FetchType.LAZY)
	private  AddRestrictions  addRestrictions ;
	
	private Long groupingId;

	@Column(name = "number")
	private Long number;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@Column(columnDefinition = "int default '0'")
	private boolean chekBox;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private ReceivePayment receivePayment;
	
	@Column(name = "amount_receved")
	private Double amountReceved;	
	
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
		AddReceivePayment other = (AddReceivePayment) obj;
		
	
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

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

		public ReceivePayment getReceivePayment() {
		return receivePayment;
	}


	public void setReceivePayment(ReceivePayment receivePayment) {
		this.receivePayment = receivePayment;
	}


		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public Double getOpenBalance() {
			return openBalance;
		}


		public void setOpenBalance(Double openBalance) {
			this.openBalance = openBalance;
		}


		public Double getPayment() {
			return payment;
		}


		public void setPayment(Double payment) {
			this.payment = payment;
		}


		


		public Double getTotalBill() {
			return totalBill;
		}


		public void setTotalBill(Double totalBill) {
			this.totalBill = totalBill;
		}


		public Date getTodayDate() {
			return todayDate;
		}


		public void setTodayDate(Date todayDate) {
			this.todayDate = todayDate;
		}


		public Bills getBills() {
			return bills;
		}


		public void setBills(Bills bills) {
			this.bills = bills;
		}


		public boolean isChekBox() {
			return chekBox;
		}


		public void setChekBox(boolean chekBox) {
			this.chekBox = chekBox;
		}


		public Double getAmountReceved() {
			return amountReceved;
		}


		public void setAmountReceved(Double amountReceved) {
			this.amountReceved = amountReceved;
		}


		public Company getCompany() {
			return company;
		}


		public void setCompany(Company company) {
			this.company = company;
		}


		public Double getPaymentPreviously() {
			return paymentPreviously;
		}


		public void setPaymentPreviously(Double paymentPreviously) {
			this.paymentPreviously = paymentPreviously;
		}


		public Double getBalancePreviously() {
			
			return balancePreviously;
		}


		public void setBalancePreviously(Double balancePreviously) {
			this.balancePreviously = balancePreviously;
		}


		public AddRestrictions getAddRestrictions() {
			return addRestrictions;
		}


		public void setAddRestrictions(AddRestrictions addRestrictions) {
			this.addRestrictions = addRestrictions;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		public Date getDueDate() {
			return dueDate;
		}


		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}


		public Long getNumber() {
			return number;
		}


		public void setNumber(Long number) {
			this.number = number;
		}


		public String getDocumentName() {
			return documentName;
		}


		public void setDocumentName(String documentName) {
			this.documentName = documentName;
		}


		public Double getPaymentTax() {
			return paymentTax;
		}


		public void setPaymentTax(Double paymentTax) {
			this.paymentTax = paymentTax;
		}


		public Long getGroupingId() {
			return groupingId;
		}


		public void setGroupingId(Long groupingId) {
			this.groupingId = groupingId;
		}


	

		
		
}
