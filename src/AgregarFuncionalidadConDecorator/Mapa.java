package AgregarFuncionalidadConDecorator;

import CrearEdificiosConFactory.Productos.IEdificio;
import CrearEdificiosConFactory.Productos.IUnidad;
import CrearEdificiosConFactory.Productos.Posicion;

import java.util.LinkedList;
import java.util.ListIterator;

public class Mapa {

    private LinkedList<PosicionDeEdificio> edificios;

    private LinkedList<PosicionDeUnidad> unidades;

    private PosicionEnUso posicionEnUso;

    private void ocupadoParaUnidades(Posicion posicion) throws PosicionEnUso {

        for (PosicionDeEdificio edificio : this.edificios) {

            if (edificio.ocupaPosicion(posicion)) throw this.posicionEnUso;

        }

        for(PosicionDeUnidad unidad : this.unidades) {

            if (unidad.ocupaPosicion(posicion)) throw this.posicionEnUso;

        }

    }

    private void ocupadoParaEdificios(PosicionDeEdificio unEdificio, Posicion posicion) throws PosicionEnUso {

        for (PosicionDeEdificio edificio : this.edificios) {

            if (edificio.existeAcoplamiento(unEdificio.posicionesAOcupar(posicion)))
                throw this.posicionEnUso;

        }

        for(PosicionDeUnidad unidad : this.unidades) {

            if (unidad.estaEntre(unEdificio.posicionesAOcupar(posicion).getFirst(), unEdificio.posicionesAOcupar(posicion).getLast())) throw this.posicionEnUso;

        }

    }

    public Mapa(){

        this.unidades = new LinkedList<>();

        this.edificios = new LinkedList<>();

        this.posicionEnUso = new PosicionEnUso();

    }

    public void posicionar(IUnidad unidad, Posicion posicion) throws PosicionEnUso {

        PosicionDeUnidad posicionDeUnidad = new TerrenoDeUnidad(unidad);

        this.ocupadoParaUnidades(posicion);

        posicionDeUnidad.posicionar(posicion);

        this.unidades.add(posicionDeUnidad);

    }

    public void posicionar(IEdificio edificio, Posicion posicion) throws PosicionEnUso {

        PosicionDeEdificio posicionDeEdificio = new TerrenoDeEdificio(edificio);

        this.ocupadoParaEdificios(posicionDeEdificio, posicion);

        posicionDeEdificio.posicionar(posicion);

        this.edificios.add(posicionDeEdificio);

    }

    public boolean estaOcupado(Posicion posicion) {

        ListIterator<PosicionDeEdificio> iteradorDeEdificio = this.edificios.listIterator();

        ListIterator<PosicionDeUnidad> iteradorDeUnidad = this.unidades.listIterator();

        boolean ocupado = false;

            while(iteradorDeEdificio.hasNext() && !ocupado){

                ocupado = iteradorDeEdificio.next().ocupaPosicion(posicion);

            }

            while(iteradorDeUnidad.hasNext() && !ocupado){

                ocupado = iteradorDeUnidad.next().ocupaPosicion(posicion);

            }

        return ocupado;

    }
}
