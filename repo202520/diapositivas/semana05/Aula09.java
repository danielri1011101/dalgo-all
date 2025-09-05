public class Aula09 {

	/**
	 * For a memory function aproach to knapsack, have the memory function
	 * check and store the subproblems of maximum value with limiting weight
	 * between min{wi} and maxW, checked and filled according to need.
	 */

	/**
	 * Dynamic programming algorithm for the Knapsack problem.
	 */
	int dpKnapsack(int[] w, int[] v, int maxW) {
		int n= w.length;
		int[][] memo= new int[n+1][maxW+1];
		for (int i= 1; i <= n; i++) {
			int wi= w[i-1];
			int vi= v[i-1];
			for (int j= 1; j <= maxW; j++) {
				if (wi > j) {
					memo[i][j]= memo[i-1][j];
				}
				memo[i][j]= Math.max(memo[i-1][j], vi +
						memo[i-1][j-wi]);
			}
		}
		return memo[n][maxW];
	}

	/**
	 * Solution to the Knapsack problem using a memory function.
	 */
	int funKnapsack(int[] ws, int[] vs, int maxW) {

		// Max value table. w-th entry is max value weight w.
		int[] mvt= new int[maxW+1];
		for (int v : mvt) {
			mvt[v]= -1;
		}
		return fKnapsack(ws, vs, mvt);
	}

	/**
	 * @param mvt length maximum weight plus one.
	 */
	int fKnapsack(int[] ws, int[] vs, int[] mvt) {
		return 455;
	}

	public static void main(String[] args) {
		System.out.println("Aula09");
	}
}
