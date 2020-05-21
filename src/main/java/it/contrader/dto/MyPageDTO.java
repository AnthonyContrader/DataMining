package it.contrader.dto;



public class MyPageDTO {
	
	private int id;
	private String message;
	private String chronology;
	private String disputesReports;


	public MyPageDTO() {

	}

	public MyPageDTO (String message, String chronology, String disputesReports) {
	this.message = message;
	this.chronology = chronology;
	this.disputesReports = disputesReports;
	}

	public MyPageDTO (int id, String message, String chronology, String disputesReports) {
	this.id = id;
	this.message = message;
	this.chronology = chronology;
	this.disputesReports = disputesReports;
	}
public int getId() {
	return id;
	}

	public void setId(int id) {
	this.id = id;
	}

	public String getMessage() {
	return message;
	}

	public void setMessage(String message) {
	this.message = message;
	}

	public String getChronology() {
	return chronology;
	}

	public void setChronology(String chronology) {
	this.chronology = chronology;
	}

	public String getDisputesReports() {
	return disputesReports;
	}

	public void setDisputesReports(String disputesReports) {
	this.disputesReports = disputesReports;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
	return id + "\t" + message +"\t\t" + chronology + "\t\t" + disputesReports;
	}
}