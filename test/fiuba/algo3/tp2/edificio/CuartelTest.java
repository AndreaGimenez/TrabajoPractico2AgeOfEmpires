package fiuba.algo3.tp2.edificio;

import Construccion.EdificioNoSoportadoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class CuartelTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void test_DadoUnCuartelEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX5Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Cuartel cuartel = new Cuartel(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5, 2), mapa);
	}
	
	




}
