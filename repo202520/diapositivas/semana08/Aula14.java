public class Aula14 {

	class AdjGraph {
		int[] nodes;
		boolean[][] adjMat;
	}

	//
	// List-of-neighbors implementation of a graph
	//

	class LisGraph {
		SLList[] nodes;
	}

	class SLList {
		LLNode head;
	}

	class LLNode {
		int value;
		LLNode next;
	}

	public static void main(String[] args) {
		System.out.println("Aula14");
	}
}
