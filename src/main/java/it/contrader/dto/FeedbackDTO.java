package it.contrader.dto;

public class FeedbackDTO {
	
	private int id;
	private int vote;
	private String review;
	


	public FeedbackDTO() {

	}

	public FeedbackDTO ( int vote, String review) {
	
	this.vote = vote;
	this.review = review;
	}

	public FeedbackDTO (int id, int vote, String review) {
	this.id = id;
	this.vote = vote;
	this.review = review;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
	return id + "\t" + vote +"\t\t" + review ;
	}
}
