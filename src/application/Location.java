package application;

import java.io.Serializable;
import java.time.LocalDate;

public class Location implements Serializable{
	
	private int idLocation;
	private Client client;
	private Voiture voiture;
	private LocalDate dateLoca;
	private LocalDate dateRemPrev;
	private LocalDate dateRemEff;
	private static int idLoc = 1;
	static final long serialVersionUID =1L;
	
	
	public Location(Client client, Voiture voiture, LocalDate dateRemPrev) {
		this.idLocation = Location.idLoc++;
		this.client = client;
		this.voiture = voiture;
		this.dateLoca = LocalDate.now();
		this.dateRemPrev = dateRemPrev;
		this.dateRemEff = null;     //Car on a pas encore attrapé la voiture 
	}
	
	//Les getters & Les setters & Méthode toString
	public int getIdLocation() {
		return idLocation;
	}
	
	public Client getClient() {
		return client;
	}
	
	public Voiture getVoiture() {
		return voiture;
	}
	
	public LocalDate getDateLoca() {
		return dateLoca;
	}
	
	public LocalDate getDateRemPrev() {
		return dateRemPrev;
	}
	
	public LocalDate getDateRemEff() {
		return dateRemEff;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	public void setDateRemPrev(LocalDate dateRemPrev) {
		this.dateRemPrev = dateRemPrev;
	}
	
	public void setDateRemEff(LocalDate dateRemEff) {
		this.dateRemEff = dateRemEff;
	}
	
	public EtatLocation etatLoca() {
		if (this.dateRemEff != null) {
			return EtatLocation.RENDU;
		}
		else if (this.dateRemPrev.isAfter(LocalDate.now())) {
			return EtatLocation.ENCOURS;
		}
		else {
			return EtatLocation.NONRENDU;
		}
	}
	
	@Override
	public String toString() {
		return "ID : "+this.getIdLocation()+"\nVoiture : "+this.getVoiture()+"\nClient : "+this.getClient()+"\nDate de Location : "+this.getDateLoca()+"\nDate de Remise Prévue : "+this.getDateRemPrev()+"\n";
	}
	
}