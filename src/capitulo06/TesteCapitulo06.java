package capitulo06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import capitulo02.Usuario;

public class TesteCapitulo06 {
	
	public static void main(String[] args) {
		
		var user1 = new Usuario("Wendel Segadilha", 150);
		var user2 = new Usuario("Venes Lopes", 134);
		var user3 = new Usuario("Anny Marcielly", 134);
		
		List<Usuario> usuarios = Arrays.asList(null, user1, user2, user3);
				
		//usuarios.forEach(u -> System.out.println(u.getNome() + " - " + u.isModerador()));
		
		//using method reference
		//usuarios.forEach(Usuario::tornarModerador);
		//usuarios.forEach(u -> System.out.println(u.getNome() + " - " + u.isModerador()));
		
		// comparing with method reference
		//usuarios.sort(Comparator.comparing(Usuario::getNome));
		
		// implements multiples comparators advanced
		Comparator<Usuario> comparadorMultiplo = Comparator.nullsLast(
				Comparator.comparingInt(Usuario::getPontos)
				.thenComparing(Usuario::getNome)
			);
		
		usuarios.sort(comparadorMultiplo);
		usuarios.forEach(System.out::println);
		
		// method reference in constructor
		Supplier<Usuario> criadorDeUsuarios = Usuario::new;
		var novoUsuario = criadorDeUsuarios.get();
		
		Function<String, Usuario> criadorOne = Usuario::new;
		var milton = criadorOne.apply("Milton");
		
		ToIntBiFunction<Integer, Integer> max = Math::max;
		System.out.println(max.applyAsInt(10, 15));
		
	}

}
