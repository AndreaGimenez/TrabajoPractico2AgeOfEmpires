package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.reparacion.Reparacion;
import fiuba.algo3.tp2.excepciones.reparacion.ReparacionActivada;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.vida.Vida;
import fiuba.algo3.tp2.vida.VidaEdificio;

public abstract class Edificio implements Posicionable, Atacable {

	private Posicion posicion;
	protected Reparacion reparacion;
	private Forma forma;
	protected Mapa mapa;
	private Aldeano aldeanoAsignadoParaReparar;
	private Vida vida;
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
	public Edificio(Posicion posicion, Forma forma, Reparacion reparacion, int vidaMaxima, int saludRecuperadaPorTurno, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		this.forma = forma;
		this.reparacion = reparacion;
		this.vida = new VidaEdificio(vidaMaxima, saludRecuperadaPorTurno);
		posicionar(posicion);
	}

	public Edificio() {

	}

	@Override
	public void posicionar(Posicion posicion) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Collection<Posicion> posicionesAOcuparEnMapa = forma.obtenerPosiciones(posicion);
		for(Posicion posicionAOcupar : posicionesAOcuparEnMapa) {
			mapa.posicionar(this, posicionAOcupar);
		}
		this.posicion = posicion;
	}
	
	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
	
	@Override
	public Collection<Posicion> obtenerPosicionesOcupadasEnMapa(){
		
		return forma.obtenerPosiciones(posicion);
	}
	
	@Override
	public void iniciar() {
		
	}

	@Override
    public void actualizarEstadoParaSiguienteTurno() {

    }

	public void reparar() throws EdificioNoAptoParaReparacionException{
		reparacion.reparar(this);
	}
	
	@Override
	public void recibirDanio(Ataque ataque) {
		
        this.reparacion = new ReparacionActivada();
        
        this.vida.recibirDanio(ataque);
	}

	public int obtenerVida(){

		return this.vida.obtenerVidaActual();

	}

    public void curar(){
    	
    	vida.curar();
    }

	public void enReparacionPorAldeano(Aldeano aldeano){

	    this.aldeanoAsignadoParaReparar = aldeano;


	}

    public boolean verificarReparador(Aldeano aldeano){

	    return (this.aldeanoAsignadoParaReparar == aldeano);
    }

	public abstract int costo();

	public abstract boolean estaReparado();
}
