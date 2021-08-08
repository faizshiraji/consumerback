package com.consumerback.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int userid;
	private String msisdn;
	private String userPin;

	@ManyToOne(cascade = CascadeType.ALL)
	private UserRole roleId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ud_id")
	private DeviceProfile deviceProfile;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pp_id")
	private PersonalProfile personalProfile;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pa_id")
	private PersonalAccount personalAccount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	List<UserOtp> userOtp = new ArrayList<>();
	
	@JsonIgnore
	private int status;
	@JsonIgnore
	private Date createDate;
	@JsonIgnore
	private Date updateDate;
	
	public Users() {
	}



	public Users(String msisdn, String userPin, UserRole roleId, DeviceProfile deviceProfile,
			PersonalProfile personalProfile, PersonalAccount personalAccount, List<UserOtp> userOtp, int status,
			Date createDate, Date updateDate) {
		this.msisdn = msisdn;
		this.userPin = userPin;
		this.roleId = roleId;
		this.deviceProfile = deviceProfile;
		this.personalProfile = personalProfile;
		this.personalAccount = personalAccount;
		this.userOtp = userOtp;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}



	public int getUserid() {
		return userid;
	}



	public String getMsisdn() {
		return msisdn;
	}



	public String getUserPin() {
		return userPin;
	}



	public UserRole getRoleId() {
		return roleId;
	}



	public DeviceProfile getDeviceProfile() {
		return deviceProfile;
	}



	public PersonalProfile getPersonalProfile() {
		return personalProfile;
	}



	public PersonalAccount getPersonalAccount() {
		return personalAccount;
	}



	public List<UserOtp> getUserOtp() {
		return userOtp;
	}



	public int getStatus() {
		return status;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public Date getUpdateDate() {
		return updateDate;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}



	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}



	public void setRoleId(UserRole roleId) {
		this.roleId = roleId;
	}



	public void setDeviceProfile(DeviceProfile deviceProfile) {
		this.deviceProfile = deviceProfile;
	}



	public void setPersonalProfile(PersonalProfile personalProfile) {
		this.personalProfile = personalProfile;
	}



	public void setPersonalAccount(PersonalAccount personalAccount) {
		this.personalAccount = personalAccount;
	}



	public void setUserOtp(List<UserOtp> userOtp) {
		this.userOtp = userOtp;
	}



	public void setStatus(int status) {
		this.status = status;
	}


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	@Override
	public String toString() {
		return "Users [userid=" + userid + ", msisdn=" + msisdn + ", userPin=" + userPin + ", roleId=" + roleId
				+ ", deviceProfile=" + deviceProfile + ", personalProfile=" + personalProfile + ", personalAccount="
				+ personalAccount + ", userOtp=" + userOtp + ", status=" + status + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

	
}
