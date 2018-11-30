package fiuba.algo3.tp2.juego;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class Jugador {
	
	private static final int POBLACION_MAXIMA = 50;
	private static final int ORO_INICIAL = 100;
	
	private int oro;
	private int poblacion;
	private Collection<Posicionable> edificios ;
	private Collection<Posicionable> unidades ;
	private Collection<Aldeano> recolectoresOro;
	
	private Turno turno;
	private String nombre;

	public Jugador(String nombre) {
		
		this.edificios = new LinkedList<>();
		this.unidades = new LinkedList<>();
		this.recolectoresOro = new LinkedList<>();
		this.oro = ORO_INICIAL;
		this.poblacion = 0;
		this.nombre = nombre;
		
		this.turno = new Turno(this);
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
			
			this.oro = this.oro - edificio.costo();
			
			if(this.oro >= edificio.costo()) {
				this.oro = this.oro - edificio.costo();
			}
			else {
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
		mapa.obtenerCelda(unidadARemover.obtenerPosicion()).liberar();
		poblacion -=1;
	}

	public void avanzarTurno() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		turno.avanzar();
	}

	public String obtenerNombre() {
		return nombre;
	}

	public boolean castilloDestruido() {

		return this.obtenerCastillo().estaDestruido();

	}

	private Castillo obtenerCastillo() {

		return (Castillo) this.obtenerPosicionables().getFirst();

	}
}
