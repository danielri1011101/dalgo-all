public class Aula04 {
	/**
	 * Computes the sequence of moves required to solve the Hanoi puzzle with
	 * three pegs, m rings, source peg s, and target peg t.
	 * @assert s /= t AND {s,t} \subset {1,2,3}
	 * @return The sequence of moves as a string.
	 */
	public static String hanoi(int m, int s, int t) {
		if (m < 1) {
			return "";
		}
		String seq= "";
		seq+= hanoi(m-1, s, 6-s-t);
		seq+= "ring " + m + ": " + s + "->" + t + "; ";
		seq+= hanoi(m-1, 6-s-t, t);
		return seq;
	}
	
	//
	// Sorting
	//
	
	/**
	 * Recursive sorting algorithm.
	 * @param aa
	 * @return a new array with the elements of aa from smallest to largest.
	 */
	public static int[] mergeSort(int[] aa) {
		int n = aa.length;
		if (n == 1) {
			return aa;
		} else {
			int m = n/2;

			// initialize the left sub-array
			int[] aal = new int[m];
			for(int i=0; i < m; i++) {
				aal[i] = aa[i];
			}

			// initialize the right sub-array
			int[] aar = new int[n-m];
			for(int j=0; m+j < n; j++) {
				aar[j] = aa[m+j];
			}
			return merge(mergeSort(aal), mergeSort(aar));
		}
	}

	/**
	 * Merge two sorted arrays.
	 * Helper function for mergeSort().
	 */
	public static int[] merge(int[] aa, int[] bb) {
		int n = aa.length;
		int m = bb.length;
		int[] ans = new int[n+m];

		int i = 0;
		int j = 0;
		boolean done = false;

		while (!done) {
			if (aa[i] > bb[j]) {
				ans[i+j] = bb[j];
				j++;
				if (j == m) {
					while (i < n) {
						ans[i+m] = aa[i];
						i++;
					}
					done = true;
				}
			} else {
				ans[i+j] = aa[i];
				i++;
				if (i == n) {
					while (j < m) {
						ans[n+j] = bb[j];
						j++;
					}
					done = true;
				}
			}
		}
		return ans;
	}

	public static int fastExp(int a, int n) {
		if (n < 1) {
			return 1;
		}
		if (n%2 == 0) {
			int nh= n/2;
			return fastExp(a, nh)*fastExp(a, nh);
		}
		return a*fastExp(a, n-1);
	}

	public static void main(String[] args) {
		System.out.println(hanoi(4,1,2));
		int a= 3;
		int n= 11;
		for (int i= 0; i <= n; i++) {
			System.out.println(fastExp(a,i));
		}
	}
}
