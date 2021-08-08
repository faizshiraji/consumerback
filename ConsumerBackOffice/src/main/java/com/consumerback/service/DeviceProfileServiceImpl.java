package com.consumerback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.DeviceProfile;
import com.consumerback.dao.DeviceProfileDao;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

	@Autowired
	public DeviceProfileDao deviceProfileDao;
	
	@Override
	public List<DeviceProfile> getDeviceProfiles() {
		return deviceProfileDao.findAll();
	}

	@Override
	public DeviceProfile getDeviceProfile(int iddeviceProfile) {
		return deviceProfileDao.findById(iddeviceProfile).get();
	}

	@Override
	public DeviceProfile addDeviceProfile(DeviceProfile deviceProfile) {
		return deviceProfileDao.save(deviceProfile);
	}

	@Override
	public DeviceProfile updateDeviceProfile(DeviceProfile deviceProfile) {
		return deviceProfileDao.save(deviceProfile);
	}

	@Override
	public void deleteDeviceProfile(int iddeviceProfile) {
		deviceProfileDao.deleteById(iddeviceProfile);
	}

}
