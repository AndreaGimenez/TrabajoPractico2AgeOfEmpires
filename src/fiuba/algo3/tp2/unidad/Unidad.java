package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.movimiento.Direccion;

public abstract class Unidad implements Movible {

	private Posicion posicion;
	private Movimiento movimiento;
	private Mapa mapa;
	
	public Unidad(Posicion posicion, Mapa mapa, Movimiento movimiento) throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		posicionar(posicion, mapa);
		this.movimiento = movimiento;
	}
	
	@Override
	public void posicionar(Posicion coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		mapa.posicionar(this, coordenada);
		this.posicion = coordenada;
	}
	
	@Override
	public void desplazar(Posicion posicion, Mapa mapa) throws CeldaOcupadaException {
		mapa.desplazar(obtenerPosicion(), posicion);
		this.posicion = posicion;
	}
	
	
	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
	
	@Override
	public void mover(Direccion direccion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {

		movimiento.mover(this, direccion, mapa);
	}
}
