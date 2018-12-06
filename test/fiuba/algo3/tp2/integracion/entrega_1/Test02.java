package fiuba.algo3.tp2.integracion.entrega_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;


import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.edificio.EdificioConstants;
import fiuba.algo3.tp2.excepciones.EdificioEnConstruccionException;
import fiuba.algo3.tp2.excepciones.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.GestionarConstruccion;
import fiuba.algo3.tp2.edificio.PosicionarEdificio;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionAbajoDerecha;
import fiuba.algo3.tp2.movimiento.DireccionAbajoIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionArriba;
import fiuba.algo3.tp2.movimiento.DireccionArribaDerecha;
import fiuba.algo3.tp2.movimiento.DireccionArribaIzquierda;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.movimiento.DireccionIzquierda;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.DireccionAbajo;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.MontajeInvalidoException;

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
	public void testUnAldeanoSoloPuedeMoverseUnaVezPorTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		//MUEVE UNA VEZ
		aldeano.mover(new DireccionDerecha());
		
		try {
			aldeano.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientosDeAldeanoDireccionDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		aldeano.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(aldeano.obtenerPosicion()));
		
		
	}
	
	@Test
	public void testMovimientosDeAldeanoDireccionArribaDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(3,1), mapa);
		
		aldeano.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(aldeano.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeAldeanoDireccionArriba() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(4,2), mapa);
		
		aldeano.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(aldeano.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeAldeanoDireccionArribaIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(4,3), mapa);
		
		aldeano.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(aldeano.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeAldeanoDireccionIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(3,4), mapa);
		
		aldeano.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(aldeano.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeAldeanoDireccionAbajoIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(3,4), mapa);
		
		aldeano.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(2,3).esIgualA(aldeano.obtenerPosicion()));
	}
	
	
	@Test
	public void testMovimientosDeAldeanoDireccionAbajo() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,3), mapa);
		
		aldeano.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(aldeano.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeAldeanoDireccionAbajoDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,2), mapa);
		
		aldeano.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(aldeano.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientoHaciaAbajoDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		try {
			aldeano.mover(new DireccionAbajo());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoALaIzquierdaDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		try {
			aldeano.mover(new DireccionIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaAbajoALaIzquierdaDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		try {
			aldeano.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	@Test
	public void testMovimientoHaciaAbajoALaDerechaDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		try {
			aldeano.mover(new DireccionAbajoDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaIzquierdaDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		try {
			aldeano.mover(new DireccionArribaIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(249,249), mapa);
		
		try {
			aldeano.mover(new DireccionArriba());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaDerechaDeAldeanoQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Aldeano aldeano = new Aldeano(new Posicion(249,249), mapa);
		
		try {
			aldeano.mover(new DireccionArribaDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	//Espadachin
	
	@Test
	public void testUnEspadachinSoloPuedeMoverseUnaVezPorTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		//MUEVE UNA VEZ
		espadachin.mover(new DireccionDerecha());
		
		try {
			espadachin.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientosDeEspadachinDireccionDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(2,1), mapa);
		
		espadachin.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(espadachin.obtenerPosicion()));
		
		
	}
	
	@Test
	public void testMovimientosDeEspadachinDireccionArribaDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(3,1), mapa);
		
		espadachin.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(espadachin.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeEspadachinDireccionArriba() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(4,2), mapa);
		
		espadachin.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(espadachin.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeEspadachinDireccionArribaIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(4,3), mapa);
		
		espadachin.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(espadachin.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeEspadachinDireccionIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(3,4), mapa);
		
		espadachin.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(espadachin.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeEspadachinDireccionAbajoIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(3,4), mapa);
		
		espadachin.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(2,3).esIgualA(espadachin.obtenerPosicion()));
	}
	
	
	@Test
	public void testMovimientosDeEspadachinDireccionAbajo() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(1,3), mapa);
		
		espadachin.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(espadachin.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeEspadachinDireccionAbajoDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Espadachin espadachin = new Espadachin(new Posicion(1,2), mapa);
		
		espadachin.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(espadachin.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientoHaciaAbajoDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin espadachin = new Espadachin(new Posicion(0,0), mapa);
		
		try {
			espadachin.mover(new DireccionAbajo());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoALaIzquierdaDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin espadachin = new Espadachin(new Posicion(0,0), mapa);
		
		try {
			espadachin.mover(new DireccionIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaAbajoALaIzquierdaDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin espadachin = new Espadachin(new Posicion(0,0), mapa);
		
		try {
			espadachin.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	@Test
	public void testMovimientoHaciaAbajoALaDerechaDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin espadachin = new Espadachin(new Posicion(0,0), mapa);
		
		try {
			espadachin.mover(new DireccionAbajoDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaIzquierdaDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin espadachin = new Espadachin(new Posicion(0,0), mapa);
		
		try {
			espadachin.mover(new DireccionArribaIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin espadachin = new Espadachin(new Posicion(249,249), mapa);
		
		try {
			espadachin.mover(new DireccionArriba());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaDerechaDeEspadachinQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Espadachin espadachin = new Espadachin(new Posicion(249,249), mapa);
		
		try {
			espadachin.mover(new DireccionArribaDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	//Arquero
	@Test
	public void testUnArqueroSoloPuedeMoverseUnaVezPorTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		//MUEVE UNA VEZ
		arquero.mover(new DireccionDerecha());
		
		try {
			arquero.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientosDeArqueroDireccionDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(2,1), mapa);
		
		arquero.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(arquero.obtenerPosicion()));
		
		
	}
	
	@Test
	public void testMovimientosDeArqueroDireccionArribaDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(3,1), mapa);
		
		arquero.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(arquero.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArqueroDireccionArriba() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(4,2), mapa);
		
		arquero.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(arquero.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArqueroDireccionArribaIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(4,3), mapa);
		
		arquero.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(arquero.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArqueroDireccionIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(3,4), mapa);
		
		arquero.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(arquero.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArqueroDireccionAbajoIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(3,4), mapa);
		
		arquero.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(2,3).esIgualA(arquero.obtenerPosicion()));
	}
	
	
	@Test
	public void testMovimientosDeArqueroDireccionAbajo() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(1,3), mapa);
		
		arquero.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(arquero.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArqueroDireccionAbajoDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Arquero arquero = new Arquero(new Posicion(1,2), mapa);
		
		arquero.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(arquero.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientoHaciaAbajoDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(0,0), mapa);
		
		try {
			arquero.mover(new DireccionAbajo());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoALaIzquierdaDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(0,0), mapa);
		
		try {
			arquero.mover(new DireccionIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaAbajoALaIzquierdaDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(0,0), mapa);
		
		try {
			arquero.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	@Test
	public void testMovimientoHaciaAbajoALaDerechaDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(0,0), mapa);
		
		try {
			arquero.mover(new DireccionAbajoDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaIzquierdaDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(0,0), mapa);
		
		try {
			arquero.mover(new DireccionArribaIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(249,249), mapa);
		
		try {
			arquero.mover(new DireccionArriba());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaDerechaDeArqueroQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		Arquero arquero = new Arquero(new Posicion(249,249), mapa);
		
		try {
			arquero.mover(new DireccionArribaDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	//ARAMA ASEDIO
	@Test
	public void testUnArmaAsedioSoloPuedeMoverseUnaVezPorTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		//MUEVE UNA VEZ
		armaAsedio.mover(new DireccionDerecha());
		
		try {
			armaAsedio.mover(new DireccionArribaDerecha());
			fail("Deberia lanza MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, 
			EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(2,1), mapa);
		
		armaAsedio.mover(new DireccionDerecha());
		assertTrue(new Posicion(3,1).esIgualA(armaAsedio.obtenerPosicion()));
		
		
	}
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionArribaDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(3,1), mapa);
		
		armaAsedio.mover(new DireccionArribaDerecha());
		assertTrue(new Posicion(4,2).esIgualA(armaAsedio.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionArriba() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(4,2), mapa);
		
		armaAsedio.mover(new DireccionArriba());
		assertTrue(new Posicion(4,3).esIgualA(armaAsedio.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionArribaIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(4,3), mapa);
		
		armaAsedio.mover(new DireccionArribaIzquierda());
		assertTrue(new Posicion(3,4).esIgualA(armaAsedio.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(3,4), mapa);
		
		armaAsedio.mover(new DireccionIzquierda());
		assertTrue(new Posicion(2,4).esIgualA(armaAsedio.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionAbajoIzquierda() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(3,4), mapa);
		
		armaAsedio.mover(new DireccionAbajoIzquierda());
		assertTrue(new Posicion(2,3).esIgualA(armaAsedio.obtenerPosicion()));
	}
	
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionAbajo() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(1,3), mapa);
		
		armaAsedio.mover(new DireccionAbajo());
		assertTrue(new Posicion(1,2).esIgualA(armaAsedio.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientosDeArmaAsedioMontadaDireccionAbajoDerecha() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(1,2), mapa);
		
		armaAsedio.mover(new DireccionAbajoDerecha());
		assertTrue(new Posicion(2,1).esIgualA(armaAsedio.obtenerPosicion()));
	}
	
	@Test
	public void testMovimientoHaciaAbajoDeArmaAsedioQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,0), mapa);
		
		try {
			armaAsedio.mover(new DireccionAbajo());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoALaIzquierdaDeArmaAsedioQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,0), mapa);
		
		try {
			armaAsedio.mover(new DireccionIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaAbajoALaIzquierdaDeArmaAsedioQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,0), mapa);
		
		try {
			armaAsedio.mover(new DireccionAbajoIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	@Test
	public void testMovimientoHaciaAbajoALaDerechaDeArmaAsedioQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,0), mapa);
		
		try {
			armaAsedio.mover(new DireccionAbajoDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaIzquierdaDeArmaAsedioQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(0,0), mapa);
		
		try {
			armaAsedio.mover(new DireccionArribaIzquierda());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaDeArmaAsedioQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(249,249), mapa);
		
		try {
			armaAsedio.mover(new DireccionArriba());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}
	
	@Test
	public void testMovimientoHaciaArribaALaDerechaDeArmaAsedioQueSeEncuentraEnElBordeDelMapa() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
					EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MovimientoInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(249,249), mapa);
		
		try {
			armaAsedio.mover(new DireccionArribaDerecha());
			fail("Deberia lanzar MovimientoInvalidoException");
		}catch(MovimientoInvalidoException e) {}
	}

	@Test
	public void testVerificarConstruccionDePlazaCentral() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioNoSoportadoException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {

		Mapa mapa = new Mapa(250, 250);
		Jugador ignacio = new Jugador("Jugador 1", mapa);
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
		Turno turno = new Turno(ignacio, mapa);

		// Turno 0/3

		try{

			gestorPlazaCentral.crearAldeano(new Posicion(6, 5), mapa);

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		// Turno 1/3

		try{

			gestorPlazaCentral.crearAldeano(new Posicion(6, 5), mapa);

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		// Turno 2/3

		try{

			gestorPlazaCentral.crearAldeano(new Posicion(6, 5), mapa);

			fail();

		} catch (EdificioEnConstruccionException e) {

		}

		turno.avanzar();

		//Turno 3/3

		try{

			gestorPlazaCentral.crearAldeano(new Posicion(5, 6), mapa);

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
