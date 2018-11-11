package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.movimiento.Direccion;

public class MovimientoBasico implements Movimiento {

	private int velocidadMovimiento = 1;
	
	@Override
	public void mover(Movible movible, Direccion direccion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Coordenada coordenada = direccion.multiplicar(velocidadMovimiento);
		movible.desplazar(movible.obtenerPosicion().sumar(coordenada), mapa);
	}
}
