package application;

/*Importazione delle librerie di javafx per utilizzo di classi e interfaccie utili allo sviluppo dello scenario.*/
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ControllerPrimoScenario implements Initializable{
	Time time = new Time(new CurrentTime().currentTime());
	//Time time = new Time("12:00:00");

	@FXML /*Annotazione riferita alla dichiarazione sottostante. Nel file fxml ho creato una Shape: Text (forma per inserire testo),
	dandogli un identificativo (id) "timer". Questa dichiarazione mi servirà nel metodo initialize per inserire l'orologio
	nell' interfaccia grafica che sto creando, precisamente nella Shape che ho creato Text.*/
	private Text timer;
	
	/*Sotto segue l'utilizzo della classe Timeline, istanziamo un nuovo oggetto timeline, sfruttiamo il costruttore per inserire
	 * i parametri utili a dare le cifre di partenza dell'orologio*/
	
	
	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),e->{time.unSecondoPassa();timer.setText(time.getCurrentTime());}));
		
	/*Riscrizione del metodo initialize relativo all'interfaccia Initializable per creare il primo scenario.
	 * Nel suo interno dichiariamo un nuovo oggetto ft relativo alla classe FadeTransition, per ricreare una transizione
	 * relativa all' entrata del primo scenario.
	 */
	
	//Richiamiamo il metodo initialize per inizializzare la classe controller(relativa al file fxml), dopo che il suo elemento radice(root) è stato completamente elaborato.
	/*I parametri assegnati:
	url : La posizione utilizzata per risolvere i percorsi relativi per l'oggetto root o null se la posizione non è nota.
	resourseboundle : le risorse utilizzate per localizzare l'oggetto root o null se l'oggetto radice non è stato localizzato.*/
	@Override
	public void initialize(URL url, ResourceBundle resourceboundle) {
		//Transizione scena corrente
		FadeTransition ft = new FadeTransition();
		ft.setNode(anchorPane);
		ft.setDuration(Duration.millis(2000));//Durata transizione.
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
		timer.setText(time.getCurrentTime()); //Inserimento dell'orario corrente, con il metodo getCurrentTime presente nella classe CurrentTime
		timeline.setCycleCount(Timeline.INDEFINITE);//Durata del ciclo dell'orologio(indefinita) metodo classe Timeline
		timeline.play();//Partenza orologio metodo classe Timeline
	}
	

	/*Le seguenti dichiarazioni serviranno per identificare anchorpane(il "contenitore" della mia interfaccia grafica),
	comTaxi(il pulsante di controllo), introduttivo alla mia app una volta cliccato, e il pulsante messaggi dove al click
	ci inoltreremo nello scenario Messaggi. Dopo l'esecuzione della richiesta, nello scenario Messaggi troveremo il messaggio
	ricevuto con i dati del taxi in arrivo al cliente.*/
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Button comTaxi;
	@FXML
	private Button Messaggi;
	
	/*Creato metodo changeScene con parametro event relativo a classe Event per gestire
	al click del mouse il passaggio di scena da primo a secondo scenario(la mia app).*/
	@FXML
	public void changeScene(Event event)throws Exception
	{
		Button button = (Button)event.getSource();//Impostato evento a button
		if(button==comTaxi);//associato button a comTaxi(la mia dichiarazione precedente fatta
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/SecondoScenario.fxml"));//Vai alla prossima scena
				Stage window = (Stage) anchorPane.getScene().getWindow();//Carica l'attuale scena
				Scene newScene = new Scene(root);//Carico la grafica della nuova scena
				//Creo la snapshot per implementare la transizione
				/*Questa transizione crea un'animazione dell'effetto di dissolvenza che si estende per tutta la sua durata.
				Questo viene fatto aggiornando la variabile di opacità del nodo a intervalli regolari.
				Inizia da fromValue se fornito, altrimenti utilizza il valore di opacità del nodo.
				Si ferma al valore toValue, se fornito altrimenti utilizzerà il valore iniziale più byValue.
				Il toValue ha la precedenza se sono specificati sia toValue che byValue.*/
				FadeTransition ft = new FadeTransition(Duration.millis(1000),anchorPane);
				ft.setFromValue(1.0);
				ft.setToValue(0.0);
				ft.play();
				ft.setOnFinished(e->
				{
					window.setScene(newScene);//Chiamo evento alla fine della transizione, carico la nuova scena
				});
			}
			catch(Exception e)
			{	
				e.printStackTrace();
			}
		}
	}

	//Medesimo provcedimento, per poter cambiare scenario, ed entrare nell' area Messaggi.
	@FXML
	public void vaiAMessaggi(Event event)throws Exception/*Utilizzo Eccezione per controllare anomalie potenziali ed avere un ritorno una volta
	che il mio programma arrivi al main e termina l'esecuzione. Avendo un ritorno dell' eccezione in essere attraverso e una relativa visualizzazione dell' anomalia riscontrata
	in fase di esecuzione del programma.*/
	{
		Button button = (Button)event.getSource();
		if(button==Messaggi);
		{
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("/FXML/MessaggiScenario.fxml"));//Vai alla prossima scena
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
				e.printStackTrace();//Catturo eccezione e stampo il resoconto
			}
		}
	}
}