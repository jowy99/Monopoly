# Monopoly

En este proyecto formado por [Juan Miguel Moreno Mancilla](https://github.com/Reynn92), [Ismael Barranco Carballo](https://github.com/Isbarcar1249) y [Joël Arnaud Carreras](https://github.com/SagittariusITG) dónde deberemos realizar un código que represente el juego de mesa "Monopoly".

## Enunciado

En grupos de 3: Elegir temática y elaborar los diagramas UML (clases, casos de uso y secuencia).


* Construir un enum que contenga 10 Calles: Cada calle tiene un nombre, color (que utilizaremos más tarde), precio de venta y precio de alquiler. El precio del alquiler se calcula como el 25% del precio de venta.
* Contruir clase Tablero: Lista con 10 casillas, de tipo 2 (calles). Debe gestionar qué jugadores hay en qué casilla.

* Construir una clase Jugador : Cada jugador tiene una figura, una lista con sus calles  y el dinero que tiene.
* Contriur una clase Monopoly: Un jugador va a tirar los dados. Va a caer en una casilla. Si la casilla se puede comprar hay que darle la opción de comprarla. Si la casilla tiene dueño, tiene que pagarle al dueño. Le toca al siguiente jugador. El juego termina cuando un jugador se queda sin dinero.

![Monopoly](https://i.pinimg.com/originals/ae/26/ba/ae26bab2aa7b6620d816db7a126f1a20.jpg)