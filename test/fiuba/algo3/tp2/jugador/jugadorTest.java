package fiuba.algo3.tp2.jugador;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.juego.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;


public class jugadorTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	//POBLACION
	
	@Test
	public void testAlIniciarUnNuevoJuegoLaPoblacionDelJugadorDeberiaSer3() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		assertEquals(3, juego.obtenerJugador(0).obtenerPoblacionActual());
		assertEquals(3, juego.obtenerJugador(1).obtenerPoblacionActual());
	}
	
	@Test
	public void testUnJugadorCreaUnAldeanoLaPoblacionDeberiaHaberAumentadoEn1() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();
		
		Jugador jugador = juego.obtenerJugador(0);
		
		int poblacionAntes = jugador.obtenerPoblacionActual();
		jugador.agregarUnidad(new Aldeano(new Posicion(7,7), mapa));
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereUnAldeanoDeberiaTener3DePoblacion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Aldeano aldeano = new Aldeano(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(aldeano);
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		jugador.removerUnidad(aldeano, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(-1, poblacionDespues-poblacionAntes);
		
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeMuereUnAldeanoQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Aldeano aldeano = new Aldeano(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(aldeano);
		
		jugador.removerUnidad(aldeano, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	@Test
	public void testUnJugadorCreaUnArmaDeAsedioLaPoblacionDeberiaHaberAumentadoEn1() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();
		
		Jugador jugador = juego.obtenerJugador(0);
		
		int poblacionAntes = jugador.obtenerPoblacionActual();
		jugador.agregarUnidad(new ArmaAsedio(new Posicion(7,7), mapa));
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeDestruyeUnArmaDeAsedioQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(armaAsedio);
		
		jugador.removerUnidad(armaAsedio, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
}
