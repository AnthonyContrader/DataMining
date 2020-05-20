package it.contrader.model;

public class Platform {
	private int id;
	private String name;
	private String description;
	private String website;


	public Platform() {

	}

	public Platform (String name, String description, String website) {
	this.name = name;
	this.description = description;
	this.website = website;
	}

	public Platform (int id, String name, String description, String website) {
	this.id = id;
	this.name = name;
	this.description = description;
	this.website = website;
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

	public String getWebsite() {
	return website;
	}

	public void setWebsite(String website) {
	this.website = website;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
	return id + "\t" + name +"\t\t" + description + "\t\t" + website;
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
	Platform other = (Platform) obj;
	if (id != other.id)
	return false;
	if (description == null) {
	if (other.description!= null)
	return false;
	} else if (!description.equals(other.description))
	return false;
	if (name == null) {
	if (other.name != null)
	return false;
	} else if (!name.equals(other.name))
	return false;
	if (website == null) {
	if (other.website != null)
	return false;
	} else if (!website.equals(other.website))
	return false;
	return true;
	}
	}

