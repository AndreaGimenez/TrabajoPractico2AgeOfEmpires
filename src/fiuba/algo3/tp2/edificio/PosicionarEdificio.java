package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class PosicionarEdificio {

    Aldeano aldeano;

    public PosicionarEdificio(Aldeano aldeano) {

        this.aldeano = aldeano;

    }

    public void posicionarALaDerechaPorDebajo(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarHorizontalmente(1));

    }

    public void posicionarALaIzquierdaPorDebajo(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarHorizontalmente(-2));

    }

    public void posicionarDebajoPorLaDerecha(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1));

    }

    public void posicionarArribaPorLaDerecha(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(2));

    }


    public void posicionarEnAristaSuperiorDerecha(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(2).desplazarHorizontalmente(1));

    }

    public void posicionarEnAristaInferiorDerecha(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1));

    }

    public void posicionarEnAristaSuperiorIzquierda(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1));

    }

    public void posicionarEnAristaInferiorIzquierda(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(-2));

    }

    public void posicionarALaDerechaPorEncima(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(1));

    }

    public void posicionarALaIzquierdaPorEncima(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-2));

    }

    public void posicionarDebajoPorLaIzquierda(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(-1));

    }

    public void posicionarArribaPorLaIzquierda(Edificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        this.aldeano.crear(edificio);
        edificio.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(2).desplazarHorizontalmente(-1));

    }
}
