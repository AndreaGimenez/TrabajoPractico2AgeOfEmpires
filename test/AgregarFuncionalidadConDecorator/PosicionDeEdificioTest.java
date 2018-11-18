package AgregarFuncionalidadConDecorator;

import CrearEdificiosConFactory.Creadores.ConstruccionCastillo;
import CrearEdificiosConFactory.Creadores.ConstruccionCuartel;
import CrearEdificiosConFactory.Creadores.ConstruccionPlazaCentral;
import CrearEdificiosConFactory.Creadores.CreadorDeAldeano;
import CrearEdificiosConFactory.Productos.IEdificio;
import CrearEdificiosConFactory.Productos.IUnidad;
import CrearEdificiosConFactory.Productos.Posicion;
import org.junit.Test;

import static org.junit.Assert.*;

public class PosicionDeEdificioTest {

    private IEdificio castillo = (new ConstruccionCastillo().crearEdificio());

    private IEdificio cuartel = (new ConstruccionCuartel().crearEdificio());

    private IEdificio plazaCentral = (new ConstruccionPlazaCentral().crearEdificio());

    @Test
    public void test01PosicionarCuartelEnMapaDeberiaMostrarCuatroPosicionesOcupadas() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(5,5);

        mapa.posicionar(cuartel, posicion);

        assertTrue(mapa.estaOcupado(new Posicion(5,5)));

        assertTrue(mapa.estaOcupado(new Posicion(6,5)));

        assertTrue(mapa.estaOcupado(new Posicion(6,6)));

        assertTrue(mapa.estaOcupado(new Posicion(5,6)));

        assertFalse(mapa.estaOcupado(new Posicion(7,6)));

    }

    @Test
    public void test02PosicionarCastilloEnMapaDeberiaMostrarVeinticincoPosicionesOcupadas() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(5,5);

        mapa.posicionar(castillo, posicion);

        for(int i = 0; i<5 ; i++){

            for(int j = 0; j<5 ; j++){

                Posicion posicionOcupada = new Posicion(5+i, 5+j);

                assertTrue(mapa.estaOcupado(posicionOcupada));

            }

        }

    }

    @Test
    public void test03PosicionarPlazaCentralEnMapaDeberiaMostrarCuatroPosicionesOcupadas() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(4,4);

        mapa.posicionar(plazaCentral, posicion);

        assertTrue(mapa.estaOcupado(new Posicion(4,4)));

        assertTrue(mapa.estaOcupado(new Posicion(5,4)));

        assertTrue(mapa.estaOcupado(new Posicion(4,5)));

        assertTrue(mapa.estaOcupado(new Posicion(5,5)));

        assertFalse(mapa.estaOcupado(new Posicion(7,6)));

    }


    @Test(expected = PosicionEnUso.class)
    public void test04PosicionarUnCuartelEncimaDeOtroNoDeberiaSerPosible() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(5,5);

        IEdificio otroCuartel = (new ConstruccionCuartel().crearEdificio());

        mapa.posicionar(cuartel, posicion);

        mapa.posicionar(otroCuartel, posicion);

    }


    @Test(expected = PosicionEnUso.class)
    public void test05PosicionarUnCuartelEnTerrenoDeUnCastilloNoDeberiaSerPosible() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(5,5);

        Posicion otraPosicion = new Posicion(7,7);

        IEdificio otroCuartel = (new ConstruccionCuartel().crearEdificio());

        mapa.posicionar(castillo, posicion);

        mapa.posicionar(otroCuartel, otraPosicion);

    }

    @Test
    public void test06PosicionarUnCuartelAlLadoDeunCastillo() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(5,5);

        Posicion otraPosicion = new Posicion(10,5);

        mapa.posicionar(castillo, posicion);

        mapa.posicionar(cuartel, otraPosicion);

    }

    @Test(expected = PosicionEnUso.class)
    public void test07PosicionarUnCuartelQueSuTerrenoIntersecaElDeUnCastilloNoDeberiaSerPosible() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(5,5);

        Posicion otraPosicion = new Posicion(4,5);

        mapa.posicionar(castillo, posicion);

        mapa.posicionar(cuartel, otraPosicion);

    }

    @Test(expected = PosicionEnUso.class)
    public void test08PosicionarUnaPlazaCentralEncimaDeUnAldeanoNoDeberiaSerPosible() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        IUnidad aldeano = (new CreadorDeAldeano().crearUnidad());

        Posicion posicion = new Posicion(5,6);

        Posicion otraPosicion = new Posicion(5,5);

        mapa.posicionar(aldeano, posicion);

        mapa.posicionar(plazaCentral, otraPosicion);

    }

    @Test(expected = PosicionEnUso.class)
    public void test09PosicionarUnaPlazaCentralQueSuTerrenoIntersecaElDeUnCuartelNoDeberiaSerPosible() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        Posicion posicion = new Posicion(5,5);

        Posicion otraPosicion = new Posicion(4,5);

        mapa.posicionar(cuartel, posicion);

        mapa.posicionar(plazaCentral, otraPosicion);

    }

    @Test(expected = PosicionEnUso.class)
    public void test10PosicionarUnAldeanoEncimaDeUnCuartelNoDeberiaSerPosible() throws PosicionEnUso {

        Mapa mapa = new Mapa();

        IUnidad aldeano = (new CreadorDeAldeano().crearUnidad());

        Posicion posicion = new Posicion(5,5);

        Posicion otraPosicion = new Posicion(4,5);

        mapa.posicionar(plazaCentral, otraPosicion);

        mapa.posicionar(aldeano, posicion);

    }


}