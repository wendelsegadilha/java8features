package capitulo05;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import capitulo02.Usuario;

public class TesteCapitulo05 {
	
	public static void main(String[] args) {
		
		var user1 = new Usuario("Wendel Segadilha", 150);
		var user2 = new Usuario("Venes Lopes", 195);
		var user3 = new Usuario("Anny Marcielly", 134);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
//		Comparator<Usuario> comparaPorNome = new Comparator<Usuario>() {
//			@Override
//			public int compare(Usuario u1, Usuario u2) {
//				return u1.getNome().compareTo(u2.getNome());
//			}
//		};
//		Collections.sort(usuarios, comparaPorNome);
//		Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));
//		usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
		
		//usuarios.sort(comparing(u -> u.getNome()));
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
		var palavras = Arrays.asList("Casa do Código", "Alura", "Jdev");
		palavras.sort(Comparator.naturalOrder());
		palavras.forEach(p -> System.out.println(p));
		palavras.sort(Comparator.reverseOrder());
		palavras.forEach(p -> System.out.println(p));
		
		
		// ordenando por pontos
//		Function<Usuario, Integer> extrairPontos = u -> u.getPontos();
//		Comparator<Usuario> comparaPorPontos = Comparator.comparing(extrairPontos);
		
		ToIntFunction<Usuario> extrairPontos = u -> u.getPontos();
		Comparator<Usuario> comparaPorPontos = Comparator.comparingInt(extrairPontos).reversed();
		
		usuarios.sort(comparaPorPontos);
		usuarios.forEach(u -> System.out.println(u.getPontos()));
		
		
	}

}
