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
@Table(name = "document")
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "document_name")
	private String documentName;

	@Column(name = "document_type")
	private Long documentType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Bills bills;

	@ManyToOne(fetch = FetchType.LAZY)
	private PurchaseBills purchaseBills;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Materials materials;

	@ManyToOne(fetch = FetchType.LAZY)
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SellOrder sellOrder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private WarehouseReleaseDocument warehouseReleaseDocument;
	@ManyToOne(fetch = FetchType.LAZY)
	private RequestWarehouseReleaseDocument requestWarehouseReleaseDocument;
	
	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	@Column(columnDefinition = "int default '0'")
	private boolean isDeleted;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Restrictions restrictions ;

	@ManyToOne(fetch=FetchType.LAZY)
	private BankDeposit bankDeposit;

	@ManyToOne(fetch=FetchType.LAZY)
	private BillsExchange billsExchange;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private ReceivePayment receivePayment  ;

	
	@ManyToOne(fetch=FetchType.LAZY)
	private NoteCredit noteCredit;


	@ManyToOne(fetch=FetchType.LAZY)
	private Office office;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private NoteDebit noteDebit;

	
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



/**
	 * @return the email
	 */
	




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
		Document other = (Document) obj;
		
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Long getDocumentType() {
		return documentType;
	}

	public void setDocumentType(Long documentType) {
		this.documentType = documentType;
	}

	public PurchaseBills getPurchaseBills() {
		return purchaseBills;
	}

	public void setPurchaseBills(PurchaseBills purchaseBills) {
		this.purchaseBills = purchaseBills;
	}

	public BillsExchange getBillsExchange() {
		return billsExchange;
	}

	public void setBillsExchange(BillsExchange billsExchange) {
		this.billsExchange = billsExchange;
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

	public BankDeposit getBankDeposit() {
		return bankDeposit;
	}

	public void setBankDeposit(BankDeposit bankDeposit) {
		this.bankDeposit = bankDeposit;
	}

	public NoteCredit getNoteCredit() {
		return noteCredit;
	}

	public void setNoteCredit(NoteCredit noteCredit) {
		this.noteCredit = noteCredit;
	}

	public NoteDebit getNoteDebit() {
		return noteDebit;
	}

	public void setNoteDebit(NoteDebit noteDebit) {
		this.noteDebit = noteDebit;
	}

	public Materials getMaterials() {
		return materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public WarehouseReleaseDocument getWarehouseReleaseDocument() {
		return warehouseReleaseDocument;
	}

	public void setWarehouseReleaseDocument(WarehouseReleaseDocument warehouseReleaseDocument) {
		this.warehouseReleaseDocument = warehouseReleaseDocument;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public SellOrder getSellOrder() {
		return sellOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public void setSellOrder(SellOrder sellOrder) {
		this.sellOrder = sellOrder;
	}

	public RequestWarehouseReleaseDocument getRequestWarehouseReleaseDocument() {
		return requestWarehouseReleaseDocument;
	}

	public void setRequestWarehouseReleaseDocument(RequestWarehouseReleaseDocument requestWarehouseReleaseDocument) {
		this.requestWarehouseReleaseDocument = requestWarehouseReleaseDocument;
	}

	


	





	
	

	

	


	


}
