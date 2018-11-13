package fiuba.algo3.tp2.unidad;

import com.sun.xml.internal.bind.v2.TODO;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Mapa;

public class Aldeano extends Unidad {
	
	public Aldeano(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
		super(posicion, mapa, new MovimientoBasico());
	}

	public void construirCuartel() throws CeldaOcupadaException, CeldaInexistenteException {

	    try {

            Posicion derecha = new Posicion(1, 0);

            Cuartel cuartel = new Cuartel(super.obtenerPosicion().sumar(derecha), super.obtenerMapa());

        } catch (Exception e) {

            Posicion arriba = new Posicion(0, -1);

            Cuartel cuartel = new Cuartel(super.obtenerPosicion().sumar(arriba), super.obtenerMapa());

        }

	}

    public void reparar(Edificio cuartel) {

	    cuartel.reparar();

    }

    @Override
    public void recibirDanio(int danio) {
        
    }
}
