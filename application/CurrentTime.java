package application;

/*Classe che mi permette di impostare l'orario corrente nella sezione di testo(Text)impostata nel
 *file fxml relativo al Primo Scenario.
 */

//Importazione librerie utili allo sviluppo della classe.
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
	/*Utilizzo le classi predefinite nelle librerie dichiarate per l' impostazione
	 *del formato di base dell' orologio(DateTimeFormatter), e la classe LocalDateTime per
	 *l'inserimento dell'ora locale effettiva. 
	 */
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	//Costruttore
	public CurrentTime() {}

	//Metodo relativo al ritorno dell'orario.
	public String currentTime()
	{
		return dtf.format(now);
	}
}
