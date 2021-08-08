package com.consumerback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerback.api.entities.DeviceProfile;

@Repository
public interface DeviceProfileDao extends JpaRepository<DeviceProfile, Integer> {

}
