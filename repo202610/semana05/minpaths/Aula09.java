import java.util.*;

public class Aula09 {
	public static class WGraph {
		int[][] distances;
		int rank;
	
		public WGraph(int[][] distances, int rank) {
			this.distances= distances;
			this.rank= rank;
		}
	}

	public static int[][] floydWarshall(WGraph g) {
		int[][] ans= Arrays.copyOf(g.distances, g.distances.length);
		int n= g.rank;
		for (int k= 0; k < n; k++) {
			for (int i= 0; i < n; i++) {
				for (int j= 0; j < n; j++) {
					int d= Integer.MAX_VALUE;
					if (ans[i][k] < d && ans[k][j] < d) {
						d= ans[i][k] + ans[k][j];
					}
					if (d < ans[i][j]) {
						ans[i][j]= d;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("Hola Dalgo!");
		int n= 4;
		int[][] ds= new int[n][n];
		for (int i= 0; i < n; i++) {
			Arrays.fill(ds[i], Integer.MAX_VALUE);
		}
		for (int i= 0; i < n; i++) {
			ds[i][i]= 0;
		}
		ds[0][1]= 5;
		ds[3][0]= 15;
		ds[2][0]= 30;
		ds[1][0]= 50;
		ds[1][2]= 15;
		ds[1][3]= 5;
		ds[2][3]= 15;
		ds[3][2]= 5;
		WGraph g= new WGraph(ds, n);
		int[][] ans= floydWarshall(g);
		for (int i= 0; i < n; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
	}
}
