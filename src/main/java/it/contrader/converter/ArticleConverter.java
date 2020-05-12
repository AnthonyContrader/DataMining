package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ArticleDTO;
import it.contrader.model.Article;

public class ArticleConverter {

	public ArticleDTO toDTO(Article article) {
		ArticleDTO articleDTO = new ArticleDTO(article.getId(), article.getName(), article.getDescription(), article.getPrice());
		return articleDTO;
	}

	public Article toEntity(ArticleDTO articleDTO) {
		Article article = new Article(articleDTO.getId(), articleDTO.getName(), articleDTO.getDescription(), articleDTO.getPrice());
		return article;
	}	
	
	public List<ArticleDTO> toDTOList(List<Article> articleList) {
		//Crea una lista vuota.
		List<ArticleDTO> articleDTOList = new ArrayList<ArticleDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Article article : articleList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			articleDTOList.add(toDTO(article));
		}
		return articleDTOList;
	}
	
}
