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

public class ArmaAsedioTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testDadoUnArqueroEnlaPosicionX5Y2CuandoSePosicionaOtroArqueroEnLaPosicionX5Y2DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio = new ArmaAsedio(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaLaDerechaDeberiaEstarEnX3Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio = new ArmaAsedio(new Posicion(3,1), mapa);
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaLaIzquierdaDeberiaEstarEnX1Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaArribaDeberiaEstarEnX2Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionArriba());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaAbajoDeberiaEstarEnX2Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionAbajo());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio = new ArmaAsedio(new Posicion(2,0), mapa);
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaArribaDerechaDeberiaEstarEnX3Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionArribaDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio = new ArmaAsedio(new Posicion(3,2), mapa);
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaAbajoDerechaDeberiaEstarEnX1Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionAbajoDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio= new ArmaAsedio(new Posicion(1,2), mapa);
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaAbajoIzquierdaDeberiaEstarEnX1Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionAbajoIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio= new ArmaAsedio(new Posicion(1,0), mapa);
	}
	
	@Test
	public void testDadoUnMapaDe5x5UnArmaDeAsedioEnLaPosicionX4Y0SeMueveHaciaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(4,0), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedio.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaEnLaPosicionX1Y2YUnArmaDeAsedioDesmontadaEnLaPosicionX2Y2CuandoSeMueveHaciaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionDerecha());
	}
	
	@Test
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaArribaIzquierdaDeberiaEstarEnX1Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionArribaIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio = new ArmaAsedio(new Posicion(1,2), mapa);
	}

	@Test
	public void testDadaUnArmaDeAsedioMontadaAlDesmontarlaDeberiaPoderMoverse() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		armaAsedio.montar();
		
		armaAsedio.desmontar();
		armaAsedio.mover(new DireccionArribaIzquierda());
	}
}
