public class Aula09 {

	class LNode {
		int val;
		LNode next;
	}

	class LList {
		LNode head;
	}

	class Graph {
		LList[] neighbors;
	}

	/**
	 * @param s Start node
	 */
	void dfsVisit(Graph g, int s, int[] pred, boolean[] visited) {
		visited[s]= true;
		LList sAdj= g.neighbors[s];
		LNode current= sAdj.head;
		while (current != null) {
			int t= current.val;
			if (!visited[t]) {
				pred[t]= s;
				dfsVisit(g, t, pred, visited);
			}
			current= current.next;
		}
		System.out.println(s);
	}

	int[] dfs(Graph g) {
		int n= g.neighbors.length;
		boolean[] visited= new boolean[n];
		int[] pred= initPred(n);
		for (int s= 0; s < n; s++) {
			if (!visited[s]) {
				dfsVisit(g, s, pred, visited); 
			}
		}
		return pred;
	}

	int[] initPred(int n) {
		int[] pred= new int[n];
		for (int i= 0; i < n; i++) {
			pred[i]= -1;
		}
		return pred;
	}

	public static void main(String[] args) {
		Aula09 au= new Aula09();

		//
		//In-class Exercise
		//

		//Neighbors of 0
		LNode n02= au.new LNode();
		n02.val= 2;
		LNode n04= au.new LNode();
		n04.val= 4;
		n02.next= n04;
		LList ns0= au.new LList();
		ns0.head= n02;

		//Neighbors of 1
		LNode n10= au.new LNode();
		n10.val= 0;
		LNode n14= au.new LNode();
		n14.val= 4;
		n10.next= n14;
		LList ns1= au.new LList();
		ns1.head= n10;

		//Neighbors of 2
		LNode n20= au.new LNode();
		n20.val= 0;
		LNode n21= au.new LNode();
		n21.val= 1;
		n20.next= n21;
		LNode n23= au.new LNode();
		n23.val= 3;
		n21.next= n23;
		LList ns2= au.new LList();
		ns2.head= n20;

		//Neighbors of 3
		LList ns3= au.new LList();
		
		//Neighbors of 4
		LList ns4= au.new LList();
		
		//Neighbors of 5
		LNode n51= au.new LNode();
		n51.val= 1;
		LList ns5= au.new LList();
		ns5.head= n51;

		LList[] neighbors= new LList[6];
		neighbors[0]= ns0;
		neighbors[1]= ns1;
		neighbors[2]= ns2;
		neighbors[3]= ns3;
		neighbors[4]= ns4;
		neighbors[5]= ns5;
		Graph g= au.new Graph();
		g.neighbors= neighbors;

		au.dfs(g);
	}
}
