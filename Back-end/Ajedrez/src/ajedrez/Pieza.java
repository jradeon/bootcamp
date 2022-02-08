package ajedrez;

public abstract class Pieza {
	
	private Color color;
	
	//protected lo ven todas las clases que están en el paquete
	protected boolean esValido (Movimiento movimiento, Tablero tablero) {
	return false;
	}
	
	public boolean mover (Movimiento movimiento, Tablero tablero) {
	return false;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
}
