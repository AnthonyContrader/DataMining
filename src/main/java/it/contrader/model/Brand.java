package it.contrader.model;

public class Brand {
	
	private int id;
	private String name;
	private String category;
	
	public Brand() {
	}

	public Brand(String name, String category) {
		
		this.name = name;
		this.category = category;
	}

	public Brand(int id, String name, String category) {
	
		this.id = id;
		this.name = name;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
	return id + "\t" + name +"\t\t" + category;
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
	Brand other = (Brand) obj;
	if (id != other.id)
	return false;
	if (category == null) {
	if (other.category!= null)
	return false;
	} else if (!category.equals(other.category))
	return false;
	if (name == null) {
	if (other.name != null)
	return false;
	} else if (!name.equals(other.name))
	return false;
	return true;
	}
	
	


}
