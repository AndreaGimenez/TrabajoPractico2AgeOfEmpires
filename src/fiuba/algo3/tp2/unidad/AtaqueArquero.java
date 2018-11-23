package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
import fiuba.algo3.tp2.mapa.Atacable;

public class AtaqueArquero implements Ataque {

	private RangoAtaque rangoAtaque;
	
	public AtaqueArquero() {
		this.rangoAtaque = new RangoAtaqueArquero();
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
		return 15;
	}
	
	@Override
	public int obtenerDanioEdificio() {
		return 10;
	}
}
