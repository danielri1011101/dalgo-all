public class Aula03 {

	/**
	 * Returns the n-th Fibonacci number, computed iteratively
	 * In Java it is O(n) for n at most 45
	 * @param n positive integer
	 */
	public static int fibIter(int n) {
		int a= 0;
		int b= 1; // larger number
		for (int i= 0; i < n; i++) {
			int temp= b;
			b+= a;
			a= temp;
		}
		return b;
	}

	/**
	 * Computes Fibonacci numbers recursively
	 * What is its time and space complexity?
	 */
	public static int fibRec(int n) {
		if (n < 2) {
			return n;
		}
		return fibRec(n-1) + fibRec(n-2);
	}

	public static void main(String[] args) {
		System.out.println(fibRec(8));
	}
}
