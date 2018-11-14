package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
<<<<<<< HEAD
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Unidad;
=======
>>>>>>> develop
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class PlazaCentral extends Edificio{
	
	public PlazaCentral(Posicion posicion, Mapa mapa) throws CeldaOcupadaException, CeldaInexistenteException {
<<<<<<< HEAD
		super(posicion, new FormaPlazaCentral(), new tipoPlazaCentral(), mapa);
=======
		super(posicion, new CreadorUnidadPlazaCentral(mapa), new FormaPlazaCentralRectangulo(), mapa);
>>>>>>> develop
	}
	
	@Override
	public void generarUnidad(Unidad unaUnidad) throws EdificioNoGeneraUnidadException {
		
	}
	

	
}
