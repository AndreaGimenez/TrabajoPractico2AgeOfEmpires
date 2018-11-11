package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.movimiento.Direccion;

public abstract class Unidad implements Movible {

	protected Coordenada posicion;
	protected Movimiento movimiento;
	
	public Unidad(Coordenada posicion, Mapa mapa, Movimiento movimiento) throws CeldaOcupadaException, CeldaInexistenteException {
		posicionar(posicion, mapa);
		this.movimiento = movimiento;
	}
	
	@Override
	public void posicionar(Coordenada coordenada, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		mapa.posicionar(this, coordenada);
		this.posicion = coordenada;
	}
	
	@Override
	public void desplazar(Coordenada posicion, Mapa mapa) throws CeldaOcupadaException {
		mapa.desplazar(obtenerPosicion(), posicion);
		this.posicion = posicion;
	}
	
	
	@Override
	public Coordenada obtenerPosicion() {
		return posicion;
	}
	
	@Override
	public void mover(Direccion direccion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {

		movimiento.mover(this, direccion, mapa);
	}
}
