package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ArticleDTO;
import it.contrader.main.MainDispatcher;

public class ArticleView extends AbstractView {
	
	private Request request;
	private String choice;

	public ArticleView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Articles ----------------\n");
			System.out.println("ID\tName\tDescription\tPrice");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ArticleDTO> articles = (List<ArticleDTO>) request.get("article");
			for (ArticleDTO a: articles)
				System.out.println(a);
			System.out.println();
		}
	}

	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Article", "doControl", this.request);
	}	

}
