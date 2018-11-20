package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignado;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;

public interface Posicionable {

	public void posicionar(Posicion coordenada) throws CeldaOcupadaException, CeldaInexistenteException;
	public Posicion obtenerPosicion();
	public void iniciar();

    void siguienteAccion() throws EdificioNoAptoParaReparacionException, EdificioConReparadorAsignado;
}
