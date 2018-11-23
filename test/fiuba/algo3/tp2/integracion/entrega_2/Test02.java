package fiuba.algo3.tp2.integracion.entrega_2;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

/**
 * Reglas de poblacion
 * 		Crear unidades
 * 		Matar unidades
 * 		Matar aldeanos
 * 		Verificar tope poblacional
 *
 */
public class Test02 {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	/*CREACION DE UNIDADES, POBLACION*/
	
	@Test
	public void testAlIniciarUnNuevoJuegoLaPoblacionDelJugadorDeberiaSer3() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
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
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();
		
		Jugador jugador = juego.obtenerJugador(0);
		
		int poblacionAntes = jugador.obtenerPoblacionActual();
		jugador.agregarUnidad(new Aldeano(new Posicion(7,7), mapa), mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testUnJugadorCreaUnArmaDeAsedioLaPoblacionDeberiaHaberAumentadoEn1() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();
		
		Jugador jugador = juego.obtenerJugador(0);
		
		int poblacionAntes = jugador.obtenerPoblacionActual();
		jugador.agregarUnidad(new ArmaAsedio(new Posicion(7,7), mapa), mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(1, poblacionDespues-poblacionAntes);
	}
	
	
	
	/*MATAR UNIDADES*/
	
	/*ARMA DE ASEDIO*/
	
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereUnArmaDeAsedioDeberiaTener3DePoblacion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(armaAsedio, mapa);
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		jugador.removerUnidad(armaAsedio, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(-1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeDestruyeUnArmaDeAsedioQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(armaAsedio, mapa);
		
		jugador.removerUnidad(armaAsedio, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*ALDEANOS*/
	
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereUnAldeanoDeberiaTener3DePoblacion()
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException,
			CeldaInexistenteException, PoblacionMaximaAlcanzadaException {

		Mapa mapa = new Mapa(250, 250);

		Juego juego = new Juego(mapa);

		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Aldeano aldeano = new Aldeano(new Posicion(7, 7), mapa);

		jugador.agregarUnidad(aldeano, mapa);
		int poblacionAntes = jugador.obtenerPoblacionActual();

		jugador.removerUnidad(aldeano, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual();

		assertEquals(-1, poblacionDespues - poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeMuereUnAldeanoQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Aldeano aldeano = new Aldeano(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(aldeano, mapa);
		
		jugador.removerUnidad(aldeano, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*ESPADACHIN*/
	
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereEspadachinDeberiaTener3DePoblacion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Espadachin espadachin = new Espadachin(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(espadachin, mapa);
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		jugador.removerUnidad(espadachin, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(-1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeDestruyeUnEspadachinQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Espadachin espadachin = new Espadachin(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(espadachin, mapa);
		
		jugador.removerUnidad(espadachin, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*ARQUERO*/
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereUnArqueroDeberiaTener3DePoblacion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Arquero arquero = new Arquero(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(arquero, mapa);
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		jugador.removerUnidad(arquero, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(-1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeDestruyeUnArqueroQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();

		Jugador jugador = juego.obtenerJugador(0);
		Arquero arquero = new Arquero(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(arquero, mapa);
		
		jugador.removerUnidad(arquero, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*TOPE POBLACIONAL*/
	
	@Test
	public void testUnJugadorConLaPoblacionMaximaAlIntentarCrearUnaNuevaUnidadDeberiaLanzarPoblacionMaximaAlcanzadaException() 
			throws PoblacionMaximaAlcanzadaException, CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, CantidadDeJugadoresInvalidaException {
		
		Mapa mapa = new Mapa(1000,1000);
		
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		juego.iniciar();
		
		Jugador jugador = juego.obtenerJugador(0);
		
		for (int i = 3 ; i <50 ; i++) {
			jugador.agregarUnidad(new Aldeano(new Posicion(i+10,i+10),mapa),mapa);
		}
		
		exceptionRule.expect(PoblacionMaximaAlcanzadaException.class);
		jugador.agregarUnidad(new Aldeano(new Posicion(0,10),mapa),mapa);
	}
}
