package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.ArticleConverter;
import it.contrader.dao.ArticleRepository;
import it.contrader.dto.ArticleDTO;
import it.contrader.model.Article;

@Service
public class ArticleService extends AbstractService<Article, ArticleDTO> {
	
	@Autowired
	private ArticleConverter converter;
	@Autowired
	private ArticleRepository repository;

	public ArticleDTO findByNameAndDescriptionAndPrice (String name, String description, int price) {
		return converter.toDTO(repository.findByNameAndDescriptionAndPrice(name, description, price));
	}

}
