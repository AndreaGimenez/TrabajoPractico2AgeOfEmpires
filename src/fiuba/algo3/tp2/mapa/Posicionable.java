package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import java.util.Collection;

import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;

public interface Posicionable {

	public void posicionar(Posicion coordenada) throws CeldaOcupadaException, CeldaInexistenteException;
	public Posicion obtenerPosicion();
	public Collection<Posicion> obtenerPosicionesOcupadasEnMapa();
	public void iniciar();

    void actualizarEstadoParaNuevoTurno() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException;
}
