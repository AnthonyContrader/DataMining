package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ArticleDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ArticleService;

public class ArticleController implements Controller {
	
private static String sub_package = "article.";
	
	private ArticleService articleService;
	
	public ArticleController() {
		this.articleService = new ArticleService();
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
		int price;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			ArticleDTO articleDTO = articleService.read(id);
			request.put("article", articleDTO);
			MainDispatcher.getInstance().callView(sub_package + "ArticleRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name =request.get("name").toString();
			description = request.get("description").toString();
			price =Integer.parseInt( request.get("price").toString());
			
			//costruisce l'oggetto user da inserire
			ArticleDTO articletoinsert = new ArticleDTO(name, description, price);
			//invoca il service
			articleService.insert(articletoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ArticleInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			articleService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ArticleDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name =request.get("name").toString();
			description = request.get("description").toString();
			price =Integer.parseInt( request.get("price").toString());
			ArticleDTO articletoupdate = new ArticleDTO(name, description, price);
			articletoupdate.setId(id);
			articleService.update(articletoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ArticleUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "ARTICLELIST":
			List<ArticleDTO> articlesDTO = articleService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("article", articlesDTO);
			MainDispatcher.getInstance().callView("Article", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ArticleRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ArticleInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ArticleUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ArticleDelete", null);
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
