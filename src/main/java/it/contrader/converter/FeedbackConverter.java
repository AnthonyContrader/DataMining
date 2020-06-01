package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

@Component
public class FeedbackConverter extends AbstractConverter<Feedback, FeedbackDTO> {

	@Override
	public Feedback toEntity(FeedbackDTO feedbackDTO) {
		Feedback feedback = null;
		if (feedbackDTO != null) {
			feedback = new Feedback(feedbackDTO.getId(), feedbackDTO.getVote(), feedbackDTO.getReview());
		}
		return feedback;
	}

	@Override
	public FeedbackDTO toDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = null;
		if (feedback != null) {
			feedbackDTO = new feedbackDTO(feedbackDTO.getId(), feedbackDTO.getVote(), feedbackDTO.getReview());

		}
		return feedbackDTO;
	}
}