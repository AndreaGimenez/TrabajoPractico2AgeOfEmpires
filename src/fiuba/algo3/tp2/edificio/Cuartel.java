package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaCuartelRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.ReparacionDesactivada;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class Cuartel extends Edificio implements GeneradorUnidades {

    private CreadorUnidad creadorUnidades;

    public Cuartel(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
        super(posicion, new FormaCuartelRectangulo(), new ReparacionDesactivada(), mapa);
        this.creadorUnidades = new CreadorUnidadCuartel(mapa);
        super.puntosDeVida(250);
        super.establecerSaludRecuperadaPorTurno(50);
    }
    
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion) 
			throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		return creadorUnidades.crear(tipoUnidad, posicion);
	}

    @Override
    public void iniciar(){

    }

    public Posicion obtenerPosicion(){

        return super.obtenerPosicion();

    }

}
