package capitulo04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import capitulo02.Usuario;

public class TesteCapitulo4 {
	
	public static void main(String[] args) {
		
		
		var user1 = new Usuario("Wendel Segadilha", 150);
		var user2 = new Usuario("Venes Lopes", 195);
		var user3 = new Usuario("Anny Marcielly", 124);
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
		
		Consumer<Usuario> mostradorNome = u -> {
			System.out.println(u.getNome() + " é moderador: " + u.isModerador());
		};
		
		Consumer<Usuario> tornarModerador = u -> {
			if (u.getPontos() > 130) {
				u.tornarModerador();
			}
		};
		
		usuarios.forEach(tornarModerador.andThen(mostradorNome));
		
		// usando predicated
		
		usuarios.removeIf(u -> u.getPontos() > 150);
		usuarios.forEach(mostradorNome);
		
	}

}
