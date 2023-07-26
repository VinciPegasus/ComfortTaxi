package application;

import java.util.Random;

public class OggettoTaxi extends Observer implements Comando{
//Dichiarazione variabili e dichiarazione variabile mediator
	private String id;
	private String cognome;
	private String nome;
	private String targa;
	private String cellulare;
	protected Mediator mediator;
	
	//Costruttore oggetto Taxi con parametri ed incapsulamenti.
	OggettoTaxi(String id, String cognome, String nome, String targa, String cellulare)
	{
		this.id=id;
		this.cognome=cognome;
		this.nome= nome;
		this.targa=targa;
		this.cellulare=cellulare;
	}
	
	
	public String getId()
	{
		return id;
	}
	public String getCognome()
	{
		return cognome;
	}
	public String getNome()
	{
		return nome;
	}
	public String getTarga()
	{
		return targa;
	}
	public String getCellulare()
	{
		return cellulare;
	}
	
	/*Dichiarazione pseudorandom relativa allo stato del taxi.
	 * Creato oggetto random. Se true, il taxi risulterà libero.
	 * False, sarà occupato.
	 */
	public boolean statoTaxi()
	{
		Random state= new Random();
		return state.nextBoolean();
	}
	
	//Costruttore OggettoTaxi relativo all'utilizzo del pattern Mediator.
	public OggettoTaxi(Mediator mediator)
	{
		this.mediator=mediator;
		mediator.setStatoOrdine(true);/*Il parametro boolean di stato del mediator sarà True alla richiesta del cliente, mi servirà
		 * a breve per fare una comparazione con lo stato del Taxi.
		 */
	}

	//Metodo per la verifica della disponibilità dei taxi.
	@Override
	public boolean richiestaDisponibilita()
	{
		if (mediator.getStatoOrdine()==statoTaxi())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Non Stamperò questo metodo, è solo per farmi capire se il messaggio viene ricevuto da tutti i colleghi, è dimostrativo ed è giusto che ci sia.
	public void ricevuto(String msg)
	{
		System.out.println(this.cognome + ": -Messaggio Ricevuto.");
	}
	
	//Parte della classe dedicata al Design Pattern OBSERVER
	//
	public OggettoTaxi(Subject subject)
	{
		this.subject=subject;
		this.subject.addObserver(this);
	}
	
	
	//Aggiornamento del taxi in partenza
	@Override
	public void aggiorna()
	{
		System.out.println("Messaggio dal Collega in partenza al gruppo.\n-In partenza AUTISTA: " + String.valueOf((subject.getState())));
	}
}
