public class Aula10 {

	/**
	 * Lines 41-43 are for LaTeX display of today's class discussion
	 */

	/**
	 * A complete solution of the knapsack problem, which returns an optimal
	 * choice of items
	 * @return boolean[] its, its[i] iff i-th item is included in the solution
	 * @param ws: all elements are positive.
	 * @param vs: =//=
	 * @param maxW: positive.
	 */
	boolean[] knapsack(int[] ws, int[] vs, int maxW) {
		int n= ws.length;

		// Compute maximum value for weight limit maxW
		int[][] memo= new int[n][maxW+1];
		for (int j= 0; j <= maxW; j++) {
			int v0= vs[0];
			int w0= ws[0];
			if (j >= w0) {
				memo[0][j]= v0;
			}
		}
		for (int i= 1; i < n; i++) {
			int wi= ws[i];
			int vi= vs[i];
			for (int j= 0; j <= maxW; j++) {
				int r= j-wi;
				if (r >= 0 && vi + memo[i-1][j-wi] > memo[i-1][j]) {
					memo[i][j]= vi + memo[i-1][j-wi];
				}
				else {
					memo[i][j]= memo[i-1][j];
				}
			}
		}

		/**
		 * {Solve knapsack by filling memo...}
		 */

		// Back-track to obtain choice of items
		boolean[] its= new boolean[n];
		int r= maxW;
		for (int i= n-1; i > 0; i--) {
			int wi= ws[i];
			int vi= vs[i];
			int ri= r-wi;
			if (ri >= 0 && memo[i][r] == memo[i-1][ri] + vi) {
				its[i]= true;
				r= ri;
			}
		}
		return its;
	}

	void printKnapsack(int[] ws, int[] vs, int maxW) {
		boolean[] its= knapsack(ws, vs, maxW);
		int n= its.length;

		int v= 0;
		System.out.println("The selected items are:");
		for (int u= 0; u < n; u++) {
			if (its[u]) {
				System.out.println("(" + ws[u] + ", " + vs[u] +
						")");
				v+= vs[u];
			}
		}

		System.out.println();
		System.out.println("With maximum value");
		System.out.println(v);
		System.out.println("for weight limit " + maxW);
	}

	public static void main(String[] args) {
		int[] ws= {1, 2, 3, 5, 6, 7};
		int[] vs= {1, 6, 7, 18, 22, 28};
		int maxW= 11;
		Aula10 au= new Aula10();
		au.printKnapsack(ws,vs,maxW);
	}
}
