package it.contrader.model;

public class Feedback {
	
	private int id;
	private int vote;
	private String review;
	


	public Feedback() {

	}

	public Feedback ( int vote, String review) {
	
	this.vote = vote;
	this.review = review;
	}

	public Feedback (int id, int vote, String review) {
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

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
	if (this == obj)
	return true;
	if (obj == null)
	return false;
	if (getClass() != obj.getClass())
	return false;
	Feedback other = (Feedback) obj;
	if (id != other.id)
	return false;
	if (review == null) {
	if (other.review!= null)
	return false;
	} else if (!review.equals(other.review))
	return false;
	if  (vote != other.vote);
	return false;
	
	}
	}