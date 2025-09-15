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

	class LisGraph {
	}

	//
	// Main method
	//

	public static void main(String[] args) {
		System.out.println("Aula11");

		// Short path graph
		int[] spgNodes= {1, 2, 7};
		boolean[] node0Conns= {};
		boolean[] node1Conns= {};
		boolean[] node2Conns= {};

		// Digraph where node [2]1 has out-degree two
		int[] digNodes= {1, 2, 7};
		boolean[] node0Conns1= {};
		boolean[] node1Conns1= {};
		boolean[] node2Conns1= {};
	}
}
