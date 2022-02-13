package ajedrez;

public class Torre extends Pieza {

	public Torre(Color color) {
		super(color);
		
	}
	
protected boolean esValido(Movimiento movimiento, Tablero tablero) {
	return false;
}
	
}
