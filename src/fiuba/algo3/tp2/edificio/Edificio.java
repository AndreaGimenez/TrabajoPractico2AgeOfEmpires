package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.reparacion.Reparacion;
import fiuba.algo3.tp2.reparacion.ReparacionActivada;
import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.vida.VidaEdificio;

public abstract class Edificio implements Posicionable, Atacable {

	private Posicion posicion;
	protected Reparacion reparacion;
	private Forma forma;
	protected Mapa mapa;
	private Aldeano aldeanoAsignadoParaReparar;
	private VidaEdificio vida;
	private int costoConstruccion;
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
	public Edificio(Posicion posicion, Forma forma, Reparacion reparacion, int vidaMaxima, int puntosDeRecuperacionPorTurno, int costoConstruccion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		this.forma = forma;
		this.reparacion = reparacion;
		this.vida = new VidaEdificio(vidaMaxima, puntosDeRecuperacionPorTurno);
		this.costoConstruccion = costoConstruccion;
		posicionar(posicion);
	}
	
	public Edificio() {
		
	}

    public abstract void actualizarEstadoParaSiguienteTurno();
    
	public void posicionar(Posicion posicion) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Collection<Posicion> posicionesAOcuparEnMapa = forma.obtenerPosiciones(posicion);
		for(Posicion posicionAOcupar : posicionesAOcuparEnMapa) {
			mapa.posicionar(this, posicionAOcupar);
		}
		this.posicion = posicion;
	}

	public Posicion obtenerPosicion() {
		return posicion;
	}

	public Collection<Posicion> obtenerPosicionesOcupadasEnMapa(){
		
		return forma.obtenerPosiciones(posicion);
	}

	public void reparar() throws EdificioNoAptoParaReparacionException{
		reparacion.reparar(this);
	}

	public void recibirDanio(Ataque ataque) {
		this.vida.restarVida(ataque.obtenerDanioEdificio());
        this.reparacion = new ReparacionActivada();
	}

	public int obtenerVida(){
		return vida.obtenerVida();
	}

    public void curar(){
    	vida.recuperarVida();
    }

	public void enReparacionPorAldeano(Aldeano aldeano){
	    this.aldeanoAsignadoParaReparar = aldeano;
	}

    public boolean verificarReparador(Aldeano aldeano){
	    return (this.aldeanoAsignadoParaReparar == aldeano);
    }
    
	public boolean estaReparado() {
		return vida.estaReparado();
	}

	public boolean estaDestruido() {
	return vida.estaDestruido();
	}
	
	public int costo() {
		return costoConstruccion;
	}

}
