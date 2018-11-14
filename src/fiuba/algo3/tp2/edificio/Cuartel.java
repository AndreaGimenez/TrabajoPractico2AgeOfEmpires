package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;

public class Cuartel extends Edificio {

    private int puntosDeSaludPorReparacion = 50;

    public Cuartel(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
        super(posicion, new CreadorUnidadCuartel(mapa), new FormaCuartel(), mapa);
    }

    @Override
    public void reparar(){

        super.curarVida(puntosDeSaludPorReparacion);

    }

    @Override
    public void iniciar(){



    }
}
