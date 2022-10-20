package Monopoly;
import java.util.Random;

public enum Calles {
    INICIO("INICIO", "", 0),
    AVENIDA_MEDITERRANEA("AVENIDA_MEDITERRANEA", "Marron", 60),
    CAJA_COMUNIDAD("CAJA_COMUNIDAD", "", 0),
    AVENIDA_BALTICA("AVENIDA_BALTICA", "Marron", 60),
    // TASA,
    // ESTACION_TREN,
    AVENIDA_ORIENTA("AVENIDA_ORIENTA", "Azul", 100),
    SUERTE("SUERTE", "", 0),
    AVENIDA_VERMONT("AVENIDA_VERMONT", "Azul", 100),
    AVENIDA_CONECTICUT("AVENIDA_CONECTICUT", "Azul", 120),
    SAINT_CHARLES("SAINT_CHARLES", "Rosa", 140),
    STATES_AVENUE("STATES_AVENUE", "Rosa", 160),
    ST_JAMES_PLACE("ST_JAMES_PLACE", "Naranja", 180),
    TENESSE_AVERAGE("TENESSE_AVERAGE", "Naranja", 180),
    NEWYORK_AVENUE("NEWYORK_AVENUE", "Naranja", 200),
    PARKING("PARKING", "", 0);

    private String nombre;
    private String color;
    protected int precioVenta;
    //private int precio_alquiler;

    Calles(String nombre, String color, int precio_venta) {
        this.nombre = nombre;
        this.color = color;
        this.precioVenta = precio_venta;
        //  this.precio_alquiler = precio_alquiler;
    }

    public int alquiler() {
        double percent = this.precioVenta * 0.25;
        int value = (int) percent;
        return value;
    }
    //get y sets, no los vemos necesarios

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }


    public int getPrecio() {
        return precioVenta;
    }

    public void cajaComunidad(Jugador jugador){
        jugador.cobrar(40);
    }

    public boolean suerte(Jugador jugador){
        Random rand = new Random();
        int r = rand.nextInt();
        boolean paga = false;

        if(r % 2 == 0){
            jugador.cobrar(40);
        } else {
            jugador.restarCuenta(40);
            paga = true;
        }
        return paga;
    }
}
