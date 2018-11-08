package MovimientoDeTropa;

import java.util.LinkedList;

public class Tablero {

    public LinkedList<Seleccionable> lista = new LinkedList<Seleccionable>();

    public Turno turno;

    public void colocarTropaEn(Tropa t, Posicion p) {

        t.posicionDeInicio(p);

        lista.add(t);

    }

    public void avanzarTurno() {

        this.turno.avanzar(1);

        this.lista.getFirst().siguienteMovimiento();

    }

    public Seleccionable obtener(Posicion p) {

    return this.lista.getFirst();

    }

    public void asignarTurnos(Turno turno) {

        this.turno = turno;

    }
}
