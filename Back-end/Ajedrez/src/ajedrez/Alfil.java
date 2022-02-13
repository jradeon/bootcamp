package ajedrez;

public class Alfil extends Pieza {
	public Alfil(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento == null || tablero == null)
			throw new NullPointerException("Movimiento o tablero null");
		
		return (movimiento.esDiagonal() && movimiento.saltoVertical() == movimiento.saltoVertical());
	}


}
