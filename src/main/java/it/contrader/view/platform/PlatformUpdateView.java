package it.contrader.view.platform;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PlatformUpdateView extends AbstractView{

	private Request request;
	private int id;
	private String name;
	private String description;
	private String website;
	private final String mode = "UPDATE";

	public PlatformUpdateView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Platform", null);
		}
	}

	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della piattaforma:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome della piattaforma:");
			name = getInput();
			System.out.println("Inserisci descrizione della piattaforma:");
			description = getInput();
			System.out.println("Inserisci il sitoweb:");
			website = getInput();
		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("description", description);
		request.put("website", website);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Platform", "doControl", request);
	}
	
}
