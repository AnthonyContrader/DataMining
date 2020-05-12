package it.contrader.view.platform;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PlatformInsertView extends AbstractView{

	private Request request;

	private String name;
	private String description;
	private String website;
	private final String mode = "INSERT";

	public PlatformInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Platform", null);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci nome piattaforma:");
			name = getInput();
			System.out.println("Inserisci descrizione:");
			description = getInput();
			System.out.println("Inserisci sitoweb:");
			website = getInput();
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("website", website);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Platform", "doControl", request);
	}
	
}
