package application;
//Questo è solo uno scenario di introduzione all' app messaggi.
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerMessaggi implements Initializable{

	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button backButton;
	@FXML
	private Label Mex;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	FadeTransition ft = new FadeTransition();
	ft.setNode(anchorPane);
	ft.setDuration(Duration.millis(2000));
	ft.setFromValue(0);
	ft.setToValue(1);
	ft.play();
	}
	
	@FXML
	public void backScene(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==backButton);
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
	
	/*Metodo riguardante la Label Messaggi, al click del mouse su di essa,
	 * si avrà accesso "ai messaggi ricevuti" e quindi alla conseguente
	 * area nel quale troveremo il messaggio inviato all' ipotetico cliente
	 * con le informazioni inerenti il Taxi ion arrivo.*/
	@FXML
	public void vaiAMessaggio(Event event)throws Exception
	{
		Label label = (Label)event.getSource();
		if(label==Mex);
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/MessaggioTaxiScenario.fxml"));//Vai alla prossima scena
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