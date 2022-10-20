package Monopoly;

import java.util.Scanner;

public class Banca {
    private int dinero;

    public Banca(){
        this.dinero = 999;
    }

    public void pagarCasillaInicio(Jugador jugador){
        int d = (int)(200 * 0.10);
        jugador.cobrar(d);
    }

    public int cobrarVenta(int cantidad){
        return this.dinero += cantidad;
    }

}
