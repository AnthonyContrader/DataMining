package it.contrader.model;

public class MyPage {
	
	private int id;
	private String message;
	private String chronology;
	private String disputesReports;


	public MyPage() {

	}

	public MyPage (String message, String chronology, String disputesReports) {
	this.message = message;
	this.chronology = chronology;
	this.disputesReports = disputesReports;
	}

	public MyPage (int id, String message, String chronology, String disputesReports) {
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

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
	if (this == obj)
	return true;
	if (obj == null)
	return false;
	if (getClass() != obj.getClass())
	return false;
	MyPage other = (MyPage) obj;
	if (id != other.id)
	return false;
	if (chronology == null) {
	if (other.chronology!= null)
	return false;
	} else if (!chronology.equals(other.chronology))
	return false;
	if (message == null) {
	if (other.message != null)
	return false;
	} else if (!message.equals(other.message))
	return false;
	if ( disputesReports== null) {
	if (other.disputesReports != null)
	return false;
	} else if (!disputesReports.equals(other.disputesReports))
	return false;
	return true;
	}
	}