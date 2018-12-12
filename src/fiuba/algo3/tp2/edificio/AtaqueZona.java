package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.unidad.Ataque;

public interface AtaqueZona extends Ataque {

	public void atacar() throws AtaqueInvalidoException;
}
