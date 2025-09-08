public class Aula10 {

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

		// memo[i][j] == max value for items 0..i and capacity j.
		int[][] memo= new int[n][maxW+1];

		// its[i] <=> i-th item belongs in the knapsack.
		boolean[][] mits= new boolean[maxW+1][n];

		for (int j= 0; j <= maxW; j++) {
			int v0= vs[0];
			int w0= ws[0];
			if (j >= w0) {
				memo[0][j]= v0;
				mits[j][0]= true;
			}
		}
		for (int i= 1; i < n; i++) {
			int wi= ws[i];
			int vi= vs[i];
			for (int j= 0; j <= maxW; j++) {
				int r= j-wi;
				if (r >= 0 && vi + memo[i-1][j-wi] > memo[i-1][j]) {
					memo[i][j]= vi + memo[i-1][j-wi];
					mits[j]= mits[j-wi];
					mits[j][i]= true;
				}
				else {
					memo[i][j]= memo[i-1][j];
				}
			}
		}
		boolean[] its= mits[maxW];
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
