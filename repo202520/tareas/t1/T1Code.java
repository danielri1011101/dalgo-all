public class T1Code {

	/**
	 * Analyze the following algorithms in terms of time and space
	 * complexity.
	 */

	boolean isPrime(int n) {
		boolean b= n >= 2;
		for (int i= 2; i < n && b; i++) {
			b= b && n%i > 0;
		}
		return b;
	}

	/**
	 * Divide a by b, both arguments are assumed positive.
	 * @return pair {quotient, remainder}.
	 */
	int[] division(int a, int b) {
		int q= 0;
		int r= a;
		while (r >= b) {
			q++;
			r= r-b;
		}
		int[] answer= {q, r};
		return answer;
	}

	/**
	 * Computes the trace of a square matrix,
	 * which is the sum of its diagonal coefficients.
	 * @param mm the matrix
	 */
	int trace(int[][] mm) {
		int t= 0;
		int n= mm.length; // rank of matrix
		for (int i= 0; i < n; i++) {
			for (int j= 0; j < n; j++) {
				if (i == j) {
					t= t + mm[i][j];
				}
			}
		}
		return t;
	}

	/**
	 * Another way to compute the trace.
	 */
	int trace2(int[][] mm) {
		int t= 0;
		int n= mm.length;
		for (int i= 0; i < n; i++) {
			t= t + mm[i][i];
		}
		return t;
	}
}
