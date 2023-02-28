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
@Table(name = "addpayrollreport")
public class AddPayrollReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "today_date")
	private Date todayDate = new Date();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;

	@Column(name = "month")
	private Long month;

	@Column(name = "year")
	private Long year;

	@ManyToOne(fetch=FetchType.LAZY)
	private Employee employee;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private AddPayroll addPayroll;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	  
	@Column(columnDefinition = "int default '0'")
	private boolean isduplicated;
	
	@Column(columnDefinition = "int default '0'")
	private boolean chekBox;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Payroll payroll;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PayrollReport payrollReport;
	
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
		AddPayrollReport other = (AddPayrollReport) obj;
		
	
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



	

		


		public Payroll getPayroll() {
		return payroll;
	}


	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}


		public Date getTodayDate() {
			return todayDate;
		}


		public void setTodayDate(Date todayDate) {
			this.todayDate = todayDate;
		}


	


		public Employee getEmployee() {
			return employee;
		}


		public void setEmployee(Employee employee) {
			this.employee = employee;
		}


		public boolean isChekBox() {
			return chekBox;
		}


		public void setChekBox(boolean chekBox) {
			this.chekBox = chekBox;
		}


		
		public Company getCompany() {
			return company;
		}


		public void setCompany(Company company) {
			this.company = company;
		}


		public Long getMonth() {
			return month;
		}


		public void setMonth(Long month) {
			this.month = month;
		}




		public Long getYear() {
			return year;
		}


		public void setYear(Long year) {
			this.year = year;
		}


		public AddPayroll getAddPayroll() {
			return addPayroll;
		}


		public void setAddPayroll(AddPayroll addPayroll) {
			this.addPayroll = addPayroll;
		}


		public PayrollReport getPayrollReport() {
			return payrollReport;
		}


		public void setPayrollReport(PayrollReport payrollReport) {
			this.payrollReport = payrollReport;
		}


	
		
		
}
