package com.consumerback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerback.api.entities.PersonalProfile;

@Repository
public interface PersonalProfileDao extends JpaRepository<PersonalProfile, Integer> {

}
