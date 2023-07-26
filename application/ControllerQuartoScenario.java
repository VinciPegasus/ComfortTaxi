package application;

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

public class ControllerQuartoScenario implements Initializable{

	/*Le seguenti dichiarazioni serviranno per identificare sia gli eventi, sia i collegamenti di controllo nella scena corrente, collegati
	 * al file fxml relativo allo scenario corrente.*/
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button backButton;
	@FXML
	private Button avanti;
	
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
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/TerzoScenario.fxml"));//Vai alla prossima scena2
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
	public void avantiScene(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==avanti);
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/QuintoScenario.fxml"));//Vai alla prossima scena2
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
}
	