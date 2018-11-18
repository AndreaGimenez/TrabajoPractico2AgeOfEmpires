package CrearEdificiosConFactory.Creadores;

import CrearEdificiosConFactory.Productos.Aldeano;
import CrearEdificiosConFactory.Productos.IUnidad;

public class CreadorDeAldeano extends CreadorDeUnidades{

    @Override
    public IUnidad crearUnidad() {
        return new Aldeano();
    }

}
