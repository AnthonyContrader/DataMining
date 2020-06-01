package it.contrader.dto;

import it.contrader.model.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {
	
	private Long id;

	private String name;

	private String category;

}
