package capitulo03;

public class TesteCapitulo03 {

	public static void main(String[] args) {

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.print(i + " - ");
			}
		}).start();
		
		
//		Validator<String> validadorCEP = new Validator<String>() {
//			@Override
//			public boolean valida(String valor) {
//				return valor.matches("[0-9]{5}-[0-9]{3}");
//			}
//		};
		
		Validator<String> validadorCEP = cep -> cep.matches("[0-9]{5}-[0-9]{3}");
		
		System.out.println(validadorCEP.valida("65300-855"));

	}

}
