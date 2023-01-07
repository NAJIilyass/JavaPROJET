package application;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable{
	
	private int idReserv;
	private Client client;
	private Voiture voiture;
	private LocalDate dateReserv;
	private LocalDate dateDemandee;
	private LocalDate dateRemPrev;
	private static int idRes = 1;
	static final long serialVersionUID =1L;
	
	
	public Reservation(Client client, Voiture voiture, LocalDate dateDemandee, LocalDate dateRemPrev) {
		this.idReserv = Reservation.idRes++;
		this.client = client;
		this.voiture = voiture;
		this.dateReserv = LocalDate.now(); 
		this.dateDemandee = dateDemandee; 
		this.dateRemPrev = dateRemPrev;
	}
	
	//Les getters & Les setters & Méthode toString
	//ici pour les getters et les setters, on a pas mis setIdReserv et setDateReserv, car ils sont faits automatiquement
	public int getIdReserv() {
		return idReserv;
	}
	
	public Client getClient() {
		return client;
	}
	
	public Voiture getVoiture() {
		return voiture;
	}
	
	public LocalDate getDateReserv() {
		return dateReserv;
	}
	
	public LocalDate getDateDemandee() {
		return dateDemandee;
	}
	
	public LocalDate getDateRemPrev() {
		return dateRemPrev;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	public void setDateDemandee(LocalDate dateDemandee) {
		this.dateDemandee = dateDemandee;
	}
	
	public void setDateRemPrev(LocalDate dateRemPrev) {
		this.dateRemPrev = dateRemPrev;
	}
	
	@Override
	public String toString() {
		return " ID : "+this.getIdReserv()+"\n Voiture : "+this.getVoiture()+"\n Client : "+this.getClient()+"\n Date Reservee : "+this.getDateReserv()+"\n Date Demandee : "+this.getDateDemandee()+"\n Date De Remise Prevue : "+this.getDateRemPrev();
	}

}