package ajedrez;

public abstract class Pieza {
	
	private Color elcolor;
	
	//protected lo ven todas las clases que están en el paquete
	
public Pieza(Color color) {
		// TODO Auto-generated constructor stub
	}


protected abstract boolean esValido(Movimiento movimiento, Tablero tablero);
	
	public void mover (Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (esValido(movimiento, tablero)) {
			tablero.mover(movimiento);
		}
	}
	
	
//	public Pieza(Color color) {
//
//		this.color = color;
//	}
	
	public Color getelColor() {
		return elcolor;
	}

	public void setelColor(Color color) {
		this.elcolor = color;
	}

	
}
