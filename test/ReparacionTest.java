import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.construccion.ConstruccionFueraDeRangoException;
import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.excepciones.AtaqueInvalidoException;
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

public class ReparacionTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testUnAldeanoQueEstaReparandoUnCuartelNoPuedeMoverse() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioFueraDeRangoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException, ConstruccionFueraDeRangoException, AtaqueInvalidoException {
		Mapa mapa = new Mapa(20,20);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano = (Aldeano) mapa.obtenerPosicionable(new Posicion(5,3));
		
		Cuartel cuartel = new Cuartel(new Posicion(6,3), mapa);
		
		cuartel.recibirDanio(new AtaqueArquero());
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		/*EL CUARTEL YA FUE CONSTRUIDO*/
		
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		
		aldeano.repararEdificio(cuartel);

		juego.avanzarJugador();
		juego.avanzarJugador();
		
		exceptionRule.expect(MovimientoInvalidoException.class);
		aldeano.mover(new DireccionAbajo());
	}
	
	@Test
	public void testUnAldeanoQueEstaConstruyendoUnCuartelPuedeMoverseAlTerminarLaConstruccion() 
			throws CeldaOcupadaException, CeldaInexistenteException, CantidadDeJugadoresInvalidaException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, TamanioInvalidoException, EdificioConConstructorAsignadoException, MovimientoInvalidoException, EdificioNoAptoParaConstruccionException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioFueraDeRangoException, AldeanoConConstruccionAsignadaException, YaSeReparoEnESteTurnoException, ConstruccionFueraDeRangoException, AtaqueInvalidoException {
		Mapa mapa = new Mapa(20,20);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano = (Aldeano) mapa.obtenerPosicionable(new Posicion(5,3));
		
		Cuartel cuartel = new Cuartel(new Posicion(6,3), mapa);
		
		cuartel.recibirDanio(new AtaqueArquero());
		jugador1.agregarEdificio(cuartel, false);
		
		aldeano.construirConstruible(cuartel);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		/*EL CUARTEL YA FUE CONSTRUIDO*/
		
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		
		aldeano.repararEdificio(cuartel);

		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		aldeano.mover(new DireccionAbajo());
	}
	
	@Test
	public void testUnAldeanoQueEstaReparandoUnCuaretelNoPuedeRepararOtroEdificio() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, 
			CeldaOcupadaException, CeldaInexistenteException, PoblacionMaximaAlcanzadaException, OroInsuficienteException, 
			EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, 
			AldeanoConConstruccionAsignadaException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, 
			EdificioFueraDeRangoException, YaSeReparoEnESteTurnoException, ConstruccionFueraDeRangoException, AtaqueInvalidoException {
		
		Mapa mapa = new Mapa(20,20);
		
		Juego juego = new Juego(mapa);
		
		juego.iniciar(new String[] {"Jugador 1", "Jugador 2"});
		
		Jugador jugador1 = juego.obtenerJugadorActual();
		
		Aldeano aldeano = new Aldeano(new Posicion(8,15), mapa);
		
		Cuartel cuartel = new Cuartel(new Posicion(7,16), mapa);
		
		jugador1.agregarEdificio(cuartel, false);
		jugador1.agregarUnidad(aldeano, mapa, false);
		
		aldeano.construirConstruible(cuartel);
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		juego.avanzarJugador();
		juego.avanzarJugador();
		
		
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		cuartel.recibirDanio(new AtaqueArquero());
		
		aldeano.repararEdificio(cuartel);

		juego.avanzarJugador();
		juego.avanzarJugador();
		
		Cuartel otroCuartel = new Cuartel(new Posicion(9,15), mapa);	
		jugador1.agregarEdificio(otroCuartel, false);
		
		otroCuartel.recibirDanio(new AtaqueArquero());
		
		exceptionRule.expect(YaSeReparoEnESteTurnoException.class);
		aldeano.repararEdificio(otroCuartel);
	}
}
