package com.consumerback.api.entities;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "device_profile")
public class DeviceProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddeviceProfile;
	private String refId;
	private String deviceName;
	private String model;
	private String appVersionNo;
	private String osName;
	private String apiLevel;
	@Column(unique = true)
	private String androidId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "deviceProfile")
	private Users users;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	
	public DeviceProfile() {
	}

	public int getIddeviceProfile() {
		return iddeviceProfile;
	}

	public String getRefId() {
		return refId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getModel() {
		return model;
	}

	public String getAppVersionNo() {
		return appVersionNo;
	}

	public String getOsName() {
		return osName;
	}

	public String getApiLevel() {
		return apiLevel;
	}

	public String getAndroidId() {
		return androidId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setIddeviceProfile(int iddeviceProfile) {
		this.iddeviceProfile = iddeviceProfile;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setAppVersionNo(String appVersionNo) {
		this.appVersionNo = appVersionNo;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public void setApiLevel(String apiLevel) {
		this.apiLevel = apiLevel;
	}

	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
