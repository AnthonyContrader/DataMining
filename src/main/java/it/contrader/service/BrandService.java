package it.contrader.service;

import it.contrader.converter.BrandConverter;
import it.contrader.dao.BrandDAO;
import it.contrader.dto.BrandDTO;
import it.contrader.model.Brand;



public class BrandService  extends AbstractService<Brand, BrandDTO> {

	public BrandService(){
		this.dao = new BrandDAO();
		this.converter = new BrandConverter();
	}
	
}
