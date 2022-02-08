package baraja;

public class Principal {
 	static	int i = 1;
	public static void main(String[] args) {
		Baraja b = new Baraja();
		b.barajar();
//        cartas.forEach(System.out::println);	
//		b.getCartas().forEach(item-> System.out.println(item.toString()));
		
		
 		var manos = b.repartirCartas(7, 5);
 		manos.forEach(mano -> {
 			 System.out.println("Jugador " + i++);
 			mano.forEach(carta -> System.out.println(carta));
 		});
		 System.out.println("quedan");
		b.getCartas().forEach(item-> System.out.println(item.toString()));
//		Naipe.Numeros v = Naipe.Numeros.AS;
//		System.out.println(v);
		
		// System.out.println(v.demaSuValor());

	}


}
