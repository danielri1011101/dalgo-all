public class Aula08 {

	/**
	 * Greedy algorithm for making change. When is it incorrect or sub-optimal?
	 * @param denoms The possible values of our currency. Sorted decreasingly.
	 * @param v The value to which the coins must add up.
	 */
	int[] gMakeChange(int[] denoms, int v) {
		int n= denoms.length;
		int[] ans= new int[n];
		int i= 0;
		while (i < n && v > 0) {
			int d= denoms[i];
			while (d > v && i < n-1) {
				i++;
				d= denoms[i];
			}
			while (d <= v) {
				v-= d;
				ans[i]++;
			}
			i++;
		}
		return ans;
	}

	/**
	 * @param val is the value to compose
	 * @param cs is the array of coin denominations, ordered increasingly.
	 */
	int dpMakeChange(int val, int[] cs) {
		int n= cs.length;
		int[][] memo= new int[n+1][val+1];
		for (int i= 1; i <= n; i++) {
			for (int j= 1; j <= val; j++) {
				if (i == 1) {
					memo[i][j]= j;
				}
				memo[i][j]= Math.min(1 + memo[i][j-cs[i-1]],
						memo[i-1][j]);
			}
		}
		return memo[n][val];
	}

	public static void printArray(int[] arr) {
		System.out.print("{");
		int n= arr.length;
		for (int i= 0; i < n-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[n-1] + "}");
	}

	public static void main(String[] args) {
		Aula08 au= new Aula08();
		int[] denoms= {5,4,2,1};
		int[] values= {8, 11, 18};
		for (int v : values) {
			printArray(au.dpMakeChange(v, denoms));
		}
		System.out.println("Hola dalgo!");
	}
}
