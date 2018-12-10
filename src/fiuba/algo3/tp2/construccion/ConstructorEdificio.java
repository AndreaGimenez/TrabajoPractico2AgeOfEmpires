package fiuba.algo3.tp2.construccion;

public interface ConstructorEdificio {
	
	public void habilitarConstruccionEsteTurno();
	public void construirEdificio(Construible construible)
		throws EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException;
}
