package Ataque;

import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.unidad.UnidadMuertaException;

public interface Atacador extends Posicionable {
	
	public void atacar(Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException;
}
