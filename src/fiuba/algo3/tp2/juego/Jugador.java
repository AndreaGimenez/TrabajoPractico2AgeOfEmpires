package fiuba.algo3.tp2.juego;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class Jugador {
	
	private static final int POBLACION_MAXIMA = 50;
	private static final int ORO_INICIAL = 100;
	
	private int oro;
	private int poblacion;
	private Mapa mapa;
	private Collection<Posicionable> edificios ;
	private Collection<Posicionable> unidades ;
	private Collection<Aldeano> recolectoresOro;
	
	private Turno turno;
	private String nombre;

	public Jugador(String nombre, Mapa mapa) {
		
		this.edificios = new LinkedList<>();
		this.unidades = new LinkedList<>();
		this.recolectoresOro = new LinkedList<>();
		this.oro = ORO_INICIAL;
		this.poblacion = 0;
		this.nombre = nombre;
		this.mapa = mapa;
		
		this.turno = new Turno(this, mapa);
	}

	public LinkedList<Posicionable> obtenerPosicionables() {

		LinkedList<Posicionable> posicionables = new LinkedList<>();

		posicionables.addAll(this.edificios);

		posicionables.addAll(this.unidades);

		return posicionables;
	}
	
	public void agregarUnidad(Unidad unidad, Mapa mapa) throws PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		agregarUnidad(unidad, mapa, true);
	}

	public void agregarUnidad(Unidad unidad, Mapa mapa, boolean verificarRecursos) 
			throws PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		if(verificarRecursos) {
			if(poblacion == POBLACION_MAXIMA) {
				removerUnidad(unidad, mapa);
				throw new PoblacionMaximaAlcanzadaException();
			}
			
			if(this.oro >= unidad.obtenerCosto()) {
				this.oro = this.oro - unidad.obtenerCosto();
			}
			else {
				removerUnidad(unidad, mapa);
				throw new OroInsuficienteException();
			}
		}
		
		this.unidades.add(unidad);
		poblacion += 1;
		
		//this.oro = oro - unidad.obtenerCosto();

		if(unidad instanceof Aldeano) {
			this.recolectoresOro.add((Aldeano) unidad);
		}
	}

	public void agregarEdificio(Edificio edificio) throws OroInsuficienteException {
	
		agregarEdificio(edificio, true);
	}
	
	public void agregarEdificio(Edificio edificio, boolean checkearRecursos) throws OroInsuficienteException {
		
		if(checkearRecursos) {

			if(this.oro >= edificio.costo()) {
				this.oro = this.oro - edificio.costo();
			}
			else {
				
				Collection<Posicion> posicionesQueOcupa = edificio.obtenerPosicionesOcupadasEnMapa();
				for(Posicion posicionActual : posicionesQueOcupa) {
					mapa.obtenerCelda(posicionActual).liberar();
				}
				
				throw new OroInsuficienteException();
			}
		}
		
		this.edificios.add(edificio);
	}

	public int obtenerOro() {
		return oro;	
	}
	
	public void sumarOroDelTurno() {
		int oroDelTurno = 0;
		for(Aldeano aldeanoActual : recolectoresOro) {
			oroDelTurno += aldeanoActual.recolectarOro();
		}
		this.oro += oroDelTurno;
	}

	public int obtenerPoblacionActual() {
		return poblacion;
	}

	public void removerUnidad(Unidad unidadARemover, Mapa mapa) {
		unidades.remove(unidadARemover);
		recolectoresOro.remove(unidadARemover);
		unidadARemover.liberarCeldas(mapa);
		poblacion -=1;
	}

	public void avanzarTurno() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		turno.avanzar();
	}

	public String obtenerNombre() {
		return nombre;
	}

	public boolean castilloDestruido() {

		return this.obtenerCastillo().estaDestruido();

	}

	public Castillo obtenerCastillo() {

		return (Castillo) this.obtenerPosicionables().getFirst(); 

	}
	
	public boolean posicionablePerteneceAJugador(Posicionable posicionable) {
		
		return (posicionable != null && (edificios.contains(posicionable) || unidades.contains(posicionable)));
	}

	public void removerEdificio(Edificio edificio, Mapa mapa) {
		edificios.remove(edificio);
		mapa.obtenerCelda(edificio.obtenerPosicion()).liberar();
	}
}
