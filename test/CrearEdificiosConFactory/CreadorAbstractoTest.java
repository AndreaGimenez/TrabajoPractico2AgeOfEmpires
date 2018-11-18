package CrearEdificiosConFactory;

import CrearEdificiosConFactory.Creadores.*;
import CrearEdificiosConFactory.Productos.Castillo;
import CrearEdificiosConFactory.Productos.Cuartel;
import CrearEdificiosConFactory.Productos.PlazaCentral;
import CrearEdificiosConFactory.Productos.Aldeano;
import CrearEdificiosConFactory.Productos.ArmaDeAsedio;
import CrearEdificiosConFactory.Productos.Arquero;
import CrearEdificiosConFactory.Productos.Espadachin;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreadorAbstractoTest {

    private CreadorDeUnidades creadorDeAldeano = new CreadorDeAldeano();

    private CreadorDeUnidades creadorDeEspadachin = new CreadorDeEspadachin();

    private CreadorDeUnidades creadorDeArquero = new CreadorDeArquero();

    private CreadorDeUnidades creadorDeArmaDeAsedio = new CreadorDeArmaDeAsedio();

    private Construccion construccionCastillo = new ConstruccionCastillo();

    private Construccion construccionPlazaCentral = new ConstruccionPlazaCentral();

    private Construccion construccionCuartel = new ConstruccionCuartel();

    @Test
    public void test01CrearUnCastilloDeberiaDevolverUnaInstanciaDeCastillo(){

        assertTrue(construccionCastillo.crearEdificio() instanceof Castillo);

    }

    @Test
    public void test02CrearUnCuartelDeberiaDevolverUnaInstanciaDeCuartel(){

        assertTrue(construccionCuartel.crearEdificio() instanceof Cuartel);

    }

    @Test
    public void test03CrearUnaPlazaCentralDeberiaDevolverUnaInstanciaDePlazaCentral(){

        assertTrue(construccionPlazaCentral.crearEdificio() instanceof PlazaCentral);

    }

    @Test
    public void test01CrearUnAldeanoDeberiaDevolverUnaInstanciaDeAldeano(){

        assertTrue(creadorDeAldeano.crearUnidad() instanceof Aldeano);

    }

    @Test
    public void test02CrearUnEspadachinDeberiaDevolverUnaInstanciaDeEspadachin(){

        assertTrue(creadorDeEspadachin.crearUnidad() instanceof Espadachin);

    }

    @Test
    public void test03CrearUnArqueroDeberiaDevolverUnaInstanciaDeArquero(){

        assertTrue(creadorDeArquero.crearUnidad() instanceof Arquero);

    }

    @Test
    public void test03CrearUnArmaDeAsedioDeberiaDevolverUnaInstanciaDeArmaDeAsedio(){

        assertTrue(creadorDeArmaDeAsedio.crearUnidad() instanceof ArmaDeAsedio);

    }



}