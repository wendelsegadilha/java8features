package capitulo08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import capitulo02.Usuario;

public class TesteCapitulo8 {
	
	public static void main(String[] args) throws IOException {
		
		var user1 = new Usuario("Wendel Segadilha", 150);
		var user2 = new Usuario("Venes Lopes", 195);
		var user3 = new Usuario("Anny Marcielly", 134);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
		usuarios.stream().filter(u -> u.getPontos() > 150).peek(System.out::println).findAny();
		
		
		int somaTotal = usuarios.stream().mapToInt(Usuario::getPontos).reduce(0, (atual, proximo) -> atual + proximo);
		System.out.println(somaTotal);
		
		int sum = usuarios.stream().mapToInt(Usuario::getPontos).sum();
		System.out.println(sum);
		
		int mult = usuarios.stream().mapToInt(Usuario::getPontos).reduce(1, (atual, proximo) -> atual * proximo);
		System.out.println(mult);
		
		
//		Files.list(Paths.get("C:\\Users\\wendel\\Downloads")).forEach(System.out::println);
		
		Files.list(Paths.get("C:\\Users\\wendel\\Downloads")).filter(f -> f.toString().endsWith(".pdf")).forEach(System.out::println);
	}
	
}
