package fiuba.algo3.tp2.integracion.entrega_1;

/**
 * Pruebas de edificios - Creacion de unidades
 *
 */ 
public class Test03 {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	/*PLAZA CENTRAL*/
	
	@Test
	public void test_DadaUnaPlazaCentral_CrearUnAldeanoEnLaPosicionElegidaDeberidaDarBien() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		
		Aldeano aldeano = (Aldeano)plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadaUnaPlazaCentral_NoDeberiaPoderCrearEspadachin_DeberiaLazarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Espadachin espadachin = (Espadachin)plazaCentral.crear(TipoUnidad.ESPADACHIN, new Posicion(3, 1));
	}
	
	@Test
	public void test_DadaUnaPlazaCentral_NoDeberiaPoderCrearArquero_DeberiaLanzarUnidadNoSoportadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Arquero arquero = (Arquero)plazaCentral.crear(TipoUnidad.ARQUERO, new Posicion(3, 1));
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX3Y3_AlCrearUnAldeanoEnUnaPosicionYaOcupadaDeberiaDarError() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		Aldeano unAldeano = new Aldeano(new Posicion(7, 7), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = (Aldeano)plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(7, 7));
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX3Y3_AlCrearUnAldeanoEnUnaPosicionFueraDelMapaDeberiaDarError() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		
		exceptionRule.expect(CeldaInexistenteException.class);
		Aldeano unAldeano = (Aldeano)plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(300, 300));
	}
	
/*CASTILLO*/
	
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

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
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

	/*CUARTEL*/

	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnEspadachinEnLaPosicionIndicada()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);

		Espadachin espadachin = (Espadachin)cuartel.crear(TipoUnidad.ESPADACHIN, new Posicion(3, 1));
		
	
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_SeDebePoderCrearUnArqueroEnLaPosicionIndicada()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		Arquero arquero = (Arquero)cuartel.crear(TipoUnidad.ARQUERO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_NoDebePoderCrearAldeano()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		Aldeano aldeano = (Aldeano)cuartel.crear(TipoUnidad.ALDEANO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadoUnCuartelEnLaPosicionX1Y1_NoDebePoderCrearArmaAsedio()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Cuartel cuartel = new Cuartel(new Posicion(1, 1), mapa);
		
		exceptionRule.expect(UnidadNoSoportadaException.class);
		ArmaAsedio armaAsedio = (ArmaAsedio)cuartel.crear(TipoUnidad.ARMA_ASEDIO, new Posicion(3, 1));
		
	}
	
	@Test
	public void test_DadoUnCuartel_AlCrearUnEspadachinEnUnaPosicionYaOcupada_DebeLanzarCeldaOcupadaException()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
		Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		cuartel.crear(TipoUnidad.ESPADACHIN, new Posicion(5, 5));
	}