package fiuba.algo3.tp2.edificio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
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
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnEspadachinEnLaPosicionIndicada() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		Espadachin espadachin = (Espadachin)cuartel.crear(TipoUnidad.ESPADACHIN, new Posicion(3, 1));
		
	
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnArqueroEnLaPosicionIndicada() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		Arquero arquero = (Arquero)cuartel.crear(TipoUnidad.ARQUERO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_NoDebePoderCrearAldeano() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Aldeano aldeano = (Aldeano)cuartel.crear(TipoUnidad.ALDEANO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_NoDebePoderCrearArmaAsedio() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)cuartel.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadoUnCuartel_AlCrearUnEspadachinEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(2, 2), mapa);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin espadachin = (Espadachin)cuartel.crear(TipoUnidad.ESPADACHIN, new Posicion(5, 5));
	}
}
