package com.consumerback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.PersonalProfile;
import com.consumerback.dao.PersonalProfileDao;

@Service
@Transactional
public class PersonalProfileServiceImpl implements PersonalProfileService {

	@Autowired
	public PersonalProfileDao personalProfileDao;
	
	@Override
	public List<PersonalProfile> getPersonalProfiles() {
		return personalProfileDao.findAll();
	}

	@Override
	public PersonalProfile getPersonalProfile(int idpersonalProfile) {
		return personalProfileDao.findById(idpersonalProfile).get();
	}

	@Override
	public PersonalProfile addPersonalProfile(PersonalProfile personalProfile) {
		return personalProfileDao.save(personalProfile);
	}

	@Override
	public PersonalProfile updatePersonalProfile(PersonalProfile personalProfile) {
		return personalProfileDao.save(personalProfile);
	}

	@Override
	public void deletePersonalProfile(int idpersonalProfile) {
		personalProfileDao.deleteById(idpersonalProfile);
	}

}
