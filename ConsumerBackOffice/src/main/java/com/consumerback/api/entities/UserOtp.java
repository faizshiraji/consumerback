package com.consumerback.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_otp")
public class UserOtp implements Serializable{

	private static final long serialVersionUID = -4356352232156475054L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int iduserOtp;
	private String otp;
	@JsonIgnore
	private Date createDate;
	@JsonIgnore
	private Date updateDate;
	@JsonIgnore
	private int status;
//	@JsonIgnore
//	private int userid;
	
	public UserOtp() {
	}

	public UserOtp(String otp, Date createDate, Date updateDate, int status) {
		this.otp = otp;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.status = status;
	}

	public int getIduserOtp() {
		return iduserOtp;
	}

	public String getOtp() {
		return otp;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public int getStatus() {
		return status;
	}

	public void setIduserOtp(int iduserOtp) {
		this.iduserOtp = iduserOtp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "UserOtp [iduserOtp=" + iduserOtp + ", otp=" + otp + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", status=" + status + "]";
	}
	
	
	
}
