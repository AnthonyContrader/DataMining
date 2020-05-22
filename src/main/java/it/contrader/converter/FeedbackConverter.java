package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

public class FeedbackConverter implements Converter<Feedback, FeedbackDTO> {

	public FeedbackDTO toDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = new FeedbackDTO(feedback.getId(), feedback.getVote(), feedback.getReview());
		return feedbackDTO;
		}


		public Feedback toEntity(FeedbackDTO feedbackDTO) {
			Feedback feedback = new Feedback(feedbackDTO.getId(), feedbackDTO.getVote(), feedbackDTO.getReview());
		return feedback;
		}


		public List<FeedbackDTO> toDTOList(List<Feedback> feedbackList) {
		//Crea una lista vuota.
		List<FeedbackDTO> feedbackDTOList = new ArrayList<FeedbackDTO>();

		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Feedback feedback : feedbackList) {
		//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
		//e lo aggiunge adda lista di DTO
		feedbackDTOList.add(toDTO(feedback));
		}
		return feedbackDTOList;
		}
	
}
