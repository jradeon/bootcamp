package baraja;

public class Naipe {
	public static enum Palos {
		oros, copas, espada, bastos
	}

	public enum Numeros {
		AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), SOTA(8), CABALLO(9), REY(10);

		private int numericValue;

		Numeros(int value) { // le pasa cualquier valor y me lo guarda en numericValue
			numericValue = value;
		}

		public int dameValor() { // nos devuelve numericValue que sería el valor que se corresponde a Numeros
			return numericValue;
		}

		public static Numeros convierte(int value) { // si value es 1 es as si es 2 y así

			switch (value) {

			case 1:
				return AS;
			case 2:
				return DOS;
			case 3:
				return TRES;
			case 4:
				return CUATRO;
			case 5:
				return CINCO;
			case 6:
				return SEIS;
			case 7:
				return SIETE;
			case 8:
				return SOTA;
			case 9:
				return CABALLO;
			case 10:
				return REY;

			default:
				throw new IllegalArgumentException("Carta no existente");
			}
		}
	}

	private Palos palo;
	private Numeros numero;

	public Naipe(Palos palo, Numeros numero) {
		this.palo = palo;
		this.numero = numero;

	}

	@Override
	public String toString() {
		return "Naipe [palo=" + palo + ", numero=" + numero + "]";
	}

}
