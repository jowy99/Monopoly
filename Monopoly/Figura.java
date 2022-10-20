package Monopoly;

public enum Figura {
    DEDAL(1),
    BARCO(2),
    BOTA(3),
    GORRO(4),
    PLANCHA(5),
    PERRO(6);

    private final int numero;

    Figura(int numero) {
        this.numero = numero;
    }

    public static Figura fromValue(int value) {
        for (Figura figura : Figura.values()) {
            if (figura.numero == value) {
                return figura;
            }
        }
        throw new IllegalArgumentException("Figura no existe");
    }

    public int getNumero() {
        return numero;
    }
}
