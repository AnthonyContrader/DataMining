package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PlatformConverter;
import it.contrader.dao.PlatformRepository;
import it.contrader.dto.PlatformDTO;
import it.contrader.model.Platform;

@Service
public class PlatformService extends AbstractService<Platform, PlatformDTO> {

	@Autowired
	private PlatformConverter converter;
	@Autowired
	private PlatformRepository repository;

	public PlatformDTO findByNameAndDescriptionAndWebsite(String name, String description, String website) {
		return converter.toDTO(repository.findByNameAndDescriptionAndWebsite(name, description, website));
	}

}