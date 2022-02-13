package ajedrez;

public class Caballo extends Pieza {
	public Caballo(Color color) {
		super(color);

	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("Movimiento o tablero null");

		return ((movimiento.saltoVertical() == 2 && movimiento.saltoHorizontal() == 1)
				|| (movimiento.saltoVertical() == 1 && movimiento.saltoHorizontal() == 2));
	}

}
