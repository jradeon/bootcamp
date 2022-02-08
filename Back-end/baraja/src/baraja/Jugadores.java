package baraja;

import java.util.ArrayList;

public class Jugadores{

	private String nombre1;
	private String nombre2;
	private ArrayList<Naipe> mano;

	public void Jugador1(String nombre1) {
		this.nombre1 = nombre1;
		this.mano = new ArrayList<>();
	}
	
	public void Jugador2(String nombre2) {
		this.nombre2 = nombre2;
		this.mano = new ArrayList<>();
	}

	public void adicionarCarta() {
		for (var palo : Naipe.Palos.values()) // values es la forma de devolver la posición con el enum
			for (var numero : Naipe.Numeros.values())
				this.mano.add(new Naipe(palo, numero));

	}

	public void botarCarta() {

	}

	@Override
	public String toString() {
		return "";
	}

}
