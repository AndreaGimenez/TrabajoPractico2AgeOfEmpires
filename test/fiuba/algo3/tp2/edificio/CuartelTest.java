package fiuba.algo3.tp2.edificio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class CuartelTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1CuyasPosicionesAldedaniasSeEncuentranVacias_CuandoSeCreaUnEspadachin_DeberiaCrearseEnLaPosicionX3Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		Espadachin espadachin = (Espadachin)cuartel.crear(TipoUnidad.ESPADACHIN);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Espadachin(new Posicion(3, 1), mapa);
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1CuyasPosicionesAldedaniasSeEncuentranVacias_CuandoSeCreaUnArquero_DeberiaCrearseEnLaPosicionX3Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		Arquero arquero = (Arquero)cuartel.crear(TipoUnidad.ARQUERO);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Arquero(new Posicion(3, 1), mapa);
	}
}
