package ajedrez;

public class Dama extends Pieza {

	public Dama(Color color) {
		super(color);
	}
	
	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("Movimiento o tablero null");

		return (movimiento.esHorizontal() || movimiento.esVertical()
				|| (movimiento.esDiagonal() && movimiento.saltoHorizontal() == movimiento.saltoVertical()));
	}
}
