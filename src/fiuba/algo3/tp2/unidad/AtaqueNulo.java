package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.mapa.Atacable;

public class AtaqueNulo implements Ataque {

	@Override
	public void atacar(Atacador atacador, Atacable atacable)
			throws AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

	@Override
	public int obtenerDanioUnidad() {
		return 0;
	}

	@Override
	public int obtenerDanioEdificio() {
		return 0;
	}

}
