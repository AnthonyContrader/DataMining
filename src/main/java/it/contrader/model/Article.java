package it.contrader.model;

public class Article {
	/**
	 * Qui sotto definisco gli attributi di Article. 
	 */
	private int id;
	private int price;
	private String description;
	private int time;
	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Article () {
	}
	public Article(int price, String description, int time) {
		this.price = price;
		this.description = description;
		this.time = time;
	}
	public Article(int id, int price, String description, int time) {
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
	
	//Metodo per il confronto degli oggetti
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Article other = (Article) obj;
			if (id != other.id)
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (price != other.price)
				return false;
			if (time != other.time)
				return false;
			return true;
		}
	}
