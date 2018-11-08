package MovimientoDeTropa;

public class Jugador {

    public Tablero tablero;

    public void asignarTablero(Tablero tablero) {

        this.tablero=tablero;

    }

    public Seleccionable seleccionar(Posicion p) {

        return this.tablero.obtener(p);

    }
}
