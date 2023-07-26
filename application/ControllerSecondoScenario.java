package application;

/*Importazione delle librerie di javafx per utilizzo di classi e interfaccie utili allo sviluppo dello scenario.*/
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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

public class ControllerSecondoScenario implements Initializable{
	
	/*Le seguenti dichiarazioni serviranno per identificare sia gli eventi, sia i collegamenti di controllo nella scena corrente, collegati
	 * al file fxml relativo allo scenario corrente.*/
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button TaxiButton;
	@FXML
	private Button backButton;
	
	//Inizializzazione secondo scenario con riscrizione metodo initialize.
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//Transizione scena corrente
		FadeTransition ft = new FadeTransition(Duration.millis(2000),anchorPane);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		//Animazione button (TaxiButton)
		TranslateTransition transition = new TranslateTransition ();
		transition.setDuration(Duration.millis(1000));
		transition.setNode(TaxiButton);
		transition.setToY(0);
		transition.setToX(-100);
		transition.setAutoReverse(true);
		transition.setCycleCount(TranslateTransition.INDEFINITE);
		transition.play();
	}
	
	//Metodo per cambio scenario verso il prossimo(il terzo).
	@FXML
	public void changeScene(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==TaxiButton);
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
		//Metodo per cambio scenario(per tornare allo scenario precedente
		@FXML
		public void backScene(Event event)throws Exception
		{
			Button button = (Button)event.getSource();
			if(button==backButton);
			{
				try
				{
					Parent root = FXMLLoader.load(getClass().getResource("/FXML/PrimoScenario.fxml"));//Vai alla prossima scena
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
				}
				catch(Exception e)
				{	
					e.printStackTrace();
				}
			}
		}
}