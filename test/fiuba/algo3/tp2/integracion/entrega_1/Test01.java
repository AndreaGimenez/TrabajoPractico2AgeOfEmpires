package fiuba.algo3.tp2.integracion.entrega_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;

/**
 * Pruebas de Mapa - Tamanio y Colocacion de unidades y edificios
 *
 */
public class Test01 {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testCrearMapaTamanio250x250ConUnidades() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Castillo castillo = new Castillo(new Posicion(0,0), mapa);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5,0), mapa);
		Aldeano aldeano1 = new Aldeano(new Posicion(5,2), mapa);
		Aldeano aldeano2 = new Aldeano(new Posicion(6,2), mapa);
		Aldeano aldeano3 = new Aldeano(new Posicion(7,2), mapa);
		
		Castillo castillo2 = new Castillo(new Posicion(246,246), mapa);
		PlazaCentral plazaCentral2 = new PlazaCentral(new Posicion(243,248), mapa);
		Aldeano aldeano4 = new Aldeano(new Posicion(244,247), mapa);
		Aldeano aldeano5 = new Aldeano(new Posicion(243,247), mapa);
		Aldeano aldeano6 = new Aldeano(new Posicion(242,247), mapa);
		
		assertEquals(castillo, mapa.obtenerPosicionable(new Posicion(0,0)));
		assertEquals(plazaCentral, mapa.obtenerPosicionable(new Posicion(5,0)));
		assertEquals(aldeano1, mapa.obtenerPosicionable(new Posicion(5,2)));
		assertEquals(aldeano2, mapa.obtenerPosicionable(new Posicion(6,2)));
		assertEquals(aldeano3, mapa.obtenerPosicionable(new Posicion(7,2)));
		
		assertEquals(castillo2, mapa.obtenerPosicionable(new Posicion(246,246)));
		assertEquals(plazaCentral2, mapa.obtenerPosicionable(new Posicion(243,248)));
		assertEquals(aldeano4, mapa.obtenerPosicionable(new Posicion(244,247)));
		assertEquals(aldeano5, mapa.obtenerPosicionable(new Posicion(243,247)));
		assertEquals(aldeano6, mapa.obtenerPosicionable(new Posicion(242,247)));
		
		assertEquals(null, mapa.obtenerPosicionable(new Posicion(150,150)));
		
		
		try {
			new Aldeano(new Posicion(3,3), mapa);
			fail("Deberia lanzar CeldaOcupadaException");
		}catch(CeldaOcupadaException e) {}
		
		try {
			new Aldeano(new Posicion(5,2), mapa);
			fail("Deberia lanzar CeldaOcupadaException");
		}catch(CeldaOcupadaException e) {}
		
		try {
			new Aldeano(new Posicion(5,2), mapa);
			fail("Deberia lanzar CeldaOcupadaException");
		}catch(CeldaOcupadaException e) {}
		
		try {
			new Aldeano(new Posicion(5,2), mapa);
			fail("Deberia lanzar CeldaOcupadaException");
		}catch(CeldaOcupadaException e) {}
	}
	
}
