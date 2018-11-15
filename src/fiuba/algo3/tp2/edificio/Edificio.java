package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public abstract class Edificio implements Posicionable {

	private Posicion posicion;
	private Forma forma;
	protected Mapa mapa;
	protected int vida;
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
	public Edificio(Posicion posicion, Forma forma, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		this.forma = forma;
		this.vida = EdificioConstants.VIDA_MAXIMA ;
		posicionar(posicion);
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

	@Override
	public void recibirDanio(int danio){

		this.vida = this.vida - danio;

	}

	public abstract void reparar() throws EdificioNoAptoParaReparacionException;

	protected void curarVida(int puntosDeSaludPorReparacion) {

		this.vida = this.vida + puntosDeSaludPorReparacion;
	}

}
