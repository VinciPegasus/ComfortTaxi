package application;

/*Importazione delle librerie di javafx per utilizzo di classi e interfaccie utili allo sviluppo dello scenario.*/
import java.net.URL;
import java.util.Random;
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

public class ControllerQuintoScenario implements Initializable{

	/*Le seguenti dichiarazioni serviranno per identificare sia gli eventi, sia i collegamenti di controllo nella scena corrente, collegati
	 * al file fxml relativo allo scenario corrente.*/
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button backButton;
	@FXML
	private Label Km;
	@FXML
	private Label Prezzo;
	@FXML
	private Button Si;
	@FXML
	private Button No;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	
		FadeTransition ft = new FadeTransition();
		ft.setNode(anchorPane);
		ft.setDuration(Duration.millis(2000));
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		getnumeroRandomKM_COSTO();
	}
	
	/*Creazione di un numero random da inserire nella Label dello
	 * scenario per ricreare un numero pseudocasuale riferito ai km percorsi,
	 * nella Label prezzo, il risultato sarà governato dall' if in basso.*/
	
	@FXML
	public void getnumeroRandomKM_COSTO()
	{	
		Random rand = new Random();
		int numero = rand.nextInt(100);
		Km.setText(numero+" km");
		if(numero>0 && numero<20)
		{
			Prezzo.setText("20 Euro");
		}
		if(numero>20 && numero<40)
		{
			Prezzo.setText("40 Euro");
		}
		if(numero>40 && numero<60)
		{
			Prezzo.setText("60 Euro");
		}
		if(numero>60 && numero<80)
		{
			Prezzo.setText("80 Euro");
		}
		if(numero>80 && numero<100)
		{
			Prezzo.setText("100 Euro");
		}
	}
	
	//Metodo riferito al pulsante per avanzare di scenario(verso il sesto) al click del mouse.
	@FXML
	public void SiAvanza(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==Si);
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/SestoScenario.fxml"));//Vai alla prossima scena
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
	
	//Metodo riferito al pulsante no per tornare al quarto scenario(quello di login).
	@FXML
	public void NoIndietro(Event event)throws Exception
	{
		Button button = (Button)event.getSource();
		if(button==No);
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