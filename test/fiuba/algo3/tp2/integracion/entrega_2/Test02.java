package fiuba.algo3.tp2.integracion.entrega_2;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;

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
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioConReparadorAsignadoException, EdificioNoAptoParaReparacionException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		assertEquals(3, juego.obtenerJugadorActual().obtenerPoblacionActual());
		juego.avanzarJugador();
		assertEquals(3, juego.obtenerJugadorActual().obtenerPoblacionActual());
	}
	
	@Test
	public void testUnJugadorCreaUnAldeanoLaPoblacionDeberiaHaberAumentadoEn1() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador = juego.obtenerJugadorActual();
		
		int poblacionAntes = jugador.obtenerPoblacionActual();
		jugador.agregarUnidad(new Aldeano(new Posicion(7,7), mapa), mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testUnJugadorCreaUnArmaDeAsedioLaPoblacionDeberiaHaberAumentadoEn1() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador = juego.obtenerJugadorActual();
		
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		boolean checkearRecursos = false;
		
		jugador.agregarUnidad(new ArmaAsedio(new Posicion(7,7), mapa), mapa, checkearRecursos);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(1, poblacionDespues-poblacionAntes);
	}
	
	
	
	/*MATAR UNIDADES*/
	
	/*ARMA DE ASEDIO*/
	
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereUnArmaDeAsedioDeberiaTener3DePoblacion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		Jugador jugador = juego.obtenerJugadorActual();
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(7,7), mapa);
		
		boolean checkearRecursos = false;
		jugador.agregarUnidad(armaAsedio, mapa, checkearRecursos);
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		jugador.removerUnidad(armaAsedio, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(-1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeDestruyeUnArmaDeAsedioQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		Jugador jugador = juego.obtenerJugadorActual();
		ArmaAsedio armaAsedio = new ArmaAsedio(new Posicion(7,7), mapa);
		
		boolean checkearRecursos= false;
		
		jugador.agregarUnidad(armaAsedio, mapa, checkearRecursos);
		
		jugador.removerUnidad(armaAsedio, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*ALDEANOS*/
	
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereUnAldeanoDeberiaTener3DePoblacion()
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException,
			CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {

		Mapa mapa = new Mapa(250, 250);

		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});;

		Jugador jugador = juego.obtenerJugadorActual();
		Aldeano aldeano = new Aldeano(new Posicion(7, 7), mapa);

		jugador.agregarUnidad(aldeano, mapa);
		int poblacionAntes = jugador.obtenerPoblacionActual();

		jugador.removerUnidad(aldeano, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual();

		assertEquals(-1, poblacionDespues - poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeMuereUnAldeanoQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		Jugador jugador = juego.obtenerJugadorActual();
		Aldeano aldeano = new Aldeano(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(aldeano, mapa);
		
		jugador.removerUnidad(aldeano, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*ESPADACHIN*/
	
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereEspadachinDeberiaTener3DePoblacion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		Jugador jugador = juego.obtenerJugadorActual();
		Espadachin espadachin = new Espadachin(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(espadachin, mapa);
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		jugador.removerUnidad(espadachin, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(-1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeDestruyeUnEspadachinQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		Jugador jugador = juego.obtenerJugadorActual();
		Espadachin espadachin = new Espadachin(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(espadachin, mapa);
		
		jugador.removerUnidad(espadachin, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*ARQUERO*/
	@Test
	public void testAUnJugadorConPoblacion4AlQueSeLeMuereUnArqueroDeberiaTener3DePoblacion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		Jugador jugador = juego.obtenerJugadorActual();
		Arquero arquero = new Arquero(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(arquero, mapa);
		int poblacionAntes = jugador.obtenerPoblacionActual();
		
		jugador.removerUnidad(arquero, mapa);
		int poblacionDespues = jugador.obtenerPoblacionActual(); 
		
		assertEquals(-1, poblacionDespues-poblacionAntes);
	}
	
	@Test
	public void testAUnJugadorAlQueSeLeDestruyeUnArqueroQueEstabaEnX7Y7DeberiaTenerLibreEsaPosicion() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});

		Jugador jugador = juego.obtenerJugadorActual();
		Arquero arquero = new Arquero(new Posicion(7,7), mapa);
		
		jugador.agregarUnidad(arquero, mapa);
		
		jugador.removerUnidad(arquero, mapa);
		
		new Aldeano(new Posicion(7,7), mapa);
	}
	
	/*TOPE POBLACIONAL*/
	
	@Test
	public void testUnJugadorConLaPoblacionMaximaAlIntentarCrearUnaNuevaUnidadDeberiaLanzarPoblacionMaximaAlcanzadaException() 
			throws PoblacionMaximaAlcanzadaException, CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, CantidadDeJugadoresInvalidaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(1000,1000);
		
		Juego juego = new Juego(mapa);

		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador = juego.obtenerJugadorActual();
		boolean checkearRecursos = false;
		for (int i = 3 ; i <50 ; i++) {
			jugador.agregarUnidad(new Aldeano(new Posicion(i+10,i+10),mapa),mapa, checkearRecursos);
		}
		
		exceptionRule.expect(PoblacionMaximaAlcanzadaException.class);
		jugador.agregarUnidad(new Aldeano(new Posicion(0,10),mapa),mapa);
	}
}
