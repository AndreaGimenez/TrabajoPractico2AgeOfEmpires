package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.unidad.Atacador;

public class AtaqueNuloCastillo implements AtaqueZona {

	public void atacar(Atacador atacador, Atacable atacable) throws AtaqueFueraDeRangoException, UnidadMuertaException,
			EdificioDestruidoException, AtaqueInvalidoException {

		throw new AtaqueInvalidoException();
	}

	@Override
	public int obtenerDanioUnidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerDanioEdificio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void atacar() throws AtaqueInvalidoException {
		// TODO Auto-generated method stub
		throw new AtaqueInvalidoException();
	}

	
}
