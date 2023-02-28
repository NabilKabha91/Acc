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
@Table(name = "closed_years")

public class CloseYear implements Serializable {
	
		private static final long serialVersionUID = 1300921551601339698L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "year")
		private int year;

		@Column(name = "close")
		private boolean close;

		@OneToOne(fetch=FetchType.LAZY)
		private Office office;

		@ManyToOne(fetch=FetchType.LAZY)
		private Company company;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public boolean isClose() {
			return close;
		}

		public void setClose(boolean close) {
			this.close = close;
		}

		public Office getOffice() {
			return office;
		}

		public void setOffice(Office office) {
			this.office = office;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		
		

	}

