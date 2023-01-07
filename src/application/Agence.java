package application;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.io.Serializable;

public class Agence implements Serializable {
	
	private int idCompte;
	private int nbrVoitureDispo;
	private int nbrVoitureTotal;
	private List<Voiture> voitures = new ArrayList<>();
	public Set<Client> clients = new HashSet<>();
	private List<Voiture> voitureDispo = new ArrayList<>();
	public List<Reservation> reservations = new ArrayList<>();
	public List<Location> locations = new ArrayList<>();
	private Map<Client, Integer> clientLocat = new HashMap<>();
	static final long serialVersionUID =1L;
	
	
	public Agence(int idCompte, int nbrVoitureDispo, int nbrVoitureTotal) {
		this.idCompte = idCompte;
		this.nbrVoitureDispo = nbrVoitureDispo;
		this.nbrVoitureTotal = nbrVoitureTotal;
		this.clients = new HashSet<>();
		this.voitures = new ArrayList<>();
		this.voitureDispo = new ArrayList<>();
	}
	
	//Les getters & Les setters
	public int getIdCompte() {
		return idCompte;
	}

	public int getNbrVoitureDispo() {
		return nbrVoitureDispo;
	}
	
	public int getNbrVoitureTotal() {
		return nbrVoitureTotal;
	}
	
	public Set<Client> getClients() {
		return clients;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public List<? extends Vehicule> getVoitures() {
		return voitures;
	}
	
	public List<? extends Vehicule> getVoitureDispo() {
		return voitureDispo;
	}
	
	public List<Location> getLocations() {
		return locations;
	}
	
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public void setNbrVoitureDispo(int nbrVoitureDispo) {
		this.nbrVoitureDispo = nbrVoitureDispo;
	}

	public void setNbrVoitureTotal(int nbrVoitureTotal) {
		this.nbrVoitureTotal = nbrVoitureTotal;
	}
	
	//Des méthodes sur les voitures, les clients et les reservations pour la recherche et l'ajout
	public Voiture rechercherVoiture(String immatricule){ 
		for (Voiture v : this.voitures) {
			if (v.getImmatricule().equals(immatricule)) {
				return v;
			}
		}
		return null;
	}
	
	public Client rechercherClient(String CIN) { 
		for (Client c : clients) {
			if (c.getCIN().equals(CIN)) {
				return c;
			}
		}
		return null;
	}	
	
	public void ajouterVoiture(String marque, String modele, String immatricule, typeCarburant carburant, String couleur, int nbrPlaces, int nbrPortes) {
		if (this.rechercherVoiture(immatricule) == null) {
			Voiture ve = new Voiture(marque, modele, immatricule, carburant, couleur, nbrPlaces, nbrPortes);
			this.voitures.add(ve);
			this.voitureDispo.add(ve);
			this.nbrVoitureDispo++;
			this.nbrVoitureTotal++;
		} 
	}
	
	//ajouter un fichier contenant les infos sur les clients
	public void ajouterClient(String nom, String prenom, String CIN, String numTel) { 
		Client client = new Client(nom, prenom, CIN, numTel);
		this.clients.add(client);
		try {
			File file = new File("listeClients.txt");
	        
			if(!file.exists()) {
					file.createNewFile();	
			}
			PrintWriter pw = new PrintWriter(file);
			pw.println(client);
			pw.println("----------------");
			pw.close();
			} catch (IOException e) {	
				e.printStackTrace();
			}
	}
		
	public boolean estDisponibleVoiture(String immatricule) { 
		for(Voiture ve : this.voitureDispo) {
			if (ve.getImmatricule().equals(immatricule)) {
				return true;
			}
		}
		return false;
	}
	
	//ajouter un fichier contenant les infos sur les reservations
	public void ajouterReservation(Reservation reservation) throws ReservationException{
		if(!(this.reservations.contains(reservation))) {
			this.reservations.add(reservation);
			try {
				File file = new File("listeReservations.txt");
		        
				if(!file.exists()) {
						file.createNewFile();	
				}
				
				PrintWriter pw = new PrintWriter(file);
				pw.println(reservation);
				pw.println("----------------");
				pw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		else {
			throw new ReservationException();
		}
	}

	//Une méthode pour sélectionner un client par un numéro au hasard (Pour une prime ou un cadeau par exemple)
	public Client selectClient(int n){
		Client[] listeClients = this.clients.toArray(new Client[this.clients.size()]);
		try {
			return listeClients[n-1];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("vous n'avez pas ce nombre de clients.");
			return null;
		}
	}

	public void modifierReservation(int idReservation, Client Client, Voiture voiture, LocalDate dateDemandee, LocalDate dateRemPrev) {
		boolean exist = false;  
		for(Reservation e: this.reservations) {
			if(idReservation == e.getIdReserv()) {
				e.setClient(Client);
				e.setVoiture(voiture);
				e.setDateDemandee(dateDemandee);
				e.setDateRemPrev(dateRemPrev);
				exist=true;
			}
		}
		if(!exist) {
			System.out.println("réservation inéxistante");
		}
	}
	
	
	public Reservation rechercherReservation(int idReservation) {
		Iterator<Reservation> it = this.reservations.iterator();
		while(it.hasNext()) {
			Reservation re = it.next();
			if(idReservation == re.getIdReserv() ) {
				return re;
			}
		}
		return null;	
	}
	
	//pour passer d'une reservation à une location
	public void activerLocation(Reservation reserv) { 
		Location loca = new Location(reserv.getClient(), reserv.getVoiture(), reserv.getDateRemPrev());
		this.locations.add(loca);
		this.reservations.remove(reserv);
		this.voitureDispo.remove(reserv.getVoiture());
		this.nbrVoitureDispo-=1;
		int nombreReserv =0;
		if (this.clientLocat.containsKey(reserv.getClient())) {
			nombreReserv = this.clientLocat.get(reserv.getClient());
		}
		this.clientLocat.put(reserv.getClient(), nombreReserv+1);
	}	
	
	//Retour d'une voiture c'est à dire la fin de la location
	public Boolean retourVoiture(String immatricule)  { 
		Voiture ve = this.rechercherVoiture(immatricule);
		Location locaa = null;
		for (Location location : this.locations) {
			if (location.getVoiture().getImmatricule().equals(immatricule)) {
				locaa = location;
			}
		}
		if (locaa != null) {
			locaa.setDateRemEff(LocalDate.now());
			this.locations.remove(locaa);
			this.voitureDispo.add(ve);
			this.nbrVoitureDispo+=1;
			return true;
		}
		else {
			return false;
		}
	}
		
	//Sélectionner les clients qui sont en cours de louer une voiture ou même de reserver une
	public Set<Client> clientActives( ) { 
		Set<Client> cl = new HashSet<>();
		for (int i=0; i<reservations.size(); i++) {
			cl.add(reservations.get(i).getClient());
		}
		for (int j=0; j<locations.size(); j++) {
			cl.add(locations.get(j).getClient());
		}
		return  cl;
	}
	
	//Sélectionner le meilleur client en terme de nombre de locations
	public Client topClient() { 
		List<Map.Entry<Client, Integer>> list = new LinkedList<Map.Entry<Client, Integer>>( clientLocat.entrySet() );
		Collections.sort(list ,new Comparator<Map.Entry<Client, Integer>>(){
			public int compare( Map.Entry<Client, Integer> o1, Map.Entry<Client, Integer> o2 ){
				return (o1.getValue()).compareTo( o2.getValue());
				 }
		});
		HashMap<Client, Integer> mapClApresTrie = new LinkedHashMap<Client, Integer>();
		for(Map.Entry<Client, Integer> entry : list) {
			mapClApresTrie.put( entry.getKey(), entry.getValue() );
			return  entry.getKey();
		 }
		 return null;
	}
	
	
	@Override
	public String toString() {
		return this.getIdCompte()+", "+this.getNbrVoitureDispo()+" de "+this.getNbrVoitureTotal();
				
	}
}
