package CrearEdificiosConFactory.Productos;

import java.util.LinkedList;

public class PlazaCentral implements IEdificio {

    private LinkedList<Posicion> posiciones = new LinkedList<>();

    @Override
    public void posicionar(Posicion referencia) {

        this.posiciones.add(referencia);

        this.posiciones.add(referencia.desplazarHorizontalmente(1).desplazarVerticalmente(-1));

    }

    @Override
    public boolean ocupaPosicion(Posicion unaPosicion) {

        return unaPosicion.estaEntre(this.posiciones.getFirst(), this.posiciones.getLast());

    }

    @Override
    public boolean existeAcoplamiento(LinkedList<Posicion> posicionesOcupadas) {
        boolean estaOcupado = false;

        for(int i = 0; i<2 && !estaOcupado; i++){

            estaOcupado = (this.posiciones.getFirst().desplazarHorizontalmente(i).estaEntre(posicionesOcupadas.getFirst(), posicionesOcupadas.getLast()));

            estaOcupado = (this.posiciones.getFirst().desplazarVerticalmente(-i).estaEntre(posicionesOcupadas.getFirst(), posicionesOcupadas.getLast()));

            estaOcupado = (this.posiciones.getFirst().desplazarVerticalmente(-i).desplazarHorizontalmente(i).estaEntre(posicionesOcupadas.getFirst(), posicionesOcupadas.getLast()));

        }

        return estaOcupado;
    }

    @Override
    public LinkedList<Posicion> posicionesAOcupar(Posicion referencia) {

        LinkedList<Posicion> posiciones = new LinkedList<>();

        posiciones.add(referencia);

        posiciones.add(referencia.desplazarHorizontalmente(1).desplazarVerticalmente(-1));

        return posiciones;

    }
}
