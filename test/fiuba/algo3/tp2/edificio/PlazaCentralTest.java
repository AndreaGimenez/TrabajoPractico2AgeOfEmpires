package fiuba.algo3.tp2.edificio;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Coordenada;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class PlazaCentralTest {
	
	
	Mapa mapa = new Mapa(100,100);
	Coordenada nacimiento = new Coordenada(1,6);
	private Edificio plazaCentral = new PlazaCentral(nacimiento, mapa);

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Coordenada(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Coordenada(5, 2), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX6Y2_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Coordenada(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Coordenada(6, 2), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX6Y3_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Coordenada(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Coordenada(6, 3), mapa);
	}
	
	@Test
	public void test_DadaUnaPlazaCentralCastilloEnlaPosicionX5Y2_CuandoSePosicionaUnAldeanoEnLaPosicionX5Y3_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, TamanioInvalidoException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(250, 250);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Coordenada(5, 2), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Coordenada(5, 3), mapa);
	}
	
	@Test
	public void test_PlazaCentralDeberiaCrearUnAldeano() throws CeldaOcupadaException, CeldaInexistenteException {
		
		
		Coordenada otroNacimiento = new Coordenada(10,10);
		Aldeano aldeano = new Aldeano(otroNacimiento, mapa);
			
		assertTrue(aldeano instanceof Aldeano);
		
	}
}
