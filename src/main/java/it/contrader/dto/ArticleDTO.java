package it.contrader.dto;

public class ArticleDTO {
	private int id;

	private String name;

	private String description;

	private int price;


	public ArticleDTO() {

	}


	public ArticleDTO(String name, String description, int price) {

	this.name = name;

	this.description = description;

	this.price = price;
	}


	public ArticleDTO(int id, String name, String description, int price) {

	this.id = id;

	this.name = name;

	this.description = description;

	this.price = price;
	}


	public int getId() {
	return id;
	}


	public void setId(int id) {
	this.id = id;
	}


	public String getName() {
	return name;
	}


	public void setName(String name) {
	this.name = name;
	}


	public String getDescription() {
	return description;
	}


	public void setDescription(String description) {
	this.description = description;
	}


	public int getPrice() {
	return price;
	}


	public void setPrice(int price) {
	this.price = price;
	}

	@Override
	public String toString() {
	return id + "\t"+ name + "\t\t"+ description + "\t\t" + price;
	}
}
