package fiuba.algo3.tp2.unidades;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.edificios.Cuartel;

public class UnidadTest {

	@Test(expected = Exception.class)
	public void armaAsedioCuandoAtacaUnAldeanoDeberiaLanzarUnaExcepcion() throws Exception {
		
		ArmaAsedio armaAsedio = new ArmaAsedio();
		Aldeano aldeano = new Aldeano();
		
		armaAsedio.atacar(aldeano);
	}
	
	@Test
	public void armaAsedioCuandoAtacaUnCuartelDeberiaRestarle75DeVida() throws Exception {
		
		ArmaAsedio armaAsedio = new ArmaAsedio();
		Cuartel cuartel = new Cuartel();
		Integer vidaCuartelAntesDeAtaque = cuartel.obtenerVida();
		
		armaAsedio.atacar(cuartel);
		
		assertEquals(75, vidaCuartelAntesDeAtaque - cuartel.obtenerVida());
	}
}
