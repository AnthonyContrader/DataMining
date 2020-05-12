package it.contrader.view.platform;

import it.contrader.controller.Request;
import it.contrader.dto.PlatformDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PlatformReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public PlatformReadView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			PlatformDTO platform = (PlatformDTO) request.get("platform");
			System.out.println(platform);
			MainDispatcher.getInstance().callView("Platform", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della piattaforma:");
		id = Integer.parseInt(getInput());
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Platform", "doControl", request);
	}
	
}
