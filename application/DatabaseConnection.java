package application;

//Importazione librerie utili allo sviluppo della classe.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DatabaseConnection {
	
	//Creazione vari ArrayList per la gestione dei taxi.
	public static ArrayList<OggettoTaxi> flotta = new ArrayList<OggettoTaxi>();//Includerà i taxi dal database.
	static OggettoTaxi taxi;
	
	public static ArrayList<OggettoTaxi> tutti = new ArrayList<OggettoTaxi>();//Includerà i taxi dell' ArrayList flotta per il controllo dei taxi tramite mediator.
	public static ArrayList<OggettoTaxi> disponibili = new ArrayList<OggettoTaxi>();
	public static ArrayList<OggettoTaxi> chiamati = new ArrayList<OggettoTaxi>();
	public static ArrayList<OggettoTaxi> occupati = new ArrayList<OggettoTaxi>();
	
	//Metodo per la connessione al database FlottaTaxi.db e aggiunta dei dati in ArrayList flotta.
	public static void connect()
	{	
		
		try
		{
			//1 Load driver
			Class.forName("org.sqlite.JDBC");
			//2Create connection
			Connection connection = DriverManager.getConnection("jdbc:sqlite:FlottaTaxi.db");
			//3 Create statement
			Statement statement = connection.createStatement();
			//4 Execute statement
			String sql="select * from Auto";
			ResultSet result = statement.executeQuery(sql);
			while(result.next())
			{		
					taxi = new OggettoTaxi(result.getString(1),
										   result.getString(2),
										   result.getString(3),
										   result.getString(4),
										   result.getString(5));
					flotta.add(taxi);
			}
			//Close connection
			connection.close();
			}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("Error connect.");
			e.printStackTrace();
		}
	}
	
	/*Metodo relativo all'algoritmo per la scelta del taxi da inviare al cliente.
	 * Utilizzo design pattern Mediator.
	 */
	public static void AlgoritmoTaxi()
	{
		//Costruzione ArrayList per i taxi con componente mediator
		Mediator mediator = new ConcreteMediator();
		ArrayList<OggettoTaxi> taxiMediator = new ArrayList<OggettoTaxi>();
		OggettoTaxi taxiMed = null;
		
		for(int i=0; i<20; i++)
		{
			taxiMed = new OggettoTaxi(mediator);//Creazione oggetto taxi con mediatore
			mediator.addCollega(taxiMed);//Aggiungo ad ogni collega(taxi) l'oggetto gestito dal mediatore.
		}
		
		tutti.addAll(flotta); //Aggiungo nell' ArrayList tutti, il contenuto di flotta(i dati dei taxi).
		
		tutti.addAll(taxiMediator); //Tutti gli oggetti adesso saranno gestiti da un mediatore.
		
		for(int i=0; i<tutti.size(); i++)
		{	//Lo stato del taxi ricordiamo sarà pseudocasuale
			if(tutti.get(i).statoTaxi()==true)//Se il taxi nell'ArrayList tutti, sarà libero
			{
				disponibili.add(tutti.get(i));//inseriscilo tra i disponibili
			}
			else
			{
				occupati.add(tutti.get(i));//Sennò sarà occupato
			}
		}
		//Aggiungi nell'ArrayList chiamati il primo taxi dell' ArrayList disponibili.
		chiamati.add(disponibili.get(0));
		
		//Parte relativa al Pattern OBSERVER
		
				Subject subject = new Subject();
				ArrayList<OggettoTaxi> observers = new ArrayList<OggettoTaxi>();
				//OggettoTaxi abb;
				//Soggetto che invia notifica
				/*abb = */new OggettoTaxi(subject);
				//observers.add(abb);
				//aggiungiamo tutti gli osservatori
				observers.addAll(flotta);
				
				
				
				
				/*System.out.println("Taxi occupati:");
				for(int i=0; i<occupati.size(); i++)
				{
					System.out.println(occupati.get(i).getCognome());
				}
				
				System.out.println("\nTaxi disponibili:");
				for(int i=0; i<disponibili.size(); i++)
				{
					System.out.println(disponibili.get(i).getCognome());
				}*/
				
				
				//Creazione oggetto centraleOperativa connessa anch'essa al mediator.
				CentraleOperativa centraleOperativaTaxi = new CentraleOperativa(mediator);
				mediator.registrazioneCentraleOperativa(centraleOperativaTaxi);
				centraleOperativaTaxi.comunicazione(/*"Centrale Operativa:\n-Si richiede comunicazione Cognome Autista relativo a Taxi in partenza, grazie.");//Comunicazione della centrale operativa tramite mediator ai colleghi della flotta."*/);
				
				
				subject.setState(chiamati.get(0).getCognome());
				
				//Aggiungo taxi chiamato tra gli occupati, rimuovo taxi chiamato dai chiamati.
				occupati.add(chiamati.get(0));
				disponibili.remove(disponibili.get(0));
				
				/*System.out.println("Taxi occupati:");
				for(int i=0; i<occupati.size(); i++)
				{
					System.out.println(occupati.get(i).getCognome());
				}
				
				System.out.println("\nTaxi disponibili:");
				for(int i=0; i<disponibili.size(); i++)
				{
					System.out.println(disponibili.get(i).getCognome());
				}*/
	}
	
	//Metodo per la restituzione del taxi in arrivo al cliente con i dati informativi utili a quest' ultimo.
	public static String stampaMessaggioCliente()
	{
		return 	"Dati Taxi in arrivo." + System.lineSeparator() +
				 System.lineSeparator() +
				"Nome autista: " + chiamati.get(0).getNome() + System.lineSeparator() +
				"Cognome autista: " + chiamati.get(0).getCognome()+ System.lineSeparator() +
				"Targa veicolo: " + chiamati.get(0).getTarga()+System.lineSeparator() +
				"Cellulare di riferimento: " + chiamati.get(0).getCellulare() + System.lineSeparator() +
				System.lineSeparator() +
				"AVVISO IMPORTANTE:" + System.lineSeparator() +
				"Restare nel punto indicato come indirizzo di partenza per attendere l'arrivo del nostro Taxi. Grazie e buon viaggio.";
	}
}
