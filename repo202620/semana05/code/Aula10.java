public class Aula10 {

	class LNode {
		int val;
		LNode next;

		public LNode(int val) {
			this.val= val;
		}
	}

	class LList {
		LNode head;

		public LList(LNode head) {
			this.head= head;
		}

		public LList() {
		}
	}

	class Queue {
		LNode first;
		LNode last;

		boolean isEmpty() {
			return this.last == null;
		}

		void enqueue(LNode node) {
			if (this.last == null) {
				this.first= node;
				this.last= this.first;
				return;
			}
			if (this.first == this.last) {
				this.last= node;
				this.first.next= this.last;
				return;
			}
			LNode last= this.last;
			last.next= node;
			this.last= node;
		}

		void enqueue(int v) {
			LNode node= new LNode(v);
			enqueue(node);
		}

		LNode dequeue() {
			LNode first= this.first;
			if (first == this.last) {
				this.first= null;
				this.last= null;
				return first;
			}
			LNode next= first.next;
			this.first= next;
			return first;
		}

		int dequeueInt() {
			LNode first= dequeue();
			return first.val;
		}
	}

	class Graph {
		LList[] neighbors;
	}

	/**
	 * @param s Start node
	 */
	void bfsVisit(Graph g, int s, boolean[] visited) {
		Queue q= new Queue();
		visited[s]= true;
		q.enqueue(s);
		while (!q.isEmpty()) {
			LNode first= q.dequeue();
			int s1= first.val;
			LList s1Adj= g.neighbors[s1];
			LNode current= s1Adj.head;
			while (current != null) {
				int t= current.val;
				if (!visited[t]) {
					visited[t]= true;
					q.enqueue(t);
				}
				current= current.next;
			}
		}
		
	}

	void bfs(Graph g) {
		int n= g.neighbors.length;
		boolean[] visited= new boolean[n];
		for (int s= 0; s < n; s++) {
			if (!visited[s]) {
				bfsVisit(g, s, visited); 
			}
		}
	}

	int[] initPred(int n) {
		int[] pred= new int[n];
		for (int i= 0; i < n; i++) {
			pred[i]= -1;
		}
		return pred;
	}

	public static void main(String[] args) {
		Aula10 au= new Aula10();

		//
		//In-class Exercise
		//

		//Neighbors of 0
		LNode n02= au.new LNode(2);
		LNode n04= au.new LNode(4);
		n02.next= n04;
		LList ns0= au.new LList(n02);

		//Neighbors of 1
		LNode n10= au.new LNode(0);
		LNode n14= au.new LNode(4);
		n10.next= n14;
		LList ns1= au.new LList(n10);

		//Neighbors of 2
		LNode n20= au.new LNode(0);
		LNode n21= au.new LNode(1);
		n20.next= n21;
		LNode n23= au.new LNode(3);
		n21.next= n23;
		LList ns2= au.new LList(n20);

		//Neighbors of 3
		LList ns3= au.new LList();
		
		//Neighbors of 4
		LList ns4= au.new LList();
		
		//Neighbors of 5
		LNode n51= au.new LNode(1);
		LList ns5= au.new LList(n51);

		LList[] neighbors= new LList[6];
		neighbors[0]= ns0;
		neighbors[1]= ns1;
		neighbors[2]= ns2;
		neighbors[3]= ns3;
		neighbors[4]= ns4;
		neighbors[5]= ns5;
		Graph g= au.new Graph();
		g.neighbors= neighbors;
		au.bfs(g);
	}
}
