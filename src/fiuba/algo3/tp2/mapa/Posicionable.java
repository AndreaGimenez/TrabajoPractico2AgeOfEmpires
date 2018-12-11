package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import java.util.Collection;

import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;

public interface Posicionable {

	public void posicionar(Posicion coordenada) throws CeldaOcupadaException, CeldaInexistenteException;
	public Posicion obtenerPosicion();
	public Collection<Posicion> obtenerPosicionesOcupadasEnMapa();
	//public void iniciar();

    void actualizarEstadoParaSiguienteTurno() 
    		throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException;
}
