package CrearEdificiosConFactory.Productos;

public class Aldeano implements IUnidad {

    private Posicion posicion;

    @Override
    public void posicionar(Posicion referencia) {

        this.posicion = referencia;

    }

    @Override
    public boolean ocupaPosicion(Posicion unaPosicion) {
        return this.posicion.estaEntre(unaPosicion, unaPosicion);
    }

    @Override
    public boolean estaEntre(Posicion inicio, Posicion fin) {
        return posicion.estaEntre(inicio, fin);
    }
}
