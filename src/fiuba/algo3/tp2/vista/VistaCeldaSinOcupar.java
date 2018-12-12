package fiuba.algo3.tp2.vista;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.vista.contenedores.ContenedorControles;
import fiuba.algo3.tp2.vista.contenedores.ContenedorPartida;

public class VistaCeldaSinOcupar {

    private ContenedorControles contenedorControles;

    public void dibujarControles() {

        Collection<Button> acciones = new ArrayList<Button>();

        ContenedorPartida.contenedorControles.setAcciones(acciones);

    }

    public void setContenedorControles(ContenedorControles contenedorControles) {
        this.contenedorControles = ContenedorPartida.contenedorControles;

    }
}
