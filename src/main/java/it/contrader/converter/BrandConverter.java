package it.contrader.converter;


import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.BrandDTO;

import it.contrader.model.Brand;


public class BrandConverter implements Converter<Brand, BrandDTO> {

	public BrandDTO toDTO(Brand brand) {
		BrandDTO brandDTO = new BrandDTO(brand.getId(), brand.getName(), brand.getCategory());
		return brandDTO;
		}


		public Brand toEntity(BrandDTO brandDTO) {
		Brand brand = new Brand(brandDTO.getId(), brandDTO.getName(), brandDTO.getCategory());
		return brand;
		}


		public List<BrandDTO> toDTOList(List<Brand> brandList) {
		//Crea una lista vuota.
		List<BrandDTO> brandDTOList = new ArrayList<BrandDTO>();

		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Brand brand : brandList) {
		//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
		//e lo aggiunge adda lista di DTO
		brandDTOList.add(toDTO(brand));
		}
		return brandDTOList;
		}

	
}
