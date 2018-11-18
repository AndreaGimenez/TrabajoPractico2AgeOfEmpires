package CrearEdificiosConFactory.Productos;


public interface IUnidad {

    void posicionar(Posicion referencia);

    boolean ocupaPosicion(Posicion unaPosicion);

    boolean estaEntre(Posicion inicio, Posicion fin);

}
