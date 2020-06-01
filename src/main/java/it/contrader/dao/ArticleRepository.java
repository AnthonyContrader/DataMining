package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Article;



@Repository
@Transactional
public interface ArticleRepository extends CrudRepository<Article, Long> {
	
	Article findByNameAndDescriptionAndPrice(String name, String description, int price);

}
