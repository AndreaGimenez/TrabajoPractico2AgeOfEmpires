package Ataque;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;

public interface Atacador extends Posicionable {
	
	public void atacar(Edificio edificio) throws AtaqueFueraDeRangoException, EdificioDestruidoException;
	public void atacar(Unidad unidad) throws AtaqueFueraDeRangoException, UnidadMuertaException;
}
