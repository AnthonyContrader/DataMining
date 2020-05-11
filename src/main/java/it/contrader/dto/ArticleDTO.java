package it.contrader.dto;


public class ArticleDTO {
	
	private int id;
	
	private int price;
	
	private String description;
	
	private int time;
	

	public ArticleDTO() {
	
	}


	public ArticleDTO(int price, String description, int time) {
		
		this.price = price;
		
		this.description = description;
		
		this.time = time;
	}


	public ArticleDTO(int id, int price, String description, int time) {
		
		this.id = id;
		
		this.price = price;
		
		this.description = description;
		
		this.time = time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return  id + "\t"+ price + "\t\t"+ description + "\t\t" + time;
	}
	
	
	
}
