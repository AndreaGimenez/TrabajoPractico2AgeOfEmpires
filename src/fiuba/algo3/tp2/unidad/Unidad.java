package fiuba.algo3.tp2.unidad;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.ivy.core.settings.Validatable;

import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.movimiento.Movimiento;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.movimiento.MovimientoNulo;
import fiuba.algo3.tp2.vida.Vida;
import fiuba.algo3.tp2.vida.VidaUnidad;

public abstract class Unidad implements Movible, Posicionable, Atacable {

	protected Posicion posicion;
	protected Movimiento movimiento;
	protected Forma forma;
	protected Vida vida;
	protected int costoGeneracion;
	private Mapa mapa;
	
	
	public Unidad(Posicion posicion, Mapa mapa, Movimiento movimiento, Forma forma, int vidaMaxima, int costoGeneracion)
				throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		this.movimiento = movimiento;
		this.forma = forma;
		this.vida = new VidaUnidad(vidaMaxima);
		this.costoGeneracion = costoGeneracion;
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
	
	@Override
	public Collection<Posicion> obtenerPosicionesOcupadasEnMapa(){
		
		Collection<Posicion> posiciones = new ArrayList<Posicion>();
		posiciones.add(posicion);
		return posiciones;
	}

	public Mapa obtenerMapa(){

		return this.mapa;
	}
	
	public int obtenerVida() {
		
		return vida.obtenerVidaActual();
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
	public void recibirDanio(Ataque ataque) {
		
		this.vida.recibirDanio(ataque);		
	}
	
	protected boolean estaEnElRango(Posicionable posicionable) {
		
		boolean estaEnElRango = false;
		Collection<Posicion> aledanias = obtenerPosicionesAledanias();
		
		for(Posicion posicion : aledanias) {
			if(posicion.getX() == posicionable.obtenerPosicion().getX() && 
					posicion.getY() == posicionable.obtenerPosicion().getY()) {
				estaEnElRango = true;
			}
		}
		return estaEnElRango;
	}
	
	private Collection<Posicion> obtenerPosicionesAledanias() {
		
		return forma.obtenerPosicionesContorno(obtenerPosicion());
	}

	public int obtenerCosto() {
		return this.costoGeneracion;
	}
}
