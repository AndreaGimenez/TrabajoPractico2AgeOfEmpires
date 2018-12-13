package fiuba.algo3.tp2.unidad;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.excepciones.UnidadNoAtacableException;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
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
		
		exceptionRule.expect(CeldaInexistenteException.class);
		armaAsedio.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaEnLaPosicionX1Y2YUnArmaDeAsedioDesmontadaEnLaPosicionX2Y2CuandoSeMueveHaciaDerechaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaMontarlaEIntentarMoverlaEnElMismoTurnoNoDeberiaSerInvalido() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, MontajeInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Jugador jugador = new Jugador("Ana", mapa);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		
		armaAsedio.montar();
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedio.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaSiSeMontaEnUnTurnoEnElSiguienteNoDeberiaPoderMoverse() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MontajeInvalidoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Jugador jugador = new Jugador("Ana", mapa);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		
		armaAsedio.montar();
		
		jugador.avanzarTurno();
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedio.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioMontadaDesmontarlaEIntentarMoverlaEnElMismoTurnoDeberiaSerInvalido() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, MontajeInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Jugador jugador = new Jugador("Ana", mapa);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		
		armaAsedio.montar();
		
		jugador.avanzarTurno();
		
		armaAsedio.desmontar();
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedio.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioMontadaSiSeDesmontaEnUnTurnoEnElSiguienteDeberiaPoderMoverse() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MontajeInvalidoException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Jugador jugador = new Jugador("Ana", mapa);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		
		boolean checkearRecursos = false;
		
		jugador.agregarUnidad(armaAsedio, mapa, checkearRecursos);
		
		armaAsedio.montar();
		
		jugador.avanzarTurno();

		armaAsedio.desmontar();
		
		jugador.avanzarTurno();

		armaAsedio.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaNoDeberiaPoderMoverseDosVecesEnElMismoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MontajeInvalidoException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(5,5);
		
		Jugador jugador = new Jugador("Ana", mapa);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		
		boolean checkearRecursos = false;
		
		jugador.agregarUnidad(armaAsedio, mapa, checkearRecursos);

		armaAsedio.mover(new DireccionArribaDerecha());
		exceptionRule.expect(MovimientoInvalidoException.class);
		armaAsedio.mover(new DireccionAbajoIzquierda());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaQueSeMovioDeberiaPoderMoverseEnElSiguienteTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MontajeInvalidoException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		Jugador jugador = new Jugador("Ana", mapa);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		
		boolean checkearRecursos = false;
		
		jugador.agregarUnidad(armaAsedio, mapa, checkearRecursos);

		armaAsedio.mover(new DireccionArribaDerecha());
		jugador.avanzarTurno();
		armaAsedio.mover(new DireccionAbajoIzquierda());
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
	public void testDadoUnMapaDe5x5UnArmaDeAsedioDesmontadaEnLaPosicionX4Y0SeMueveHaciaLaDerechaDeberiaLanzarCeldaInexistenteException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(4,0), mapa);
		
		exceptionRule.expect(CeldaInexistenteException.class);
		armaAsedio.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioDesmontadaEnLaPosicionX1Y2YUnArmaDeAsedioDesmontadaEnLaPosicionX2Y2CuandoElPrimeroSeMueveHaciaDerechaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,2), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX0Y2CuandoElPrimeroSeMueveHaciaIzquierdaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,2), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionIzquierda());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX1Y1CuandoElPrimeroSeMueveHaciaAbajoDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionAbajo());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX1Y3CuandoElPrimeroSeMueveHaciaArribaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(1,3), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionArriba());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX2Y3CuandoElPrimeroSeMueveHaciaArribaDerechaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,3), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionArribaDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX0Y3CuandoElPrimeroSeMueveHaciaArribaIzquierdaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,3), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionArribaIzquierda());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX2Y1CuandoElPrimeroSeMueveHaciaAbajoDerechaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionAbajoDerecha());
	}
	
	@Test
	public void testDadoUnArmaDeAsedioEnLaPosicionX1Y2YUnArmaDeAsedioEnLaPosicionX0Y1CuandoElPrimeroSeMueveHaciaAbajoIzquierdaDeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(5,5);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,1), mapa);
		ArmaAsedio armaAsedioAMover = new ArmaAsedio(new Posicion(1,2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		armaAsedioAMover.mover(new DireccionAbajoIzquierda());
	}
	 
	//ATAQUE
	
	@Test
	public void testCuandoUnArmaAsedioAtacaUnAldeanoDeberiaLanzarUnidadNoAtacableException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		exceptionRule.expect(UnidadNoAtacableException.class);
		armaAsedio.atacar(aldeano);
	}

	@Test
	public void testCuandoUnArmaAsedioAtacaUnCuartelFueraDeSuRangoDeberiaLanzarAtaqueFueraDeRangoExceptionException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException, UnidadMuertaException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(7,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		armaAsedio.atacar(cuartel);
	}
	
	@Test
	public void testCuandoUnArmaAsedioAtaca5VecesUnCuartelDeberiaLanzarEdificioDestruidoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, 
			EdificioDestruidoException, UnidadMuertaException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MontajeInvalidoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		((ArmaAsedio)armaAsedio).montar();
		Atacable cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		
		exceptionRule.expect(EdificioDestruidoException.class);
		armaAsedio.atacar(cuartel);
	}
}
