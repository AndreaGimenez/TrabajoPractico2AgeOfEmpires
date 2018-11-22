package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;

public class AtaqueEspadachin extends Ataque {

	private RangoAtaque rangoAtaque;
	
	
	public AtaqueEspadachin() {
		this.rangoAtaque = new RangoAtaqueEspadachin();
	}
	
	@Override
	public void atacar(Atacador atacador, Unidad unidad) throws AtaqueFueraDeRangoException, UnidadMuertaException {
		
		if(rangoAtaque.estaEnRango(atacador, unidad)){
			
			unidad.recibirDanio(25);
		}
		else {
			throw new AtaqueFueraDeRangoException();
		}
	}

	@Override
	public void atacar(Atacador atacador, Edificio edificio) throws AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		if(rangoAtaque.estaEnRango(atacador, edificio)){
			
			edificio.recibirDanio(15);
		}
		else {
			throw new AtaqueFueraDeRangoException();
		}
	}
}
