package CrearEdificiosConFactory.Productos;


public class Espadachin implements IUnidad {

    @Override
    public void posicionar(Posicion referencia) {

    }

    @Override
    public boolean ocupaPosicion(Posicion unaPosicion) {
        return false;
    }

    @Override
    public boolean estaEntre(Posicion inicio, Posicion fin) {
        return false;
    }
}
