package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import Ataque.Atacador;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.RangoAtaque;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;

public class AtaqueCastillo implements AtaqueZona {
	
	private RangoAtaque rangoAtaque;
	private AtacadorZona atacante;
	private Mapa mapa;
	
	
	public AtaqueCastillo(AtacadorZona atacante, Mapa mapa) {
		rangoAtaque = new RangoAtaqueCastillo();
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
		return 20;
	}

	@Override
	public int obtenerDanioEdificio() {
		return 20;
	}
}
