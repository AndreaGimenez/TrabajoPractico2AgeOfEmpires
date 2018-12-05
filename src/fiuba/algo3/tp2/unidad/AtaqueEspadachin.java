package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.mapa.Atacable;

public class AtaqueEspadachin implements Ataque {

	private RangoAtaque rangoAtaque;
	
	public AtaqueEspadachin() {
		this.rangoAtaque = new RangoAtaqueEspadachin();
	}

	@Override
	public void atacar(Atacador atacador, Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException {
		
		if(rangoAtaque.estaEnRango(atacador, atacable)){
			
			atacable.recibirDanio(this);
		}
		else {
			throw new AtaqueFueraDeRangoException();
		}
	}
	
	@Override
	public int obtenerDanioUnidad() {
		return 25;
	}
	
	@Override
	public int obtenerDanioEdificio() {
		return 15;
	}
}
