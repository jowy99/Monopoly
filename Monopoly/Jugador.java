package Monopoly;

import java.util.ArrayList;

public class Jugador {
    private int dinero;
    private final Figura figura;
    private ArrayList<Calles> propiedades = new ArrayList<>();
    private int casilla = 0;

    Banca banca = new Banca();

    public Jugador(Figura figura) {
        this.figura = figura;
        this.dinero = 200;
    }

    public int getDinero() {
        return this.dinero;
    }

    public Figura getFigura() {
        return this.figura;
    }

    public void comprarCasa(Calles casa) {
        this.dinero -= casa.getPrecio();
        this.propiedades.add(casa);
    }

    public void venderCasa(Calles casa){
        int cantidad = casa.getPrecio()/2;
        restarCuenta(cantidad);
        this.propiedades.remove(casa);
        banca.cobrarVenta(cantidad);
    }

    public void mover(int posiciones) {
        if ((this.casilla + posiciones) >= 11) {
            this.casilla = (this.casilla + posiciones) % 11;
        } else {
            this.casilla += posiciones;
        }
    }

    public int getCasilla() {
        return this.casilla;
    }

    public ArrayList<Calles> getPropiedades() {
        return propiedades;
    }

    public void pagar(Jugador jugador, int cantidad) {
        restarCuenta(cantidad);
        jugador.cobrar(cantidad);
    }

    public void restarCuenta(int precio) {
        this.dinero -= precio;
    }

    public int cobrar(int cantidad) {
        return this.dinero += cantidad;
    }
}
