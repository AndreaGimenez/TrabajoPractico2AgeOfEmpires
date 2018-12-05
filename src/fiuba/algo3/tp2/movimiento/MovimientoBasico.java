package fiuba.algo3.tp2.movimiento;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;

public class MovimientoBasico implements Movimiento {

	private int velocidadMovimiento = 1;
	
	@Override
	public void mover(Movible movible, Direccion direccion, Mapa mapa) throws MovimientoInvalidoException {
		
		Posicion coordenada = direccion.multiplicar(velocidadMovimiento);
		try {
			movible.desplazar(movible.obtenerPosicion().sumar(coordenada));
		} catch (CeldaOcupadaException | CeldaInexistenteException e) {
			throw new MovimientoInvalidoException();
		}
	}
}
