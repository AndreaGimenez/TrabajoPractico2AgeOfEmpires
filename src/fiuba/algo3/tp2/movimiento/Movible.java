package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;

public interface Movible extends Posicionable{

	public void mover(Direccion direccion) throws MovimientoInvalidoException, CeldaOcupadaException, CeldaInexistenteException;
	public void desplazar(Posicion posicion) throws CeldaOcupadaException, CeldaInexistenteException;
}
