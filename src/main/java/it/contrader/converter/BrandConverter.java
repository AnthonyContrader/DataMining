package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.BrandDTO;
import it.contrader.model.Brand;

@Component
public class BrandConverter extends AbstractConverter<Brand, BrandDTO> {
	
	@Override
	public Brand toEntity(BrandDTO brandDTO) {
		Brand brand = null;
		if (brandDTO != null) {
			brand = new Brand(brandDTO.getId(), brandDTO.getName(), brandDTO.getCategory());
		}
		return brand;
	}

	@Override
	public BrandDTO toDTO(Brand brand) {
		BrandDTO brandDTO = null;
		if (brand != null) {
			brandDTO = new BrandDTO(brand.getId(), brand.getName(), brand.getCategory());

		}
		return brandDTO;
	}

}
