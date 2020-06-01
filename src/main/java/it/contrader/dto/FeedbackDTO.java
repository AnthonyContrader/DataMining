package it.contrader.dto;

import it.contrader.model.Feedback;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {

	private Long id;

	private int vote;

	private String review;

}