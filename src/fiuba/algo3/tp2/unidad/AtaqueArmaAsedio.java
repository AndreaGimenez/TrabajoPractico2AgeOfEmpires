package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;

public class AtaqueArmaAsedio implements Ataque {

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
		return 75;
	}
}
