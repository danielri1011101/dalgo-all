public class Aula09 {

	/**
	 * 250904
	 * For a memory function aproach to knapsack, have the memory function
	 * check and store the subproblems of maximum value with limiting weight
	 * between min{wi} and maxW, checked and filled according to need
	 *
	 * 250905
	 * Table filling for matrix bracketing as in CYK parsing algorithm
	 */

	//
	// Knapsack
	//

	/**
	 * Greedy algorithm for solving the knapsack problem
	 * @param ws Weights
	 * @param vs Values
	 * Weights and values arrays are assumed of equal length so that they
	 * can be read as an array of weight,value pairs.
	 * @return ans The maximum value attainable by this greedy processing.
	 */
	int gKnapsack(int[] ws, int[] vs, int maxW) {
		int ans= 0;
		int r= maxW;
		int j= 0;
		int n= ws.length;
		while (r > 0 && j < n) {
			int wj= ws[j];
			int vj= vs[j];
			if (wj < r) {
				r-= wj;
				ans+= vj;
			}
			j++;
		}
		return ans;
	}

	/**
	 * Dynamic programming algorithm for the Knapsack problem
	 * @param ws The array of weights
	 * @param vs The corresponding array of values
	 * @assert ws, vs must be of equal length
	 */
	int dpKnapsack(int[] ws, int[] vs, int maxW) {
		int n= ws.length;
		int[][] memo= new int[n+1][maxW+1];
		for (int i= 1; i <= n; i++) {
			int wi= ws[i-1];
			int vi= vs[i-1];
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

		// Max value table. w-th entry is max value with weight limit w.
		int[] mvt= new int[maxW+1];
		return fKnapsack(ws, vs, mvt, maxW);
	}

	/**
	 * @param ws Weights
	 * @param vs Values. Values must be positive.
	 * @param mvt Maximum value table. Length is maximum weight plus one.
	 * @param j The weight of the Knapsack, j \in [0..maxW]
	 */
	int fKnapsack(int[] ws, int[] vs, int[] mvt, int j) {
		if (mvt[j] > 0) {
			return mvt[j];
		}
		int n= ws.length;
		int wn= ws[n-1];
		int vn= vs[n-1];
		int v= Integer.MIN_VALUE;

		// Case of including the element
		if (wn < j) {
			int j1= j-wn;
			v= fKnapsack(ws, vs, mvt, j1) + vn;
		}

		// Case of not including the element
		int[] ws1= subArr(ws, n-1);
		int[] vs1= subArr(vs, n-1);
		int prev= fKnapsack(ws1, vs1, mvt, j);

		// Compute answer, update table, and return
		int ans= Math.max(v, prev);
		mvt[j]= ans;
		return ans;
	}

	/**
	 * @return xs[0..k-1]
	 * @assert k \geq 0
	 */
	private static int[] subArr(int[] xs, int k) {
		int[] ans= new int[k];
		for (int i= 0; i < k; i++) {
			ans[i]= xs[i];
		}
		return ans;
	}

	//
	// Matrix bracketing
	//

	/**
	 * @param rs Array of factors' ranks, amount of factors is one less
	 * mi has dimensions rs[i-1] x rs[i] for i \in [1..n]
	 * @return Number of multiplications required with the optimal bracketing
	 */
	int dpMb(int[] rs) {
		int n= rs.length;

		// memo[i][j] Solution to subproblem mi*...*mj
		int[][] memo= new int[n][n];
		int s= 1;
		for (int i= 1; i < n-s; i++) {
			memo[i][i+s]= rs[i-1]*rs[i]*rs[i+1];
		}
		s++;
		while (s < n-1) {
			for (int i= 1; i+s < n; i++) {
				int mults= Integer.MAX_VALUE;
				for (int k= 1; k < s; k++) {
					int msl= memo[i][i+k];
					int msr= memo[i+k+1][i+s];
					int oms= rs[i-1]*rs[i+k]*rs[i+s];
					if (msl + msr + oms < mults) {
						mults= msl+msr+oms;
					}
				}
			}
			s++;
		}
		return memo[0][n-1];
	}

	/**
	 * Functional solution to matrix bracketing
	 * @locvar mmt Minimum multiplications table
	 */
	int funMb(int[] rs) {
		int n= rs.length;
		int[][] mmt= new int[n][n];
		for (int i= 0; i < n; i++) {
			for (int j= 0; j < n; j++) {
				mmt[i][j]= -1;
			}
		}
		return fmb(rs, mmt, 1, n-1);
	}

	/**
	 * @return Minimum multiplications for mi*...*mj according to the table
	 * @param mmt
	 * and the array
	 * @param rs Factors' ranks
	 */
	int fmb(int[] rs, int[][] mmt, int i, int j) {
		int n= rs.length;
		boolean b= j >= n || i >= n;
		if (b) {
			return 0;
		}
		if (mmt[i][j] >= 0) {
			return mmt[i][j];
		}
		int s= j-i;
		if (s <= 0) {
			return 0;
		}
		int mults= Integer.MAX_VALUE;
		for (int k= 1; k < s; k++) {
			int msl= fmb(rs, mmt, i, i+k);
			int msr= fmb(rs, mmt, i+k+1, i+s);
			int oms= rs[i-1]*rs[i+k]*rs[i+s];
			if (msl + msr + oms < mults) {
				mults= msl+msr+oms;
			}
		}
		mmt[i][j]= mults;
		return mults;
	}

	//
	// Main
	//
	
	public static void main(String[] args) {
		System.out.println("Aula09");
	}
}
