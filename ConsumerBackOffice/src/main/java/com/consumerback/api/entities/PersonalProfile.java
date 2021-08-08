package com.consumerback.api.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "personal_profile")
public class PersonalProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpersonalProfile;
	private String fullname;
	private Date dob;
	private String country;
	private String presentHouse;
	private String presentVillage;
	private int presentPostalCode;
	private String permanentHouse;
	private String permanentVillage;
	private int permanentPostalCode;
	private String email;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "personalProfile")
	private Users users;
	
	public PersonalProfile() {
	}

	public PersonalProfile(String fullname, Date dob, String country, String presentHouse, String presentVillage,
			int presentPostalCode, String permanentHouse, String permanentVillage, int permanentPostalCode,
			String email, Date createDate, Date updateDate, Users users) {
		this.fullname = fullname;
		this.dob = dob;
		this.country = country;
		this.presentHouse = presentHouse;
		this.presentVillage = presentVillage;
		this.presentPostalCode = presentPostalCode;
		this.permanentHouse = permanentHouse;
		this.permanentVillage = permanentVillage;
		this.permanentPostalCode = permanentPostalCode;
		this.email = email;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.users = users;
	}

	public int getIdpersonalProfile() {
		return idpersonalProfile;
	}

	public String getFullname() {
		return fullname;
	}

	public Date getDob() {
		return dob;
	}

	public String getCountry() {
		return country;
	}

	public String getPresentHouse() {
		return presentHouse;
	}

	public String getPresentVillage() {
		return presentVillage;
	}

	public int getPresentPostalCode() {
		return presentPostalCode;
	}

	public String getPermanentHouse() {
		return permanentHouse;
	}

	public String getPermanentVillage() {
		return permanentVillage;
	}

	public int getPermanentPostalCode() {
		return permanentPostalCode;
	}

	public String getEmail() {
		return email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setIdpersonalProfile(int idpersonalProfile) {
		this.idpersonalProfile = idpersonalProfile;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPresentHouse(String presentHouse) {
		this.presentHouse = presentHouse;
	}

	public void setPresentVillage(String presentVillage) {
		this.presentVillage = presentVillage;
	}

	public void setPresentPostalCode(int presentPostalCode) {
		this.presentPostalCode = presentPostalCode;
	}

	public void setPermanentHouse(String permanentHouse) {
		this.permanentHouse = permanentHouse;
	}

	public void setPermanentVillage(String permanentVillage) {
		this.permanentVillage = permanentVillage;
	}

	public void setPermanentPostalCode(int permanentPostalCode) {
		this.permanentPostalCode = permanentPostalCode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "PersonalProfile [fullname=" + fullname + ", dob=" + dob + ", country=" + country + ", presentHouse="
				+ presentHouse + ", presentVillage=" + presentVillage + ", presentPostalCode=" + presentPostalCode
				+ ", permanentHouse=" + permanentHouse + ", permanentVillage=" + permanentVillage
				+ ", permanentPostalCode=" + permanentPostalCode + ", email=" + email + "]";
	}

	
	
}
