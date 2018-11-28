package fiuba.algo3.tp2.integracion.entrega_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.reparacion.EdificioFueraDeRangoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.edificio.EdificioEnConstruccionException;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
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
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.unidad.DireccionAbajo;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.Unidad;
import fiuba.algo3.tp2.unidad.UnidadConstants;

/**
 * Pruebas de Unidades
 * 		Movimiento y direccion
 * 		Construccion
 * 		Reparacion
 *
 */
public class Test02 {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
	// MOVIMIENTO Y DIRECCION
	
	@Test
	public void testMovimientosDeAldeanoEnTodasLasDirecciones() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		//MOVER DERECHA
		aldeano.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(aldeano.obtenerPosicion()));
		
		try {
			aldeano.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		aldeano.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-DERECHA
		aldeano.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(aldeano.obtenerPosicion()));
		
		try {
			aldeano.mover(new DireccionArriba());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		aldeano.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA
		aldeano.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(aldeano.obtenerPosicion()));
		
		try {
			aldeano.mover(new DireccionArribaIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		aldeano.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-IZQUIERDA
		aldeano.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(aldeano.obtenerPosicion()));
		
		try {
			aldeano.mover(new DireccionIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		aldeano.actualizarEstadoParaNuevoTurno();
		
		//MOVER IZQUIERDA
		aldeano.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(aldeano.obtenerPosicion()));
		
		try {
			aldeano.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		aldeano.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-IZQUIERDA
		aldeano.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(1,3).esIgualA(aldeano.obtenerPosicion()));
		
		try {
			aldeano.mover(new DireccionAbajo());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		aldeano.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO
		aldeano.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(aldeano.obtenerPosicion()));
		
		try {
			aldeano.mover(new DireccionAbajoDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		aldeano.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-DERECHA
		aldeano.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(aldeano.obtenerPosicion()));		
	}
	
	@Test
	public void testMovimientoDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		try {
			aldeano.mover(new DireccionAbajo());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		try {
			aldeano.mover(new DireccionIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientosDeEspadachin() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		//MOVER DERECHA
		espadachin.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(espadachin.obtenerPosicion()));
		
		try {
			espadachin.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		espadachin.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-DERECHA
		espadachin.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(espadachin.obtenerPosicion()));
		
		try {
			espadachin.mover(new DireccionArriba());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		espadachin.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA
		espadachin.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(espadachin.obtenerPosicion()));
		
		try {
			espadachin.mover(new DireccionArribaIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		espadachin.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-IZQUIERDA
		espadachin.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(espadachin.obtenerPosicion()));
		
		try {
			espadachin.mover(new DireccionIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		espadachin.actualizarEstadoParaNuevoTurno();
		
		//MOVER IZQUIERDA
		espadachin.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(espadachin.obtenerPosicion()));
		
		try {
			espadachin.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		espadachin.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-IZQUIERDA
		espadachin.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(1,3).esIgualA(espadachin.obtenerPosicion()));
		
		try {
			espadachin.mover(new DireccionAbajo());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		espadachin.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO
		espadachin.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(espadachin.obtenerPosicion()));
		
		try {
			espadachin.mover(new DireccionAbajoDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		espadachin.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-DERECHA
		espadachin.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(espadachin.obtenerPosicion()));
	}

	@Test
	public void testMovimientoDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin aldeano = new Espadachin(new Posicion(0,0), mapa);
		
		try {
			aldeano.mover(new DireccionAbajo());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		try {
			aldeano.mover(new DireccionIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}

	@Test
	public void testMovimientosDeArquero() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		//MOVER DERECHA
		arquero.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(arquero.obtenerPosicion()));
		
		try {
			arquero.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		arquero.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-DERECHA
		arquero.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(arquero.obtenerPosicion()));
		
		try {
			arquero.mover(new DireccionArriba());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		arquero.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA
		arquero.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(arquero.obtenerPosicion()));
		
		try {
			arquero.mover(new DireccionArribaIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		arquero.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-IZQUIERDA
		arquero.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(arquero.obtenerPosicion()));
		
		try {
			arquero.mover(new DireccionIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		arquero.actualizarEstadoParaNuevoTurno();
		
		//MOVER IZQUIERDA
		arquero.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(arquero.obtenerPosicion()));
		
		try {
			arquero.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		arquero.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-IZQUIERDA
		arquero.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(1,3).esIgualA(arquero.obtenerPosicion()));
		
		try {
			arquero.mover(new DireccionAbajo());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		arquero.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO
		arquero.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(arquero.obtenerPosicion()));
		
		try {
			arquero.mover(new DireccionAbajoDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		arquero.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-DERECHA
		arquero.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(arquero.obtenerPosicion()));
	}

	@Test
	public void testMovimientoDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(0,0), mapa);
		
		try {
			arquero.mover(new DireccionAbajo());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		try {
			arquero.mover(new DireccionIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientosDeArmaAsedioDesmontada() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		//MOVER DERECHA
		armaAsedio.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(armaAsedio.obtenerPosicion()));
		
		try {
			armaAsedio.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-DERECHA
		armaAsedio.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(armaAsedio.obtenerPosicion()));
		
		try {
			armaAsedio.mover(new DireccionArriba());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA
		armaAsedio.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(armaAsedio.obtenerPosicion()));
		
		try {
			armaAsedio.mover(new DireccionArribaIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.actualizarEstadoParaNuevoTurno();
		
		//MOVER ARRIBA-IZQUIERDA
		armaAsedio.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(armaAsedio.obtenerPosicion()));
		
		try {
			armaAsedio.mover(new DireccionIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.actualizarEstadoParaNuevoTurno();
		
		//MOVER IZQUIERDA
		armaAsedio.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(armaAsedio.obtenerPosicion()));
		
		try {
			armaAsedio.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-IZQUIERDA
		armaAsedio.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(1,3).esIgualA(armaAsedio.obtenerPosicion()));
		
		try {
			armaAsedio.mover(new DireccionAbajo());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO
		armaAsedio.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(armaAsedio.obtenerPosicion()));
		
		try {
			armaAsedio.mover(new DireccionAbajoDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.actualizarEstadoParaNuevoTurno();
		
		//MOVER ABAJO-DERECHA
		armaAsedio.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(armaAsedio.obtenerPosicion()));
	}

	@Test
	public void testMovimientosDeArmaAsedioMontada() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		armaAsedio.montar();
		
		//MOVER DERECHA
		try {
			armaAsedio.mover(new DireccionDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
		
		armaAsedio.desmontar();
		armaAsedio.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(armaAsedio.obtenerPosicion()));
	}

	@Test
	public void testVerificarConstruccionDePlazaCentral() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {

		Mapa mapa = new Mapa(250, 250);
		Jugador ignacio = new Jugador("Jugador 1");
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
		boolean checkearRecursos = false;
		ignacio.agregarUnidad(aldeano, mapa, checkearRecursos);
		PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);

		posicionador.posicionarALaIzquierdaPorEncima(EdificioConstants.TipoEdificio.PLAZA_CENTRAL);

		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-1)).estaOcupada());
		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-2)).estaOcupada());
		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-2)).estaOcupada());
		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(-1)).estaOcupada());


		GestionarConstruccion gestorPlazaCentral = new GestionarConstruccion((Edificio) mapa.obtenerPosicionable(new Posicion(4,5)));
		ignacio.agregarEdificio(gestorPlazaCentral, false);
		Turno turno = new Turno(ignacio);

		// Turno 0/3

		try{

			gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(6, 5));

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		// Turno 1/3

		try{

			gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(6, 5));

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		// Turno 2/3

		try{

			gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(6, 5));

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		//Turno 3/3

		try{

			gestorPlazaCentral.crear(UnidadConstants.TipoUnidad.ALDEANO, new Posicion(5, 6));

		} catch (EdificioEnConstruccionException e) {

			fail();

		}

	}

	/*@Test
	public void testVerificarConstruccionDeCuartel()
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioNoSoportadoException, TamanioInvalidoException, EdificioEnConstruccionException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {

		Mapa mapa = new Mapa(250, 250);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
		PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);
		Jugador ignacio = new Jugador();
		
		boolean checkearRecursos = false;
		ignacio.agregarUnidad(aldeano, mapa, checkearRecursos);
		ignacio.setOro(250);

		posicionador.posicionarEnAristaInferiorDerecha(EdificioConstants.TipoEdificio.CUARTEL);

		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1)).estaOcupada());
		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarVerticalmente(-2).desplazarHorizontalmente(2)).estaOcupada());
		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(2).desplazarVerticalmente(-1)).estaOcupada());
		assertTrue(mapa.obtenerCelda(aldeano.obtenerPosicion().desplazarHorizontalmente(1).desplazarVerticalmente(-2)).estaOcupada());


		GestionarConstruccion gestorCuartel = new GestionarConstruccion((Edificio) mapa.obtenerPosicionable(new Posicion(6,6)));
		ignacio.agregarEdificio(gestorCuartel);
		Turno turno = new Turno(ignacio);


		// Turno 0/3

		try{

			gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 4));

			fail();

		} catch (EdificioEnConstruccionException e){

		}

		try{

			gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(5, 4));

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		// Turno 1/3

		try{

			gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 4));

			fail();

		} catch (EdificioEnConstruccionException e){

		}

		try{

			gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(5, 4));

			fail();

		} catch (EdificioEnConstruccionException e) {

		}


		turno.avanzar();

		// Turno 2/3

		try{

			gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(5, 4));

			fail();

		} catch (EdificioEnConstruccionException e){

		}

		try{

			gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(5, 4));

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		// Turno 3/3

		try{

			Unidad espadachin = gestorCuartel.crear(UnidadConstants.TipoUnidad.ESPADACHIN, new Posicion(6, 5));

			Unidad arquero = gestorCuartel.crear(UnidadConstants.TipoUnidad.ARQUERO, new Posicion(7, 5));


		} catch (EdificioEnConstruccionException e){

			fail();

		}


		assertEquals(0, ignacio.obtenerOro());
	}
*/

/*	@Test
	public void testDeReparacionDeCuartel() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, EdificioNoSoportadoException, EdificioFueraDeRangoException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, OroInsuficienteException {

		Mapa mapa = new Mapa(250, 250);
		Aldeano aldeano = new Aldeano(new Posicion(5, 5), mapa);
		PosicionarEdificio posicionador = new PosicionarEdificio(aldeano);
		Jugador ignacio = new Jugador();
		
		boolean checkearRecursos = false;
		ignacio.agregarUnidad(aldeano, mapa, checkearRecursos);
		ignacio.setOro(250);
		Ataque ataque = mock(Ataque.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(249);

		posicionador.posicionarEnAristaInferiorDerecha(EdificioConstants.TipoEdificio.CUARTEL);

		Edificio cuartel = (Edificio) mapa.obtenerPosicionable(new Posicion(6,6));

		ignacio.agregarEdificio(cuartel);
		Turno turno = new Turno(ignacio);

		cuartel.recibirDanio(ataque);

		aldeano.repararEdificio(cuartel);

		assertEquals(51, cuartel.obtenerVida());

		turno.avanzar();

		assertEquals(101, cuartel.obtenerVida());

		turno.avanzar();

		assertEquals(151, cuartel.obtenerVida());

		turno.avanzar();

		assertEquals(201, cuartel.obtenerVida());

		turno.avanzar();

		assertEquals(250, cuartel.obtenerVida());

	}
*/

}
