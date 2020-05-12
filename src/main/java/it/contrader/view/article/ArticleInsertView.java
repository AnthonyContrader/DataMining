package it.contrader.view.article;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ArticleInsertView extends AbstractView {
	
	private Request request;

	private String name;
	private String description;
	private int price;
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
			System.out.println("Inserisci nome articolo");
			name = getInput();
			System.out.println("descrizione:");
			description = getInput();
			System.out.println("price:");
			price = Integer.parseInt (getInput());
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("price", price);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Article", "doControl", request);
	}

}
