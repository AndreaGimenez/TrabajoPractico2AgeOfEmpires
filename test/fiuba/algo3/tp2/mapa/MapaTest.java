package fiuba.algo3.tp2.mapa;

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

public class MapaTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test(expected = TamanioInvalidoException.class)
	public void test_CuandoSeCreaUnMapaConDimensionesTamanioXIgual0YTamanioYIgual1_DeberiaLanzarTamanioInvalidoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(0, 1);
	}
	
	@Test(expected = TamanioInvalidoException.class)
	public void test_CuandoSeCreaUnMapaConDimensionesX1Y0_DeberiaLanzarTamanioInvalidoException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(1, 0);
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5CuyaCeldaConCoordenadasX1Y1TieneUnAldeano_CuandoSePosicionaUnAldeanoEnLasCoordenadasX1Y1_DeberiaLanzarCeldaOcupadaException() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(5, 5);
		Aldeano aldeano = new Aldeano(new Coordenada(1,1), mapa);
		
		exceptionRule.expect(CeldaOcupadaException.class);
		Aldeano otroAldeano = new Aldeano(new Coordenada(1,1), mapa);
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5_CuandoSeUbicaUnAldeanoEnLaPosicionX1Y1_DeberiaPoderUbicarUnAldeanoEnlaPosicion1x2() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(5, 5);
		Aldeano aldeano = new Aldeano(new Coordenada(1,1), mapa);
		
		Aldeano otroAldeano = new Aldeano(new Coordenada(1,2), mapa);
		
		assertTrue(mapa.estaOcupadaCelda(new Coordenada(1,1)));
		assertTrue(mapa.estaOcupadaCelda(new Coordenada(1,2)));
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5_CuandoSeUbicaUnAldeanoEnLaPosicionX6Y1_DeberiaLanzarCeldaInexistenteException() 
			throws CeldaInexistenteException, CeldaOcupadaException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(5, 5);
		exceptionRule.expect(CeldaInexistenteException.class);
		Aldeano aldeano = new Aldeano(new Coordenada(6,1), mapa);
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5_CuandoSeUbicaUnAldeanoEnLaPosicionX1NegativoY1_DeberiaLanzarCeldaInexistenteException() 
			throws CeldaInexistenteException, CeldaOcupadaException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(5, 5);
		
		exceptionRule.expect(CeldaInexistenteException.class);
		Aldeano aldeano = new Aldeano(new Coordenada(-1,1), mapa);
		
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5_CuandoSeUbicaUnAldeanoEnLaPosicionX1Y6_DeberiaLanzarCeldaInexistenteException() 
			throws CeldaInexistenteException, CeldaOcupadaException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(5, 5);
		
		exceptionRule.expect(CeldaInexistenteException.class);
		Aldeano aldeano = new Aldeano(new Coordenada(1,6), mapa);
		
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5_CuandoSeUbicaUnAldeanoEnLaPosicionX1Y1Negativo_DeberiaLanzarCeldaInexistenteException() 
			throws CeldaInexistenteException, CeldaOcupadaException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(5, 5);
		
		exceptionRule.expect(CeldaInexistenteException.class);
		Aldeano aldeano = new Aldeano(new Coordenada(1,-1), mapa);
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5YUnAldeanoUbicadoEnLaPosicionX1Y2_CuandoSeDesplazaALaPosicionX2Y2_DeberiaPoderPosicionarUnAldeanoEnLaPosicionX1Y2() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(5, 5);
		Aldeano aldeano = new Aldeano(new Coordenada(1,2), mapa);
	
		mapa.desplazar(new Coordenada(1,2), new Coordenada(2,2));
		
		mapa.posicionar(aldeano, new Coordenada(1,2));
		
		assertTrue(mapa.estaOcupadaCelda(new Coordenada(1,2)));
	}
	
	@Test
	public void test_DadoUnMapaDeTamanio5x5YUnAldeanoUbicadoEnLaPosicionX1Y2_CuandoSeDesplazaALaPosicionX2Y2ySeUbicaUnAldeanoEnLaPosicionX2Y2_DeberiaLanzarCeldaOcupadaException() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(5, 5);
		Aldeano aldeano = new Aldeano(new Coordenada(1,2), mapa);
		
		mapa.desplazar(new Coordenada(1,2), new Coordenada(2,2));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		mapa.posicionar(aldeano, new Coordenada(2,2));
	}
}
