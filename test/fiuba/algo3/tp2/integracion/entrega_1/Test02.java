package fiuba.algo3.tp2.integracion.entrega_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.ConstruccionFueraDeRangoException;
import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.excepciones.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
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
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.AldeanoConConstruccionAsignadaException;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.AtaqueArquero;
import fiuba.algo3.tp2.unidad.DireccionAbajo;
import fiuba.algo3.tp2.unidad.Espadachin;

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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
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
		}catch(CeldaInexistenteException e) {}
	}

	@Test
	public void testAldeanoConstruyePlazaCentralLasPosicionesQueOcupaDeberianEstarOcupadas() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, 
			EdificioNoSoportadoException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, 
			EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, 
			PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, 
			EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException, ConstruccionFueraDeRangoException {

		Mapa mapa = new Mapa(250, 250);
		Jugador jugador1 = new Jugador("Jugador 1", mapa);
		
		Aldeano aldeano = new Aldeano(new Posicion(20, 20), mapa);
		
		boolean checkearRecursos = false;
		
		jugador1.agregarUnidad(aldeano, mapa, checkearRecursos);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(21,20), mapa);
		
		jugador1.agregarEdificio(plazaCentral, checkearRecursos);
		
		aldeano.construirConstruible(plazaCentral);
		
		try {
			new Aldeano(new Posicion(21,20), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
		
		try {
			new Aldeano(new Posicion(21,21), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
		
		try {
			new Aldeano(new Posicion(22,20), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
		
		try {
			new Aldeano(new Posicion(22,21), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
}

	@Test
	public void testAldeanoConstruyeCuartelLasPosicionesQueOcupaDeberianEstarOcupadas() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, 
			EdificioNoSoportadoException, EdifioNoAptoParaContruirException, UnidadNoSoportadaException, 
			EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, 
			PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaConstruccionException, 
			EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException, ConstruccionFueraDeRangoException {

		Mapa mapa = new Mapa(250, 250);
		
		Jugador jugador1 = new Jugador("Jugador 1", mapa);
		
		Aldeano aldeano = new Aldeano(new Posicion(20, 20), mapa);
		
		boolean checkearRecursos = false;
		
		jugador1.agregarUnidad(aldeano, mapa, checkearRecursos);
		
		Cuartel cuartel = new Cuartel(new Posicion(21,20), mapa);
		
		jugador1.agregarEdificio(cuartel, checkearRecursos);
		
		aldeano.construirConstruible(cuartel);
		
		try {
			new Aldeano(new Posicion(21,20), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
		
		try {
			new Aldeano(new Posicion(21,21), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
		
		try {
			new Aldeano(new Posicion(22,20), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
		
		try {
			new Aldeano(new Posicion(22,21), mapa);
			fail();
		}
		catch(CeldaOcupadaException e) {
		}
}

	@Test
	public void testDeReparacionDeCuartel() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, 
			PoblacionMaximaAlcanzadaException, EdificioNoSoportadoException, EdificioFueraDeRangoException, 
			EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, 
			OroInsuficienteException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException, 
			EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, CantidadDeJugadoresInvalidaException, AtaqueInvalidoException {

		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Aldeano aldeano = new Aldeano(new Posicion(20, 20), mapa);

		Jugador jugador1 = juego.obtenerJugadorActual();
		
		boolean checkearRecursos = false;
		jugador1.agregarUnidad(aldeano, mapa, checkearRecursos);
		
		Cuartel cuartel = new Cuartel(new Posicion(21,20), mapa);

		jugador1.agregarEdificio(cuartel, checkearRecursos);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		for(int i = 0 ; i < 24 ; i++) {
			cuartel.recibirDanio(new AtaqueArquero());
		}
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		aldeano.repararEdificio(cuartel);

		assertEquals(60, cuartel.obtenerVida());

		juego.avanzarJugador();
		juego.avanzarJugador();

		assertEquals(110, cuartel.obtenerVida());

		juego.avanzarJugador();
		juego.avanzarJugador();

		assertEquals(160, cuartel.obtenerVida());

		juego.avanzarJugador();
		juego.avanzarJugador();

		assertEquals(210, cuartel.obtenerVida());

		juego.avanzarJugador();
		juego.avanzarJugador();

		assertEquals(250, cuartel.obtenerVida());

	}
}
