package CrearEdificiosConFactory.Creadores;

import CrearEdificiosConFactory.Productos.ArmaDeAsedio;
import CrearEdificiosConFactory.Productos.IUnidad;

public class CreadorDeArmaDeAsedio extends CreadorDeUnidades {

    @Override
    public IUnidad crearUnidad() {
        return new ArmaDeAsedio();
    }

}
