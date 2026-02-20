package dutils;

public class DalgoUtils {
	public static class DSet {
		int[] comps; // components
		int[] heights; // only root nodes carry height info

		public DSet(int n) {
			this.comps= new int[n];
			this.heights= new int[n];
			for (int i= 0; i < n; i++) {
				this.comps[i]= i;
			}
		}

		public int find(int x) {
			int r= this.comps[x]; // root
			while (r != this.comps[r]) {
				r= this.comps[r];
			}
			return r;
		}

		/**
		 * Keeping track of tree heights
		 * Requires new field for the class
		 */
		public void union(int x, int y) {
			int a= find(x);
			int b= find(y);
			if (a == b) {
				return;
			}
			int ha= this.heights[a];
			int hb= this.heights[b];
			if (ha < hb) {
				this.comps[a]= b;
			}
			else if (hb < ha) {
				this.comps[b]= a;
			}
			else {
				this.comps[b]= a;
				this.heights[a]++;
			}
		}


	}

	public static void main(String[] args) {
	}
}
