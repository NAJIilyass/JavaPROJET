package application;

import java.io.Serializable;

public abstract class Vehicule implements Serializable {
	
	private String marque;
	private String modele;
	private String immatricule;
	private typeCarburant carburant;
	private String couleur;
	static final long serialVersionUID =1L;
	
	
	public Vehicule() {	
	}
	
	public Vehicule(String marque, String modele, String immatricule, typeCarburant carburant, String couleur) {
		this.marque = marque;
		this.modele = modele;
		this.immatricule = immatricule;
		this.couleur = couleur;
		this.carburant = carburant;
	}
	
	//Les getters & Les setters & Méthode toString
	public String getMarque() {
		return marque;
	}
	
	public String getModele() {
		return modele;
	}
	
	public String getImmatricule() {
		return immatricule;
	}
	
	public typeCarburant getCarburant() {
		return carburant;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}
	
	public void setCarburant(typeCarburant carburant) {
		this.carburant = carburant;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public String toString() {
		return this.getMarque()+" de modele "+this.getModele()+" a pour immatricule "
				+this.getImmatricule()+", "+this.getCarburant()+", "+this.getCouleur();
	}
	
}