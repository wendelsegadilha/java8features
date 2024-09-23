package capitulo09;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import capitulo02.Usuario;

public class TesteCapitulo09 {

	public static void main(String[] args) {
		
		Usuario user1 = new Usuario("Paulo Silveira", 150, true);
		Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
		Usuario user3 = new Usuario("Guilherme Silveira", 90);
		Usuario user4 = new Usuario("Sergio Lopes", 120);
		Usuario user5 = new Usuario("Adriano Almeida", 100);
		
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);
		
		// gera um mapa com a chave sendo a pontução
		Map<Integer, List<Usuario>> pontuacao = usuarios.stream().collect(Collectors.groupingBy(Usuario::getPontos));
		System.out.println(pontuacao);
		
		// divide em moderadores e não moderadores
		Map<Boolean, List<Usuario>> moderadores = usuarios.stream().collect(Collectors.partitioningBy(Usuario::isModerador));
		System.out.println(moderadores);
		
		//moderadores por nome
		Map<Boolean, List<String>> nomesPorTipo = usuarios.stream().collect(Collectors.partitioningBy(Usuario::isModerador, 
				Collectors.mapping(Usuario::getNome, Collectors.toList())));
		System.out.println(nomesPorTipo);
		
		

	}

}
