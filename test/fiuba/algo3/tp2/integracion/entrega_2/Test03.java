package fiuba.algo3.tp2.integracion.entrega_2;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.AtacadorZona;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.EdificioDestruidoException;
import fiuba.algo3.tp2.mapa.Atacable;
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
import fiuba.algo3.tp2.unidad.Atacador;
import fiuba.algo3.tp2.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.unidad.Espadachin;
import fiuba.algo3.tp2.unidad.MontajeInvalidoException;
import fiuba.algo3.tp2.excepciones.UnidadMuertaException;
import fiuba.algo3.tp2.excepciones.UnidadNoAtacableException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;

/**
 * Tests de Ataques de unidades y castillo
 *
 */
public class Test03 {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	// ATAQUES DE ESPADACHIN
	
	@Test
	public void testUnEspadachinAtacaAUnAldeanoDentroDeSuRangoHastaMatarlo() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadMuertaException, 
			EdificioDestruidoException, AtaqueFueraDeRangoException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador espadachin = new Espadachin(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		espadachin.atacar(aldeano);
		espadachin.actualizarEstadoParaSiguienteTurno();
		espadachin.atacar(aldeano);
		espadachin.actualizarEstadoParaSiguienteTurno();
		
		exceptionRule.expect(UnidadMuertaException.class);
		espadachin.atacar(aldeano);
	}
	
	@Test
	public void testUnEspadachinAtacaUnCuartelHastaDestruirlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, 
			EdificioDestruidoException, UnidadMuertaException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador espadachin = new Espadachin(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		for(int i = 0; i < 17; i++) {
			espadachin.atacar(cuartel);
			espadachin.actualizarEstadoParaSiguienteTurno();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		espadachin.atacar(cuartel);
	}
	
	@Test
	public void testUnEspadachinAtacaUnAldeanoFueraDeSuRango() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador espadachin = new Espadachin(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(3,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		espadachin.atacar(aldeano);
	}
	
	// ATAQUES DE ARQUERO
	
	@Test
	public void testUnArqueroAtacaUnAldeanoFueraDeSuRango() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		arquero.atacar(aldeano);
	}
	
	@Test
	public void testUnArqueroAtacaUnAldeanoHastaMatarlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, 
			AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable aldeano = new Aldeano(new Posicion(2,1), mapa);
		
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		arquero.atacar(aldeano);
		arquero.actualizarEstadoParaSiguienteTurno();
		
		exceptionRule.expect(UnidadMuertaException.class);
		arquero.atacar(aldeano);
	}
	
	@Test
	public void testUnArqueroAtacaUnCuartelHastaDestruirlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, 
			EdificioDestruidoException, UnidadMuertaException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador arquero = new Arquero(new Posicion(1,1), mapa);
		Atacable cuartel = new Cuartel(new Posicion(4,1), mapa);
		
		for(int i = 1; i < 26; i++) {
			arquero.atacar(cuartel);
			arquero.actualizarEstadoParaSiguienteTurno();
		}
		
		exceptionRule.expect(EdificioDestruidoException.class);
		arquero.atacar(cuartel);
	}
	
	// ATAQUES DE ARMA DE ASEDIO
	
	@Test
	public void testUnArmaDeAsedioAtacaUnAldeano() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, UnidadMuertaException, EdificioDestruidoException, AtaqueInvalidoException, MontajeInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		((ArmaAsedio)armaAsedio).montar();
		Atacable aldeano = new Aldeano(new Posicion(5,1), mapa);
		
		exceptionRule.expect(UnidadNoAtacableException.class);
		armaAsedio.atacar(aldeano);
	}

	@Test
	public void testUnArmaDeAsedioAtacaUnCuartelFueraDeSuRango() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException, UnidadMuertaException, AtaqueInvalidoException, MontajeInvalidoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		((ArmaAsedio)armaAsedio).montar();
		Atacable cuartel = new Cuartel(new Posicion(7,1), mapa);
		
		exceptionRule.expect(AtaqueFueraDeRangoException.class);
		armaAsedio.atacar(cuartel);
	}
	
	@Test
	public void testUnArmaDeAsedioAtacaUnCuartelHastaDestruirlo() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException, AtaqueFueraDeRangoException, EdificioDestruidoException, 
			UnidadMuertaException, AtaqueInvalidoException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, MontajeInvalidoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(250,250);
		
		Jugador jugador = new Jugador("Ana", mapa);
		
		Atacador armaAsedio = new ArmaAsedio(new Posicion(1,1), mapa);
		((ArmaAsedio)armaAsedio).montar();
		Atacable cuartel = new Cuartel(new Posicion(2,1), mapa);
		
		jugador.avanzarTurno();
		
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		armaAsedio.atacar(cuartel);
		armaAsedio.actualizarEstadoParaSiguienteTurno();
		
		exceptionRule.expect(EdificioDestruidoException.class);
		armaAsedio.atacar(cuartel);
	}
	
	// ATAQUES DE CASTILLO
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
