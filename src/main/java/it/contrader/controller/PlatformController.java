package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PlatformDTO;

import it.contrader.main.MainDispatcher;
import it.contrader.service.PlatformService;



public class PlatformController implements Controller{
	
	
	private static String sub_package = "platform.";
	private PlatformService platformService;
	
	public PlatformController() {
		this.platformService = new PlatformService();
	}
	
	
	
	
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name;
		String description;
		String website;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			PlatformDTO platformDTO = platformService.read(id);
			request.put("platform", platformDTO);
			MainDispatcher.getInstance().callView(sub_package + "PlatformRead", request);
			break;
		
		
		case "INSERT":
			name = request.get("name").toString();
			description = request.get("description").toString();
			website = request.get("website").toString();
			
			
			PlatformDTO platformtoinsert = new PlatformDTO(name, description, website);
			//invoca il service
			platformService.insert(platformtoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "PlatformInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			platformService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PlatformDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			description = request.get("description").toString();
			website = request.get("website").toString();
			PlatformDTO platformtoupdate = new PlatformDTO(name, description, website);
			platformtoupdate.setId(id);
			platformService.update(platformtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PlatformUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "PLATFORMLIST":
			List<PlatformDTO> platformsDTO = platformService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("platforms", platformsDTO);
			MainDispatcher.getInstance().callView("Platform", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PlatformRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PlatformInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "PlatformUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PlatformDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}

}
