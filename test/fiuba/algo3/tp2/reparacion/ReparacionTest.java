package fiuba.algo3.tp2.reparacion;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fiuba.algo3.tp2.excepciones.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Ataque;
import fiuba.algo3.tp2.unidad.AtaqueEspadachin;

public class ReparacionTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1NoPuedeRepararUnCuartelQueEsteEnX3Y1()
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		Cuartel cuartel = new Cuartel(new Posicion(3,1), mapa);
		
		exceptionRule.expect(EdificioFueraDeRangoException.class);
		aldeano.repararEdificio(cuartel);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1NoPuedeRepararUnCuartelQueEsteEnX2Y1PeroQueNoEsteDaniado()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		
		Cuartel cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		exceptionRule.expect(EdificioNoAptoParaReparacionException.class);
		
		aldeano.repararEdificio(cuartel);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1PuedeReparaUnCuartelEnX2Y2QueRecibioDanio() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioDestruidoException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);
		
		Ataque ataque = mock(AtaqueEspadachin.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(50);

		cuartel.recibirDanio(ataque);
		
		aldeano.repararEdificio(cuartel);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1PuedeReparaUnCuartelEnX2Y2QueRecibioDanioSoloUnaVezPorTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioDestruidoException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);
		
		Ataque ataque = mock(AtaqueEspadachin.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(50);
		 
		cuartel.recibirDanio(ataque);
		aldeano.repararEdificio(cuartel);
		exceptionRule.expect(EdificioNoAptoParaReparacionException.class);
		aldeano.repararEdificio(cuartel);
	}
	
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1ReparaUnCuartelCon0PorCientoDeVidaEnCuatroTurnos() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioDestruidoException, EdificioConReparadorAsignadoException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {

		Mapa mapa = new Mapa(250,250);

		Jugador ignacio = new Jugador("Jugador 1", mapa);

		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Cuartel cuartel = new Cuartel(new Posicion(2,1),mapa);
		
		Ataque ataque = mock(AtaqueEspadachin.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(249);
		
		boolean checkearRecursos = false;
		ignacio.agregarUnidad(aldeano, mapa, checkearRecursos);

		ignacio.agregarEdificio(cuartel, false);

		Turno turno = new Turno(ignacio, mapa);

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

	@Test
	public void testRepararUnCastillo()
			throws CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, TamanioInvalidoException, EdificioDestruidoException, EdificioConReparadorAsignadoException {

		Mapa mapa = new Mapa(250,250);

		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Edificio castillo = new Castillo(new Posicion(2,1),mapa);
		
		Ataque ataque = mock(AtaqueEspadachin.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(999);

		castillo.recibirDanio(ataque);

		aldeano.repararEdificio(castillo);

		assertEquals(16, castillo.obtenerVida());

	}

	@Test
	public void testDaniarUnCuartelDeberiaMostrarAlCuartelConLaMismaVidaAlAvanzarUnTurnoYNoFueReparado() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioDestruidoException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {

		Mapa mapa = new Mapa(250,250);

		Jugador ignacio = new Jugador("Jugador 1", mapa);

		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Edificio cuartel = new Cuartel(new Posicion(2,1),mapa);
		
		Ataque ataque = mock(AtaqueEspadachin.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(50);
		
		boolean checkearRecursos = false;
		
		ignacio.agregarUnidad(aldeano, mapa, checkearRecursos);

		ignacio.agregarEdificio(cuartel, false);

		Turno turno = new Turno(ignacio, mapa);

		cuartel.recibirDanio(ataque);

		assertEquals(200, cuartel.obtenerVida());

		turno.avanzar();

		assertEquals(200, cuartel.obtenerVida());

	}

	@Test(expected = EdificioConReparadorAsignadoException.class)
	public void testDosAldeanosNoDeberianPoderRepararElMismoEdificio() throws EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioConReparadorAsignadoException, EdificioDestruidoException {

		Mapa mapa = new Mapa(250,250);

		Aldeano juan = new Aldeano(new Posicion(1,1), mapa);

		Aldeano pedro = new Aldeano(new Posicion(1,2), mapa);

		Edificio castillo = new Castillo(new Posicion(2,1),mapa);
		
		Ataque ataque = mock(AtaqueEspadachin.class);
		when(ataque.obtenerDanioEdificio()).thenReturn(999);

		castillo.recibirDanio(ataque);

		juan.repararEdificio(castillo);

		pedro.repararEdificio(castillo);

	}


}
