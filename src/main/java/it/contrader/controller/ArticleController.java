package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ArticleDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ArticleService;

public class ArticleController implements Controller {
	
private static String sub_package = "article.";
	
	private ArticleService articleService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public ArticleController() {
		this.articleService = new ArticleService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		int price;
		String description;
		int time;

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
			price =Integer.parseInt( request.get("price").toString());
			description = request.get("description").toString();
			time =Integer.parseInt( request.get("time").toString());
			
			//costruisce l'oggetto user da inserire
			ArticleDTO articletoinsert = new ArticleDTO(price, description, time);
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
			price =Integer.parseInt( request.get("price").toString());
			description = request.get("description").toString();
			time =Integer.parseInt( request.get("time").toString());
			ArticleDTO articletoupdate = new ArticleDTO(price, description, time);
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
