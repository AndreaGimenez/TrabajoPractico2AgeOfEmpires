package fiuba.algo3.tp2.juego;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class Jugador {
	
	private static final int POBLACION_MAXIMA = 50;
	
	private int oro;
	private int poblacion;
	private Collection<Posicionable> edificios ;
	private Collection<Posicionable> unidades ;
	private Collection<Aldeano> recolectoresOro;
	
	private Turno turno;

	public Jugador() {
		
		this.edificios = new LinkedList<>();
		this.unidades = new LinkedList<>();
		this.recolectoresOro = new LinkedList<>();
		this.oro = 0;
		this.poblacion = 0;
		
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
			
			if(this.oro >= unidad.costo()) {
				this.oro = this.oro - unidad.costo();
			}
			else {
				throw new OroInsuficienteException();
			}
		}
		
		this.unidades.add(unidad);
		poblacion += 1;

		if(unidad instanceof Aldeano) {
			this.recolectoresOro.add((Aldeano) unidad);
		}
	}

	public void agregarEdificio(Edificio edificio) {

		this.edificios.add(edificio);

		this.oro = this.oro - edificio.costo();

	}

	public void setOro(int oroInicial) {
		
		this.oro = oroInicial;	
		
	}
	
	public int obtenerOro() {
		this.oro += recolectarOroDelTurno();
		return this.oro;		
	}

	private int recolectarOroDelTurno() {
		int oroDelTurno = 0;
		for(Aldeano aldeanoActual : recolectoresOro) {
			//System.out.println(aldeanoActual.recolectarOro());
			oroDelTurno += aldeanoActual.recolectarOro();
		}
		return oroDelTurno;
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

}
