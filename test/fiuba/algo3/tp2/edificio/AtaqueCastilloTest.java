package fiuba.algo3.tp2.edificio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.Unidad;

public class AtaqueCastilloTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadoUnAldeanoQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarMuerto() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException {
		
		Mapa mapa = new Mapa(20,20);
		Juego juego = new Juego(mapa);
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Castillo castillo =(Castillo)mapa.obtenerPosicionable(new Posicion(0,0));	
		Aldeano aldeano = new Aldeano(new Posicion(0,4), mapa);
		
		juego.avanzarJugador();
		Jugador jugador2 = juego.obtenerJugadorActual();
		
		jugador2.agregarUnidad(aldeano, mapa, false);
		
		juego.avanzarJugador();/*ATAQUE*/
		juego.avanzarJugador();
		juego.avanzarJugador();/*ATAQUE*/
		juego.avanzarJugador();
		juego.avanzarJugador();/*ATAQUE*/
		juego.avanzarJugador();
		
		assertEquals(true,aldeano.estaMuerta());
	}

	@Test
	public void test_DadoUnAldeanoQueSeEncuentraFueraDeLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca3Veces_ElAldeanoDeberiaEstarVivo() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(20,20);
		Juego juego = new Juego(mapa);
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Castillo castillo =(Castillo)mapa.obtenerPosicionable(new Posicion(0,0));	
		Aldeano aldeano = new Aldeano(new Posicion(0,19), mapa);
		
		juego.avanzarJugador();
		Jugador jugador2 = juego.obtenerJugadorActual();
		
		jugador2.agregarUnidad(aldeano, mapa, false);
		
		juego.avanzarJugador();/*ATAQUE*/
		juego.avanzarJugador();
		juego.avanzarJugador();/*ATAQUE*/
		juego.avanzarJugador();
		juego.avanzarJugador();/*ATAQUE*/
		juego.avanzarJugador();
		
		assertEquals(false,aldeano.estaMuerta());
	}
	
	@Test
	public void test_DadoUnCuartelQueSeEncuentraEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca13Veces_ElEdificioDeberiaEstarDestruido() throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException{
		
		Mapa mapa = new Mapa(20,20);
		Juego juego = new Juego(mapa);
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Castillo castillo =(Castillo)mapa.obtenerPosicionable(new Posicion(0,0));	
		Cuartel cuartel = new Cuartel(new Posicion(0,5), mapa);
		
		juego.avanzarJugador();
		Jugador jugador2 = juego.obtenerJugadorActual();
		
		jugador2.agregarEdificio(cuartel, false);
		
		
		for(int i = 0 ; i < 13 ; i ++) {
			juego.avanzarJugador();/*ATAQUE*/
			juego.avanzarJugador();
		}
		
		assertEquals(true,cuartel.estaDestruido());
	}
	
	@Test
	public void test_DadoUnCuartelYUnAldeanoQueSeEncuentranEnLaZonaDeAtaqueDeUnCastillo_CuandoElCastilloAtaca14Veces_ElEdificioDeberiaEstarDestruidoYElAldeanoMuerto() throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(20,20);
		Juego juego = new Juego(mapa);
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Castillo castillo =(Castillo)mapa.obtenerPosicionable(new Posicion(0,0));	
		Cuartel cuartel = new Cuartel(new Posicion(0,5), mapa);
		Aldeano aldeano = new Aldeano(new Posicion(4,4), mapa);
		juego.avanzarJugador();
		Jugador jugador2 = juego.obtenerJugadorActual();
		
		jugador2.agregarEdificio(cuartel, false);
		jugador2.agregarUnidad(aldeano, mapa, false);
		
		for(int i = 0 ; i < 3 ; i ++) {
			juego.avanzarJugador();/*ATAQUE*/
			juego.avanzarJugador();
		}
		assertEquals(true,aldeano.estaMuerta());
		
		for(int i = 0 ; i < 10 ; i ++) {
			juego.avanzarJugador();/*ATAQUE*/
			juego.avanzarJugador();
		}
		assertEquals(true,cuartel.estaDestruido());
	}
}
