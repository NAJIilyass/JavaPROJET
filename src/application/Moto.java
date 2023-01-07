package application;

import java.io.Serializable;

public class Moto extends Vehicule implements Serializable{
	
	private double vitesseMax;
	static final long serialVersionUID =1L;
	
	
	public Moto(String marque, String modele, String immatricule, typeCarburant carburant, String couleur, double vitesseMax) {
		super(marque, modele, immatricule, carburant, couleur);
		this.vitesseMax = vitesseMax;
	}
	
	//Les getters & Les setters & Méthode toString
	public double getVitesseMax() {
		return vitesseMax;
	}
	
	public void setVitesseMax(double vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	
	@Override
	public String toString() {
		return super.toString()+" a pour vitesse maximale "+this.getVitesseMax()+" Km/h";
	}
}
