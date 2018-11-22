package fiuba.algo3.tp2.unidad;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Ataque.Atacador;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;
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
	public void testUnArmaAsedioEnLaPosicionX2Y1SeMueveHaciaAbajoDerechaDeberiaEstarEnX3Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionAbajoDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		ArmaAsedio otroArmaAsedio= new ArmaAsedio(new Posicion(3,0), mapa);
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
	
	
	@Test
	public void testDadoUnMapaDe5x5UnArmaDeAsedioDesmontadaEnLaPosicionX4Y0SeMueveHaciaLaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(4,0), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedio.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaEnLaPosicionX1Y2YUnArmaDeAsedioDesmontadaEnLaPosicionX2Y2CuandoElPrimeroSeMueveHaciaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX0Y2CuandoElPrimeroSeMueveHaciaIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,2), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionIzquierda());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX1Y1CuandoElPrimeroSeMueveHaciaAbajoDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionAbajo());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX1Y3CuandoElPrimeroSeMueveHaciaArribaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(1,3), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionArriba());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX2Y3CuandoElPrimeroSeMueveHaciaArribaDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,3), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionArribaDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX0Y3CuandoElPrimeroSeMueveHaciaArribaIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,3), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionArribaIzquierda());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX2Y1CuandoElPrimeroSeMueveHaciaAbajoDerechaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX0Y1CuandoElPrimeroSeMueveHaciaAbajoIzquierdaDeberiaLanzarMovimientoInvalidoException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,1), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedioAMover.mover(new DireccionAbajoIzquierda());
	}
	 
	//ATAQUE
	
	@Test
	public void testCuandoUnArmaAsedioAtacaUnAldeanoDeberiaLanzarUnidadNoAtacableException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		exceptionRule.expect(UnidadNoAtacableException.class);
		armaAsedio.atacar(aldeano);
	}

	@Test
	public void testCuandoUnArmaAsedioAtacaUnCuartelFueraDeSuRangoDeberiaLanzarAtaqueFueraDeRangoExceptionException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(7,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		armaAsedio.atacar(cuartel);
	}
	
	@Test
	public void testCuandoUnArmaAsedioAtaca5VecesUnCuartelDeberiaLanzarEdificioDestruidoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		armaAsedio.atacar(cuartel);
		armaAsedio.atacar(cuartel);
		armaAsedio.atacar(cuartel);
		armaAsedio.atacar(cuartel);
		
		exceptionRule.expect(EdificioDestruidoException.class);
		armaAsedio.atacar(cuartel);
	}
}
