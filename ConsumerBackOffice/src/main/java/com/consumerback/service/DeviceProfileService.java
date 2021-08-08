package com.consumerback.service;

import java.util.List;

import com.consumerback.api.entities.DeviceProfile;

public interface DeviceProfileService {

	public List<DeviceProfile> getDeviceProfiles();
	
	public DeviceProfile getDeviceProfile(int iddeviceProfile);
	
	public DeviceProfile addDeviceProfile(DeviceProfile deviceProfile);
	
	public DeviceProfile updateDeviceProfile(DeviceProfile deviceProfile);
	
	public void deleteDeviceProfile(int iddeviceProfile);
	
}
