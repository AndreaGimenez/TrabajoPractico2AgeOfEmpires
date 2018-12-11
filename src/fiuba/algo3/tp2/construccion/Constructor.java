package fiuba.algo3.tp2.construccion;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.AldeanoConConstruccionAsignadaException;

public interface Constructor {
	
	public void construirConstruible(Construible construible)
			throws EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, 
			AldeanoConConstruccionAsignadaException, ConstruccionFueraDeRangoException, CeldaOcupadaException;
	public Collection<Posicion> obtenerPosicionesContorno();

}
 