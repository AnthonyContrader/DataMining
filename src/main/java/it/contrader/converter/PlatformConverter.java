package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.PlatformDTO;
import it.contrader.model.Platform;

@Component
public class PlatformConverter extends AbstractConverter<Platform, PlatformDTO> {

	@Override
	public Platform toEntity(PlatformDTO platformDTO) {
		Platform platform = null;
		if (platformDTO != null) {
			platform = new Platform(platformDTO.getId(), platformDTO.getName(), platformDTO.getDescription(), platformDTO.getWebsite());
		}
		return platform;
	}

	@Override
	public PlatformDTO toDTO(Platform platform) {
		PlatformDTO platformDTO = null;
		if (platform != null) {
			platformDTO = new PlatformDTO(platform.getId(), platform.getName(), platform.getDescription(), platform.getWebsite());

		}
		return platformDTO;
	}
}