package fiuba.algo3.tp2.unidad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import Ataque.Atacador;
import fiuba.algo3.tp2.mapa.Atacable;
import fiuba.algo3.tp2.mapa.Posicion;

public class RangoAtaqueArqueroTest {

	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX1Y1YUnAldeanoEnX5Y1NoDeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,1));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(1,1));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertFalse(rango.estaEnRango(arquero, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX8Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(8,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX6Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(6,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX2Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(2,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX4Y5DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(4,5));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y8DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,8));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y6DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,6));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
	
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y4DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,4));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
	
	@Test
	public void testDadoUnRangoAtaqueArqueroQueSeEncuentraEnLaPosicionX5Y5YUnAldeanoEnX5Y2DeberiaEstarEnElRango() {
		
		Atacable aldeano = mock(Aldeano.class);
		
		Collection<Posicion> posicionesOcupadasAldeano = new ArrayList<Posicion>();
		posicionesOcupadasAldeano.add(new Posicion(5,2));
		
		when(aldeano.obtenerPosicionesOcupadasEnMapa()).thenReturn(posicionesOcupadasAldeano);
		
		Atacador arquero = mock(Arquero.class);
		when(arquero.obtenerPosicion()).thenReturn(new Posicion(5,5));
		
		RangoAtaque rango = new RangoAtaqueArquero();
		assertTrue(rango.estaEnRango(arquero, aldeano));
	}
}
