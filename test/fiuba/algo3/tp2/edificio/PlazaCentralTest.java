package fiuba.algo3.tp2.edificio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.movimiento.DireccionDerecha;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.MovimientoInvalidoException;
import fiuba.algo3.tp2.unidad.UnidadConstants.TipoUnidad;

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
<<<<<<< HEAD
	
	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX5Y5DeberiaCrearAldeanoEnLaPosicionX5Y6() throws TamanioInvalidoException, 
			CeldaOcupadaException, CeldaInexistenteException, EdificioNoGeneraUnidadException{
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(5, 5), mapa);
		
		plazaCentral.generarUnidad(new Aldeano(new Posicion(5, 7), mapa));
		
	}
	
=======

	@Test
	public void test_DadaUnaPlazaCentralEnLaPosicionX1Y1CuyasPosicionesAldedaniasSeEncuentranVacias_CuandoSeCreaUnAldeano_DeberiaCrearseEnLaPosicionX3Y1() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, MovimientoInvalidoException, UnidadNoSoportadaException {
		
		Mapa mapa = new Mapa(250, 250);
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1, 1), mapa);
		
		Aldeano aldeano = (Aldeano)plazaCentral.crear(TipoUnidad.ALDEANO);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(3, 1), mapa);
	}
>>>>>>> develop
}
