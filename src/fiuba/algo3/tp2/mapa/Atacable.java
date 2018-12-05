package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.unidad.Ataque;

public interface Atacable extends Posicionable {

	void recibirDanio(Ataque ataque);
}
