package it.contrader.dto;

public class PlatformDTO {
	private int id;
	private String name;
	private String description;
	private String website;

	
	public PlatformDTO() {
		
	}

	public PlatformDTO (String name, String description, String website) {
		this.name = name;
		this.description = description;
		this.website = website;
	}

	public PlatformDTO (int id, String name, String description, String website) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.website = website;
	}
//metodi set e get
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

	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t" + description + "\t\t" + website;
	}
}
