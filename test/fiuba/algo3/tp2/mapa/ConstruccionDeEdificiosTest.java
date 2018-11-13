package fiuba.algo3.tp2.mapa;

import fiuba.algo3.tp2.edificio.*;
import fiuba.algo3.tp2.unidad.Aldeano;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;

import static org.junit.Assert.*;

public class ConstruccionDeEdificiosTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void test01CuartelDeberiaMostrarCuatroCeldasOcupadasAlConstruirlo() 
    		throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion p = new Posicion(2,3);

        Edificio cuartel = new Cuartel(p, mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano primerAldeano = new Aldeano(new Posicion(2, 3), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano segundoAldeano = new Aldeano(new Posicion(2, 2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano tercerAldeano = new Aldeano(new Posicion(3, 2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano cuartoAldeano = new Aldeano(new Posicion(3, 3), mapa);

    }

    @Test
    public void test02PlazaCentralDeberiaMostrarCuatroCeldasOcupadasAlConstruirla() 
    		throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {

        Mapa mapa = new Mapa(250,250);

        Posicion p = new Posicion(2,3);

        Edificio plazaCentral = new PlazaCentral(p, mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano primerAldeano = new Aldeano(new Posicion(2, 3), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano segundoAldeano = new Aldeano(new Posicion(2, 2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano tercerAldeano = new Aldeano(new Posicion(3, 2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano cuartoAldeano = new Aldeano(new Posicion(3, 3), mapa);

    }

    @Test
    public void test03CastilloDeberiaMostrarUnCuadradoDeLado4CeldasOcupado() 
    		throws TamanioInvalidoException, CeldaOcupadaException, CeldaInexistenteException {

        Mapa mapa = new Mapa(250,250);

        Posicion p = new Posicion(5,5);

        Edificio castillo = new Castillo(p, mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano primerAldeano = new Aldeano(new Posicion(5, 5), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano segundoAldeano = new Aldeano(new Posicion(8, 5), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano tercerAldeano = new Aldeano(new Posicion(8, 2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano cuartoAldeano = new Aldeano(new Posicion(5, 2), mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano quintoAldeano = new Aldeano(new Posicion(7, 4), mapa);

    }

    @Test
    public void test04CrearUnCuartelAlLadoDeUnCastilloDeberiaSerValido() 
    		throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {

        Mapa mapa = new Mapa(250,250);

        Posicion pCastillo = new Posicion(5,5);

        Posicion pCuartel = new Posicion(9,4);

        Edificio castillo = new Castillo(pCastillo, mapa);

        Edificio cuartel = new Cuartel(pCuartel,mapa);

    }

    @Test
    public void test05CrearUnCuartelEncimaDeUnCastilloNoDeberiaSerValido() 
    		throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {

        Mapa mapa = new Mapa(250,250);

        Posicion pCastillo = new Posicion(5,5);

        Posicion pCuartel = new Posicion(6,4);

        Edificio castillo = new Castillo(pCastillo, mapa);

        exceptionRule.expect(CeldaOcupadaException.class);
        Edificio cuartel = new Cuartel(pCuartel,mapa);

    }

    @Test
    public void test06AldeanoDeberiaConstruirUnCuartelASuDerecha() 
    		throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {

        Mapa mapa = new Mapa(250,250);

        Posicion nacimiento = new Posicion(5,5);

        Aldeano juan = new Aldeano(nacimiento, mapa);

        juan.construirCuartel();

        exceptionRule.expect(CeldaOcupadaException.class);
        Aldeano pedro = new Aldeano(new Posicion(6, 5), mapa);

    }
    
    @Test
    public void test06AldeanoDeberiaConstruirUnCuartelArribaSiSuDerechaEstaOcupada() 
    		throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {

        Mapa mapa = new Mapa(250,250);

        Posicion nacimiento = new Posicion(5,5);

        Aldeano juan = new Aldeano(nacimiento, mapa);

        Aldeano pedro = new Aldeano(new Posicion(6, 5), mapa);
        
        juan.construirCuartel();

        for(int i = 5; i < 7 ; i++) {
     	   for(int j = 6 ; j < 8 ; j++) {
     		   exceptionRule.expect(CeldaOcupadaException.class);
     		   new Aldeano(new Posicion(i,j), mapa);
     	   }
        }
    }
    
    @Test
    public void test07AldeanoConstruyeCuartelLasPosicionesFronteraEstanLibresParaSerOcupadas() 
    		throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {
    
    	 Mapa mapa = new Mapa(250,250);

         Posicion nacimiento = new Posicion(5,5);

         Aldeano juan = new Aldeano(nacimiento, mapa);

         Aldeano pedro = new Aldeano(new Posicion(6, 5), mapa);
         
         juan.construirCuartel();
         
         for(int i = 5 ; i < 9 ; i++) {
        	 new Aldeano(new Posicion(4,i), mapa);
         }
         for(int i = 5 ; i < 8 ; i++) {
        	 new Aldeano(new Posicion(i,8), mapa);
         }
         for(int i = 5 ; i < 8 ; i++) {
        	 new Aldeano(new Posicion(7,i), mapa);
         }
    	
    }
	
    /*
    @Test
    public void test08AldeanoDeberiaLanzarEspacioDeConstruccionOcupadoErrorSiSuDerechaYArribaEstanOcupados() throws CeldaOcupadaException, CeldaInexistenteException, TamanioInvalidoException {

        Mapa mapa = new Mapa(250,250);

        Posicion nacimiento = new Posicion(5,5);

        Aldeano juan = new Aldeano(nacimiento, mapa);

        Aldeano pedro = new Aldeano(new Posicion(6, 5), mapa);

        Aldeano pablo = new Aldeano(new Posicion(5, 4), mapa);

        exceptionRule.expect(EspacioDeConstruccionOcupadoError.class);
        juan.construirCuartel();

    }
    */

}