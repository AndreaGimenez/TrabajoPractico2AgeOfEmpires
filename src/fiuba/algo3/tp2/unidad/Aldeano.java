package fiuba.algo3.tp2.unidad;

import java.util.Collection;

import fiuba.algo3.tp2.construccion.Constructor;
import fiuba.algo3.tp2.construccion.Construible;
import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.formas.FormaAldeanoRectangulo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.movimiento.MovimientoNulo;
import fiuba.algo3.tp2.recursos.OroPorTurno;
import fiuba.algo3.tp2.reparacion.Reparador;
import fiuba.algo3.tp2.reparacion.ReparadorEdificio;
import fiuba.algo3.tp2.reparacion.ReparadorEdificioAldeano;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;

public class Aldeano extends Unidad implements Constructor, Reparador {
	
	private static final int VIDA_MAXIMA = 50;
	private static final int COSTO_GENERACION = 25;

	private Construible construibleEnConstruccion;
	
	private ReparadorEdificio reparadorEdificio;
	private Edificio edificioEnReparacion;
	
	private RangoReparacion rangoReparacion;
	
	public OroPorTurno oroPorTurno;

	
	
	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaAldeanoRectangulo(), VIDA_MAXIMA, COSTO_GENERACION);
		
		this.reparadorEdificio = new ReparadorEdificioAldeano(this);
		this.oroPorTurno = new OroPorTurno();
		this.rangoReparacion = new RangoReparacion();
		this.construibleEnConstruccion = null;
	}
	
	@Override
	public void construirConstruible(Construible construible)
			throws EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException {
		
		if(this.construibleEnConstruccion == null ) {
			this.construibleEnConstruccion = construible;
			construible.asignarConstructor(this);
			
			this.movimiento = new MovimientoNulo();
			
			setChanged();
			notifyObservers(construibleEnConstruccion);
		}
		else {
			construible.liberarCeldas(obtenerMapa());
			throw new AldeanoConConstruccionAsignadaException();
		}
	}	

	@Override
	public void repararEdificio(Edificio edificio)
			throws EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException {
		
		if(this.construibleEnConstruccion != null) {
			throw new AldeanoConConstruccionAsignadaException();
		}
		if(!rangoReparacion.estaEnRango(this, edificio)) {
			throw new EdificioFueraDeRangoException();
		}
		reparadorEdificio.repararEdificio(edificio);
		this.edificioEnReparacion = edificio;
		
		this.movimiento = new MovimientoNulo();
		
		setChanged();
		notifyObservers(reparadorEdificio);
	}

	@Override
	public void actualizarEstadoParaSiguienteTurno() 
			throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException  {
		
		//REPARACION
		reparadorEdificio.habilitarReparacionEsteTurno();
		if(this.edificioEnReparacion != null && this.edificioEnReparacion.estaReparado()) {
			
			this.edificioEnReparacion = null;
			
			setChanged();
			notifyObservers();
		}

		if(this.edificioEnReparacion != null) {
			
			this.reparadorEdificio.repararEdificio(this.edificioEnReparacion);
		}
		
		//CONSTRUCCION
		if(this.construibleEnConstruccion != null) {
			
			construibleEnConstruccion.avanzarConstruccion();
		}
		
		if((this.construibleEnConstruccion != null) && (this.construibleEnConstruccion.estaConstruido())){
			this.construibleEnConstruccion = null;
			
			setChanged();
			notifyObservers();
		}
		
		//ORO
		actualizarRecolectorOro();
		
		if(this.construibleEnConstruccion == null &&  this.edificioEnReparacion == null) {
			
			movimiento = new MovimientoBasico();
			
			setChanged();
			notifyObservers(movimiento);
		}
		
	}

	private void actualizarRecolectorOro() {
		
		if(this.edificioEnReparacion == null && this.construibleEnConstruccion == null ){
			oroPorTurno.activarRecolector();
		}
		else {
			oroPorTurno.desactivarRecolector();
		}
	}
	
	public int recolectarOro() {
		return oroPorTurno.recolectarOroDelTurno();
	}

	public Collection<Posicion> obtenerPosicionesContorno() {
		return forma.obtenerPosicionesContorno(this.posicion);
	}
	
}
