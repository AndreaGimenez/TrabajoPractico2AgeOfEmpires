package fiuba.algo3.tp2.edificio;

import java.util.Collection;


import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Unidad;
<<<<<<< HEAD
=======
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;
>>>>>>> develop

public abstract class Edificio implements Posicionable {

	private Posicion posicion;
	private Forma forma;
<<<<<<< HEAD
	private Mapa mapa;
	private TipoDeEdificio tipo;
	private GeneradorDeUnidades generadorDeUnidades;
=======
	protected Mapa mapa;
	private int vida;
	private CreadorUnidad creadorUnidades;
>>>>>>> develop
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
<<<<<<< HEAD
	public Edificio(Posicion posicion, Forma forma, TipoDeEdificio tipo, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
=======
	public Edificio(Posicion posicion, CreadorUnidad creadorUnidades, Forma forma, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
>>>>>>> develop
		
		this.mapa = mapa;
		this.forma = forma;
		this.creadorUnidades = creadorUnidades;
		posicionar(posicion);
		this.tipo = tipo;
	}
	
	@Override
	public void posicionar(Posicion coordenada) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Collection<Posicion> coordenadasAOcuparEnMapa = forma.obtenerCoordenadas(coordenada);
		
		for(Posicion coordenadaPosicion : coordenadasAOcuparEnMapa) {
			mapa.posicionar(this, coordenadaPosicion);
		}
		this.posicion = coordenada;
	}
	
	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
	
	@Override
	public void iniciar() {
		
	}
<<<<<<< HEAD
	
	
	public void generarUnidad(Unidad unaUnidad) throws EdificioNoGeneraUnidadException {
		
		generadorDeUnidades.generar(unaUnidad, tipo);
=======

	@Override
	public void recibirDanio(int danio){

		this.vida = this.vida - danio;

	}

	public void reparar(){

	}

	protected void curarVida(int puntosDeSaludPorReparacion) {

		this.vida = this.vida + puntosDeSaludPorReparacion;

	}
	
	public Unidad crear(TipoUnidad tipoUnidad) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		return creadorUnidades.crear(tipoUnidad);
>>>>>>> develop
	}
}
