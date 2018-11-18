package AgregarFuncionalidadConDecorator;

import CrearEdificiosConFactory.Productos.IEdificio;
import CrearEdificiosConFactory.Productos.Posicion;


import java.util.LinkedList;

public abstract class PosicionDeEdificio implements IEdificio {

    private IEdificio edificio;

    public PosicionDeEdificio(IEdificio edificio){

        this.edificio = edificio;

    }

    public void posicionar(Posicion referencia) {

        this.edificio.posicionar(referencia);

    }

    public boolean ocupaPosicion(Posicion unaPosicion){

        return this.edificio.ocupaPosicion(unaPosicion);

    }


    public boolean existeAcoplamiento(LinkedList<Posicion> posicionesOcupadas){

        return this.edificio.existeAcoplamiento(posicionesOcupadas);

    }

    public LinkedList<Posicion> posicionesAOcupar(Posicion referencia){

        return this.edificio.posicionesAOcupar(referencia);

    }

}
