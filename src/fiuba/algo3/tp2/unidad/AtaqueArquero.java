package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;

public class AtaqueArquero extends Ataque {

	private RangoAtaque rangoAtaque;
	
	public AtaqueArquero() {
		this.rangoAtaque = new RangoAtaqueArquero();
	}
	
	@Override
	public void atacar(Atacador atacador, Unidad unidad) throws AtaqueFueraDeRangoException, UnidadMuertaException {
		
		if(rangoAtaque.estaEnRango(atacador, unidad)){
			
			unidad.recibirDanio(15);
		}
		else {
			throw new AtaqueFueraDeRangoException();
		}
	}
	
	@Override
	public void atacar(Atacador atacador, Edificio edificio) throws AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		if(rangoAtaque.estaEnRango(atacador, edificio)){
			
			edificio.recibirDanio(10);
		}
		else {
			throw new AtaqueFueraDeRangoException();
		}
	}
}
