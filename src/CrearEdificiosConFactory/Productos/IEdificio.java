package CrearEdificiosConFactory.Productos;

import java.util.LinkedList;

public interface IEdificio {

    void posicionar(Posicion referencia);

    boolean ocupaPosicion(Posicion unaPosicion);

    boolean existeAcoplamiento(LinkedList<Posicion> posicionesOcupadas);

    LinkedList<Posicion> posicionesAOcupar(Posicion referencia);
}
