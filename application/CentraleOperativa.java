package application;

public class CentraleOperativa{

	@SuppressWarnings("unused")
	private Mediator mediator;
	public CentraleOperativa(Mediator mediator)
	{
		this.mediator=mediator;
	}
	
	
	public void comunicazione(/*String msg*/)
	{
		//Messaggio scritto per stamparlo qui, solo a scopo dimostrativo. La propagazione del messaggio è stata creata in ConcreteMediator.
		System.out.println("Centrale Operativa:\n-Si richiede comunicazione Cognome Autista relativo a Taxi in partenza, grazie.");
		//mediator.inviaMessaggio(msg);
	}
}
