package fiuba.algo3.tp2.mapa;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import org.junit.Test;

import fiuba.algo3.tp2.unidad.Aldeano;

public class CeldaTest {
	
	@Test
	public void testSeCreaUnCeldaDeberiaEstarVacia() {
		Celda celda = new Celda();
		
		assertTrue(!celda.estaOcupada());
	}
	
	@Test
	public void testSeCreaUnCeldaLuegoDeOcuparlaNoDeberiaEstarVacia() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
		
		Celda celda = new Celda();
		celda.ocupar(new Aldeano(new Posicion(0,0), new Mapa(5,5)));
		assertTrue(celda.estaOcupada());
	}
}
