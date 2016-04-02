package com.dreamedapps.bulletins.service;

import com.dreamedapps.bulletins.dto.SchoolDTO;
import com.dreamedapps.bulletins.dto.SchoolEntryDTO;
import com.dreamedapps.bulletins.model.School;
import com.dreamedapps.bulletins.repository.MemoryBulletinRepository;

public class AdminService {

	private MemoryBulletinRepository bulletinRepository;

	public AdminService(MemoryBulletinRepository bulletinRepository) {
		this.bulletinRepository = bulletinRepository;
	}

	public SchoolDTO createSchool(SchoolEntryDTO schoolDTO) {
		String name = schoolDTO.getName();
		String code = schoolDTO.getCode();
		School school = bulletinRepository.createSchool(name, code);
		return new SchoolDTO(school.getCode(),school.getName());
	}
}
