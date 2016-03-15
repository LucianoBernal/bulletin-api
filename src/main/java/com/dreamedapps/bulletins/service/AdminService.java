package com.dreamedapps.bulletins.service;

import com.dreamedapps.bulletins.dto.SchoolDTO;
import com.dreamedapps.bulletins.dto.SchoolEntryDTO;
import com.dreamedapps.bulletins.model.School;
import com.dreamedapps.bulletins.repository.BulletinRepository;

public class AdminService {

	private BulletinRepository bulletinRepository;

	public AdminService(BulletinRepository bulletinRepository) {
		this.bulletinRepository = bulletinRepository;
	}

	public SchoolDTO createSchool(SchoolEntryDTO schoolDTO) {
		String name = schoolDTO.getName();
		School school = bulletinRepository.createSchool(name);
		return new SchoolDTO(school.getId(),school.getName());
	}
}
