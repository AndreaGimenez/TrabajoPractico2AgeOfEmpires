package CrearEdificiosConFactory.Creadores;

import CrearEdificiosConFactory.Productos.IEdificio;
import CrearEdificiosConFactory.Productos.PlazaCentral;

public class ConstruccionPlazaCentral extends Construccion {

    @Override
    public IEdificio crearEdificio() {

        return new PlazaCentral();

    }

}
