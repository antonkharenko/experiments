package concurrency.in.practice;

public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
