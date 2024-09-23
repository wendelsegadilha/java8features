package capitulo03;

@FunctionalInterface
public interface Validator<T> {
	boolean valida(T t);
}
