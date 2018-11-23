package fiuba.algo3.tp2.juego;

import java.util.Collection;
import java.util.LinkedList;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class Jugador {
	
	private int oro;
	private Collection<Posicionable> edificios ;
	private Collection<Posicionable> unidades ;
	private Collection<Aldeano> recolectoresOro;
	private int poblacion;

	public Jugador() {
		
		this.edificios = new LinkedList<>();
		this.unidades = new LinkedList<>();
		this.recolectoresOro = new LinkedList<>();
		this.oro = 0;
		this.poblacion = 0;
	}

	public LinkedList<Posicionable> obtenerPosicionables() {

		LinkedList<Posicionable> posicionables = new LinkedList<>();

		posicionables.addAll(this.edificios);

		posicionables.addAll(this.unidades);

		return posicionables;

	}

	public void agregarUnidad(Unidad unidad) {

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
			oroDelTurno += aldeanoActual.recolectarOro();
		}
		return oroDelTurno;
	}

	public int obtenerPoblacionActual() {
		return poblacion;
	}

	public void removerUnidad(Unidad unidadARemover, Mapa mapa) {
		unidades.remove(unidadARemover);
		mapa.obtenerCelda(unidadARemover.obtenerPosicion()).liberar();
		poblacion -=1;
	} 

}
