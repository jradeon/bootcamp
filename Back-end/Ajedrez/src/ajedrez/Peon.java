package ajedrez;

public class Peon extends Pieza{
	
	public Peon(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		// TODO
		if(movimiento == null || tablero == null)
			throw new NullPointerException("El movimiento o el tablero son null");
		
		if(puedeComer(movimiento, tablero)) {
			
		}
		return false;
	}

	private boolean avanza(Movimiento movimiento) {
		//TODO
		return false;
	}
	
	private boolean inicia(Posicion posicion) {
		//TODO
		return false;
	}
	
	private boolean puedeComer(Movimiento movimiento, Tablero tablero) {
		//TODO
		if(movimiento == null || tablero == null)
			throw new NullPointerException("El movimiento o el tablero son null");
		
		
		return false;
	}
	
	public void mover(Movimiento movimiento, Tablero tablero) {
		
	}

}
