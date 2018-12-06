package fiuba.algo3.tp2.edificio;

import fiuba.algo3.tp2.excepciones.EdificioNoSoportadoException;
import fiuba.algo3.tp2.edificio.EdificioConstants.TipoEdificio;
import fiuba.algo3.tp2.excepciones.CeldaInexistenteException;
import fiuba.algo3.tp2.excepciones.CeldaOcupadaException;
import fiuba.algo3.tp2.unidad.Aldeano;

public class PosicionarEdificio {

    Aldeano aldeano;

    public PosicionarEdificio(Aldeano aldeano) {

        this.aldeano = aldeano;

    }

    public void posicionarALaDerechaPorDebajo(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarHorizontalmente(1));

    }

    public void posicionarALaIzquierdaPorDebajo(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarHorizontalmente(-2));

    }

    public void posicionarDebajoPorLaDerecha(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1));

    }

    public void posicionarArribaPorLaDerecha(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(2));

    }


    public void posicionarEnAristaSuperiorDerecha(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(2).desplazarHorizontalmente(1));

    }

    public void posicionarEnAristaInferiorDerecha(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1));

    }

    public void posicionarEnAristaSuperiorIzquierda(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(1));

    }

    public void posicionarEnAristaInferiorIzquierda(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(-2));

    }

    public void posicionarALaDerechaPorEncima(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(1));

    }

    public void posicionarALaIzquierdaPorEncima(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(1).desplazarHorizontalmente(-2));

    }

    public void posicionarDebajoPorLaIzquierda(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(-1).desplazarHorizontalmente(-2));

    }

    public void posicionarArribaPorLaIzquierda(EdificioConstants.TipoEdificio edificio) throws EdificioNoSoportadoException, CeldaInexistenteException, CeldaOcupadaException {

        Edificio edificioCreado = this.aldeano.crear(edificio);

        GestionarConstruccion posicionador = new GestionarConstruccion(edificioCreado);

        posicionador.posicionar(this.aldeano.obtenerPosicion().desplazarVerticalmente(2).desplazarHorizontalmente(-1));

    }

}
