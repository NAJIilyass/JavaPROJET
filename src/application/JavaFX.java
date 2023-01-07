package application;
 
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class JavaFX extends Application {
    //Déclaration des Variables
	VBox panel;
	VBox panel0;
    HBox panel1;
    HBox panel2;
    HBox panel3;
    HBox panel4;
    VBox panel5;
    
    Text bnv;
    Text vide;
    
    Button AjouterReserv;
    Button ActiverLocation;
    Button RetourVoiture;
    Button AjouterClient;
    Button AjouterVoiture;
    Button ConsulClient;
    Button ConsulVoitureDispo;
    Button ConsulReservations;
    Button ConsulVoitures;
    Button ConsulLocations;
    
    
    Agence agence;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Connexion BD
    	try {
            agence=BaseDonnees.Load();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    	
        //Création Panes
        panel = new VBox(20);
        panel0 = new VBox(20);
        panel1 = new HBox(70);
        panel2 = new HBox(70);
        panel3 = new HBox(70);
        panel4 = new HBox(70);
        panel5 = new VBox(20);        
   
        //Création Buttons
        bnv = new Text("BIENVENUE");
        vide = new Text("");
        
        RetourVoiture = new Button("Retour D'Une Voiture");
        
        AjouterReserv = new Button("Ajouter  Une Réservation");
        ActiverLocation = new Button("Activer        Une       Location");
               
        AjouterClient = new Button("Ajouter        Un       Client");
        AjouterVoiture = new Button("Ajouter         Une        Voiture");
        
        ConsulClient = new Button("Consulter      Un    Client");
        ConsulVoitureDispo = new Button("Consulter Les Voitures Dispo");
        ConsulReservations = new Button("Consulter   Les  Reservations");
        ConsulVoitures = new Button("Consulter    Les  Voitures");
        ConsulLocations = new Button("Consulter Les Locations");
        
        
        //Style des élements
        panel.setStyle("-fx-background-image: url('file:back.jpg');-fx-background-size : cover;    ");
        bnv.setFont(Font.font("DialogInput", FontWeight.BOLD, 45));
        bnv.setFill(Color.WHITE);
        AjouterReserv.setStyle("-fx-font: normal bold 15px 'serif'  ");
        ActiverLocation.setStyle("-fx-font: normal bold 15px 'serif'  ");
        RetourVoiture.setStyle("-fx-font: normal bold 15px 'serif'  ");
        AjouterClient.setStyle("-fx-font: normal bold 15px 'serif'  ");
        AjouterVoiture.setStyle("-fx-font: normal bold 15px 'serif'  ");
        ConsulClient.setStyle("-fx-font: normal bold 15px 'serif'  ");
        ConsulVoitureDispo.setStyle("-fx-font: normal bold 15px 'serif'  ");
        ConsulReservations.setStyle("-fx-font: normal bold 15px 'serif'  ");
        ConsulVoitures.setStyle("-fx-font: normal bold 15px 'serif'  ");
        ConsulLocations.setStyle("-fx-font: normal bold 15px 'serif'  ");
        
        //Ajout des élements
        panel0.getChildren().addAll(RetourVoiture);
        panel0.setAlignment(Pos.CENTER);
        panel1.getChildren().addAll(AjouterReserv,ActiverLocation);
        panel1.setAlignment(Pos.CENTER);
        panel2.getChildren().addAll(AjouterClient,AjouterVoiture);
        panel2.setAlignment(Pos.CENTER);
        panel3.getChildren().addAll(ConsulClient,ConsulReservations);
        panel3.setAlignment(Pos.CENTER);
        panel4.getChildren().addAll(ConsulVoitures,ConsulVoitureDispo);
        panel4.setAlignment(Pos.CENTER);
        panel5.getChildren().addAll(ConsulLocations);
        panel5.setAlignment(Pos.CENTER);
        
        panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
        panel.setAlignment(Pos.CENTER);
        
        
        //Action Par Buttons
        AjouterVoiture.setOnAction(event -> {
        	panel.getChildren().removeAll(panel.getChildren());
            VBox tempVoiture = new VBox(5);
            VBox.setMargin(tempVoiture, new Insets(10,10,10,10));
            tempVoiture.setAlignment(Pos.CENTER);
            
            //Remplir la nouvelle scene
            Label tempVoiture1 = new Label("Marque :");
            TextField tempVoiture11 = new TextField();

            Label tempVoiture2 = new Label("Model :");
            TextField tempVoiture21 = new TextField();
            
            Label tempVoiture3 = new Label("Immatricule :");
            TextField tempVoiture31 = new TextField();

            Label tempVoiture4 = new Label("Carburant :");
            ComboBox<typeCarburant> tempVoiture41 = new ComboBox<typeCarburant>();
            tempVoiture41.getItems().addAll(typeCarburant.DIESEL, typeCarburant.ELECTRICITE, typeCarburant.ESSENCE);
            
            Label tempVoiture5 = new Label("Couleur :");
            TextField tempVoiture51 = new TextField();
            
            Label tempVoiture6 = new Label("Nombre De Places :");
            TextField tempVoiture61 = new TextField();
            
            Label tempVoiture7 = new Label("Nombre De Portes :");
            TextField tempVoiture71 = new TextField();

            Button tempVoiture81=new Button("Ajouter");
            Button tempVoiture82=new Button("Retour");
            
            //Style des élements
            tempVoiture1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoiture2.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoiture3.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoiture4.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoiture5.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoiture6.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoiture7.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            
            tempVoiture81.setStyle("-fx-font: normal bold 15px 'serif'  ");
            tempVoiture82.setStyle("-fx-font: normal bold 15px 'serif'  ");
            
            tempVoiture81.setOnAction(event1 -> {
            	//Conversion de String en Integer
            	int nbrPlaces = Integer.parseInt(tempVoiture61.getText());
                int nbrPortes = Integer.parseInt(tempVoiture71.getText());
            	agence.ajouterVoiture(tempVoiture11.getText(), tempVoiture21.getText(), tempVoiture31.getText(), tempVoiture41.getValue(), tempVoiture51.getText(), nbrPlaces, nbrPortes);
                
            	try {
            		BaseDonnees.Save(agence);
            		System.out.println("Voiture ajoutee d'immatricule : "+tempVoiture31.getText());
                    panel.getChildren().removeAll(panel.getChildren());
                    panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            
            tempVoiture82.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
   


            //temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            HBox Buttons = new HBox(30);
            Buttons.getChildren().addAll(tempVoiture81, tempVoiture82);
            Buttons.setAlignment(Pos.CENTER);
            tempVoiture.getChildren().addAll(tempVoiture1, tempVoiture11, tempVoiture2, tempVoiture21, tempVoiture3, tempVoiture31, tempVoiture4, tempVoiture41, tempVoiture5, tempVoiture51, tempVoiture6,  tempVoiture61, tempVoiture7, tempVoiture71, vide, Buttons);
            panel.getChildren().addAll(tempVoiture);
        });
        
        
        
        
        AjouterReserv.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox tempReserv = new VBox(5);
            VBox.setMargin(tempReserv, new Insets(10,10,10,10));
            tempReserv.setAlignment(Pos.CENTER);
            
            //Remplir la nouvelle scene
            Label tempReserv1 = new Label("CIN :");
            TextField tempReserv11 = new TextField();

            Label tempReserv2 = new Label("Immatricule :");
            TextField tempReserv21 = new TextField();
            
            Label tempReserv3 = new Label("Date Demandée :");
            TextField tempReserv31 = new TextField();

            Label tempReserv4 = new Label("Date De Remise Prévue :");
            TextField tempReserv41 = new TextField();

            Button tempReserv51=new Button("Ajouter");
            Button tempReserv52=new Button("Retour");
            
            //Style des élements
            tempReserv1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempReserv2.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempReserv3.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempReserv4.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempReserv51.setStyle("-fx-font: normal bold 15px 'serif'  ");
            tempReserv52.setStyle("-fx-font: normal bold 15px 'serif'  ");
            
            tempReserv51.setOnAction(event1 -> {
            	//Conversion de String en LocalDate
            	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dateDemandee = LocalDate.parse(tempReserv31.getText(), format);
                LocalDate dateRemPrev = LocalDate.parse(tempReserv41.getText(), format);
            	Client cli = agence.rechercherClient(tempReserv11.getText());
            	Voiture Voit = agence.rechercherVoiture(tempReserv21.getText());
                Reservation reserv = new Reservation(cli, Voit, dateDemandee, dateRemPrev);
                try {
					agence.ajouterReservation(reserv);
				} catch (ReservationException e1) {
					e1.printStackTrace();
				}
                
            	try {
            		BaseDonnees.Save(agence);
            		System.out.println("Reservation ajoutee d'ID : "+reserv.getIdReserv());
                    panel.getChildren().removeAll(panel.getChildren());
                    panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            
            tempReserv52.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
   


            //temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            HBox Buttons = new HBox(30);
            Buttons.getChildren().addAll(tempReserv51, tempReserv52);
            Buttons.setAlignment(Pos.CENTER);
            tempReserv.getChildren().addAll(tempReserv1, tempReserv11, tempReserv2, tempReserv21, tempReserv3, tempReserv31, tempReserv4, tempReserv41, vide, Buttons);
            panel.getChildren().addAll(tempReserv);
        }); 
        
        
             
        AjouterClient.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox tempClient = new VBox(5);
            VBox.setMargin(tempClient, new Insets(10,10,10,10));
            tempClient.setAlignment(Pos.CENTER);
            
            //Remplir la nouvelle scene
            Label tempClient1 = new Label("Nom :");
            TextField tempClient11 = new TextField();

            Label tempClient2 = new Label("Prénom :");
            TextField tempClient21 = new TextField();
            
            Label tempClient3 = new Label("CIN :");
            TextField tempClient31 = new TextField();

            Label tempClient4 = new Label("Téléphone :");
            TextField tempClient41 = new TextField();

            Button tempClient51=new Button("Ajouter");
            Button tempClient52=new Button("Retour");
            
            //Style des élements
            tempClient1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempClient2.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempClient3.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempClient4.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempClient51.setStyle("-fx-font: normal bold 15px 'serif'  ");
            tempClient52.setStyle("-fx-font: normal bold 15px 'serif'  ");
            
            tempClient51.setOnAction(event1 -> {
                agence.ajouterClient(tempClient11.getText(),tempClient21.getText(), tempClient31.getText(), tempClient41.getText());
                try {
                	BaseDonnees.Save(agence);
            		System.out.println("Client ajoute de CIN : "+tempClient31.getText());
                    panel.getChildren().removeAll(panel.getChildren());
                    panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            
            tempClient52.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
   


            //temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            HBox Buttons = new HBox(30);
            Buttons.getChildren().addAll(tempClient51, tempClient52);
            Buttons.setAlignment(Pos.CENTER);
            tempClient.getChildren().addAll(tempClient1, tempClient11, tempClient2, tempClient21, tempClient3, tempClient31, tempClient4, tempClient41, vide, Buttons);
            panel.getChildren().addAll(tempClient);
        });
        
        
        
        
        
        ActiverLocation.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox tempLoca = new VBox(5);
            VBox.setMargin(tempLoca, new Insets(10,10,10,10));
            tempLoca.setAlignment(Pos.CENTER);
            
          //Remplir la nouvelle scene
            Label tempLoca1 = new Label("L'Identifiant de la Réservation :");
            TextField tempLoca11 = new TextField();

            Button tempLoca21=new Button("Activer");
            Button tempLoca22=new Button("Retour");
            
            //Style des élements
            tempLoca1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempLoca21.setStyle("-fx-font: normal bold 15px 'serif'  ");
            tempLoca22.setStyle("-fx-font: normal bold 15px 'serif'  ");
            
            tempLoca21.setOnAction(event1 -> {
            	int idReserv = Integer.parseInt(tempLoca11.getText());
                agence.activerLocation(agence.rechercherReservation(idReserv));
            	try {
            		BaseDonnees.Save(agence);
            		System.out.println("Location activee de reservation d'ID : "+idReserv);
                    panel.getChildren().removeAll(panel.getChildren());
                    panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            
            tempLoca22.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
   


            //temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            HBox Buttons = new HBox(30);
            Buttons.getChildren().addAll(tempLoca21, tempLoca22);
            Buttons.setAlignment(Pos.CENTER);
            tempLoca.getChildren().addAll(tempLoca1, tempLoca11, vide, Buttons);
            panel.getChildren().addAll(tempLoca);
        });
        
        
        
        
        
        RetourVoiture.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox tempVoit = new VBox(5);
            VBox.setMargin(tempVoit, new Insets(10,10,10,10));
            tempVoit.setAlignment(Pos.CENTER);
            
            //Remplir la nouvelle scene
            Label tempVoit1 = new Label("Immatricule :");
            TextField tempVoit11 = new TextField();

            Button tempVoit21=new Button("Activer");
            Button tempVoit22=new Button("Quitter");
            
            //Style des élements
            tempVoit1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoit21.setStyle("-fx-font: normal bold 15px 'serif'  ");
            tempVoit22.setStyle("-fx-font: normal bold 15px 'serif'  ");
            
            tempVoit21.setOnAction(event1 -> {
                if(agence.retourVoiture(tempVoit11.getText())) {	
                	try {
                		BaseDonnees.Save(agence);
                		System.out.println("Voiture retournee d'immatricule : "+tempVoit11.getText());
                		panel.getChildren().removeAll(panel.getChildren());
                        panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
                	} catch (IOException e) {
                		e.printStackTrace();
                	}
                }else {
                	Label tempVoit3 = new Label("l'immatricule "+tempVoit11.getText()+" ne convient a aucune location");
                    tempVoit3.setStyle("-fx-text-fill: white");
                	panel.getChildren().add(tempVoit3);
                }
            });
            
            tempVoit22.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });


            //temp1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            HBox Buttons = new HBox(30);
            Buttons.getChildren().addAll(tempVoit21, tempVoit22);
            Buttons.setAlignment(Pos.CENTER);
            tempVoit.getChildren().addAll(tempVoit1, tempVoit11, vide, Buttons);
            panel.getChildren().addAll(tempVoit);
        });
        
        
        
        
        
        ConsulClient.setOnAction(event -> {
            panel.getChildren().removeAll(panel.getChildren());
            VBox tempCli=new VBox(5);
            tempCli.setAlignment(Pos.CENTER);
            
            Label tempCli1 = new Label("Chercher Un Client Par CIN :");
            TextField tempCli11=new TextField();
            
            Button tempCli21=new Button("Chercher");
            Button tempCli22=new Button("Retour");
            
            VBox.setMargin(tempCli, new Insets(10,10,10,10));
            tempCli1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempCli21.setStyle("-fx-font: normal bold 15px 'serif'  ");
            tempCli22.setStyle("-fx-font: normal bold 15px 'serif'");
            
            tempCli21.setOnAction(event1 -> {
                Client tempclient=null;
                Iterator<Client> it = agence.getClients().iterator();
        		while(it.hasNext()) {
        			Client cl = it.next();
        			if(cl.getCIN().equals(tempCli11.getText())) {
        				tempclient = cl;
        			}
        		}
        		
                if (tempclient == null){
                    Label tempCli3 = new Label("Aucun Client correspond a ce CIN");
                    tempCli3.setStyle("-fx-text-fill: white");
                    panel.getChildren().add(tempCli3);
                }else{
                    TextArea tempCli4 = new TextArea();
                    tempCli4.setStyle("-fx-font: normal 15px 'Courier New'");
                    tempCli4.setText("Client :"+tempclient.toString());
                    panel.getChildren().add(tempCli4);
                    tempCli21.setDisable(true);
                }
            });
            
            tempCli22.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
            
            HBox Buttons = new HBox(30);
            Buttons.getChildren().addAll(tempCli21, tempCli22);
            Buttons.setAlignment(Pos.CENTER);
            tempCli.getChildren().addAll(tempCli1,tempCli11, vide, Buttons);
            panel.getChildren().addAll(tempCli);
        });
        

        
        
       
        ConsulReservations.setOnAction(event -> {
        	panel.getChildren().removeAll(panel.getChildren());
            VBox tempRes=new VBox(5);
            tempRes.setAlignment(Pos.CENTER);
            
            Label tempRes1 = new Label("Reservations :");            
            TextArea tempRes2 = new TextArea();
            
            Button tempRes3=new Button("Retour");

            VBox.setMargin(tempRes, new Insets(10,10,10,10));
            tempRes1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempRes3.setStyle("-fx-font: normal bold 15px 'serif'");
            tempRes2.setStyle("-fx-font: normal 15px 'Courier New'");
           
            String phrase = "";
            Iterator<Reservation> it = agence.getReservations().iterator();
    		while(it.hasNext()) {
    			phrase += it.next().toString();
    			phrase += "\n";
    			phrase += "\n";
    		}
            
            tempRes2.setText(phrase);
            panel.getChildren().add(tempRes2);
            
            tempRes3.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
            
            tempRes.getChildren().addAll(tempRes1, tempRes2, vide, tempRes3);
            panel.getChildren().addAll(tempRes);
        });


        
        
        
        ConsulVoitures.setOnAction(event -> {
        	panel.getChildren().removeAll(panel.getChildren());
            VBox tempVoi=new VBox(5);
            tempVoi.setAlignment(Pos.CENTER);
            
            Label tempVoi1 = new Label("Voitures :");            
            TextArea tempVoi2 = new TextArea();
            Button tempVoi3=new Button("Retour");

            VBox.setMargin(tempVoi, new Insets(10,10,10,10));
            
            tempVoi1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoi2.setStyle("-fx-font: normal 15px 'Courier New'");
            tempVoi3.setStyle("-fx-font: normal bold 15px 'serif'");

           
            String phrase = "";
            int count = 1;
            Iterator<? extends Vehicule> it = agence.getVoitures().iterator();
    		while(it.hasNext()) {
    			phrase += "Voiture "+count+it.next().toString();
    			count++;
    			phrase += "\n";
    		}
            
            tempVoi2.setText(phrase);
            panel.getChildren().add(tempVoi2);
            
            tempVoi3.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
            
            tempVoi.getChildren().addAll(tempVoi1, tempVoi2, vide, tempVoi3);
            panel.getChildren().addAll(tempVoi);
        });
        
        
        
        
        
        ConsulVoitureDispo.setOnAction(event -> {
        	panel.getChildren().removeAll(panel.getChildren());
            VBox tempVoiDispo=new VBox(5);
            tempVoiDispo.setAlignment(Pos.CENTER);
            
            Label tempVoiDispo1 = new Label("Voitures Disponibles :");            
            TextArea tempVoiDispo2 = new TextArea();
            Button tempVoiDispo3=new Button("Retour");

            VBox.setMargin(tempVoiDispo, new Insets(10,10,10,10));
            
            tempVoiDispo1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempVoiDispo2.setStyle("-fx-font: normal 15px 'Courier New'");
            tempVoiDispo3.setStyle("-fx-font: normal bold 15px 'serif'");

           
            String phrase = "";
            int count = 1;
            Iterator<? extends Vehicule> it = agence.getVoitureDispo().iterator();
    		while(it.hasNext()) {
    			phrase += "Voiture "+count+it.next().toString();
    			count++;
    			phrase += "\n";
    		}
            
            tempVoiDispo2.setText(phrase);
            panel.getChildren().add(tempVoiDispo2);
            
            tempVoiDispo3.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
            
            tempVoiDispo.getChildren().addAll(tempVoiDispo1, tempVoiDispo2, vide, tempVoiDispo3);
            panel.getChildren().addAll(tempVoiDispo);
        });
        
        
        
        
        
        ConsulLocations.setOnAction(event -> {
        	panel.getChildren().removeAll(panel.getChildren());
            VBox tempLoc=new VBox(5);
            tempLoc.setAlignment(Pos.CENTER);
            
            Label tempLoc1 = new Label("Locations :");            
            TextArea tempLoc2 = new TextArea();
            Button tempLoc3=new Button("Retour");

            VBox.setMargin(tempLoc, new Insets(10,10,10,10));
            
            tempLoc1.setStyle("-fx-text-fill: white;-fx-font: normal bold 20px 'serif'  ");
            tempLoc2.setStyle("-fx-font: normal 15px 'Courier New'");
            tempLoc3.setStyle("-fx-font: normal bold 15px 'serif'");
           
            String phrase = "";
            Iterator<Location> it = agence.getLocations().iterator();
    		while(it.hasNext()) {
    			phrase += it.next().toString();
    			phrase += "\n";
    			phrase += "\n";
    		}
            
            tempLoc2.setText(phrase);
            panel.getChildren().add(tempLoc2);
            
            tempLoc3.setOnAction(event1 -> {
                panel.getChildren().removeAll(panel.getChildren());
                panel.getChildren().addAll(bnv, vide, panel0, panel1, panel2, panel3, panel4, panel5);
            });
            
            tempLoc.getChildren().addAll(tempLoc1, tempLoc2, vide, tempLoc3);
            panel.getChildren().addAll(tempLoc);
        });
           
        //Réglage de la scene
        Scene scene = new Scene(panel,600,600);
        primaryStage.setTitle("Agence MSN");
        primaryStage.setOpacity(0.95);
        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}