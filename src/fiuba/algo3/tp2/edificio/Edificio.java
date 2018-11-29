package fiuba.algo3.tp2.edificio;

import java.util.Collection;

<<<<<<< HEAD
import fiuba.algo3.tp2.formas.Forma;
import fiuba.algo3.tp2.mapa.Atacable;
=======

>>>>>>> johnny
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.reparacion.Reparacion;
import fiuba.algo3.tp2.reparacion.ReparacionActivada;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.unidad.Unidad;
<<<<<<< HEAD
=======
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;
>>>>>>> develop

public abstract class Edificio implements Posicionable, Atacable {

	private Posicion posicion;
	protected Reparacion reparacion;
	private Forma forma;
<<<<<<< HEAD
	private Mapa mapa;
	private TipoDeEdificio tipo;
	private GeneradorDeUnidades generadorDeUnidades;
=======
	protected Mapa mapa;
	private Aldeano aldeanoAsignadoParaReparar;
	private Aldeano aldeanoConstructor;
	private boolean estaEnReparacion;
	private int vida;
<<<<<<< HEAD
	private int topeDeVida;
	private int puntosDeRecuperacion;
=======
	private CreadorUnidad creadorUnidades;
>>>>>>> develop
>>>>>>> johnny
	
	/*
	 * La coordenada es la celda inferior izquierda del edificio
	 */
<<<<<<< HEAD
	public Edificio(Posicion posicion, Forma forma, Reparacion reparacion, int vidaMaxima, int saludRecuperadaPorTurno, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
=======
<<<<<<< HEAD
	public Edificio(Posicion posicion, Forma forma, TipoDeEdificio tipo, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
=======
	public Edificio(Posicion posicion, CreadorUnidad creadorUnidades, Forma forma, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
>>>>>>> develop
>>>>>>> johnny
		
		this.mapa = mapa;
		this.forma = forma;
		this.reparacion = reparacion;
		this.vida = vidaMaxima;
		this.topeDeVida = vidaMaxima;
		this.puntosDeRecuperacion = saludRecuperadaPorTurno;
		this.estaEnReparacion = false;
		posicionar(posicion);
		this.tipo = tipo;
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
<<<<<<< HEAD
	
	
	public void generarUnidad(Unidad unaUnidad) throws EdificioNoGeneraUnidadException {
		
		generadorDeUnidades.generar(unaUnidad, tipo);
=======

	@Override
    public void actualizarEstadoParaNuevoTurno() throws EdificioNoAptoParaReparacionException {

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

		this.estaEnReparacion = true;

	}
<<<<<<< HEAD

    public boolean verificarReparador(Aldeano aldeano){

	    return (this.aldeanoAsignadoParaReparar == aldeano);
    }

    public Aldeano obtenerConstructor(){

		return this.aldeanoAsignadoParaReparar;

=======
	
	public Unidad crear(TipoUnidad tipoUnidad) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		return creadorUnidades.crear(tipoUnidad);
>>>>>>> develop
>>>>>>> johnny
	}

    public abstract Unidad crear(TipoUnidad unidad, Posicion posicion) throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException;

	public abstract int costo();

	public abstract boolean estaReparado();
}
