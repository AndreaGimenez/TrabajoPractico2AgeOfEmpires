package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.construccion.ConstructorEdificios;
import fiuba.algo3.tp2.construccion.CreadorEdificio;
import fiuba.algo3.tp2.construccion.CreadorEdificioAldeano;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.formas.FormaAldeanoRectangulo;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.recursos.OroPorTurno;
import fiuba.algo3.tp2.reparacion.Reparador;
import fiuba.algo3.tp2.reparacion.ReparadorEdificio;
import fiuba.algo3.tp2.reparacion.ReparadorEdificioAldeano;

public class Aldeano extends Unidad implements ConstructorEdificios, Reparador {
	
	private static final int VIDA_MAXIMA = 50;
	private static final int COSTO_GENERACION = 25;
	
	private CreadorEdificio creadorEdificio;
	private Edificio edificioEnConstruccion;
	
	private ReparadorEdificio reparadorEdificio;
	private Edificio edificioEnReparacion;
	
	public OroPorTurno oroPorTurno;

	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaAldeanoRectangulo(), VIDA_MAXIMA, COSTO_GENERACION);
		
		this.creadorEdificio = new CreadorEdificioAldeano(mapa, this);
		
		this.reparadorEdificio = new ReparadorEdificioAldeano();
		
		this.oroPorTurno = new OroPorTurno();
	}

	public void crear(Edificio edificio){
		this.edificioEnConstruccion = edificio;
	}

	@Override
	public void repararEdificio(Edificio edificio)
			throws EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		if(!estaEnElRango(edificio)) {
			throw new EdificioFueraDeRangoException();
		}
		reparadorEdificio.repararEdificio(edificio, this);
		this.edificioEnReparacion = edificio;
	}

	@Override
	public void actualizarEstadoParaSiguienteTurno() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {

		this.reparadorEdificio.esPosibileVolverAReparar();

		if(this.edificioEnReparacion != null && this.edificioEnReparacion.estaReparado()) {
			this.edificioEnReparacion = null;
		}

		if(this.edificioEnReparacion != null) {

			this.reparadorEdificio.repararEdificio(this.edificioEnReparacion, this);
		}
		
		actualizarRecolectorOro();
		movimiento = new MovimientoBasico();
	}

	private void actualizarRecolectorOro() {
		
		if(this.edificioEnReparacion == null && this.edificioEnConstruccion == null ){
			oroPorTurno.activarRecolector();
		}
		else {
			oroPorTurno.desactivarRecolector();
		}
	}
	
	public int recolectarOro() {
		return oroPorTurno.recolectarOroDelTurno();
	}
	
}
