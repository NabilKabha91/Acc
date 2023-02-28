package com.timesheet.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 992005927089339422L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "type_name_ar")
	private String typeNameAr;
	@Column(name = "type_name_en")
	private String typeNameEn;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((typeNameAr == null) ? 0 : typeNameAr.hashCode());
		result = prime * result + ((typeNameEn == null) ? 0 : typeNameEn.hashCode());
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
		UserType other = (UserType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (typeNameAr == null) {
			if (other.typeNameAr != null)
				return false;
		} else if (!typeNameAr.equals(other.typeNameAr))
			return false;
		if (typeNameEn == null) {
			if (other.typeNameEn != null)
				return false;
		} else if (!typeNameEn.equals(other.typeNameEn))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserType [id=" + id + ", typeNameAr=" + typeNameAr + ", typeNameEn=" + typeNameEn + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeNameAr() {
		return typeNameAr;
	}

	public void setTypeNameAr(String typeNameAr) {
		this.typeNameAr = typeNameAr;
	}

	public String getTypeNameEn() {
		return typeNameEn;
	}

	public void setTypeNameEn(String typeNameEn) {
		this.typeNameEn = typeNameEn;
	}

	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
