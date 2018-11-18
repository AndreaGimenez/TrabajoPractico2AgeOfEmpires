package CrearEdificiosConFactory.Creadores;

import CrearEdificiosConFactory.Productos.Arquero;
import CrearEdificiosConFactory.Productos.IUnidad;

public class CreadorDeArquero extends CreadorDeUnidades {

    @Override
    public IUnidad crearUnidad() {
        return new Arquero();
    }

}
