package it.contrader.model;

public class Article {
	/**
	 * Qui sotto definisco gli attributi di Article. 
	 */
	private int id;
	private String name;
	private String description;
	private int price;
	
	public Article () {
	}
	public Article(String name, String description, int price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Article(int id, String name, String description, int price) {
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
		this.price= price;
	}
	@Override
	public String toString() {
		return  id + "\t"+ name + "\t\t"+ description + "\t\t" + price;
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
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (price != other.price)
				return false;
			return true;
		}
	}
