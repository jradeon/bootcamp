package ajedrez;

public class Rey extends Pieza {

	public Rey(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento == null || tablero == null)

			throw new NullPointerException("Movimiento o tablero null");
		return ((movimiento.saltoHorizontal() == 1 && movimiento.saltoVertical() == 1) // diagonal
				|| (movimiento.saltoHorizontal() == 1 && movimiento.saltoVertical() == 0) // horizontal
				|| (movimiento.saltoHorizontal() == 0 && movimiento.saltoVertical() == 1)); // vertical
	}
}