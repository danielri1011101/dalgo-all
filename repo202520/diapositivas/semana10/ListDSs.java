public class ListDSs {

	static class LisGraph {
		LList[] adjacency;
	}

	/**
	 * Linked list for weighted directed graphs
	 * Holds two list nodes that are heads: one for the graph node sequence
	 * and one for the edge weight sequence
	 * @constraint The lists given by both 
	 */
	static class LList {
		LNode nsHead; // Nodes head
		LNode wsHead; // Weights head
	}

	static class LNode {
		int value;
		LNode next;
	}

	public static void main(String[] args) {
		System.out.println("ListDSs");
	}
}
