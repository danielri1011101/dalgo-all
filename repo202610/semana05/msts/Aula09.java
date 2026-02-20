import java.util.*;
import dutils.DalgoUtils.*;

public class Aula09 {
	public static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int weight;

		public Edge(int u, int v, int weight) {
			this.u= u;
			this.v= v;
			this.weight= weight;
		}

		@Override
		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}

		@Override
		public String toString() {
			String ans= "";
			ans+= "(" + "{" + this.u;
			ans+= ", " + this.v + "}" + ", ";
			ans+= this.weight + ")";
			return ans;
		}
	}

	// Weighted graph
	public static class WGraph {
		Edge[] edges;
		int rank; // Number of nodes

		public WGraph(Edge[] edges, int rank) {
			Arrays.sort(edges);
			this.edges= edges;
			this.rank= rank;
		}
	}

	/**
	 * Edges of weighted graph g are sorted increasingly by weight
	 */
	public static boolean[] kruskal(WGraph g) {
		int t= g.edges.length;
		int n= g.rank;
		boolean[] ans= new boolean[t];
		DSet set= new DSet(n);
		int i= 0;
		int j= 0;
		while (i < t && j < n-1) {
			Edge e= g.edges[i];
			int x= set.find(e.u);
			int y= set.find(e.v);
			if (x != y) {
				set.union(x, y);
				ans[i]= true;
				j++;
			}
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		Edge e0= new Edge(0,1,1);
		Edge e1= new Edge(1,2,2);
		Edge e2= new Edge(0,3,4);
		Edge e3= new Edge(2,5,6);
		Edge e4= new Edge(3,6,4);
		Edge e5= new Edge(5,6,3);
		Edge e6= new Edge(1,3,6);
		Edge e7= new Edge(1,4,4);
		Edge e8= new Edge(2,4,5);
		Edge e9= new Edge(3,4,3);
		Edge e10= new Edge(5,4,8);
		Edge e11= new Edge(6,4,7);
		Edge[] es= {e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11};
		Arrays.sort(es);
		System.out.println(Arrays.toString(es));
		WGraph g= new WGraph(es, 7);
		boolean[] mst= kruskal(g);
		System.out.println(Arrays.toString(mst));
	}
}
