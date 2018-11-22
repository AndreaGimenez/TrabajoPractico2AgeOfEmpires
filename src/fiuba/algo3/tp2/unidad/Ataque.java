package fiuba.algo3.tp2.unidad;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;

public abstract class Ataque {

	public abstract void atacar(Atacador atacador, Unidad unidad) throws AtaqueFueraDeRangoException, UnidadMuertaException;
	public abstract void atacar(Atacador atacador, Edificio edificio) throws AtaqueFueraDeRangoException, EdificioDestruidoException;

}
