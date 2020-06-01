package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Platform;

@Repository
@Transactional
public interface PlatformRepository extends CrudRepository<Platform, Long> {

	Platform findByNameAndDescriptionAndWebsite(String name, String description, String website);

}