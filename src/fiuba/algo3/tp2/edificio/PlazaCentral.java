package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.construccion.Constructor;
import fiuba.algo3.tp2.construccion.Construible;
import fiuba.algo3.tp2.construccion.EstadoConstruccion;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.formas.FormaPlazaCentralRectangulo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.ReparacionDesactivada;

public class PlazaCentral extends Edificio implements Construible{
	
	private static final int VIDA_MAXIMA = 450;
	private static final int SALUD_RECUPERADA_POR_TURNO = 25;
	private static final int COSTO_CONSTRUCCION = 100;
	private static final int  TURNOS_CONSTRUCCION = 3;
	
	private EstadoConstruccion estadoConstruccion;
	private Constructor constructor;
	 
	public PlazaCentral(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaPlazaCentralRectangulo(), new ReparacionDesactivada(), VIDA_MAXIMA, SALUD_RECUPERADA_POR_TURNO, COSTO_CONSTRUCCION, mapa);
		
		this.estadoConstruccion = new EstadoConstruccion(this, TURNOS_CONSTRUCCION); 

	}


	@Override
	public void actualizarEstadoParaSiguienteTurno() {
		this.generable = null;
	}
	
	@Override
	public void avanzarConstruccion() {
		estadoConstruccion.avanzarConstruccion();
	}
	
	@Override
	public boolean estaConstruido() {
		return estadoConstruccion.estaConstruido();
	}

	@Override
	public void asignarConstructor(Constructor constructor) {
		this.constructor = constructor;
		
	}


	@Override
	public boolean verificarConstructor(Constructor constructor) {
		
		return (this.constructor == constructor);
	}


	@Override
	public boolean estaEnElContornoDe(Constructor constructor) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void liberarCeldas(Mapa mapa) {
		Collection<Posicion>posicionesOcupadas = this.obtenerPosicionesOcupadasEnMapa();

		for(Posicion posicionActual : posicionesOcupadas) {
			mapa.obtenerCelda(posicionActual).liberar();
		}
	}
}
