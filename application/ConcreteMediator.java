package application;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator{

	private List<OggettoTaxi> colleghi;	
	private boolean stato;
	
	public ConcreteMediator()
	{
		this.colleghi=new ArrayList<>();
	}
	
	public void addCollega(OggettoTaxi collega)
	{
		this.colleghi.add(collega);
	}
	
	@Override
	public void setStatoOrdine(Boolean stato)
	{
		this.stato=stato;
	}

	@Override
	public boolean getStatoOrdine()
	{
		return stato;
	}

	@SuppressWarnings("unused")//Soppressione Warning per la prossima istruzione: Per Il valore del campo CentraleOperativa.mediator non usato
	private CentraleOperativa centraleOperativa;
	
	@Override
	public void registrazioneCentraleOperativa(CentraleOperativa centraleOperativa)
	{
		this.centraleOperativa=centraleOperativa;
	}


	/*@Override
	public void inviaMessaggio(String msg)
	{
		for(OggettoTaxi i : this.colleghi)
		{
			i.ricevuto(msg);
		}
	}*/

}
