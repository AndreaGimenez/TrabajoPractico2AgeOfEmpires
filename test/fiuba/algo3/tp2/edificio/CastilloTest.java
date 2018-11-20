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
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class CastilloTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX8Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(8, 2), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX8Y5_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(8, 5), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y5_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_DebePoderCrearUnArmaDeAsedioEnLaPosicionSolicitada() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(5, 5));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_AlCrearUnArmaDeAsedioEnLaPosicionX3Y3_DebeLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(3, 3));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnAldeano_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ALDEANO, new Posicion(5, 5));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnEspadachin_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ESPADACHIN, new Posicion(5, 5));
		
	}
	
	@Test
	public void test_DadoUnCastilloEnLaPosicionX1Y1_NoDebePoderCrearUnArquero_DebeLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARQUERO, new Posicion(5, 5));
		
	}
	
	@Test 
	public void test_DadoUnCastillo_AlQuererCrearUnArmaDeAsedioEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(1, 1), mapa);
		Cuartel cuartel = new Cuartel(new Posicion(6, 4), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)castillo.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(6, 4));
	}
}
