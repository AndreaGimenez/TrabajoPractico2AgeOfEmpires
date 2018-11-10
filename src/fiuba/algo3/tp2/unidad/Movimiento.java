package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.movimiento.Direccion;

public interface Movimiento {

	public void mover(Movible movimiento, Direccion direccion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException;

}
