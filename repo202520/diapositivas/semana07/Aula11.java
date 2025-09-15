public class Aula11 {

	//
	// Adjacency graphs
	//

	class AdjGraph {
		
		int[] nodeVals;
		boolean[][] adjMat;

		AdjGraph(int[] nodeVals, boolean[][] adjMat) {
			this.nodeVals= nodeVals;
			this.adjMat= adjMat;
		}

		int getNnodes() {
			int n= this.nodeVals.length;
			return n;
		}

		/**
		 * @return Adjacency matrix row rank
		 * @notice Can be made private
		 */
		int getAmrr() {
			boolean[][] am= this.adjMat;
			int rr= am.length;
			return rr;
		}

		/**
		 * @return Adjacency matrix column rank
		 * @notice Can be made private
		 */
		int getAmcr() {
			boolean[][] am= this.adjMat;
			int cr= am[0].length;
			return cr;
		}

		/**
		 * @return Whether or not the graph satisfies the mathematical
		 * definition
		 * @notice Full validity requires checking it is not a multigraph
		 */
		boolean getValidity() {
			int n= this.getNnodes();
			int rr= this.getAmrr();
			int cr= this.getAmcr();
			return n==rr && rr==cr;
		}
	}

	//
	// List graphs
	//

	// Singly linked list helper class
	class SLList {
		LLNode head;
	}

	// Linked list node helper class
	class LLNode {
		int nodeVal;
		LLNode next;
	}

	class LisGraph {

		// The elements of the array are the lists of neighbors
		SLList[] nodes;
	}

	//
	// Main method
	//

	public static void main(String[] args) {
		System.out.println("Aula11");

		// Controlling instance
		Aula11 au= new Aula11();

		// Short path graph
		int[] spgNodes= {1, 2, 7};
		boolean[] node0Conns= {false, true, false};
		boolean[] node1Conns= {false, false, true};
		boolean[] node2Conns= {false, false, false};
		boolean[][] spgAdjMat= {node0Conns, node1Conns, node2Conns};
		AdjGraph spg= au.new AdjGraph(spgNodes, spgAdjMat);
		System.out.println(spg.getValidity());

		// Directed graph where node [2]1 has out-degree two
		int[] digNodes= {1, 2, 7};
		boolean[] node0Conns1= {false, false, false};
		boolean[] node1Conns1= {true, false, true};
		boolean[] node2Conns1= {false, false, false};
		boolean[][] digAdjMat= {node0Conns1, node1Conns1, node2Conns1};
		AdjGraph dig= au.new AdjGraph(digNodes, digAdjMat);
		System.out.println(dig.getValidity());
	}
}
