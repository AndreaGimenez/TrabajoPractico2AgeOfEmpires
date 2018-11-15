package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.Direccion;

public abstract class Unidad implements Movible {

	private Posicion posicion;
	protected Movimiento movimiento;
	private Mapa mapa;
	
	public Unidad(Posicion posicion, Mapa mapa, Movimiento movimiento) throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		this.movimiento = movimiento;
		posicionar(posicion);
	}
	
	@Override
	public void posicionar(Posicion coordenada) throws CeldaOcupadaException, CeldaInexistenteException {
		
		mapa.posicionar(this, coordenada);
		this.posicion = coordenada;
	}
	
	@Override
	public void desplazar(Posicion posicion) throws CeldaOcupadaException, CeldaInexistenteException {
		
		mapa.desplazar(obtenerPosicion(), posicion);
		this.posicion = posicion;
	}
	
	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}

	public Mapa obtenerMapa(){

		return this.mapa;
	}
	
	@Override
	public void mover(Direccion direccion) throws MovimientoInvalidoException {
		movimiento.mover(this, direccion, mapa);
		movimiento = new MovimientoNulo();
	}
	
	@Override
	public void iniciar() {
		movimiento = new MovimientoBasico();
	}
	
	@Override
	public void recibirDanio(int danio) {
		
	}
}
