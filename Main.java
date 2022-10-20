import Monopoly.Jugador;
import Monopoly.Monopoly;
import Monopoly.Figura;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Jugador> misjugadores = new ArrayList<>();
        Monopoly monopoly;

        int cantidadJugadores;
        int contador = 1;

        System.out.println("\tMonopoly\n\n¿Cuántos jugadores sois? (Mínimo 3, máximo 5)");

        do {
            cantidadJugadores = sc.nextInt();
        } while (cantidadJugadores < 3 || cantidadJugadores > 5);

        HashMap<Integer, Figura> figurasDisponibles = new HashMap<>();
        for (Figura figura : Figura.values()) {
            figurasDisponibles.put(figura.getNumero(), figura);
        }

        while (contador < cantidadJugadores) {
            for (int i = 0; i < cantidadJugadores; i++) {
                StringBuilder menuFigurasDisponibles = new StringBuilder();

                for (Map.Entry<Integer, Figura> figuraDisponibleEntry : figurasDisponibles.entrySet()) {
                    Figura figuraDisponible = figuraDisponibleEntry.getValue();
                    menuFigurasDisponibles.append(figuraDisponibleEntry.getKey())
                            .append(". ")
                            .append(figuraDisponible.name())
                            .append("\n");
                }
                System.out.println("\nJugador " +
                        contador +
                        " ¿Qué ficha quieres ser? \n" +
                        menuFigurasDisponibles
                );
                int figuraVal = sc.nextInt();
                Figura figura = Figura.fromValue(figuraVal);
                misjugadores.add(new Jugador(figura));
                sc.nextLine();

                System.out.println("\nJugador " +
                        contador +
                        " es la figura: " +
                        figura.name()
                );
                figurasDisponibles.remove(figura.getNumero());

                contador += 1;
            }
        }

        for (Jugador jugador : misjugadores) {
            System.out.println("Tu figura es: " +
                    jugador.getFigura().name() +
                    " y tienes: " +
                    jugador.getDinero() +
                    " monopolis."
            );
        }

        monopoly = new Monopoly(misjugadores);
        System.out.println("Empieza el juego.\n\n");
        monopoly.jugar();
    }
}
