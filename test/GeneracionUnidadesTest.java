import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fiuba.algo3.tp2.edificio.Castillo;
import fiuba.algo3.tp2.edificio.Cuartel;
import fiuba.algo3.tp2.edificio.PlazaCentral;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.excepciones.TamanioInvalidoException;
import fiuba.algo3.tp2.generacionDeUnidades.YaSeGeneraronUnidadesEnEsteTurnoException;
import fiuba.algo3.tp2.mapa.Mapa;
import fiuba.algo3.tp2.mapa.Posicion;
import fiuba.algo3.tp2.unidad.Aldeano;
import fiuba.algo3.tp2.unidad.ArmaAsedio;
import fiuba.algo3.tp2.unidad.Arquero;
import fiuba.algo3.tp2.unidad.Espadachin;

public class GeneracionUnidadesTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	//CASTILLO
	@Test
	public void testUnCastilloGeneraUnArmaDeAsedio() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Castillo castillo = new Castillo(new Posicion(0,0), mapa);
		
		castillo.crear(new ArmaAsedio(new Posicion(5,0),mapa));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5,0), mapa);
	}
	
	@Test
	public void testUnCastilloGeneraUnArmaDeAsedioNoDebriaPoderGenerarOtraEnElMismoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Castillo castillo = new Castillo(new Posicion(0,0), mapa);
		
		castillo.crear(new ArmaAsedio(new Posicion(5,0),mapa));
		
		exceptionRule.expect(YaSeGeneraronUnidadesEnEsteTurnoException.class);
		castillo.crear(new ArmaAsedio(new Posicion(5,1),mapa));
	}
	
	@Test
	public void testUnCastilloGeneraUnArmaDeAsedioDebriaPoderGenerarOtraEnOtroTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Castillo castillo = new Castillo(new Posicion(0,0), mapa);
		
		castillo.crear(new ArmaAsedio(new Posicion(5,0),mapa));
		
		castillo.actualizarEstadoParaSiguienteTurno();
		
		castillo.crear(new ArmaAsedio(new Posicion(5,1),mapa));
	}
	
	//CUARTEL CREACION DE ARQUERO
	@Test
	public void testUnCuartelGeneraUnArquero() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException{
		Mapa mapa = new Mapa(10,10);
		
		Cuartel cuartel = new Cuartel(new Posicion(0,0), mapa);
		
		cuartel.crear(new Arquero(new Posicion(5,0),mapa));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5,0), mapa);
	}
	
	@Test
	public void testUnCuartelGeneraUnArqueroNoDebriaPoderGenerarOtraEnElMismoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Cuartel cuartel = new Cuartel(new Posicion(0,0), mapa);
		
		cuartel.crear(new Arquero(new Posicion(5,0),mapa));
		
		exceptionRule.expect(YaSeGeneraronUnidadesEnEsteTurnoException.class);
		cuartel.crear(new Arquero(new Posicion(5,1),mapa));
	}
	
	@Test
	public void testUnCuartelGeneraUnArqueroDebriaPoderGenerarOtraEnOtroTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Cuartel cuartel = new Cuartel(new Posicion(0,0), mapa);
		
		cuartel.crear(new Arquero(new Posicion(5,0),mapa));
		
		cuartel.actualizarEstadoParaSiguienteTurno();
		
		cuartel.crear(new Arquero(new Posicion(5,1),mapa));
	}
	
	//CUARTEL CREACION DE ESPADACHIN
	
	@Test
	public void testUnCuartelGeneraUnEspadachin() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException{
		Mapa mapa = new Mapa(10,10);
		
		Cuartel cuartel = new Cuartel(new Posicion(0,0), mapa);
		
		cuartel.crear(new Espadachin(new Posicion(5,0),mapa));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5,0), mapa);
	}
	
	@Test
	public void testUnCuartelGeneraUnEspadachinNoDebriaPoderGenerarOtraEnElMismoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Cuartel cuartel = new Cuartel(new Posicion(0,0), mapa);
		
		cuartel.crear(new Espadachin(new Posicion(5,0),mapa));
		
		exceptionRule.expect(YaSeGeneraronUnidadesEnEsteTurnoException.class);
		cuartel.crear(new Arquero(new Posicion(5,1),mapa));
	}
	
	@Test
	public void testUnCuartelGeneraUnEspadachinDebriaPoderGenerarOtraEnOtroTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Cuartel cuartel = new Cuartel(new Posicion(0,0), mapa);
		
		cuartel.crear(new Espadachin(new Posicion(5,0),mapa));
		
		cuartel.actualizarEstadoParaSiguienteTurno();
		
		cuartel.crear(new Espadachin(new Posicion(5,1),mapa));
	}
	
	@Test
	public void testUnCuartelGeneraUnEspadachinNoDebriaPoderGenerarUnArqueroEnElMismoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		Cuartel cuartel = new Cuartel(new Posicion(0,0), mapa);
		
		cuartel.crear(new Espadachin(new Posicion(5,0),mapa));
		
		exceptionRule.expect(YaSeGeneraronUnidadesEnEsteTurnoException.class);
		cuartel.crear(new Arquero(new Posicion(5,1),mapa));
	}
	
	//PLAZA CENTRAL CREA ALDEANO
		
	@Test
	public void testUnaPlazaCentralGeneraUnALdeano() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException{
		Mapa mapa = new Mapa(10,10);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(0,0), mapa);
		
		plazaCentral.crear(new Aldeano(new Posicion(5,0),mapa));
		
		exceptionRule.expect(CeldaOcupadaException.class);
		new Aldeano(new Posicion(5,0), mapa);
	}
	
	@Test
	public void testUnaPlazaCentralGeneraUnAldeanoNoDebriaPoderGenerarOtroEnElMismoTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(0,0), mapa);
		
		plazaCentral.crear(new Aldeano(new Posicion(5,0),mapa));
		
		exceptionRule.expect(YaSeGeneraronUnidadesEnEsteTurnoException.class);
		plazaCentral.crear(new Aldeano(new Posicion(5,1),mapa));
	}
	
	@Test
	public void testUnaPlazaCentralGeneraUnAldeanoDebriaPoderGenerarOtroEnOtroTurno() 
			throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException, YaSeGeneraronUnidadesEnEsteTurnoException {
		Mapa mapa = new Mapa(10,10);
		
		PlazaCentral plazaCentral = new PlazaCentral(new Posicion(0,0), mapa);
		
		plazaCentral.crear(new Aldeano(new Posicion(5,0),mapa));
		
		plazaCentral.actualizarEstadoParaSiguienteTurno();
		
		plazaCentral.crear(new Aldeano(new Posicion(5,1),mapa));
	}
}
