package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaCuartelRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class Cuartel extends Edificio implements GeneradorUnidades {

    //private int puntosDeSaludPorReparacion = 50;
    private CreadorUnidad creadorUnidades;

    public Cuartel(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
        super(posicion, new FormaCuartelRectangulo(), new ReparacionDesactivada(), mapa);
        this.creadorUnidades = new CreadorUnidadCuartel(mapa);
    }
    
	public Unidad crear(TipoUnidad tipoUnidad) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		return creadorUnidades.crear(tipoUnidad);
	}

    @Override
    public void iniciar(){

    }

}
