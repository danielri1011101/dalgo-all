public class Aula05 {

	/**
	 * Fast exponentiation
	 * @param n a non-negative integer
	 * @return a^n
	 */
	int fastExp(int a, int n) {
		if (n < 1) {
			return 1;
		}
		if (n%2 == 0) {
			int nh= n/2;
			int b= fastExp(a, nh);
			return b*b;
		}
		return a*fastExp(a, n-1);
	}

	public static void main(String[] args) {
		Aula05 au= new Aula05();
		int a= 3;
		int n= 11;
		for (int i= 0; i <= n; i++) {
			System.out.println(au.fastExp(a,i));
		}
	}
}
