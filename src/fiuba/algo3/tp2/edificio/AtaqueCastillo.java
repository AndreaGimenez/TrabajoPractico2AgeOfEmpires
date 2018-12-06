package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Atacador;
import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.RangoAtaque;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;

public class AtaqueCastillo implements AtaqueZona {
	
	private static final int DANIO_UNIDAD = 20;
	private static final int DANIO_EDIFICIO = 20;
	
	private RangoAtaque rangoAtaque;
	private AtacadorZona atacante;
	private Mapa mapa;
	
	
	public AtaqueCastillo(AtacadorZona atacante, Mapa mapa) {
		rangoAtaque = new RangoAtaqueCastillo(mapa);
		this.atacante = atacante;
		this.mapa = mapa;
	}

	@Override
	public void atacar() {
		
		Collection<Posicionable> posicionablesEnRango = mapa.obtenerPosicionables(rangoAtaque.obtenerPosicionesRango(atacante));
		
		for(Posicionable posicionableEnRango : posicionablesEnRango) {
			try {
				if(posicionableEnRango instanceof Atacable) {
					((Atacable)posicionableEnRango).recibirDanio(this);
				}
				
			}catch(EdificioDestruidoException | UnidadMuertaException e) {}
		}
	}

	@Override
	public void atacar(Atacador atacador, Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException {
		
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
