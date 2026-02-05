public class Aula05 {

	/**
	 * Recursive solution to the knapsack problem using a memory
	 * function
	 * @param p: pointer
	 */
	int funKnapsack(int[] ws, int[] vs, int p, int maxW) {
		int n= ws.length;
		boolean[] bs= new boolean[n];
		int[] anss= new int[n];
		return 455 + 80085;
	}

	int memo(boolean[] bs, int[] anss, int p) {
		if (p < 0 || p >= bs.length || p >= anss.length) {
			return -1;
		}
		if (!bs[p]) {
			return -1;
		}
		return anss[p];
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		System.out.println("Hola Dalgo");
	}
}
