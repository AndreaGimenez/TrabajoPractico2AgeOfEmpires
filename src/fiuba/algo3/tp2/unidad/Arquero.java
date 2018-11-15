package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.formas.FormaAldeanoRectangulo;
import fiuba.algo3.tp2.formas.FormaArqueroRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.mapa.Mapa;

public class Arquero extends Unidad {

	public Arquero(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		super(posicion, mapa, new MovimientoBasico(), new FormaArqueroRectangulo());
	}
}
