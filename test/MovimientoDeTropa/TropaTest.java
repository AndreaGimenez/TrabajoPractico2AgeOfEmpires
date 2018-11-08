package MovimientoDeTropa;

import org.junit.Test;
import static org.junit.Assert.*;


public class TropaTest {

    @Test
    public void test01MoverTropaUnaPosicionALaDerecha(){

        Tropa t = new Tropa();
        Tablero tablero = new Tablero();
        Jugador j = new Jugador();
        Posicion p = new Posicion(3,3);
        Posicion pFin = new Posicion(4,3);

        tablero.colocarTropaEn(t,p);

        j.asignarTablero(tablero);

        j.seleccionar(p).moverHasta(pFin);

        assertEquals(pFin.getPosX(), t.posicion().getPosX());

        assertEquals(pFin.getPosY(), t.posicion().getPosY());

    }

    @Test
    public void PruebaDeMovimiento(){

        Tropa t = new Tropa();
        Tablero tablero = new Tablero();
        Jugador j = new Jugador();
        Posicion p = new Posicion(3,3);
        Posicion pFin = new Posicion(5,1);
        Turno turno = new Turno();

        tablero.colocarTropaEn(t,p);

        tablero.asignarTurnos(turno);

        j.asignarTablero(tablero);

        j.seleccionar(p).moverHasta(pFin);

        Posicion pIntermedia = new Posicion(4, 3);

        assertEquals(pIntermedia.getPosX(), t.posicion().getPosX());
        assertEquals(pIntermedia.getPosY(), t.posicion().getPosY());

        tablero.avanzarTurno();

        pIntermedia.cambiarPosicion(5, 3);

        assertEquals(pIntermedia.getPosX(), t.posicion().getPosX());
        assertEquals(pIntermedia.getPosY(), t.posicion().getPosY());

        tablero.avanzarTurno();

        pIntermedia.cambiarPosicion(5, 2);

        assertEquals(pIntermedia.getPosX(), t.posicion().getPosX());
        assertEquals(pIntermedia.getPosY(), t.posicion().getPosY());

        tablero.avanzarTurno();

        pIntermedia.cambiarPosicion(5, 1);

        assertEquals(pIntermedia.getPosX(), t.posicion().getPosX());
        assertEquals(pIntermedia.getPosY(), t.posicion().getPosY());

    }

}