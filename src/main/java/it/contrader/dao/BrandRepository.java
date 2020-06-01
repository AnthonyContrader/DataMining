package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Brand;

@Repository
@Transactional
public interface BrandRepository extends CrudRepository<Brand, Long> {
	
	Brand findByNameAndCategory(String name, String category);

}
