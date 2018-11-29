package fiuba.algo3.tp2.unidad;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionAbajoDerecha;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionArribaDerecha;
import fiuba.algo3.tp2.movimiento.DireccionArribaIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class AldeanoTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnAldeanoEnlaPosicionX5Y2CuandoSePosicionaOtroAldeanoEnLaPosicionX5Y2DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Aldeano aldeano = new Aldeano(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaLaDerechaDeberiaEstarEnX3Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(3,1), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaLaIzquierdaDeberiaEstarEnX1Y1() 
			throws TamanioInvalidoException, MovimientoInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(1,1), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaArribaDeberiaEstarEnX2Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionArriba());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(2,2), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaAbajoDeberiaEstarEnX2Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException{
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionAbajo());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(2,0), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaArribaDerechaDeberiaEstarEnX3Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionArribaDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(3,2), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaAbajoDerechaDeberiaEstarEnX3Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionAbajoDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(3,0), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaAbajoIzquierdaDeberiaEstarEnX1Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionAbajoIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(1,0), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaArribaIzquierdaDeberiaEstarEnX1Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionArribaIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Posicion(1,2), mapa);
	}
	
	@Test
	public void testDadoUnMapaDe5x5UnAldeanoEnLaPosicionX4Y0SeMueveHaciaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(4,0), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeano.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX2Y2CuandoElPrimeroSeMueveHaciaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,2), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX0Y2CuandoElPrimeroSeMueveHaciaIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(0,2), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionIzquierda());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX1Y1CuandoElPrimeroSeMueveHaciaAbajoDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionAbajo());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX1Y3CuandoElPrimeroSeMueveHaciaArribaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,3), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionArriba());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX2Y3CuandoElPrimeroSeMueveHaciaArribaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,3), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionArribaDerecha());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX0Y3CuandoElPrimeroSeMueveHaciaArribaIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(0,3), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionArribaIzquierda());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX2Y1CuandoElPrimeroSeMueveHaciaAbajoDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnAldeanoEnLaPosicionX1Y2YUnAldeanoEnLaPosicionX0Y1CuandoElPrimeroSeMueveHaciaAbajoIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Aldeano aldeano = new Aldeano(new Posicion(0,1), mapa);
		Aldeano aldeanoAMover = new Aldeano(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeanoAMover.mover(new DireccionAbajoIzquierda());
	}
	/*
	@Test
	public void test_AldeanoConstruyeUnaPlazaCentral() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
		
		aldeano.crear(tipoEdificio)
		
		
	}*/
}
