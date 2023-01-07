package application;

import java.io.Serializable;

public class Client implements Serializable{
	
	private String nom;
	private String prenom;
	private String CIN;
	private String numTel;
	static final long serialVersionUID =1L;
	
	
	public Client(String nom, String prenom, String CIN, String numTel) {
		this.nom = nom;
		this.prenom = prenom;
		this.CIN = CIN;
		this.numTel = numTel;
	}
	
	//Les getters & Les setters & Méthode toString
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getCIN() {
		return CIN;
	}
	
	public String getNumTel() {
		return numTel;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setCIN(String cIN) {
		this.CIN = cIN;
	}
	
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	@Override
	public String toString() {
		return "\n	Nom : "+this.getNom()+"\n	Prenom : "+this.getPrenom()+"\n	CIN : "+this.getCIN()+"\n	Tel : "+this.getNumTel()+"\n";
	}
}
