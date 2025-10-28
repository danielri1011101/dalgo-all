public class Aula21 {

	boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		int r= (int) Math.sqrt(Math.abs(n));
		for (int a= 2; a <= r; a++) {
			if (n % a == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Aula21");
	}
}
