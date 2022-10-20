package Monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Monopoly {
    Random r = new Random();
    private final Tablero tablero;
    private boolean puedeContinuar = true;
    private final ArrayList<Jugador> jugadores;
    private Calles inicio = Calles.INICIO;
    private Calles cc = Calles.CAJA_COMUNIDAD;
    private Calles suerte = Calles.SUERTE;
    private Calles parking = Calles.PARKING;

    private int turno = 1;

    Banca banca = new Banca();

    public Monopoly(ArrayList<Jugador> jugadores) {
        this.tablero = new Tablero();
        this.jugadores = jugadores;
    }

    public int tirarDado() {
        int dado = r.nextInt(6 - 1) + 1;
        return dado+=dado;
    }

    public void jugar() {
        do {
            this.jugarTurno();
        } while (this.puedeContinuar);

        Jugador perdedor = null;
        for (Jugador jugador : jugadores) {
            if (jugador.getDinero() <= 0) {
                perdedor = jugador;
            }
        }

        System.out.println("Juego terminado, el jugador " +
                perdedor.getFigura().name() +
                " ha perdido."
        );
    }

    private void jugarTurno() {
        Scanner sc = new Scanner(System.in);

        for (Jugador jugadorTirando : jugadores) {
            System.out.println("\nTurno: " + turno + "\n\n" + jugadorTirando.getFigura() + " está tirando.\n" + "Dinero: " + jugadorTirando.getDinero());
            jugadorTirando.mover(tirarDado());
            System.out.println("Dados: " + tirarDado());
            Casilla casillaActual = this.tablero.getCasilla(jugadorTirando.getCasilla());

            if (jugadorTirando.getCasilla() == 0){
                banca.pagarCasillaInicio(jugadorTirando);
            }
            System.out.println(jugadorTirando.getFigura() +
                    " ha caido en la casilla " +
                    casillaActual.getCalle().getNombre()
            );

            boolean casillaEnVenta = true;
            for (Jugador jugador : jugadores) {
                boolean laTiene = jugador.getPropiedades().contains(casillaActual.getCalle());
                if (laTiene) {
                    casillaEnVenta = false;
                    jugadorTirando.pagar(jugador, casillaActual.getCalle().getPrecio());
                    System.out.println(jugadorTirando.getFigura() +
                            " ha caído en la casilla " +
                            casillaActual.getCalle().getNombre() +
                            " en propiedad de " +
                            jugador.getFigura() +
                            " con importe de " +
                            casillaActual.getCalle().alquiler()
                    );
                }
            }

            // Casilla comprada por el mismo jugador

            boolean propiedadPrivada = jugadorTirando.getPropiedades().contains(casillaActual.getCalle());
            if (propiedadPrivada) {
                System.out.println("\nQuieres vender tu calle?\n1. Si\t\t2. No\n");
                int vender = sc.nextInt();
                if (vender == 1){
                    jugadorTirando.venderCasa(casillaActual.getCalle());
                } else continue;
            }

            // Casilla en Venta

            if (casillaEnVenta) {

                // Calles default?

                if(casillaActual.getCalle() == inicio || casillaActual.getCalle() == parking){
                    continue;
                }

                if(casillaActual.getCalle() == cc){
                    System.out.println("Has caído en la casilla de Caja de la comunidad. Cobras 40$");
                    cc.cajaComunidad(jugadorTirando);
                    continue;
                }

                if(casillaActual.getCalle() == suerte){
                    if(suerte.suerte(jugadorTirando)) {
                        System.out.println("Has caído en la casilla de Caja de la comunidad. Paga 40$");
                    } else {
                        System.out.println("Has caído en la casilla de Caja de la comunidad. Cobra 40$");
                    }
                    continue;
                }

                // Calle en venta

                System.out.println("La calle " +
                        casillaActual.getCalle().getNombre() +
                        " no es de nadie. El precio de la calle es de " + casillaActual.getCalle().getPrecio() + " Quieres comprar la calle?\n\n1. Si\t\t2. No\n"
                );

                int quierocomprarono = sc.nextInt();
                if (quierocomprarono == 1) {
                    jugadorTirando.comprarCasa(casillaActual.getCalle());
                }
            }

            // Para ver las casas que tiene

            int opCasas;
            System.out.println("\nQuieres ver tus propiedades compradas?\n\n1. Si\t\t2. No\n");
            opCasas = sc.nextInt();

            if(opCasas == 1){
                System.out.println("\nPropiedades en adquiridas: " + jugadorTirando.getPropiedades());
            } else continue;

            turno++;

            if (jugadorTirando.getDinero() <= 0) {
                this.puedeContinuar = false;
            }
        }
    }
}
