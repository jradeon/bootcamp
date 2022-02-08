package ajedrez;

public enum Color {
	BLANCO(1), NEGRO(2);

	int varValor;

	Color(int i) {
		varValor = i;
	}

	public Color convierte(int i) {
		switch (i) {

		case 1:
			return BLANCO;
			
		case 2:
			return NEGRO;
			
		default:
			throw new IllegalArgumentException("El color no existe");
		}

	}

}
