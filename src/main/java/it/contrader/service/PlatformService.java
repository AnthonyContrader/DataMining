package it.contrader.service;

import java.util.List;

import it.contrader.converter.PlatformConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.PlatformDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.PlatformDTO;
import it.contrader.dto.UserDTO;

public class PlatformService {

	private PlatformDAO platformDAO;
	private PlatformConverter platformConverter;
	
	//Istanzio DAO  e Converter specifici.
	public PlatformService(){
		this.platformDAO = new PlatformDAO();
		this.platformConverter = new PlatformConverter();
	}
	

	public List<PlatformDTO> getAll() {
		// Ottiene una lista di entit� e le restituisce convertendole in DTO
		return platformConverter.toDTOList(platformDAO.getAll());
	}


	public PlatformDTO read(int id) {
		// Ottiene un'entit� e la restituisce convertendola in DTO
		return platformConverter.toDTO(platformDAO.read(id));
	}


	public boolean insert(PlatformDTO dto) {
		// Converte un DTO in entit� e lo passa al DAO per l'inserimento
		return platformDAO.insert(platformConverter.toEntity(dto));
	}


	public boolean update(PlatformDTO dto) {
		// Converte un userDTO in entit� e lo passa allo userDAO per la modifica
		return platformDAO.update(platformConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return platformDAO.delete(id);
	}
}
