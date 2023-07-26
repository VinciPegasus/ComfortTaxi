package application;

/*Importazione delle librerie di javafx per utilizzo di classi e interfaccie utili allo sviluppo dello scenario.*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerSettimoScenario implements Initializable{

	/*Le seguenti dichiarazioni serviranno per identificare sia gli eventi, sia i collegamenti di controllo nella scena corrente, collegati
	 * al file fxml relativo allo scenario corrente.*/
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button backButton;
	@FXML
	private Button Esci;
	@FXML
	private Button InviaRichiesta;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	FadeTransition ft = new FadeTransition();
	ft.setNode(anchorPane);
	ft.setDuration(Duration.millis(2000));
	ft.setFromValue(0);
	ft.setToValue(1);
	ft.play();
}

	/*Metodo presente in tutti gli scenari, inerente la simulazione del pulsante cellulare di
	default per tornare indietro in modo generico.*/
	@FXML
	public void backScene(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==backButton);
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/QuartoScenario.fxml"));//Vai alla prossima scena2
				Stage window = (Stage) anchorPane.getScene().getWindow();//Carica l'attuale scena1
				Scene newScene = new Scene(root);//Carico la grafica della nuova scena
				//Creo la snapshot per implementare la transizione
				FadeTransition ft = new FadeTransition(Duration.millis(1000),anchorPane);
				ft.setFromValue(1.0);
				ft.setToValue(0.0);
				ft.play();
				ft.setOnFinished(e->
				{
					window.setScene(newScene);
				});
			}
			catch(Exception e)
			{	
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	public void esciScene(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==Esci);
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/PrimoScenario.fxml"));//Vai alla prossima scena2
				Stage window = (Stage) anchorPane.getScene().getWindow();//Carica l'attuale scena1
				Scene newScene = new Scene(root);//Carico la grafica della nuova scena
				//Creo la snapshot per implementare la transizione
				FadeTransition ft = new FadeTransition(Duration.millis(1000),anchorPane);
				ft.setFromValue(1.0);
				ft.setToValue(0.0);
				ft.play();
				ft.setOnFinished(e->
				{
					window.setScene(newScene);
				});
			}
			catch(Exception e)
			{	
				e.printStackTrace();
			}
		}
	}
	
	/*Metodo relativo al pulsante di invio richiesta, ove al click del mouse invia la richiesta dell' ipotetico cliente alla flotta Taxi. */
	@FXML
	public void InviaRichiestaTaxi(Event event)
	{
		Button button = (Button)event.getSource();
		if(button==InviaRichiesta)
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/OttavoScenario.fxml"));//Vai alla prossima scena
				Stage window = (Stage) anchorPane.getScene().getWindow();//Carica l'attuale scena
				Scene newScene = new Scene(root);//Carico la grafica della nuova scena
				//Creo la snapshot per implementare la transizione
				FadeTransition ft = new FadeTransition(Duration.millis(1000),anchorPane);
				ft.setFromValue(1.0);
				ft.setToValue(0.0);
				ft.play();
				ft.setOnFinished(e->
				{
					window.setScene(newScene);
				});
				DatabaseConnection.connect(); //Connessione al database attraverso richiamo metodo statico classe DatabaseConnection
				DatabaseConnection.AlgoritmoTaxi();/*Richiamo metodo statico AlgoritmoTaxi(con utilizzo di pattern Mediator e pattern Observer per la scelta
				del taxi(attraverso gestione Mediator) e la comunicazione ai colleghi da parte del Taxi in partenza(attravero gestione pattern Observer).*/
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}