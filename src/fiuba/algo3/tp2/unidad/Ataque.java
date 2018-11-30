package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.mapa.Atacable;

public interface Ataque {

	public void atacar(Atacador atacador, Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException;
	public int obtenerDanioUnidad();
	public int obtenerDanioEdificio();
}
