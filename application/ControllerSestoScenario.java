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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerSestoScenario implements Initializable{

	/*Le seguenti dichiarazioni serviranno per identificare sia gli eventi, sia i collegamenti di controllo nella scena corrente, collegati
	 * al file fxml relativo allo scenario corrente.*/
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button backButton;
	@FXML
	private ToggleGroup Scelta;
	@FXML
	private RadioButton Contanti;
	@FXML
	private RadioButton Carta;
	@FXML
	private RadioButton Bancomat;
	@FXML
	private Button Avanti;
	
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
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/QuartoScenario.fxml"));//Vai alla prossima scena
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
	
	//Metodo relativo all'avanzamento nel prossim scenario dopo l'indicazione del pagamento.
	@FXML
	public void avanzaPerRichiesta(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==Avanti);
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/SettimoScenario.fxml"));//Vai alla prossima scena
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