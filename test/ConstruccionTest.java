import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioFueraDeRangoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.excepciones.MovimientoInvalidoException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.juego.PoblacionMaximaAlcanzadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.AldeanoConConstruccionAsignadaException;
import fiuba.algo3.tp2.unidad.AtaqueArquero;
import fiuba.algo3.tp2.unidad.DireccionAbajo;

public class ConstruccionTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testUnAldeanoEnX0Y0ConstruyeUnaPlazaCentralEnX1Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException {
		
		Mapa mapa = new Mapa(10,10);
		
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		aldeano.construirConstruible(new PlazaCentral(new Posicion (1,0), mapa));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(1,0), mapa);
	}
	
	@Test
	public void testUnAldeanoEnX0Y0ConstruyeUnaPlazaCentralEnX1Y0DeberiaEstarEnConstruccion() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException {
		
		Mapa mapa = new Mapa(10,10);
		
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion (1,0), mapa);
		aldeano.construirConstruible(plazaCentral);
		
		assertEquals(false, plazaCentral.estaConstruido());
	}
	
	@Test
	public void testUnAldeanoEnX0Y0ConstruyeUnCuartelEnX1Y0() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException {
		
		Mapa mapa = new Mapa(10,10);
		
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		aldeano.construirConstruible(new Cuartel(new Posicion (1,0), mapa));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(1,0), mapa);
	}
	
	@Test
	public void testUnAldeanoEnX0Y0ConstruyeUnCuartelEnX1Y0DeberiaEstarEnConstruccion() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException {
		
		Mapa mapa = new Mapa(10,10);
		
		Aldeano aldeano = new Aldeano(new Posicion(0,0), mapa);
		
		Cuartel cuartel = new Cuartel (new Posicion (1,0), mapa);
		aldeano.construirConstruible(cuartel);
		
		assertEquals(false, cuartel.estaConstruido());
	}
	
	//INTEGRACION
	
	@Test
	public void testUnAldeanoEnX5Y3ConstruyeUnaPlazaCentralEnX6Y3DeberiaTardar3TurnosEnConstruirse() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(20,20);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano = (Aldeano) mapa.obtenerPosicionable(new Posicion(5,3));
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(6,3), mapa);
		
		jugador1.agregarEdificio(plazaCentral, false);
		
		aldeano.construirConstruible(plazaCentral);
		
		assertEquals(false, plazaCentral.estaConstruido());
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		assertEquals(false, plazaCentral.estaConstruido());
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		assertEquals(false, plazaCentral.estaConstruido());

		juego.avanzarJugador();
		juego.avanzarJugador();
		assertEquals(true, plazaCentral.estaConstruido());
}
	
	@Test
	public void testUnAldeanoEnX5Y3ConstruyeUnCuartelEnX6Y3DeberiaTardar3TurnosEnConstruirse() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(20,20);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano = (Aldeano) mapa.obtenerPosicionable(new Posicion(5,3));
		
		Cuartel cuartel = new Cuartel(new Posicion(6,3), mapa);
		
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		assertEquals(false, cuartel.estaConstruido());
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		assertEquals(false, cuartel.estaConstruido());
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		assertEquals(false, cuartel.estaConstruido());

		juego.avanzarJugador();
		juego.avanzarJugador();
		assertEquals(true, cuartel.estaConstruido());
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelNoPuedeMoverse() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException {
		Mapa mapa = new Mapa(20,20);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano = (Aldeano) mapa.obtenerPosicionable(new Posicion(5,3));
		
		Cuartel cuartel = new Cuartel(new Posicion(6,3), mapa);
		
		jugador1.agregarEdificio(cuartel, false);
		aldeano.construirConstruible(cuartel);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeano.mover(new DireccionAbajo());
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelPuedeMoverseAlTerminarLaConstruccion() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException {
		Mapa mapa = new Mapa(20,20);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano = (Aldeano) mapa.obtenerPosicionable(new Posicion(5,3));
		
		Cuartel cuartel = new Cuartel(new Posicion(6,3), mapa);
		
		jugador1.agregarEdificio(cuartel, false);
		aldeano.construirConstruible(cuartel);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		aldeano.mover(new DireccionAbajo());
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelNoPuedeConstruirOtraEdificio() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException {
		Mapa mapa = new Mapa(30,30);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano =new Aldeano(new Posicion(8,15), mapa);
		jugador1.agregarUnidad(aldeano, mapa, false);
		
		Cuartel cuartel = new Cuartel(new Posicion(7,16), mapa);	
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		Cuartel otroCuartel = new Cuartel(new Posicion(9,15), mapa);
		exceptionRule.expect(AldeanoConConstruccionAsignadaException.class);
		aldeano.construirConstruible(otroCuartel);
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelPuedeConstruirOtroEdificioAlFinalizar() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException {
		
		Mapa mapa = new Mapa(30,30);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano =new Aldeano(new Posicion(8,15), mapa);
		jugador1.agregarUnidad(aldeano, mapa, false);
		
		Cuartel cuartel = new Cuartel(new Posicion(7,16), mapa);	
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		Cuartel otroCuartel = new Cuartel(new Posicion(9,15), mapa);
		aldeano.construirConstruible(otroCuartel);
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelNoPuedeRepararOtroEdificio() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, EdificioFueraDeRangoException, YaSeReparoEnESteTurnoException {
		Mapa mapa = new Mapa(30,30);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano =new Aldeano(new Posicion(8,15), mapa);
		jugador1.agregarUnidad(aldeano, mapa, false);
		
		Cuartel cuartel = new Cuartel(new Posicion(7,16), mapa);	
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		Cuartel otroCuartel = new Cuartel(new Posicion(9,15), mapa);
		otroCuartel.recibirDanio(new AtaqueArquero());
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		exceptionRule.expect(AldeanoConConstruccionAsignadaException.class);
		aldeano.repararEdificio(otroCuartel);
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelPuedeRepararOtroEdificio() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, EdificioFueraDeRangoException, YaSeReparoEnESteTurnoException {
		Mapa mapa = new Mapa(30,30);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano =new Aldeano(new Posicion(8,15), mapa);
		jugador1.agregarUnidad(aldeano, mapa, false);
		
		Cuartel cuartel = new Cuartel(new Posicion(7,16), mapa);	
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		Cuartel otroCuartel = new Cuartel(new Posicion(9,15), mapa);
		otroCuartel.recibirDanio(new AtaqueArquero());
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		exceptionRule.expect(AldeanoConConstruccionAsignadaException.class);
		aldeano.repararEdificio(otroCuartel);
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelPuedeRepararOtroEdificioAlFinalizarLaConstruccion() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, AldeanoConConstruccionAsignadaException, EdificioFueraDeRangoException, YaSeReparoEnESteTurnoException {
		Mapa mapa = new Mapa(30,30);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano =new Aldeano(new Posicion(8,15), mapa);
		jugador1.agregarUnidad(aldeano, mapa, false);
		
		Cuartel cuartel = new Cuartel(new Posicion(7,16), mapa);	
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		Cuartel otroCuartel = new Cuartel(new Posicion(9,15), mapa);
		otroCuartel.recibirDanio(new AtaqueArquero());
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		aldeano.repararEdificio(otroCuartel);
	}
}
