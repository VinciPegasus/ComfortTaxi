package application;

/*Interfaccia Mediator. Servirà a sviluppare la classe conreta ove utilizzerò
 * questi seguenti metodi con riscrizione degli stessi per mediare la comunicazione tra
 * i diversi soggetti.
 */

public interface Mediator {
		
	public void addCollega(OggettoTaxi collega);
	void setStatoOrdine(Boolean stato);
	public boolean getStatoOrdine();
	public void registrazioneCentraleOperativa(CentraleOperativa centraleOperativa);
	//public void inviaMessaggio(String msg);
}
