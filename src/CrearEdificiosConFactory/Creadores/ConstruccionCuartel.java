package CrearEdificiosConFactory.Creadores;

import CrearEdificiosConFactory.Productos.Cuartel;
import CrearEdificiosConFactory.Productos.IEdificio;

public class ConstruccionCuartel extends Construccion {

    @Override
    public IEdificio crearEdificio() {

        return new Cuartel();

    }

}
