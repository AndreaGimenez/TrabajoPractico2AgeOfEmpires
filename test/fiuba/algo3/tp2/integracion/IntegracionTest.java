package fiuba.algo3.tp2.integracion;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Construccion.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.edificio.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.edificio.UnidadNoSoportadaException;
import fiuba.algo3.tp2.juego.CantidadDeJugadoresInvalidaException;
import fiuba.algo3.tp2.juego.Juego;
import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.reparacion.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.reparacion.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

public class IntegracionTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testCrearMapaTamanio250x250ConDosCastillosDosPlazasCentralesY6Aldeanos() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		new Castillo(new Posicion(0,0), mapa);
		new PlazaCentral(new Posicion(5,0), mapa);
		new Aldeano(new Posicion(5,2), mapa);
		new Aldeano(new Posicion(6,2), mapa);
		new Aldeano(new Posicion(7,2), mapa);
		
		new Castillo(new Posicion(246,246), mapa);
		new PlazaCentral(new Posicion(243,248), mapa);
		new Aldeano(new Posicion(244,247), mapa);
		new Aldeano(new Posicion(243,247), mapa);
		new Aldeano(new Posicion(242,247), mapa);
	}
	
	@Test
	public void testAlIniciarUnaPartidaElPrimerJugadorPuedeCrearUnAldeano() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException {
		
		Mapa mapa = new Mapa(250,250);
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		
		juego.iniciar();
		
		Jugador primerJugador = juego.obtenerJugador(0);
		
		PlazaCentral plazaCentral = (PlazaCentral) mapa.obtenerPosicionable(new Posicion(5,0));
		
		plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(7,7));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		plazaCentral.crear(TipoUnidad.ALDEANO, new Posicion(7,7));
	}
	
	//RECOLECCION DEL ORO
	@Test
	public void testUnJugadorCon3AldeanosQueNoEstanConstruyendoNiReparandoDeberiaTener60UnidadesMasDeOro() 
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException {
		
		Mapa mapa = new Mapa(250,250);
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		
		juego.iniciar();
		
		Jugador primerJugador = juego.obtenerJugador(0);
		Turno turno = new Turno(primerJugador.obtenerPosicionables());
		
		int oroAntes = primerJugador.obtenerOro();

		turno.avanzar();
		
		int oroDespues = primerJugador.obtenerOro();

		assertEquals(60, oroDespues-oroAntes);
	}
	
	/*@Test
	public void testUnJugadorCon2AldeanosLibresY1ConstruyendoDeberiaGenerar40UnidadesDeOro()
			throws TamanioInvalidoException, CantidadDeJugadoresInvalidaException, CeldaOcupadaException, CeldaInexistenteException, EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioNoSoportadoException {
		Mapa mapa = new Mapa(250,250);
		Juego juego = new Juego(mapa);
		
		juego.agregarJugador();
		juego.agregarJugador();
		
		juego.iniciar();
		
		Jugador primerJugador = juego.obtenerJugador(0);
		Turno turno = new Turno(primerJugador.obtenerPosicionables());
		
		Aldeano aldeano1 = (Aldeano) mapa.obtenerPosicionable(new Posicion(5, 3));
		Aldeano aldeano2 = (Aldeano) mapa.obtenerPosicionable(new Posicion(5, 5));
		Aldeano aldeano3 = (Aldeano) mapa.obtenerPosicionable(new Posicion(3, 5));
		
		aldeano3.crear(TipoEdificio.CUARTEL);
		
		int oroAntes = primerJugador.obtenerOro();
		
		turno.avanzar();
		
		int oroDespues = primerJugador.obtenerOro();
		
		assertEquals(40, oroDespues - oroAntes);
	}*/
}
