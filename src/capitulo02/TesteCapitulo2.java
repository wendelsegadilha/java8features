package capitulo02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TesteCapitulo2 {
	
	public static void main(String[] args) {
		
		var user1 = new Usuario("Wendel Segadilha", 150);
		var user2 = new Usuario("Venes Lopes", 195);
		var user3 = new Usuario("Anny Marcielly", 134);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
//		for (Usuario u : usuarios) {
//			System.out.println(u.getNome());
//		}
		
//		class Mostrador implements Consumer<Usuario> {
//			@Override
//			public void accept(Usuario u) {
//				System.out.println(u.getNome());
//			}
//		}
		
//		Consumer<Usuario> mostrador = new Consumer<Usuario>() {
//			@Override
//			public void accept(Usuario u) {
//				System.out.println(u.getNome());
//			}
//		};
		
//		Consumer<Usuario> mostrador = (Usuario u) -> {System.out.println(u.getNome());};
//		Consumer<Usuario> mostrador = u -> System.out.println(u.getNome());
		
//		var mostrador = new Mostrador();
//		usuarios.forEach(mostrador);
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		usuarios.forEach(u -> u.tornarModerador());
		usuarios.forEach(u -> System.out.println(u.isModerador()));
		
	}
	
}
