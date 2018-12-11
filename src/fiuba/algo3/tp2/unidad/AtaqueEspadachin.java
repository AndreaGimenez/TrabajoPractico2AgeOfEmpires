package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.mapa.Atacable;

public class AtaqueEspadachin implements Ataque {
	
	private static final int DANIO_UNIDAD = 25;
	private static final int DANIO_EDIFICIO = 15;
	
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
		return DANIO_UNIDAD;
	}
	
	@Override
	public int obtenerDanioEdificio() {
		return DANIO_EDIFICIO;
	}
}
