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
		boolean[] its= new boolean[n];

		// memo[i][j] == max value for items 0..i and capacity j.
		int[][] memo= new int[n][maxW+1];
		for (int i= 0; i < n; i++) {
			int wi= ws[i];
			int vi= vs[i];
			for (int j= 0; j <= maxW; j++) {
				int r= j-wi;
				if (j < 0 && i > 0) {
					memo[i][j]= memo[i-1][j];
				}
				if (j >= 0 && i == 0) {
					memo[i][j]= vi;
					its[i]= true;
				}
			}
		}
		return its;
	}

	public static void main(String[] args) {
		System.out.println("Aula10");
	}
}
