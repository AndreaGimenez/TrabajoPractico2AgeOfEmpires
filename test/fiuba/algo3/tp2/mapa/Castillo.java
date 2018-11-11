package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.FormaCastillo;

public class Castillo extends Edificio {
	
	public Castillo(Coordenada posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, new FormaCastillo(), mapa);
	}
}
