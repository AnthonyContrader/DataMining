package it.contrader.dto;

import it.contrader.model.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PlatformDTO {

	private Long id;

	private String name;

	private String description;

	private String website;

}