package fiuba.algo3.tp2.mapa;

import java.util.LinkedList;

import org.junit.Test;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;

public class ReparacionDeEdificiosTest {

    @Test
    public void test01CuartelCon1DeVidaDeberiaRecuperar50DeVidaSiUnAldeanoLoReparaUnTurno() 
    		throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {

        Posicion posicion = new Posicion(5,5);

        Mapa mapa = new Mapa(250,250);

        Edificio cuartel = new Cuartel(posicion, mapa);
        
        cuartel.recibirDanio(249);

        Aldeano aldeano = new Aldeano(posicion.sumar(new Posicion(-1, 0)),mapa);

        LinkedList<Posicionable> posicionables = new LinkedList<Posicionable>();

        posicionables.add(aldeano);

        posicionables.add(cuartel);

        Turno turno = new Turno(posicionables);

        aldeano.reparar(cuartel);

        turno.iniciar();
        
    }
}
