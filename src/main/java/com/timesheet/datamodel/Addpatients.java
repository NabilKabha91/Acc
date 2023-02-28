package com.timesheet.datamodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "infoPatient")
public class Addpatients implements Serializable {

	private static final long serialVersionUID = -8455061850556612696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "namePatient")
	private String namePatient;
	@Column(name = "age")
	private Long age;
	@Column(name = "phone")
	private Long phone;
	@Column(name = "infoinsurance")
	private String infoinsurance;
	@Column(name = "pastMedicalHistory")
	private String pastMedicalHistory;
	@Column(name = "pastSurgicalHistory")
	private String pastSurgicalHistory;

	@Column(name = "workNature")
	private String workNature;
	@Column(name = "location")
	private String location;
	@Column(name = "doctor")
	private String doctor;

	@Column(name = "diagnosis")
	private String diagnosis;

	@Column(name = "gender")
	private String gender;

	@Column(name = "SelsectNationality")
	private Long SelsecNationality;

	@Column(name = "SelsectCashOrInsurance")
	private String SelsectCashOrInsurance;

	@Column(name = "nameCompny")
	private String nameCompny;

	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	@Column(name = "idNumber")
	private Long idNumber;
	
	@Column(name = "chiefComplaints")
	private String chiefComplaints;
	@Column(name = "otherPastMedical")
	private String otherPastMedical;

	@Column(name = "selsectYesOrNo")
	private String selsectYesOrNo;

	@Column(name = "describeIllnesses")
	private String describeIllnesses;
	@Column(name = "otherPastSurgical")
	private String otherPastSurgical;

	@Column(name = "MarriedStatus")
	private String marriedStatus;
	@Column(name = "fileNewDate")
	private Date  fileNewDate;
	@Column(name = "Children")
	private String children;
	@Column(name = "liveAlone")
	private String liveAlone;
	@Column(name = "Tobacco")
	private String tobacco;
	@Column(name = "howMuch")
	private String howMuch;
	@Column(name = "howLong")
	private String howLong;
	@Column(name = "alcoholUse")
	private String alcoholUse;
	@Column(name = "otherSubstanceUseOrAbouse")
	private String otherSubstanceUseOrAbouse;

	@Column(name = "generalSymptoms")
	private String generalSymptoms;

	@Column(name = "eyesEarsNosethroat")
	private String eyesEarsNosethroat;

	@Column(name = "infoheart")
	private String infoheart;

	@Column(name = "lung")
	private String lung;

	@Column(name = "allergiesRashes")
	private String allergiesRashes;

	@Column(name = "musclesBonesJoints")
	private String musclesBonesJoints;

	@Column(name = "psychiatric")
	private String psychiatric;
	
	@Column(name = "endocrine")
	private String endocrine;
	
	@Column(name = "bleedingLymphNodes")
	private String bleedingLymphNodes;
	@Column(name = "nerves")
	private String nerves;
	
	@Column(name = "skinAndOrBreasts")
	private String skinAndOrBreasts;
	@Column(name = "oBGenitalUrinary")
	private String oBGenitalUrinary;
	
	@Column(name = "abdomen")
	private String abdomen;
	
	@Column(name = "otherSymptom")
	private String otherSymptom;
	@Column(name = "pleaseList")
	private String pleaseList;
	@Column(name = "currentMedicaltions")
	private String currentMedicaltions;
//		Mehtod Getters and setters 

	public String getPastMedicalHistory() {
		return pastMedicalHistory;
	}

	public void setPastMedicalHistory(String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNamePatient() {
		return namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getWorkNature() {
		return workNature;
	}

	public void setWorkNature(String workNature) {
		this.workNature = workNature;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getNameCompny() {
		return nameCompny;
	}

	public void setNameCompny(String nameCompny) {
		this.nameCompny = nameCompny;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getSelsecNationality() {
		return SelsecNationality;
	}

	public void setSelsecNationality(Long selsecNationality) {
		SelsecNationality = selsecNationality;
	}

	public String getSelsectCashOrInsurance() {
		return SelsectCashOrInsurance;
	}

	public void setSelsectCashOrInsurance(String selsectCashOrInsurance) {
		this.SelsectCashOrInsurance = selsectCashOrInsurance;
	}

	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public String getPastSurgicalHistory() {
		return pastSurgicalHistory;
	}

	public void setPastSurgicalHistory(String pastSurgicalHistory) {
		this.pastSurgicalHistory = pastSurgicalHistory;
	}

	public String getInfoinsurance() {
		return infoinsurance;
	}

	public void setInfoinsurance(String infoinsurance) {
		this.infoinsurance = infoinsurance;
	}

	public String getOtherPastMedical() {
		return otherPastMedical;
	}

	public void setOtherPastMedical(String otherPastMedical) {
		this.otherPastMedical = otherPastMedical;
	}

	public String getDescribeIllnesses() {
		return describeIllnesses;
	}

	public void setDescribeIllnesses(String describeIllnesses) {
		this.describeIllnesses = describeIllnesses;
	}

	public String getSelsectYesOrNo() {
		return selsectYesOrNo;
	}

	public void setSelsectYesOrNo(String selsectYesOrNo) {
		this.selsectYesOrNo = selsectYesOrNo;
	}

	public String getOtherPastSurgical() {
		return otherPastSurgical;
	}

	public void setOtherPastSurgical(String otherPastSurgical) {
		this.otherPastSurgical = otherPastSurgical;
	}



	public String getMarriedStatus() {
		return marriedStatus;
	}

	public void setMarriedStatus(String marriedStatus) {
		this.marriedStatus = marriedStatus;
	}

	
	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getLiveAlone() {
		return liveAlone;
	}

	public void setLiveAlone(String liveAlone) {
		this.liveAlone = liveAlone;
	}


	public String getTobacco() {
		return tobacco;
	}

	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}

	public String getHowMuch() {
		return howMuch;
	}

	public void setHowMuch(String howMuch) {
		this.howMuch = howMuch;
	}

	public String getHowLong() {
		return howLong;
	}

	public void setHowLong(String howLong) {
		this.howLong = howLong;
	}

	public String getAlcoholUse() {
		return alcoholUse;
	}

	public void setAlcoholUse(String alcoholUse) {
		this.alcoholUse = alcoholUse;
	}

	public String getOtherSubstanceUseOrAbouse() {
		return otherSubstanceUseOrAbouse;
	}

	public void setOtherSubstanceUseOrAbouse(String otherSubstanceUseOrAbouse) {
		this.otherSubstanceUseOrAbouse = otherSubstanceUseOrAbouse;
	}

	public String getGeneralSymptoms() {
		return generalSymptoms;
	}

	public void setGeneralSymptoms(String generalSymptoms) {
		this.generalSymptoms = generalSymptoms;
	}

	public String getEyesEarsNosethroat() {
		return eyesEarsNosethroat;
	}

	public void setEyesEarsNosethroat(String eyesEarsNosethroat) {
		this.eyesEarsNosethroat = eyesEarsNosethroat;
	}

	public String getInfoheart() {
		return infoheart;
	}

	public void setInfoheart(String infoheart) {
		this.infoheart = infoheart;
	}

	public String getLung() {
		return lung;
	}

	public void setLung(String lung) {
		this.lung = lung;
	}

	public String getAllergiesRashes() {
		return allergiesRashes;
	}

	public void setAllergiesRashes(String allergiesRashes) {
		this.allergiesRashes = allergiesRashes;
	}

	public String getMusclesBonesJoints() {
		return musclesBonesJoints;
	}

	public void setMusclesBonesJoints(String musclesBonesJoints) {
		this.musclesBonesJoints = musclesBonesJoints;
	}

	public String getPsychiatric() {
		return psychiatric;
	}

	public void setPsychiatric(String psychiatric) {
		this.psychiatric = psychiatric;
	}

	public String getEndocrine() {
		return endocrine;
	}

	public void setEndocrine(String endocrine) {
		this.endocrine = endocrine;
	}

	public String getBleedingLymphNodes() {
		return bleedingLymphNodes;
	}

	public void setBleedingLymphNodes(String bleedingLymphNodes) {
		this.bleedingLymphNodes = bleedingLymphNodes;
	}

	public String getNerves() {
		return nerves;
	}

	public void setNerves(String nerves) {
		this.nerves = nerves;
	}

	public String getSkinAndOrBreasts() {
		return skinAndOrBreasts;
	}

	public void setSkinAndOrBreasts(String skinAndOrBreasts) {
		this.skinAndOrBreasts = skinAndOrBreasts;
	}

	public String getoBGenitalUrinary() {
		return oBGenitalUrinary;
	}

	public void setoBGenitalUrinary(String oBGenitalUrinary) {
		this.oBGenitalUrinary = oBGenitalUrinary;
	}

	public String getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}

	public String getChiefComplaints() {
		return chiefComplaints;
	}

	public void setChiefComplaints(String chiefComplaints) {
		this.chiefComplaints = chiefComplaints;
	}

	public String getPleaseList() {
		return pleaseList;
	}

	public void setPleaseList(String pleaseList) {
		this.pleaseList = pleaseList;
	}

	public String getCurrentMedicaltions() {
		return currentMedicaltions;
	}

	public void setCurrentMedicaltions(String currentMedicaltions) {
		this.currentMedicaltions = currentMedicaltions;
	}

	public String getOtherSymptom() {
		return otherSymptom;
	}

	public void setOtherSymptom(String otherSymptom) {
		this.otherSymptom = otherSymptom;
	}

	public Date getFileNewDate() {
		return fileNewDate;
	}

	public void setFileNewDate(Date fileNewDate) {
		this.fileNewDate = fileNewDate;
	}

	
	

}
