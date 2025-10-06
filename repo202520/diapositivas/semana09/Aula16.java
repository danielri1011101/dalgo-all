public class Aula16 {

	/**
	 * Directed graph with lengths
	 */
	static class Graph {
		int nNodes; // Number of nodes
		
		int[][] pLens;
			// Path lengths
			// Square matrix of rank r with zero diagonal entires 
			// And positive non-diagonal entries
	}

	/**
	 * Floyd-Warshall algorithm for solving the shortest distances problem
	 */
	static int[][] floydWarshall(Graph g) {
		int[][] ls= matxCopy(g.pLens); // Avoid side-effects
		int n= ls.length;
		for (int k= 0; k < n; k++) {
			for (int i= 0; i < n; i++) {
				for (int j= 0; j < n; j++) {
					int prev= ls[i][j];
					int ik= ls[i][k];
					boolean b= ik < Integer.MAX_VALUE;
					int kj= ls[k][j];
					b= b && kj < Integer.MAX_VALUE;
					if (b && ik + kj < prev) {
						ls[i][j]= ik + kj;
					}
				}
			}
		}
		return ls;
	}

	/**
	 * Matrix-copying method
	 */
	static int[][] matxCopy(int[][] m) {
		int nr= m.length;
		int nc= m[0].length;
		int[][] m1= new int[nr][nc];
		for (int i= 0; i < nr; i++) {
			for (int j= 0; j < nc; j++) {
				m1[i][j]= m[i][j];
			}
		}
		return m1;
	}

	/**
	 * Matrix printing
	 */
	static void matxPrint(int[][] m) {
		int r= m.length;
		System.out.print("[");
		arrPrint(m[0]);
		for (int i= 1; i < r-1; i++) {
			System.out.print(" ");
			arrPrint(m[i]);
		}
		System.out.print(" ");
		arrPrint1(m[r-1]);
		System.out.println("]");
		 
	}

	/**
	 * Array printing
	 */
	static void arrPrint(int[] a) {
		int l= a.length;
		for (int i= 0; i < l-1; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[l-1]);
	}

	static void arrPrint1(int[] a) {
		int l= a.length;
		for (int i= 0; i < l-1; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.print(a[l-1]);
	} 

	public static void main(String[] args) {
		int maxv= Integer.MAX_VALUE;
		int[] r0= {0, 5, maxv, maxv};
		int[] r1= {50, 0, 15, 5};
		int[] r2= {30, maxv, 0, 15};
		int[] r3= {15, maxv, 5, 0};
		int[][] lss= new int[4][4];
		lss[0]= r0;
		lss[1]= r1;
		lss[2]= r2;
		lss[3]= r3;
		Graph g= new Graph();
		g.pLens= lss;
		g.nNodes= 4; 
		int[][] fw= floydWarshall(g);
		matxPrint(fw);
		System.out.println("Aula16");
	}
}
