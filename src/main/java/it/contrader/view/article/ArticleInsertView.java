package it.contrader.view.article;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ArticleInsertView extends AbstractView {
	
	private Request request;

	private int price;
	private String description;
	private int time;
	private final String mode = "INSERT";

	public ArticleInsertView() {
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Article", null);
		}
	}


	@Override
	public void showOptions() {
			System.out.println("Inserisci filtro prezzo:");
			price = getInput();
			System.out.println("descrizione:");
			description = getInput();
			System.out.println("tempo:");
			time = getInput();
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("price", price);
		request.put("description", description);
		request.put("time", time);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Article", "doControl", request);
	}

}
