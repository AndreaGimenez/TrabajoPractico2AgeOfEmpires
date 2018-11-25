package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
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
