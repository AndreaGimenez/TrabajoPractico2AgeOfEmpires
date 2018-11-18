package AgregarFuncionalidadConDecorator;

import CrearEdificiosConFactory.Productos.IUnidad;
import CrearEdificiosConFactory.Productos.Posicion;

public abstract class PosicionDeUnidad implements IUnidad {

    private IUnidad unidad;

    public PosicionDeUnidad(IUnidad unidad){

        this.unidad = unidad;

    }

    public void posicionar(Posicion referencia) {

        this.unidad.posicionar(referencia);

    }

    public boolean ocupaPosicion(Posicion posicion){

        return this.unidad.ocupaPosicion(posicion);

    }

    public boolean estaEntre(Posicion inicio, Posicion fin){

        return this.unidad.estaEntre(inicio, fin);

    }
}
