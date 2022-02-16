package ajedrez;

public abstract class Pieza {

	private Color elcolor;

	// protected lo ven todas las clases que están en el paquete

	public Pieza(Color color) {
		elcolor = color;
	}

	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException;

	public void mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (esValido(movimiento, tablero)) {
			tablero.mover(movimiento);
		}
	}


	public Color getelColor() {
		return elcolor;
	}


}
