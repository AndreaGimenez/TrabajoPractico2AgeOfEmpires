package MovimientoDeTropa;

public interface Seleccionable {

    Posicion posicion();

    void moverHasta(Posicion fin);

    void siguienteMovimiento();
}
