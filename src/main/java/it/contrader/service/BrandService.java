package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.BrandConverter;
import it.contrader.dao.BrandRepository;
import it.contrader.dto.BrandDTO;
import it.contrader.model.Brand;


@Service
public class BrandService extends AbstractService<Brand, BrandDTO> {
	
	@Autowired
	private BrandConverter converter;
	@Autowired
	private BrandRepository repository;

	public BrandDTO findByNameAndCategory(String name, String category) {
		return converter.toDTO(repository.findByNameAndCategory(name, category));
	}

}
