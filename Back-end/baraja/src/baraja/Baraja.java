package baraja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Crear las clases para implementar juegos que utilizan una baraja de naipes.
//Los naipes tienen dos propiedades distintivas: valor y palo. 
//Probar la funcionalidad de barajar, repartir, comparar, … 
//(Utilizar Enumeraciones, genéricos, colecciones …)

public class Baraja {
	private List<Naipe> cartas = new ArrayList<Naipe>();

	public Baraja() {
		generarCartas();
	}

	public void generarCartas() {
		cartas = new ArrayList<Naipe>();
		for (var palo : Naipe.Palos.values()) // values es la forma de devolver la posición con el enum
			for (var numero : Naipe.Numeros.values())
				cartas.add(new Naipe(palo, numero));

	}

	public List<Naipe> getCartas() {
		return new ArrayList<Naipe>(cartas);
	}

	public void barajar() {
		Collections.shuffle(cartas); // método que ordena aleatoriamente
	}

	public List<List<Naipe>> repartirCartas(int numCartas, int numJugadores) {
		List<List<Naipe>> jugadores = new ArrayList<List<Naipe>>();
		for (int i = 0; i < numJugadores; i++) {
			jugadores.add(new ArrayList<Naipe>());
		}

		for (int carta = 0; carta < numCartas; carta++) 
			for (int jugador = 0; jugador < numJugadores; jugador++) {
				jugadores.get(jugador).add(cartas.get(0));
				cartas.remove(0);
				if (cartas.size() == 0) {
					break;
				}
			}

		return jugadores;
	}
}
