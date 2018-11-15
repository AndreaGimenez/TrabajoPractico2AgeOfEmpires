package Construccion;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;

public class CreadorEdificioAldeano implements CreadorEdificio  {
	
	private Mapa mapa;
	
	public CreadorEdificioAldeano(Mapa mapa) {
		this.mapa = mapa;
	}
	
	@Override
	public Edificio crear(TipoEdificio tipoEdificio)
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException {
		Edificio edificioADevolver = null;
		Posicion posicion = determinarPosicionCreacion();
		
		switch(tipoEdificio) {
		case PLAZA_CENTRAL:
			edificioADevolver = new PlazaCentral(posicion, mapa);
			break;
		case CUARTEL:
			edificioADevolver = new Cuartel(posicion, mapa);
		break;
		default:
			throw new EdificioNoSoportadoException();
		}
		
		return edificioADevolver;
	}
	
	private Posicion determinarPosicionCreacion() {
		return new Posicion(2,1);
	}
}
