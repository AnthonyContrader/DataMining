package it.contrader.service;

import java.util.List;

import it.contrader.converter.ArticleConverter;
import it.contrader.dao.ArticleDAO;
import it.contrader.dto.ArticleDTO;

public class ArticleService {

	private ArticleDAO articleDAO;
	private ArticleConverter articleConverter;
	
	//Istanzio DAO  e Converter specifici.
	public ArticleService(){
		this.articleDAO = new ArticleDAO();
		this.articleConverter = new ArticleConverter();
	}
	

	public List<ArticleDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return articleConverter.toDTOList(articleDAO.getAll());
	}


	public ArticleDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return articleConverter.toDTO(articleDAO.read(id));
	}


	public boolean insert(ArticleDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return articleDAO.insert(articleConverter.toEntity(dto));
	}


	public boolean update(ArticleDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return articleDAO.update(articleConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return articleDAO.delete(id);
	}
	
}
