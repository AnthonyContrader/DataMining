package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.dto.PlatformDTO;
import it.contrader.main.MainDispatcher;


public class PlatformView extends AbstractView  {

	private Request request;
	private String choice;

	public PlatformView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Platform ---------------------\n");
			System.out.println("ID\tName\tDescription\tWebsite");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<PlatformDTO> platforms = (List<PlatformDTO>) request.get("platforms");
			for (PlatformDTO p: platforms)
				System.out.println(p);
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
		MainDispatcher.getInstance().callAction("Platform", "doControl", this.request);
	}

	
}
