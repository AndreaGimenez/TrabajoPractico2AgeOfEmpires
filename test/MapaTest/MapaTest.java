package MapaTest;

import fiuba.algo3.tp2.espacio.Mapa;
import fiuba.algo3.tp2.espacio.punto.Celda;
import fiuba.algo3.tp2.posicion.Posicion;
import fiuba.algo3.tp2.posicion.PosicionImpl;
import fiuba.algo3.tp2.unidades.Aldeano;

public class MapaTest {
	
	@Test
	public void testUnEspacioNoDeberiaEstarDisponibleLuegoDeOcuparloConUnaUnidad() {
	
		Mapa mapa = new Mapa();
		
		mapa.posicionar(new Aldeano(), new PosicionImpl(new Celda(2,2)));
	}
	
	
}
