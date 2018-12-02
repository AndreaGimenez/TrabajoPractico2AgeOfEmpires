package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaCuartelRectangulo;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.excepciones.reparacion.ReparacionDesactivada;

public class Cuartel extends Edificio /*implements GeneradorUnidades*/ {
	
	private static final int VIDA_MAXIMA = 250;
	private static final int SALUD_RECUPERADA_POR_TURNO = 50;
    private static final int COSTO_CONSTRUCCION = 250;
	
    //private CreadorUnidad creadorUnidades;

    public Cuartel(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
        super(posicion, new FormaCuartelRectangulo(), new ReparacionDesactivada(), VIDA_MAXIMA, SALUD_RECUPERADA_POR_TURNO, COSTO_CONSTRUCCION, mapa);
       // this.creadorUnidades = new CreadorUnidadCuartel(mapa);
    }
    /*
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion)
            throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		return creadorUnidades.crear(tipoUnidad, posicion);
	}*/

    public Posicion obtenerPosicion(){

        return super.obtenerPosicion();
    }

	@Override
	public void actualizarEstadoParaSiguienteTurno() {
		// TODO Auto-generated method stub
		
	}
}
