package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.ArticleDTO;
import it.contrader.model.Article;

@Component
public class ArticleConverter extends AbstractConverter<Article, ArticleDTO> {
	
	@Override
	public Article toEntity(ArticleDTO articleDTO) {
		Article article = null;
		if (articleDTO != null) {
			article = new Article(articleDTO.getId(), articleDTO.getName(), articleDTO.getDescription(), articleDTO.getPrice());
		}
		return article;
	}

	@Override
	public ArticleDTO toDTO(Article article) {
		ArticleDTO articleDTO = null;
		if (article != null) {
			articleDTO = new ArticleDTO(article.getId(), article.getName(), article.getDescription(), article.getPrice());

		}
		return articleDTO;
	}
	
}
