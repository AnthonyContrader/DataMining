package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.PlatformDTO;

import it.contrader.model.Platform;


public class PlatformConverter {
	
	public PlatformDTO toDTO(Platform platform) {
		PlatformDTO platformDTO = new PlatformDTO(platform.getId(), platform.getName(), platform.getDescription(), platform.getWebsite());
		return platformDTO;
	}

	
	public Platform toEntity(PlatformDTO platformDTO) {
		Platform platform = new Platform(platformDTO.getId(), platformDTO.getName(), platformDTO.getDescription(), platformDTO.getWebsite());
		return platform;
	}
	
	
	public List<PlatformDTO> toDTOList(List<Platform> platformList) {
		//Crea una lista vuota.
		List<PlatformDTO> platformDTOList = new ArrayList<PlatformDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Platform platform : platformList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			platformDTOList.add(toDTO(platform));
		}
		return platformDTOList;
	}
}
