public class Aula01 {

	//
	// Determinants
	//

	/**
	 * Recursive determinant, does not modify the matrix.
	 */
	public static int recDet(int[][] mm) {
		int[] pivot = mm[0];
		int n = pivot.length;
		if(n == 1) {
			return pivot[0];
		}
		else {
			int det = 0;
			for(int i=0; i < n; i++) {
				int a = pivot[i]; // expansion coefficient
				int[][] smi = subMat(mm,0,i);
				int x = pow(-1,i); // alterate the sum
				det += x*a*recDet(smi);
			}
			return det;
		}
	}

	/**
	 * Compute a^n
	 */
	public static int pow(int a, int n) {
		int pow = 1;
		for(int i=0; i < n; i++) {
			pow *= a;
		}
		return pow;
	}

	/**
	 * Returns the submatrix given by removing row r and column c.
	 */
	private static int[][] subMat(int[][] mm, int r, int c) {
		int n = mm[0].length;
		int[][] sm = new int[n-1][n-1];

		// i is the row index
		for(int i=0; i < n-1; i++) {

			// j is the column index
			for(int j=0; j < n-1; j++) {	

				// row shift
				int y = 0;
				if(i >= r) {
					y++;
				}

				// column shift
				int x = 0;
				if(j >= c) {
					x++;
				}
				sm[i][j] = mm[i+y][j+x];
			}
		}
		return sm;
	}

	/**
	 * Computes the determinant via Gauss-Jordan elimination.
	 * @param mm is assumed to have non-zero diagonal elements at each step.
	 * @param mm is a vertical array of its rows.
	 * @param mm is modified by the execution.
	 * 
	 * @question For what matrices does this algorithm fail?
	 */
	public static int gjDet(int[][] mm) {
		int n = mm[0].length;
		int[][] id = idty(n);

		// perform gaussian elimination
		for(int i=0; i < n; i++) {
			int a = mm[i][i]; // pivot coefficient
			for(int j=1; i+j < n; j++) {
				int b = mm[i+j][i];

				// modify the j-th row of mm and id
				rowOp(mm[i+j], a, -b, mm[i]);
				rowOp(id[i+j], a, -b, id[i]);
			}
		}

		// dividend
		int c = 1;
		for(int i=0; i < n; i++) {
			c = c*mm[i][i];
		}

		// divisor
		int q = 1;
		for(int i=0; i < n; i++) {
			q = q*id[i][i];
		}
		return c/q;
	}

	/**
	 * Return the identity matrix of rank n.
	 */
	private static int[][] idty(int n) {
		if(n <= 0) {
			return null;
		}
		int[][] id = new int[n][n];
		for(int i = 0; i < n; i++) {
			id[i][i] = 1;
		}
		return id;
	}

	/**
	 * Performs the row operation r = ar + bv for Gauss-Jordan elimination.
	 * @param r is modified by the operation.
	 */
	private static void rowOp(int[] r, int a, int b, int[] v) {
		for(int i=0; i < r.length; i++) {
			r[i] = a*r[i] + b*v[i];
		}
	}

	/**
	 * Prints an integer array.
	 */
	private static void printArr(int[] aa) {
		for(int a : aa) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	/**
	 * Prints an integer matrix.
	 */
	public static void printMat(int[][] mm) {
		for(int[] r : mm) {
			printArr(r);
		}
	}



	//
	// Sorting
	//
	
	/**
	 * Recursive sorting algorithm, first divide-and-conquer example.
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

	public static void insertionSort(int[] aa) {
		int n = aa.length;
		for (int i=1; i < n; i++) {
			int v = aa[i];
			int j = i-1;
			int temp = aa[j];

			while (0 <= j && v < aa[j]) {
				
				// assert v is at j+1
				
				temp = aa[j];
				aa[j] = v;
				aa[j+1] = temp;
				j--;
			}
		}
	}



















	

	public static void main (String[] args) {
		System.out.println("Hola Dalgo!");

		// rows of a matrix
		int[] r0 = {1,2,3};
		int[] r1 = {4,0,1};
		int[] r2 = {2,3,4};

		// array for sorting
		int[] r21 = {2,3,4,-1,4,0,1};
	}
}
