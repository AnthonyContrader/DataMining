package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.FeedbackConverter;
import it.contrader.dao.FeedbackRepository;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

@Service
public class FeedbackService extends AbstractService<Feedback, FeedbackDTO> {

	@Autowired
	private FeedbackConverter converter;
	@Autowired
	private FeedbackRepository repository;

	public FeedbackDTO findByVoteAndReview(int vote, String review) {
		return converter.toDTO(repository.findByVoteAndReview(vote, review));
	}

}