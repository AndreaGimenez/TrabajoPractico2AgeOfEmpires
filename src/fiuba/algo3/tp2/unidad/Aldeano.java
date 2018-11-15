package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;

public class Aldeano extends Unidad {
	
	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico());
	}

    public void reparar(Edificio cuartel) {
	    cuartel.reparar();
    }

    @Override
    public void recibirDanio(int danio) {
        
    }
}
