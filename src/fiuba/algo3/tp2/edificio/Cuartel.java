package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.formas.FormaCuartelRectangulo;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
<<<<<<< HEAD
import fiuba.algo3.tp2.reparacion.ReparacionDesactivada;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class Cuartel extends Edificio implements GeneradorUnidades {
	
	private static final int VIDA_MAXIMA = 250;
	private static final int SALUD_RECUPERADA_POR_TURNO = 50;
    private static final int COSTO = 250;
	
    private CreadorUnidad creadorUnidades;
=======

<<<<<<< HEAD
public class Cuartel extends Edificio{

	public Cuartel(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaCuartel(), mapa);
	}
}
=======
public class Cuartel extends Edificio {

    private int puntosDeSaludPorReparacion = 50;
>>>>>>> johnny

    public Cuartel(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
        super(posicion, new FormaCuartelRectangulo(), new ReparacionDesactivada(), VIDA_MAXIMA, SALUD_RECUPERADA_POR_TURNO, mapa);
        this.creadorUnidades = new CreadorUnidadCuartel(mapa);
    }
    
	public Unidad crear(TipoUnidad tipoUnidad, Posicion posicion)
            throws CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		return creadorUnidades.crear(tipoUnidad, posicion);
	}

    @Override
    public int costo() {

        return this.COSTO;

    }

    @Override
    public boolean estaReparado() {
        return super.obtenerVida() == this.VIDA_MAXIMA;
    }

    @Override
    public void iniciar(){

    }

    public Posicion obtenerPosicion(){

        return super.obtenerPosicion();
    }
}
>>>>>>> develop
