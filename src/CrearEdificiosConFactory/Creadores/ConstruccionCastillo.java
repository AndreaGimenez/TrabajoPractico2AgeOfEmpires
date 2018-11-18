package CrearEdificiosConFactory.Creadores;

import CrearEdificiosConFactory.Productos.Castillo;
import CrearEdificiosConFactory.Productos.IEdificio;

public class ConstruccionCastillo extends Construccion {

    @Override
    public IEdificio crearEdificio() {

        return new Castillo();

    }
}
