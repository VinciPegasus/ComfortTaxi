package application;

//Definito per Pattern Observer
import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private String state;
	
	public void setState(String state)
	{
		this.state=state;
		notificaATuttiGliOsservatori();
	}
	
	public String getState()
	{
		return state;
	}
	//Aggiungi osservatore
	public void addObserver(Observer observer)
	{
		observers.add(observer);
	}
	//Rimuovi osservetore
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}
	/*Aggiornamento a tutti gli osservatori(colleghi)dall' osservato(taxi in partenza.
	 * attraverso la classe subject.
	 */
	public void notificaATuttiGliOsservatori()
	{
		for (Observer observer : observers)
		{
			observer.aggiorna();
		}
	}
}
