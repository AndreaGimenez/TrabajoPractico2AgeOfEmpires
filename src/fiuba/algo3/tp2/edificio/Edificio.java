package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.reparacion.Reparacion;
import fiuba.algo3.tp2.reparacion.ReparacionActivada;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public abstract class Edificio implements Posicionable {

	private Posicion posicion;
	protected Reparacion reparacion;
	private Forma forma;
	protected Mapa mapa;
	int vida;
	int puntosDeRecuperacion;
	int topeDeVida;
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
	public Edificio(Posicion posicion, Forma forma, Reparacion reparacion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		this.forma = forma;
		this.reparacion = reparacion;
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
    public void siguienteAccion() throws EdificioNoAptoParaReparacionException {

	    try{

            this.reparar();

        } catch (EdificioNoAptoParaReparacionException e){

        }

    }

	public void reparar() throws EdificioNoAptoParaReparacionException{
		reparacion.reparar(this);
	}

    protected void puntosDeVida(int vidaMaxima) {

		this.vida = vidaMaxima;

		this.topeDeVida = this.vida;
    }

	public void recibirDanio(int danio) {

        this.reparacion = new ReparacionActivada();

		this.vida = this.vida - danio;

	}

	public int obtenerVida(){

		return this.vida;

	}

    public void curar(){

	    if(this.vida > this.topeDeVida - this.puntosDeRecuperacion)
	        this.vida = this.topeDeVida;
	    else
	        this.vida = this.vida + this.puntosDeRecuperacion;

    }

    protected void establecerSaludRecuperadaPorTurno(int puntosDeRecuperacion){

        this.puntosDeRecuperacion = puntosDeRecuperacion;

    }
}
