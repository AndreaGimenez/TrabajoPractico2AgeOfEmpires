package fiuba.algo3.tp2.unidades;

import org.junit.Test;

import fiuba.algo3.tp2.edificios.Cuartel;
import fiuba.algo3.tp2.espacio.Mapa;
import fiuba.algo3.tp2.espacio.punto.Coordenada;

public class AldeanoTest {

	@Test
	public void cuandoAldeanoCreaEdificioNoDeberiaPoderCrearseOtroCuyaPosicionSeSuperponga() {
		
		Aldeano aldeano = new Aldeano();
		aldeano.construir(new Cuartel(), Mapa.getInstance().getCelda(new Coordenada(1,2)));
	}
}
