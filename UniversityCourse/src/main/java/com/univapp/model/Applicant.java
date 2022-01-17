package com.univapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Applicant")
public class Applicant {
	
	@Id
	@GeneratedValue
	private int applicantId;
	private String applicantName;
	private String mobileNumber;
	private String applicantDegree;
	private String applicantStatus;
	private int applicantGraduationPercent;
	public int getApplicantId() {
		return applicantId;
	}
	public String getApplicantStatus() {
		return applicantStatus;
	}
	public void setApplicantStatus(String applicantStatus) {
		this.applicantStatus = applicantStatus;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getApplicantDegree() {
		return applicantDegree;
	}
	public void setApplicantDegree(String applicantDegree) {
		this.applicantDegree = applicantDegree;
	}
	public int getApplicantGraduationPercent() {
		return applicantGraduationPercent;
	}
	public void setApplicantGraduationPercent(int applicantGraduationPercent) {
		this.applicantGraduationPercent = applicantGraduationPercent;
	}
	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", applicantName=" + applicantName + ", mobileNumber="
				+ mobileNumber + ", applicantDegree=" + applicantDegree + ", applicantStatus=" + applicantStatus
				+ ", applicantGraduationPercent=" + applicantGraduationPercent + "]";
	}
	
	
	

}
