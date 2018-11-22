package fiuba.algo3.tp2.oroTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tp2.recursos.OroPorTurno;

public class OroTest {
	
	@Test
	public void testDadoUnOroPorTurnoDesactivadoSuRecoleccionDeOroDeberiaSer0() {
		
		OroPorTurno oroPorTurno = new OroPorTurno();
		
		oroPorTurno.desactivarRecolector();
		oroPorTurno.recolectarOroDelTurno();
		assertEquals(0, oroPorTurno.recolectarOroDelTurno());
	}
	
	@Test
	public void testDadoUnOroPorTurnoSuOroDeberiaSer20SiNoFueRecolectadoYEstaEnModoRecolector() {
		
		OroPorTurno oroPorTurno = new OroPorTurno();
		oroPorTurno.activarRecolector();
		assertEquals(20, oroPorTurno.recolectarOroDelTurno());	
	}
	
	@Test
	public void testDadoUnOroPorTurnoSuOroDeberiaSer0LuegoDeQueFueRecolectado() {
		
		OroPorTurno oroPorTurno = new OroPorTurno();
		
		oroPorTurno.activarRecolector();
		oroPorTurno.sumarOroEnTurno();
		oroPorTurno.recolectarOroDelTurno();
		
		assertEquals(0,oroPorTurno.recolectarOroDelTurno());
	}
	
}
