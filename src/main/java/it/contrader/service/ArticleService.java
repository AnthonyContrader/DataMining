package it.contrader.service;

import it.contrader.converter.ArticleConverter;
import it.contrader.dao.ArticleDAO;
import it.contrader.dto.ArticleDTO;
import it.contrader.model.Article; //cambia dalla prima settimana


public class ArticleService extends AbstractService<Article, ArticleDTO>  {

	
		public ArticleService(){
			
			this.dao = new ArticleDAO();
			this.converter = new ArticleConverter();
		}
		

	}
