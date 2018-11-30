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

public abstract class Edificio implements Posicionable, Atacable {

	private Posicion posicion;
	protected Reparacion reparacion;
	private Forma forma;
	protected Mapa mapa;
	private Aldeano aldeanoAsignadoParaReparar;
	private int vida;
	private int topeDeVida;
	private int puntosDeRecuperacion;
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
	public Edificio(Posicion posicion, Forma forma, Reparacion reparacion, int vidaMaxima, int saludRecuperadaPorTurno, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		
		this.mapa = mapa;
		this.forma = forma;
		this.reparacion = reparacion;
		this.vida = vidaMaxima;
		this.topeDeVida = vidaMaxima;
		this.puntosDeRecuperacion = saludRecuperadaPorTurno;
		posicionar(posicion);
	}

	public Edificio() {

	}

	@Override
	public void posicionar(Posicion posicion) throws CeldaOcupadaException, CeldaInexistenteException {
		
		Collection<Posicion> posicionesAOcuparEnMapa = forma.obtenerCoordenadas(posicion);
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
		
		return forma.obtenerCoordenadas(posicion);
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
        
        if(vida == 0) {
        	throw new EdificioDestruidoException();
        }
		vida -= ataque.obtenerDanioEdificio();
		
		if(vida <= 0) {
			vida = 0;
		}
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

	public void enReparacionPorAldeano(Aldeano aldeano){

	    this.aldeanoAsignadoParaReparar = aldeano;


	}

    public boolean verificarReparador(Aldeano aldeano){

	    return (this.aldeanoAsignadoParaReparar == aldeano);
    }

	public abstract int costo();

	public abstract boolean estaReparado();
}
