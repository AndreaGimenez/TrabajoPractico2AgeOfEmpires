package fiuba.algo3.tp2.vista;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collection;

public class VistaCeldaSinOcupar {

    private ContenedorControles contenedorControles;

    public void dibujarControles() {

        Collection<Button> acciones = new ArrayList<Button>();

        contenedorControles.setAcciones(acciones);

    }

    public void setContenedorControles(ContenedorControles contenedorControles) {
        this.contenedorControles = contenedorControles;

    }
}
