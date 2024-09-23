package capitulo07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import capitulo02.Usuario;

public class TesteCapitulo07 {
	
	public static void main(String[] args) {
		
		var user1 = new Usuario("Wendel Segadilha", 150);
		var user2 = new Usuario("Venes Lopes", 195);
		user2.tornarModerador();
		var user3 = new Usuario("Anny Marcielly", 134);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		
		List<Usuario> maisQue100 = usuarios.stream().filter(u -> u.getPontos() >= 150).collect(Collectors.toList());
		maisQue100.forEach(System.out::println);
		
		
		List<Integer> numeros = Arrays.asList(1, 4, 3 ,4, 9, 1, 9, 5, 7, 6);
		
		List<Integer> numerosPares = numeros.stream().skip(2).filter(n -> n % 2 == 0).collect(Collectors.toList());
		numerosPares.forEach(System.out::println);
		
		List<Integer> numerosUnicos = numeros.stream().distinct().collect(Collectors.toList());
		numerosUnicos.forEach(System.out::print);
		
		List<Integer> numerosLimitados = numeros.stream().limit(5).collect(Collectors.toList());
		numerosLimitados.forEach(System.out::println);
		
		
		Map<Boolean, List<Integer>> numerosImparesPares = numeros.stream().collect(Collectors.groupingBy(n -> n % 2 == 0));
		System.out.println(numerosImparesPares);
		
		Map<Boolean, List<Usuario>> usuariosClassificados = usuarios.stream().collect(Collectors.groupingBy(u -> u.isModerador()));
		System.out.println(usuariosClassificados);
		
		long quantidadeUsuarios = usuarios.stream().count();
		System.out.println(quantidadeUsuarios);
		
		Optional<Usuario> usuarioMenorPonto = usuarios.stream().min(Comparator.comparing(Usuario::getPontos));
		System.out.println(usuarioMenorPonto.get());
		
		Optional<Usuario> usuarioMaiorPonto = usuarios.stream().max(Comparator.comparing(Usuario::getPontos));
		System.out.println(usuarioMaiorPonto.get());
		
		HashSet<Usuario> conjutoUsuarios = usuarios.stream().sorted(Comparator.comparing(Usuario::getNome)).collect(Collectors.toCollection(HashSet::new));
		System.out.println(conjutoUsuarios);
		
		// calc average with points
		usuarios.stream().mapToInt(Usuario::getPontos).average().orElseThrow(() -> new RuntimeException("Teste"));
		OptionalDouble average = usuarios.stream().mapToInt(Usuario::getPontos).average();
		System.out.println(average.orElse(0));
		
		int sum = usuarios.stream().mapToInt(Usuario::getPontos).sum();
		OptionalInt max = usuarios.stream().mapToInt(Usuario::getPontos).max();
		OptionalInt min = usuarios.stream().mapToInt(Usuario::getPontos).min();
		System.out.println(max.getAsInt() + " - " + min.getAsInt());
		
		//nome do user com maior quantidade de pontos
		Optional<String> usuarioComMaiorPonto = usuarios.stream().max(Comparator.comparing(Usuario::getPontos)).map(Usuario::getNome);
		System.out.println(usuarioComMaiorPonto.orElseThrow(RuntimeException::new));
		
		
		
		
		
		
	}

}
