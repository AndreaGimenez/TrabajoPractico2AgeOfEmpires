package fiuba.algo3.tp2.unidad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.generacionDeUnidades.Generable;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.movimiento.Direccion;
import fiuba.algo3.tp2.movimiento.Movible;
import fiuba.algo3.tp2.movimiento.Movimiento;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.movimiento.MovimientoNulo;
import fiuba.algo3.tp2.vida.VidaUnidad;

public abstract class Unidad extends Observable implements Movible, Posicionable, Atacable, Generable {

	protected Posicion posicion;
	protected Movimiento movimiento;
	protected Forma forma;
	protected int costoGeneracion;
	private VidaUnidad vida;
	protected Mapa mapa;
	
	
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
		return vida.obtenerVida();
	}

	public int obtenerVidaMaxima() {
		return vida.obtenerVidaMaxima();
	}
	
	@Override
	public void mover(Direccion direccion) throws MovimientoInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		Posicion posicionaAnterior = this.posicion;
		movimiento.mover(this, direccion, mapa);
		movimiento = new MovimientoNulo();
		
		setChanged();
		notifyObservers(posicionaAnterior);
	}

	public void iniciar() {
		movimiento = new MovimientoBasico();
	}
	
	@Override
	public void recibirDanio(Ataque ataque) {
		vida.restarVida(ataque.obtenerDanioUnidad());
		
		setChanged();
		notifyObservers(this.vida);
	}
	
	public boolean estaMuerta() {
		return vida.estaMuerta();
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
	
	@Override
	public void liberarCeldas(Mapa mapa) {
		
		Collection<Posicion>posicionesOcupadas = this.obtenerPosicionesOcupadasEnMapa();
		
		for(Posicion posicionActual : posicionesOcupadas) {
			mapa.obtenerCelda(posicionActual).liberar();
		}
	}
}
