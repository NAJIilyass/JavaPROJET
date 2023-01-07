package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDonneesAGENCE {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/";
		Connection connexion = null;
	
		try {
			connexion = DriverManager.getConnection(url,"root","BE17F5E363");
			Statement st = connexion.createStatement();
			String requete = "CREATE DATABASE AGENCE";
			st.executeUpdate(requete);
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probleme de connexion");
		}  
		System.out.println("DATABASE CREE");
		
		
		//----
		
		
		url = "jdbc:mysql://localhost/Agence";		
		try {
			connexion = DriverManager.getConnection(url,"root","BE17F5E363");
			Statement st = connexion.createStatement();
			String requete = "CREATE TABLE VOITURES " +
	                   "(immatricule VARCHAR(255) not NULL, " +
	                   " marque VARCHAR(255), " + 
	                   " modele VARCHAR(255), " + 
	                   " carburant VARCHAR(255), " + 
	                   " couleur VARCHAR(255), " + 
	                   " nbrPlaces INTEGER, " +
	                   " nbrPortes INTEGER, " + 
	                   " PRIMARY KEY ( immatricule ))"; 
	         st.executeUpdate(requete);
	         
	         requete = "CREATE TABLE CLIENTS " +
	                   "(CIN VARCHAR(255) not NULL, " +
	                   " nom VARCHAR(255), " + 
	                   " prenom VARCHAR(255), " + 
	                   " tel VARCHAR(255), " + 
	                   " PRIMARY KEY ( CIN ))"; 
	         st.executeUpdate(requete);
	         
	         requete = "CREATE TABLE VOITURES " +
	                   "(immatricule VARCHAR(255) not NULL, " +
	                   " marque VARCHAR(255), " + 
	                   " modele VARCHAR(255), " + 
	                   " carburant VARCHAR(255), " + 
	                   " couleur VARCHAR(255), " + 
	                   " nbrPlaces INTEGER, " +
	                   " nbrPortes INTEGER, " + 
	                   " PRIMARY KEY ( immatricule ))"; 
	         st.executeUpdate(requete);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probleme de connexion");
		}  
		System.out.println("TABLE CREE");
		
		
		//----
		
		
		try {
			connexion = DriverManager.getConnection(url,"root","BE17F5E363");
			Statement st = connexion.createStatement();
			String requete = "INSERT INTO VOITURES VALUES ('48', 'MERCEDES', 'AMG', 'DIESEL', 'Noir', 5, 4)";
	        st.executeUpdate(requete);
			requete = "INSERT INTO VOITURES VALUES ('51', 'BMW', 'Serie 4', 'ELECTRICITE', 'Bleu', 7, 4)";
	        st.executeUpdate(requete);
			requete = "INSERT INTO VOITURES VALUES ('77', 'Audi', 'A4', 'ESSENCE', 'Blanche', 5, 4)";
	        st.executeUpdate(requete);
			requete = "INSERT INTO VOITURES VALUES ('1', 'RENAULT', 'CLIO 7', 'DIESEL', 'Orange MAT', 5, 3)";
	        st.executeUpdate(requete);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probleme de connexion");
		}  
		System.out.println("VALEURS AJOUTEES");
		
		
		//----
		
		
		try {
			connexion = DriverManager.getConnection(url,"root","BE17F5E363");
			Statement st = connexion.createStatement();
			
			String requete = "select * from VOITURES";
			ResultSet resultat = st.executeQuery(requete);
			ResultSetMetaData metaData = resultat.getMetaData();
			for(int i=1;i<=metaData.getColumnCount();i++) {
				System.out.print(metaData.getColumnLabel(i)+"\t");
			}
			System.out.println();
			while(resultat.next()) {
				for(int i=1;i<=metaData.getColumnCount();i++) {
					System.out.print(resultat.getString(i)+"\t");
				}
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probleme de connexion");
		}  
		System.out.println("REQUETE EXECTUEE");
	}  
}
