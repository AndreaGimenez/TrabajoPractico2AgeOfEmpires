package fiuba.algo3.tp2.unidad;

import Construccion.ConstructorEdificios;
import Construccion.CreadorEdificio;
import Construccion.CreadorEdificioAldeano;
import Construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.formas.FormaAldeanoRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.MovimientoBasico;
import fiuba.algo3.tp2.recursos.OroPorTurno;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
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
		this.edificioEnReparacion = null;
		
		this.reparadorEdificio = new ReparadorEdificioAldeano();
		this.edificioEnConstruccion = null;
		
		this.oroPorTurno = new OroPorTurno();
	}

	public Edificio crear(TipoEdificio tipoEdificio)
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException {
		
		Edificio edificio = creadorEdificio.crear(tipoEdificio);
		this.edificioEnConstruccion = edificio;
		return edificio;
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
	public void siguienteAccion() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {

		this.reparadorEdificio.esPosibileVolverAReparar();

		if(this.edificioEnReparacion != null) {
			this.reparadorEdificio.repararEdificio(this.edificioEnReparacion, this);
		}
		
		actualizarRecolectorOro();
		movimiento = new MovimientoBasico();
	}

	private void actualizarRecolectorOro() {
		
		if(this.edificioEnReparacion == null && this.edificioEnConstruccion == null) {
			oroPorTurno.activarRecolector();
		}
		else {
			oroPorTurno.desactivarRecolector();
		}
	}
	
	public int recolectarOro() {
		return oroPorTurno.recolectarOroDelTurno();
	}

	@Override
	public int obtenerCosto() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
