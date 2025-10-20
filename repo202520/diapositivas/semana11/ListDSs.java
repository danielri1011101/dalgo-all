public class ListDSs {

	static class LisGraph {
		LList[] adjacency;
	}

	/**
	 * Linked list for weighted directed graphs
	 *
	 * The list represents the edges out of some graph node
	 *
	 * EXAMPLE: If the list represents the edges out of node "3" in some graph G,
	 * then [(0, 2), (4, 3), (7, 5)] means that in G there exists the connection
	 * 3 --> 0 with weight 2, the connection 3 --> 4 with weight 3, and the
	 * connection 3 --> 7 with weight 5
	 *
	 * REMARK: an instance of LList as defined below does not know what
	 * source node it represents
	 */
	static class LList {
		LNode head;
	}

	static class LNode {
		Connection conn;
		LNode next;
	}

	static class Connection {
		int target;
		int weight;
	}

	static class Stack {
		int[] slots;
		int index;

		/**
		 * Constructor
		 * @param c capacity of the stack
		 */
		Stack(int c) {
			this.slots= new int[c];
			for (int s : slots) {
				s= -1;
			}
		}

		boolean push(int v) {
			if (this.index >= this.slots.length) {
				return false;
			}
			this.slots[this.index]= v;
			this.index++;
			return true;
		}

		int pop() {
			if (this.slots[this.index] < 0) {
				return -1; // Empty stack
			}
			if (this.index == 0) {
				int v= this.slots[this.index];
				this.slots[this.index]= -1;
				return v;
			}
			int v= this.slots[this.index];
			this.slots[this.index]= -1;
			this.index--;
			return v;
		}
	}

	//
	// Searching algorithms
	//

	int[] dfs(LisGraph g) {
		return null;
	}

	public static void main(String[] args) {
		System.out.println("ListDSs");
	}
}
