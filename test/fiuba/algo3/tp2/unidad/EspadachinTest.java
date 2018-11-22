package fiuba.algo3.tp2.unidad;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionAbajoDerecha;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionArribaDerecha;
import fiuba.algo3.tp2.movimiento.DireccionArribaIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;

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
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaLaDerechaDeberiaEstarEnX3Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(3,1), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaLaIzquierdaDeberiaEstarEnX1Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(1,1), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaArribaDeberiaEstarEnX2Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionArriba());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(2,2), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaAbajoDeberiaEstarEnX2Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionAbajo());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(2,0), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaArribaDerechaDeberiaEstarEnX3Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionArribaDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(3,2), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaAbajoDerechaDeberiaEstarEnX3Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionAbajoDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(3,0), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaAbajoIzquierdaDeberiaEstarEnX1Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionAbajoIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin= new Espadachin(new Posicion(1,0), mapa);
	}
	
	@Test
	public void testUnEspadachinEnLaPosicionX2Y1SeMueveHaciaArribaIzquierdaDeberiaEstarEnX1Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionArribaIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Espadachin otroEspadachin = new Espadachin(new Posicion(1,2), mapa);
	}
	
	@Test
	public void testDadoUnMapaDe5x5UnEspadachinEnLaPosicionX4Y0SeMueveHaciaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espapdachin = new Espadachin(new Posicion(4,0), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espapdachin.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnEspachinEnLaPosicionX1Y2YUnEspachinEnLaPosicionX2Y2CuandoSeMueveHaciaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,2), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnEspadachinEnLaPosicionX1Y2YUnEspadachinEnLaPosicionX0Y2CuandoElPrimeroSeMueveHaciaIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(0,2), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionIzquierda());
	}
	
	@Test
	public void testDadoUnespadachinEnLaPosicionX1Y2YUnespadachinEnLaPosicionX1Y1CuandoElPrimeroSeMueveHaciaAbajoDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(1,1), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionAbajo());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX1Y3CuandoElPrimeroSeMueveHaciaArribaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(1,3), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionArriba());
	}
	
	@Test
	public void testDadoUnEspadachinEnLaPosicionX1Y2YUnEspadachinEnLaPosicionX2Y3CuandoElPrimeroSeMueveHaciaArribaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,3), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionArribaDerecha());
	}
	
	@Test
	public void testDadoUnEspadachinEnLaPosicionX1Y2YUnEspadachinEnLaPosicionX0Y3CuandoElPrimeroSeMueveHaciaArribaIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(0,3), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionArribaIzquierda());
	}
	
	@Test
	public void testDadoUnEspadachinEnLaPosicionX1Y2YUnEspadachinEnLaPosicionX2Y1CuandoElPrimeroSeMueveHaciaAbajoDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnEspadachinEnLaPosicionX1Y2YUnEspadachinEnLaPosicionX0Y1CuandoElPrimeroSeMueveHaciaAbajoIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Espadachin espadachin = new Espadachin(new Posicion(0,1), mapa);
		Espadachin espadachinAMover = new Espadachin(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		espadachinAMover.mover(new DireccionAbajoIzquierda());
	}
	
	//ATAQUE
	
	@Test
	public void testCuandoUnEspadachinAtaqueUnAldeanoFueraDeSuRangoDeberiaLanzarAtaqueFueraDeRangoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(1,1), mapa);
		
		Aldeano aldeano = new Aldeano(new Posicion(3,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		espadachin.atacar(aldeano);
	}
	
	@Test
	public void testCuandoUnEspadachinAtaca3VecesAUnAldeanoDeberiaLanzarUnidadMuertaException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(1,1), mapa);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		espadachin.atacar(aldeano);
		espadachin.atacar(aldeano);
		
		exceptionRule.expect(UnidadMuertaException.class);
		espadachin.atacar(aldeano);
	}
	
	@Test
	public void testCuandoUnEspadachinAtaca18VecesAUnCuartelElUltimoAtaqueDeberiaLanzarEdificioDestruidoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(1,1), mapa);
		
		Cuartel cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		for(int i = 0; i < 17; i++) {
			espadachin.atacar(cuartel);
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		espadachin.atacar(cuartel);
	}
}
