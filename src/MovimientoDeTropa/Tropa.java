package MovimientoDeTropa;

import java.util.LinkedList;

public class Tropa implements Seleccionable {

    public Posicion posicion;

    public LinkedList<Posicion> recorrido;

    public void posicionDeInicio(Posicion p){

        this.posicion = p;

    }

    public Posicion posicion(){

        return this.posicion;

    }

    public void siguienteMovimiento(){

        this.posicion.ejecutarMovimiento(this.recorrido.getFirst());

        this.recorrido.removeFirst();

    }

    private LinkedList<Posicion> calcularTrayectoria(Posicion fin) {

        LinkedList<Posicion> trayectoria = new LinkedList<Posicion>();

        int i,j;

        for(i=this.posicion.getPosX(); i<fin.getPosX(); i++){

            Posicion p = new Posicion((i+1), this.posicion.getPosY());

            trayectoria.addLast(p);
        }

        for(j=this.posicion.getPosY(); j>=fin.getPosY(); j--){

            Posicion p = new Posicion(i,(j-1));

            trayectoria.addLast(p);

        }

        return trayectoria;

    }

    public void moverHasta(Posicion fin){

        this.recorrido = calcularTrayectoria(fin);

        this.posicion.ejecutarMovimiento(this.recorrido.getFirst());

        this.recorrido.removeFirst();

    }

}
