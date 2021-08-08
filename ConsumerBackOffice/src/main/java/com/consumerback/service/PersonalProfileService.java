package com.consumerback.service;

import java.util.List;

import com.consumerback.api.entities.PersonalProfile;

public interface PersonalProfileService {

	public List<PersonalProfile> getPersonalProfiles();
	
	public PersonalProfile getPersonalProfile(int idpersonalProfile);
	
	public PersonalProfile addPersonalProfile(PersonalProfile personalProfile);
	
	public PersonalProfile updatePersonalProfile(PersonalProfile personalProfile);
	
	public void deletePersonalProfile(int idpersonalProfile);

}
