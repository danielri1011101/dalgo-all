public class Aula05 {

	public static class KItem {
		int weight;
		int value;

		public KItem(int weight, int value) {
			this.weight= weight;
			this.value= value;
		}
	}

	/**
	 * Recursive solution to the knapsack problem using a memory
	 * function
	 */
	static int funKnapsack(KItem[] ys, int maxW) {
		int n= ys.length;
		boolean[][] bs= new boolean[n][maxW+1];
		int[][] anss= new int[n][maxW+1];
		return fknpsck(ys, bs, anss, n-1, maxW);
	}

	private static int fknpsck(KItem[] ys, boolean[][] bs, int[][] anss,
			int item, int weight) {
		KItem current= ys[item];
		int cw= current.weight;
		int cv= current.value;

		// Base case
		if (item == 0) {
			if (cw <= weight) {
				anss[0][weight]= cv;
				bs[0][weight]= true;
				return cv;
			}
				anss[0][weight]= 0;
				bs[0][weight]= true;
				return 0;
		}

		// Build-up
		if (weight-cw < 0) {
			if (bs[item-1][weight]) {
				return anss[item-1][weight];
			}
			int prevSol1= fknpsck(ys, bs, anss, item-1, weight);
			anss[item-1][weight]= prevSol1;
			bs[item-1][weight]= true;
			return prevSol1;
		}

		if (bs[item-1][weight] && bs[item-1][weight-cw]) {
			int prevSol1= anss[item-1][weight];
			int prevSol2= anss[item-1][weight-cw];
			return Math.max(prevSol1, prevSol2 + cv);
		}

		else if (bs[item-1][weight]) {
			int prevSol1= anss[item-1][weight];
			int prevSol2= fknpsck(ys, bs, anss, item-1, weight-cw);
			anss[item-1][weight-cw]= prevSol2;
			bs[item-1][weight-cw]= true;
			return Math.max(prevSol1, prevSol2 + cv);
		}

		int prevSol1= fknpsck(ys, bs, anss, item-1, weight);
		anss[item-1][weight]= prevSol1;
		bs[item-1][weight]= true;
		int prevSol2= fknpsck(ys, bs, anss, item-1, weight-cw);
		anss[item-1][weight-cw]= prevSol2;
		bs[item-1][weight-cw]= true;
		
		return Math.max(prevSol1, prevSol2 + cv);
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		System.out.println("Hola Dalgo");
		KItem[] ys= new KItem[6];
		ys[0]= new KItem(7, 28);
		ys[1]= new KItem(6, 22);
		ys[2]= new KItem(5, 18);
		ys[3]= new KItem(3, 7);
		ys[4]= new KItem(2, 6);
		ys[5]= new KItem(1, 1);
		int exampleSol= funKnapsack(ys, 11);
		System.out.println(exampleSol);
	}
}
