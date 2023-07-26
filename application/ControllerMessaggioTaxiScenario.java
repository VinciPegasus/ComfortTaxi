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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
	import javafx.stage.Stage;
	import javafx.util.Duration;

	public class ControllerMessaggioTaxiScenario implements Initializable{

			@FXML
			private AnchorPane anchorPane;
			@FXML
			private Button backButton;
			@FXML
			private Button Esci;
			@FXML
			private Label MessaggioDaTaxi;
			@FXML
			private Label Mittente;
			
			@Override
			public void initialize(URL url, ResourceBundle rb) {
			FadeTransition ft = new FadeTransition();
			ft.setNode(anchorPane);
			ft.setDuration(Duration.millis(2000));
			ft.setFromValue(0);
			ft.setToValue(1);
			ft.play();
			try
			{
				if(DatabaseConnection.stampaMessaggioCliente()!=null)
					Mittente.setText("Mittente: ComfortTaxi\n");
					MessaggioDaTaxi.setText(DatabaseConnection.stampaMessaggioCliente());
			}
			catch(Exception e)
			{
				Mittente.setText("Nessun mittente");
				MessaggioDaTaxi.setText("Nessun Messaggio Ricevuto.");
				System.out.println("Nessun messaggio ricevuto");
			}
}


			@FXML
			public void backScene(Event event)throws Exception
			{
				Button button = (Button)event.getSource();
				if(button==backButton);
				{
					try
					{
						Parent root = FXMLLoader.load(getClass().getResource("/FXML/MessaggiScenario.fxml"));//Vai alla prossima scena2
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
