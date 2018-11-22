package fiuba.algo3.tp2.unidad;

import java.util.Collection;

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
import fiuba.algo3.tp2.reparacion.*;

public class Aldeano extends Unidad implements ConstructorEdificios, Reparador{
	
	private static final int VIDA_MAXIMA = 50;
	
	private CreadorEdificio creadorEdificio;
	private ReparadorEdificio reparadorEdificio;
	private Edificio edificioEnReparacion;

	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico(), new FormaAldeanoRectangulo(), VIDA_MAXIMA);
		this.creadorEdificio = new CreadorEdificioAldeano(mapa);
		this.reparadorEdificio = new ReparadorEdificioAldeano();
		this.edificioEnReparacion = null;
	}

	public Edificio crear(TipoEdificio tipoEdificio)
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException {
		
		return creadorEdificio.crear(tipoEdificio);
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

		if(this.edificioEnReparacion != null)
			this.reparadorEdificio.repararEdificio(this.edificioEnReparacion, this);

	}
}
