package Monopoly;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {

    private ArrayList<Casilla> casillas = new ArrayList<>();

    public Tablero() {
        this.crearCasillas();
    }

    private void crearCasillas() {
        for (Calles calle : Calles.values()) {
            this.casillas.add(new Casilla(calle));
        }
    }

    public Casilla getCasilla(int casilla) {
        return casillas.get(casilla);
    }
}
