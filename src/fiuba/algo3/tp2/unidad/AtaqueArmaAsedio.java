package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.excepciones.UnidadNoAtacableException;
import fiuba.algo3.tp2.mapa.Atacable;

public class AtaqueArmaAsedio implements Ataque {
	
	private static final int DANIO_EDIFICIO = 75;
	
	private RangoAtaque rangoAtaque;
	
	public AtaqueArmaAsedio() {
		rangoAtaque = new RangoAtaqueArmaAsedio();
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
		throw new UnidadNoAtacableException();
	}
	
	@Override
	public int obtenerDanioEdificio() {
		return DANIO_EDIFICIO;
	}
}
