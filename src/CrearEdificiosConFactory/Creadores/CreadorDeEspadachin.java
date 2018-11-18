package CrearEdificiosConFactory.Creadores;

import CrearEdificiosConFactory.Productos.Espadachin;
import CrearEdificiosConFactory.Productos.IUnidad;

public class CreadorDeEspadachin extends CreadorDeUnidades {

    @Override
    public IUnidad crearUnidad() {
        return new Espadachin();
    }

}
