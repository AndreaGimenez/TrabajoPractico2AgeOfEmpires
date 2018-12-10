package fiuba.algo3.tp2.edificio;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import fiuba.algo3.tp2.excepciones.EdificioEnConstruccionException;
import fiuba.algo3.tp2.excepciones.EdifioNoAptoParaContruirException;
import fiuba.algo3.tp2.excepciones.UnidadNoSoportadaException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.juego.Jugador;
import fiuba.algo3.tp2.juego.OroInsuficienteException;
import fiuba.algo3.tp2.construccion.EdificioConConstructorAsignadoException;
import fiuba.algo3.tp2.construccion.EdificioNoAptoParaConstruccionException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.Posicionable;
import fiuba.algo3.tp2.reparacion.YaSeReparoEnESteTurnoException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.excepciones.EdificioConReparadorAsignadoException;
import fiuba.algo3.tp2.excepciones.EdificioNoAptoParaReparacionException;
import fiuba.algo3.tp2.turno.Turno;
import fiuba.algo3.tp2.unidad.Aldeano;

public class PlazaCentralTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX5Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5, 2), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX6Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(6, 2), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX6Y3_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(6, 3), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2CuandoSePosicionaUnAldeanoEnLaPosicionX5Y3_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5, 3), mapa);
	}
	
	@Test
	public void test_AlPosicionarUnaPlazaCentral_DebeEstarEnConstruccion() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 5), mapa);
		GestionarConstruccion gestionarPlazaCentral = new GestionarConstruccion(plazaCentral);

		assertTrue(gestionarPlazaCentral.estaEnConstruccion());
	}
	
	@Test
	public void test_AlEstarUnaPlazaCentralEnConstruccion_NoPuedeCrearUnidades()
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, UnidadNoSoportadaException, EdifioNoAptoParaContruirException, EdificioEnConstruccionException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(3, 3), mapa);
		GestionarConstruccion gestionarPlazaCentral = new GestionarConstruccion(plazaCentral);

		exceptionRule.expect(EdificioEnConstruccionException.class);
		Aldeano unAldeano = (Aldeano) gestionarPlazaCentral.crearAldeano(new Posicion(10, 10), mapa);
	}
	
	@Test
    public void test_plazaCentralCreaUnAldeanoDespuesDeQueTermineSuConstruccion() 
    		throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, OroInsuficienteException, 
    		EdificioNoAptoParaReparacionException, EdificioConReparadorAsignadoException, EdificioEnConstruccionException, UnidadNoSoportadaException, EdificioNoAptoParaConstruccionException, EdificioConConstructorAsignadoException, YaSeReparoEnESteTurnoException {

        Mapa mapa = new Mapa(250, 250);
        PlazaCentral plazaCentral = new PlazaCentral(new Posicion(17, 17), mapa);
        GestionarConstruccion gestorPlazaCentral = new GestionarConstruccion(plazaCentral);
         
        Jugador jugador = new Jugador("Jugador 1", mapa);
        Collection<Posicionable> posicionables = jugador.obtenerPosicionables();
        jugador.agregarEdificio(gestorPlazaCentral, false);
        Turno turno = new Turno(jugador, mapa);
        turno.avanzar();
        turno.avanzar();
        turno.avanzar();

        Aldeano aldeano = gestorPlazaCentral.crearAldeano(new Posicion(19, 19), mapa);
        
        assertTrue(mapa.obtenerCelda(new Posicion(19, 19)).estaOcupada());

    }
}
