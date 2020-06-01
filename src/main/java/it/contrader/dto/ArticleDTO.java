package it.contrader.dto;

import it.contrader.model.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ArticleDTO {
	

	private String name;

	private String description;

	private int price;

}
