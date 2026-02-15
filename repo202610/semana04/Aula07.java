import java.util.Arrays;
import dutils.DalgoUtilities.*;

public class Aula07 {

	static class LisGraph {
		LList[] adjList;

		public LisGraph(LList[] adjList) {
			this.adjList= adjList;
		}
	}

	static class LList {
		LNode head;

		public LList(LNode head) {
			this.head= head;
		}

		void printMe() {
			LNode current= this.head;
			int ntag= current.ntag;
			while (current.succ != null) {
				System.out.print(ntag);
				System.out.print(" -> ");
				current= current.succ;
				ntag= current.ntag;
			}
			System.out.print(ntag);
			return;
		}
	}

	static class LNode {
		int ntag;
		LNode succ;

		public LNode(int ntag) {
			this.ntag= ntag;
		}
	}

	static class MatGraph {
		int nodes;
		boolean[][] adjMatrix;

		public MatGraph(int nodes, boolean[][] adjMatrix) {
			this.nodes= nodes;
			this.adjMatrix= adjMatrix;
		}
	}

	static LisGraph fromMatrix(MatGraph h) {
		int n= h.nodes; 
		boolean[][] mat= h.adjMatrix;
		LList[] adjList= new LList[n];
		for (int i= 0; i < n; i++) {
			LNode prev= null;
			for (int j= 0; j < n; j++) {
				if (mat[i][j]) {
					LNode current= new LNode(j);
					if (prev != null) {
						prev.succ= current;
						prev= current;
					}
					else {
						LList nbsi= new LList(current);
						adjList[i]= nbsi;
						prev= current;
					}
				}
			}
		}
		LisGraph g= new LisGraph(adjList);
		return g;
	}

	static int[] dfSearch(LisGraph g, int s) {
		int n= g.adjList.length;
		int[] ps= new int[n];
		Arrays.fill(ps, -1);
		ps[s]= s;
		dfs(g, ps, s);
		return ps;
	}

	static void dfs(LisGraph g, int[] ps, int s) {
		LList[] ls= g.adjList;
		LNode current= ls[s].head;
		int t= current.ntag;
		while (current.succ != null) {
			if (ps[t] < 0) {
				ps[t]= s;
				dfs(g, ps, t);
			}
			current= current.succ;
			t= current.ntag;
		}
		if (ps[t] < 0) {
			ps[t]= s;
			dfs(g, ps, t);
		}
	}

	static int[] bfSearch(LisGraph g, int s) {
		int n= g.adjList.length;
		int[] ps= new int[n];
		Arrays.fill(ps, -1);
		ps[s]= s;
		bfs(g, ps, s);
		return ps;
	}

	static void bfs(LisGraph g, int[] ps, int s) {
		QNode nd= new QNode(s);
		Queue q= new Queue(nd);
		while (!q.isEmpty()) {
			QNode cqnd= q.dequeue();
			int t= cqnd.ntag;
			LList nbs= g.adjList[t];
			LNode current= nbs.head;
			int v= current.ntag;
			while (current.succ != null) {
				if (ps[v] < 0) {
					QNode x= new QNode(v);
					q.enqueue(x);
					ps[v]= t;
				}
				current= current.succ;
				v= current.ntag; 
			}
			v= current.ntag;
			if (ps[v] < 0) {
				QNode x= new QNode(v);
				q.enqueue(x);
				ps[v]= t;
			}
		}
	}

	static void printLisGraph(LisGraph g) {
		LList[] ls= g.adjList;
		int n= ls.length;
		System.out.print("[");
		for (int i= 0; i < n-1; i++) {
			if (ls[i] != null) {
				ls[i].printMe();
			}
			System.out.println(",");
		}
		ls[n-1].printMe();
		System.out.println("]");
	}

	public static void main(String[] args) {

		int nodes= 8;
		boolean[][] adjMatrix= new boolean[8][8];
		adjMatrix[0][1]= true;
		adjMatrix[0][2]= true;
		adjMatrix[0][3]= true;

		adjMatrix[1][0]= true;
		adjMatrix[1][2]= true;
		adjMatrix[1][4]= true;
		adjMatrix[1][5]= true;

		adjMatrix[2][0]= true;
		adjMatrix[2][1]= true;
		adjMatrix[2][5]= true;

		adjMatrix[3][0]= true;
		adjMatrix[3][6]= true;
		adjMatrix[3][7]= true;

		adjMatrix[4][1]= true;
		adjMatrix[4][5]= true;

		adjMatrix[5][1]= true;
		adjMatrix[5][2]= true;
		adjMatrix[5][4]= true;

		adjMatrix[6][3]= true;
		adjMatrix[6][7]= true;

		adjMatrix[7][3]= true;
		adjMatrix[7][6]= true;

		MatGraph h= new MatGraph(nodes, adjMatrix);

		LisGraph g= fromMatrix(h);

		printLisGraph(g);

		String dfTree= Arrays.toString(dfSearch(g, 0));
		System.out.println(dfTree);

		String bfTree= Arrays.toString(bfSearch(g, 0));
		System.out.println(bfTree);

		// SIn-SOut
		System.out.println("Hola Dalgo!");
	}
}
