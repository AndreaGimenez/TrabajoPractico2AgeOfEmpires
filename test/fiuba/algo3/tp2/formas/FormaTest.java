package fiuba.algo3.tp2.formas;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.mapa.CeldaInexistenteException;
import fiuba.algo3.tp2.mapa.CeldaOcupadaException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.mapa.TamanioInvalidoException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class FormaTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testSeCreaUnCastilloConFormaRectanguloDe4X4EnX1Y1DeberiaOcuaparLasPosicionesIndicadas() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(10,10);
		
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		
		for( int i = 1 ; i < 5 ; i++ ) {
			for( int j = 1 ; j < 5 ; j++) {
				exceptionRule.expect(CeldaOcupadaException.class);
				Aldeano aldeano = new Aldeano(new Posicion(i,j), mapa);
			}
		}
	}
	
	@Test
	public void testSeCreaUnCastilloConFormaRectanguloDe4X4EnX1Y1DeberianPoderOcuaparseLasPosicionesDelBorde() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(10,10);
		
		Castillo castillo = new Castillo(new Posicion(1,1), mapa);
		
		/*Bordea con aldeanos la forma del castillo del test anterior*/
		
		for( int i = 0 ; i < 6 ; i++ ) {
			new Aldeano(new Posicion(i,0), mapa);
		}
		for( int i = 1 ; i < 6 ; i++ ) {
			new Aldeano(new Posicion(0,i), mapa);
		}
		for( int i = 1 ; i < 6 ; i++ ) {
			new Aldeano(new Posicion(i,5), mapa);
		}
		for( int i = 1 ; i < 5 ; i++ ) {
			new Aldeano(new Posicion(5,i), mapa);
		}
	}
	
	@Test
	public void testSeCreaUnaPlazaCentralConFormaRectanguloDe2X2EnX1Y1DeberiaOcuaparLasPosicionesIndicadas() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(10,10);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1,1), mapa);
		
		for( int i = 1 ; i < 2 ; i++ ) {
			for( int j = 1 ; j < 2 ; j++) {
				exceptionRule.expect(CeldaOcupadaException.class);
				Aldeano aldeano = new Aldeano(new Posicion(i,j), mapa);
			}
		}
	}
	
	@Test
	public void testSeCreaUnaPlazaCentralConFormaRectanguloDe2X2EnX1Y1DeberianPoderOcuaparseLasPosicionesDelBorde() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {
		
		Mapa mapa = new Mapa(10,10);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(1,1), mapa);
		
		/*Bordea con aldeanos la forma de la Plaza Central del test anterior*/
		
		for( int i = 0 ; i < 4 ; i++ ) {
			new Aldeano(new Posicion(i,0), mapa);
		}
		for( int i = 1 ; i < 4 ; i++ ) {
			new Aldeano(new Posicion(0,i), mapa);
		}
		for( int i = 1 ; i < 4 ; i++ ) {
			new Aldeano(new Posicion(i,3), mapa);
		}
		for( int i = 1 ; i < 3 ; i++ ) {
			new Aldeano(new Posicion(3,i), mapa);
		}
	}
	
	@Test 
	public void testSeCreaUnAldeanoConFormaRectanguloDe1X1EnX1Y1DeberianPoderOcuaparseLasPosicionesAledanias() 
			throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
		
		Mapa mapa = new Mapa(10,10);
		Aldeano aldeano = new Aldeano(new Posicion(1,1), mapa);
		
		for( int i = 0 ; i < 3 ; i++ ) {
			new Aldeano(new Posicion(i,0), mapa);
		}
		for( int i = 1 ; i < 3 ; i++ ) {
			new Aldeano(new Posicion(0,i), mapa);
		}
		for( int i = 1 ; i < 3 ; i++ ) {
			new Aldeano(new Posicion(i,2), mapa);
		}
		for( int i = 1 ; i < 2 ; i++ ) {
			new Aldeano(new Posicion(2,i), mapa);
		}
	}
}
