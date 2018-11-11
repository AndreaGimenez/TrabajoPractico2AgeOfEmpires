package fiuba.algo3.tp2.unidad;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;

public class EspadachinTest {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnEspadachinEnlaPosicionX5Y2CuandoSePosicionaOtroEspadachinEnLaPosicionX5Y2DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Espadachin espadachin = new Espadachin(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaLaDerechaDeberiaEstarEnX3Y1() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionDerecha(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(3,1), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaLaIzquierdaDeberiaEstarEnX1Y1() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionIzquierda(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(1,1), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaArribaDeberiaEstarEnX2Y2() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionArriba(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(2,2), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaAbajoDeberiaEstarEnX2Y0() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionAbajo(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(2,0), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaArribaDerechaDeberiaEstarEnX3Y2() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionArribaDerecha(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(3,2), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaAbajoDerechaDeberiaEstarEnX1Y2() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionAbajoDerecha(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(1,2), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaAbajoIzquierdaDeberiaEstarEnX1Y0() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionAbajoIzquierda(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin= new Espadachin(new Posicion(1,0), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaArribaIzquierdaDeberiaEstarEnX1Y2() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionArribaIzquierda(),mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(1,2), mapa);
	}
}
