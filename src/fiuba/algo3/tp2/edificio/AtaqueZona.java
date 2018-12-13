package fiuba.algo3.tp2.edificio;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.unidad.Ataque;

public interface AtaqueZona extends Ataque {

	public void atacar(Collection<Posicionable> pocisionablesEnemigos) throws AtaqueInvalidoException;
}
