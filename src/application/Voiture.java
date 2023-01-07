package application;

import java.io.Serializable;

public class Voiture extends Vehicule implements Serializable {
	
	private int nbrPlaces;
	private int nbrPortes;
	static final long serialVersionUID =1L;
	
	
	public Voiture(String marque, String modele, String immatricule, typeCarburant carburant, String couleur, int nbrPlaces, int nbrPortes) {
		super(marque, modele, immatricule, carburant, couleur);
		this.nbrPlaces = nbrPlaces;
		this.nbrPortes = nbrPortes;
	}
	
	//Les getters & Les setters & Méthode toString
	public int getNbrPlaces() {
		return nbrPlaces;
	}
	
	public int getNbrPortes() {
		return nbrPortes;
	}
	
	public void setNbrPlaces(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
	
	public void setNbrPortes(int nbrPortes) {
		this.nbrPortes = nbrPortes;
	}
	
	@Override
	public String toString() {
		return "\n	Immatricule : "+this.getImmatricule()+"\n	Marque : "+this.getMarque()+"\n	Modele : "+this.getModele()+"\n	Carburant : "+this.getCarburant()+"\n 	Couleur : "+this.getCouleur()+"\n 	Nombre de Places : "+this.getNbrPlaces()+"\n 	Nombre de Portes : "+this.getNbrPortes()+"\n";
		}
}
