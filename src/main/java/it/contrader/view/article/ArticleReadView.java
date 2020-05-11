package it.contrader.view.article;

import it.contrader.controller.Request;

import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ArticleReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";

	public ArticleReadView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ArticleDTO article = (ArticleDTO) request.get("article");
			System.out.println(article);
			MainDispatcher.getInstance().callView("Article", null);
		}
	}

	
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'articolo:");
		id = Integer.parseInt(getInput());
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Article", "doControl", request);
	}

}
