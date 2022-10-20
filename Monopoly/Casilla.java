package Monopoly;

import Monopoly.Monopoly;

public class Casilla {

    private Calles calle;

    public Casilla(Calles calle){

        this.calle = calle;
    }

    public Calles getCalle() {
        return this.calle;
    }
}