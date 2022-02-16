package ajedrez;

public class Torre extends Pieza {

	public Torre(Color color) {
		super(color);

	}

	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (tablero.hayPiezasEntre(movimiento) || (!movimiento.esHorizontal() && !movimiento.esVertical()))
			throw new JuegoException("No es un movimiento válido");
		return true;
	}

}
