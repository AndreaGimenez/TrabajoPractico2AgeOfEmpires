package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.RangoAtaque;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;

public class AtaqueCastillo implements AtaqueZona {
	
	private RangoAtaque rangoAtaque;
	private Posicionable atacante;
	private Mapa mapa;
	
	
	public AtaqueCastillo(Castillo atacante, Mapa mapa) {
		rangoAtaque = new RangoAtaqueCastillo();
		this.atacante = atacante;
		this.mapa = mapa;
	}

	@Override
	public void atacar() {
		
		Collection<Posicionable> posicionablesEnRango = mapa.obtenerPosicionables(rangoAtaque.obtenerPosicionesRango(atacante));
		
		for(Posicionable posicionableEnRango : posicionablesEnRango) {
			try {
				posicionableEnRango.recibirDanio(20);
			}catch(EdificioDestruidoException | UnidadMuertaException e) {}
		}
	}
}
