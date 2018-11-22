package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;

public class AtaqueArmaAsedio extends Ataque {

	private RangoAtaque rangoAtaque;
	
	public AtaqueArmaAsedio() {
		rangoAtaque = new RangoAtaqueArmaAsedio();
	}
	
	@Override
	public void atacar(Atacador atacador, Unidad unidad) 
			throws AtaqueFueraDeRangoException, UnidadMuertaException {
		throw new UnidadNoAtacableException();
	}
	
	@Override
	public void atacar(Atacador atacador, Edificio edificio)
			throws AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		if(rangoAtaque.estaEnRango(atacador, edificio)){
			
			edificio.recibirDanio(75);
		}
		else {
			throw new AtaqueFueraDeRangoException();
		}
	}

}
