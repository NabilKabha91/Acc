package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="exclusion")
public class Exclusion implements Serializable {
	
	private static final long serialVersionUID = -8455061850556612696L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "date")
	private Date date1 ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Assets asset;
	
	@Column(name = "disposalOrSale")
	private int disposalOrSale;
	
	private Long groupingId;
	private Long groupingId2;

	
	@Column(name = "TheValueObtainedFromTheSale")
	private Double theValueObtainedFromTheSale;
	
	@Column(name = "AssetValue")
	private Double assetValue;
	

	@Column(name = "AccumlatedDepreciation")
	private Double accumlatedDepreciation;
	
	@Column(name = "netBookValue")
	private Double netBookValue;
	
	
	@Column(name="gainAndLoss")
	private Double gainAndLoss ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Company company;
	
	@Column(name="group1")
	private String group1 ;
	
	@Column(name = "soso")
	private String soso;

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate1() {
		return date1;
	}


	public void setDate1(Date date1) {
		this.date1 = date1;
	}


	public Assets getAsset() {
		return asset;
	}


	public void setAsset(Assets asset) {
		this.asset = asset;
	}


	public int getDisposalOrSale() {
		return disposalOrSale;
	}


	public void setDisposalOrSale(int disposalOrSale) {
		this.disposalOrSale = disposalOrSale;
	}


	public Long getGroupingId() {
		return groupingId;
	}


	public void setGroupingId(Long groupingId) {
		this.groupingId = groupingId;
	}


	


	public Double getTheValueObtainedFromTheSale() {
		return theValueObtainedFromTheSale;
	}


	public void setTheValueObtainedFromTheSale(Double theValueObtainedFromTheSale) {
		this.theValueObtainedFromTheSale = theValueObtainedFromTheSale;
	}


	public Double getAssetValue() {
		return assetValue;
	}


	public void setAssetValue(Double assetValue) {
		this.assetValue = assetValue;
	}


	public Double getAccumlatedDepreciation() {
		return accumlatedDepreciation;
	}


	public void setAccumlatedDepreciation(Double accumlatedDepreciation) {
		this.accumlatedDepreciation = accumlatedDepreciation;
	}


	public Double getNetBookValue() {
		return netBookValue;
	}


	public void setNetBookValue(Double netBookValue) {
		this.netBookValue = netBookValue;
	}


	public Double getGainAndLoss() {
		return gainAndLoss;
	}


	public void setGainAndLoss(Double gainAndLoss) {
		this.gainAndLoss = gainAndLoss;
	}


	public Long getGroupingId2() {
		return groupingId2;
	}


	public void setGroupingId2(Long groupingId2) {
		this.groupingId2 = groupingId2;
	}


	public String getGroup1() {
		return group1;
	}


	public void setGroup1(String group1) {
		this.group1 = group1;
	}


	public String getSoso() {
		return soso;
	}


	public void setSoso(String soso) {
		this.soso = soso;
	}





}
