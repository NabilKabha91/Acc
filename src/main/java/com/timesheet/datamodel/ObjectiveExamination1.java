package com.timesheet.datamodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "objectiveExamination1")
public class ObjectiveExamination1 implements Serializable {
	
	private static final long serialVersionUID = -8455061850556612696L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "odemea")
	private String odemea;
	
	@Column(name = "bandages_scars")
	private String bandagesAndScars;
	
	@Column(name = "limbAttitude")
	private String limbAttitude;
	
	@Column(name = "bonyContours")
	private String bonyContours;
	
	@Column(name = "gaitType")
	private String gaitType;
	
	@Column(name = "deformities")
	private String deformities;
	
	@Column(name = "tenderness")
	private String tenderness;
	
	@Column(name = "dfTissue")
	private String dfTissue;
	
	@Column(name = "spasm")
	private String spasm;

	public String getTenderness() {
		return tenderness;
	}

	public void setTenderness(String tenderness) {
		this.tenderness = tenderness;
	}

	public String getDfTissue() {
		return dfTissue;
	}

	public void setDfTissue(String dfTissue) {
		this.dfTissue = dfTissue;
	}

	public String getSpasm() {
		return spasm;
	}

	public void setSpasm(String spasm) {
		this.spasm = spasm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOdemea() {
		return odemea;
	}

	public void setOdemea(String odemea) {
		this.odemea = odemea;
	}

	public String getBandagesAndScars() {
		return bandagesAndScars;
	}

	public void setBandagesAndScars(String bandagesAndScars) {
		this.bandagesAndScars = bandagesAndScars;
	}

	public String getLimbAttitude() {
		return limbAttitude;
	}

	public void setLimbAttitude(String limbAttitude) {
		this.limbAttitude = limbAttitude;
	}

	public String getBonyContours() {
		return bonyContours;
	}

	public void setBonyContours(String bonyContours) {
		this.bonyContours = bonyContours;
	}

	public String getGaitType() {
		return gaitType;
	}

	public void setGaitType(String gaitType) {
		this.gaitType = gaitType;
	}

	public String getDeformities() {
		return deformities;
	}

	public void setDeformities(String deformities) {
		this.deformities = deformities;
	}
	
	
	
	
	
	

}
