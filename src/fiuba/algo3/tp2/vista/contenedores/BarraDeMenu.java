package fiuba.algo3.tp2.vista.contenedores;


import fiuba.algo3.tp2.vista.handlers.OpcionAcercaDeEventHandler;
import fiuba.algo3.tp2.vista.handlers.OpcionMuteEventHandler;
import fiuba.algo3.tp2.vista.handlers.OpcionPantallaCompletaEventHandler;
import fiuba.algo3.tp2.vista.handlers.OpcionSalirEventHandler;
import fiuba.algo3.tp2.vista.musica.Musica;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage, Musica musica) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");
        Menu menuSonido = new Menu("Sonido"); 

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem menuMute = new MenuItem("Apagar");
        
        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        
        OpcionMuteEventHandler opcionMuteHandler = new OpcionMuteEventHandler(musica, menuMute);
        menuMute.setOnAction(opcionMuteHandler);
        
        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionAbrir, new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuSonido.getItems().addAll(menuMute);
        

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda, menuSonido);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
