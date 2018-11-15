package fiuba.algo3.tp2.mapa;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PosicionTest {
	
	@Test
	public void testSeCreaUnaPosicionConValoresX3Y6AlObtenerEsosValoresDeberianSerLosSeteados() {
		
		Posicion posicion = new Posicion(3,6);
		
		assertEquals(3, posicion.getX());
		
		assertEquals(6, posicion.getY());
	}
}
