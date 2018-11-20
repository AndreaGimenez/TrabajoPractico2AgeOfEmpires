package fiuba.algo3.tp2.reparacion;
import static org.junit.Assert.assertEquals;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Edificio;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.turno.Turno;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;

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
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);

		cuartel.recibirDanio(50);
		
		aldeano.repararEdificio(cuartel);
	}
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1PuedeReparaUnCuartelEnX2Y2QueRecibioDanioSoloUnaVezPorTurno()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Cuartel cuartel = new Cuartel(new Posicion(2,2), mapa);
		 
		cuartel.recibirDanio(50);
		aldeano.repararEdificio(cuartel);
		exceptionRule.expect(EdificioNoAptoParaReparacionException.class);
		aldeano.repararEdificio(cuartel);
	}
	
	
	@Test
	public void testUnAldeanoEnLaPosicionX1Y1ReparaUnCuartelCon0PorCientoDeVidaEnCuatroTurnos() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {

		Mapa mapa = new Mapa(250,250);

		Jugador ignacio = new Jugador();

		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Cuartel cuartel = new Cuartel(new Posicion(2,1),mapa);

		ignacio.agregarUnidad(aldeano);

		ignacio.agregarEdificio(cuartel);

		Turno turno = new Turno(ignacio.obtenerPosicionables());

		turno.iniciar();

		cuartel.recibirDanio(249);

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
	public void testRepararUnCastilloDeberiaSumar15PuntosDeVida() throws CeldaOcupadaException, CeldaInexistenteException, EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, TamanioInvalidoException, EdificioConReparadorAsignadoException {

		Mapa mapa = new Mapa(250,250);

		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Edificio castillo = new Castillo(new Posicion(2,1),mapa);

		castillo.recibirDanio(999);

		aldeano.repararEdificio(castillo);

		assertEquals(16, castillo.obtenerVida());

	}

	@Test
	public void testDaniarUnCuartelDeberiaMostrarAlCuartelConLaMismaVidaAlAvanzarUnTurnoYNoFueReparado() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {

		Mapa mapa = new Mapa(250,250);

		Jugador ignacio = new Jugador();

		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);

		Edificio cuartel = new Cuartel(new Posicion(2,1),mapa);

		ignacio.agregarUnidad(aldeano);

		ignacio.agregarEdificio(cuartel);

		Turno turno = new Turno(ignacio.obtenerPosicionables());

		turno.iniciar();

		cuartel.recibirDanio(50);

		assertEquals(200, cuartel.obtenerVida());

		turno.avanzar();

		assertEquals(200, cuartel.obtenerVida());

	}

	@Test(expected = EdificioConReparadorAsignadoException.class)
	public void testDosAldeanosNoDeberianPoderRepararElMismoEdificio() throws EdificioFueraDeRangoException, EdificioNoAptoParaReparacionException, CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, EdificioConReparadorAsignadoException {

		Mapa mapa = new Mapa(250,250);

		Aldeano juan = new Aldeano(new Posicion(1,1), mapa);

		Aldeano pedro = new Aldeano(new Posicion(1,2), mapa);

		Edificio castillo = new Castillo(new Posicion(2,1),mapa);

		castillo.recibirDanio(999);

		juan.repararEdificio(castillo);

		pedro.repararEdificio(castillo);

	}


}
