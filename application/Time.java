package application;

/*Classe per il controllo e lo sviluppo dell'algoritmo riguardante alla dinamica dell' orologio,
 *dopo aver avuto il ritorno dell'orario locale. 
 */

public class Time {
	
	private int ora;
	private int minuto;
	private int secondo;

	//Costruttore con parametri
	public Time(int ora, int minuto, int secondo)
	{
		this.ora = ora;
		this.minuto = minuto;
		this.secondo = secondo;
	}

	//Costruttore di inserimento numeri interi(ora,minuto,secondo) in stringa time.
	public Time(String currentTime)
	{
		//Costruzione della stringa
		String[] time = currentTime.split(":");//Divisione stringa con ":"
		//Per contenere i numeri interi nelle stringhe, faacciamo utilizzo di classi Wrapper
		ora= Integer.parseInt(time[0]);
		minuto = Integer.parseInt(time[1]);
		secondo = Integer.parseInt(time[2]);
	}
	
	public String getCurrentTime()
	{
		return ora + ":" + minuto;
	}

	public void unSecondoPassa()
	{
		secondo++;
		if(secondo == 60)
		{
			minuto++;
			secondo = 0;
			if(minuto == 60)
			{
				ora++;
				minuto = 0;
				if(ora == 24)
				{
					ora = 0;
				}
			
			}
		}
	}
}