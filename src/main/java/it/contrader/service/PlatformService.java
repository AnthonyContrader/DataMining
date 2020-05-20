package it.contrader.service;

import it.contrader.converter.PlatformConverter;
import it.contrader.dao.PlatformDAO;
import it.contrader.dto.PlatformDTO;
import it.contrader.model.Platform;


public class PlatformService extends AbstractService<Platform, PlatformDTO>{
	
	//Istanzio DAO  e Converter specifici.
	public PlatformService(){
		this.dao = new PlatformDAO();
		this.converter = new PlatformConverter();
	}

}
