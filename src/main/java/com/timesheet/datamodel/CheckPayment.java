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
@Table(name = "checkpayment")
public class CheckPayment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "check_number")
	private Long checkNumber;

	@Column(name = "due_date")
	private Date  dueDate;
	@Column(name = "arrest_date")
	private Date  arrestDate;
	
	@Column(name = "check_value")
	private Double checkValue;
	
	
	@Column(name = "bank")
	private String bank;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Customer customer;
	
	

	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	private ReceivePayment receivePayment;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private BillsExchange billsExchange;
	
	
	
	public boolean isIsduplicated() {
		return isduplicated;
	}
	

	public void setIsduplicated(boolean isduplicated) {
		this.isduplicated = isduplicated;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	
	
	
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
		CheckPayment other = (CheckPayment) obj;
		
	
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





	

	









		public String getBank() {
			return bank;
		}



		public void setBank(String bank) {
			this.bank = bank;
		}



	

		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public Long getCheckNumber() {
			return checkNumber;
		}


		public void setCheckNumber(Long checkNumber) {
			this.checkNumber = checkNumber;
		}


		public Date getDueDate() {
			return dueDate;
		}


		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}


		public Date getArrestDate() {
			return arrestDate;
		}


		public void setArrestDate(Date arrestDate) {
			this.arrestDate = arrestDate;
		}


		public Double getCheckValue() {
			return checkValue;
		}


		public void setCheckValue(Double checkValue) {
			this.checkValue = checkValue;
		}


		public ReceivePayment getReceivePayment() {
			return receivePayment;
		}


		public void setReceivePayment(ReceivePayment receivePayment) {
			this.receivePayment = receivePayment;
		}


		public BillsExchange getBillsExchange() {
			return billsExchange;
		}


		public void setBillsExchange(BillsExchange billsExchange) {
			this.billsExchange = billsExchange;
		}



		
}
