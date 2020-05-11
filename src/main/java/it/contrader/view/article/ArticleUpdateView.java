package it.contrader.view.article;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ArticleUpdateView extends AbstractView {
	
	private Request request;

	private int id;
	private String price;
	private String description;
	private String time;
	private final String mode = "UPDATE";

	public ArticleUpdateView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Article", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'articolo:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci filtro prezzo:");
			price = getInput();
			System.out.println("Inserisci descrizione:");
			description = getInput();
			System.out.println("Inserisci tempo:");
			time = getInput();
		} catch (Exception e) {

		}
	}


	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("price", price);
		request.put("description", description);
		request.put("time", time);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Article", "doControl", request);
	}

}
