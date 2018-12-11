package fiuba.algo3.tp2.unidad;

import fiuba.algo3.tp2.excepciones.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.movimiento.DireccionAbajoDerecha;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionArribaDerecha;
import fiuba.algo3.tp2.movimiento.DireccionArribaIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;

public class ArqueroTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testDadoUnArqueroEnlaPosicionX5Y2CuandoSePosicionaOtroArqueroEnLaPosicionX5Y2DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Arquero arquero = new Arquero(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void testUnArqueroEnLaPosicionX2Y1SeMueveHaciaLaDerechaDeberiaEstarEnX3Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(3,1), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaLaIzquierdaDeberiaEstarEnX1Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(1,1), mapa);
	}
	
	@Test
	public void testUnArqueroEnLaPosicionX2Y1SeMueveHaciaArribaDeberiaEstarEnX2Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionArriba());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(2,2), mapa);
	}
	
	@Test
	public void testUnArqueroEnLaPosicionX2Y1SeMueveHaciaAbajoDeberiaEstarEnX2Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionAbajo());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(2,0), mapa);
	}
	
	@Test
	public void testUnArqueroEnLaPosicionX2Y1SeMueveHaciaArribaDerechaDeberiaEstarEnX3Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionArribaDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(3,2), mapa);
	}
	
	@Test
	public void testUnArqueroEnLaPosicionX2Y1SeMueveHaciaAbajoDerechaDeberiaEstarEnXY0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionAbajoDerecha());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(3,0), mapa);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX2Y1SeMueveHaciaAbajoIzquierdaDeberiaEstarEnX1Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionAbajoIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(1,0), mapa);
	}
	
	@Test
	public void testUnArqueroEnLaPosicionX2Y1SeMueveHaciaArribaIzquierdaDeberiaEstarEnX1Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionArribaIzquierda());
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Arquero otroArquero = new Arquero(new Posicion(1,2), mapa);
	}

	@Test
	public void testDadoUnMapaDe5x5UnArqueroEnLaPosicionX4Y0SeMueveHaciaDerechaDeberiaLanzarCeldaInexistenteException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(4,0), mapa);
		
		exceptionRule.expect(CeldaInexistenteException.class);
		arquero.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX2Y2CuandoSeMueveHaciaDerechaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(2,2), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX0Y2CuandoElPrimeroSeMueveHaciaIzquierdaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(0,2), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionIzquierda());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX1Y1CuandoElPrimeroSeMueveHaciaAbajoDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(1,1), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionAbajo());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX1Y3CuandoElPrimeroSeMueveHaciaArribaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(1,3), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionArriba());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX2Y3CuandoElPrimeroSeMueveHaciaArribaDerechaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(2,3), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionArribaDerecha());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX0Y3CuandoElPrimeroSeMueveHaciaArribaIzquierdaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(0,3), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionArribaIzquierda());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX2Y1CuandoElPrimeroSeMueveHaciaAbajoDerechaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnArqueroEnLaPosicionX1Y2YUnArqueroEnLaPosicionX0Y1CuandoElPrimeroSeMueveHaciaAbajoIzquierdaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Arquero arquero = new Arquero(new Posicion(0,1), mapa);
		Arquero arqueroAMover = new Arquero(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		arqueroAMover.mover(new DireccionAbajoIzquierda());
	} 
	
	//ATAQUE
	
	@Test
	public void testCuandoUnArqueroAtacaUnAldeanoFueraDeSuRangoDeberiaLanzarAtaqueFueraDeRangoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		arquero.atacar(aldeano);
	}
	
	@Test
	public void testCuandoUnArqueroAtaca5VecesAUnAldeanoDeberiaLanzarUnidadMuertaException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, 
			AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		
		exceptionRule.expect(UnidadMuertaException.class);
		arquero.atacar(aldeano);
	}
	
	@Test
	public void testCuandoUnArqueroAtaca26VecesAUnCuartelElUltimoAtaqueDeberiaLanzarEdificioDestruidoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, 
			EdificioDestruidoException, UnidadMuertaException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(4,1), mapa);
		
		for(int i = 1; i < 26; i++) {
			arquero.atacar(cuartel);
			arquero.actualizarEstadoParaSiguienteTurno();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		arquero.atacar(cuartel);
	}
}
