package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;

public class Aldeano extends Unidad implements ConstructorEdificios{
	
	private CreadorEdificio creadorEdificio;
	
	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico());
		this.creadorEdificio = new CreadorEdificioAldeano(mapa);
	}

    public void reparar(Edificio cuartel) {
	    cuartel.reparar();
    }

    @Override
    public void recibirDanio(int danio) {
        
    }

	@Override
	public Edificio crear(TipoEdificio tipoEdificio) 
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException {
		
		return creadorEdificio.crear(tipoEdificio);
	}
}
