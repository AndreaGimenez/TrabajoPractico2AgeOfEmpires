package fiuba.algo3.tp2.edificio;


import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class GeneradorDeUnidades {

	public void generar(Unidad unaUnidad, TipoDeEdificio tipo) throws EdificioNoGeneraUnidadException{
		if ((tipo instanceof tipoPlazaCentral) || !(unaUnidad instanceof Aldeano) ) {
			throw new EdificioNoGeneraUnidadException();
		}
	}

}
