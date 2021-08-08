package com.consumerback.api.requests;

import java.io.Serializable;

public class JwtDeviceProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3814116055649452530L;
	private String refId;
	private String deviceName;
	private String model;
	private String appVersionNo;
	private String osName;
	private String apiLevel;
	private String androidId;
	
	public JwtDeviceProfile(String refId, String deviceName, String model, String appVersionNo, String osName,
			String apiLevel, String androidId) {
		this.refId = refId;
		this.deviceName = deviceName;
		this.model = model;
		this.appVersionNo = appVersionNo;
		this.osName = osName;
		this.apiLevel = apiLevel;
		this.androidId = androidId;
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
	
	
	
}
