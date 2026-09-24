import java.util.ArrayList;

public class Aula15 {

	/*
	 * Data structure for Graphs with weights
	 * Linked list with two fields
	 */

	//Graph link
	class GLink {
		int tnode; //Target node
		int weight; //Edge weight
		GLink next;
	}

	class GNeighbors {
		GLink head;
	}

	class WGraph {
		GNeighbors[] adjacency;
	}

	class Edge {
		int src; //Source
		int tgt; //Target
		int weight;
	}

	/*
	 * @TO-DO
	 */
	int[][] getMatrix(WGraph g) {
		return null;
	}

	/*
	 * @TO-DO
	 */
	ArrayList<Edge> getEdges(WGraph g) {
		return null;
	}

	/*
	 * @TO-DO
	 */
	int find1(int[] partition, Edge edge) {
		return -1;
	}

	/*
	 * @TO-DO
	 */
	int union1(int[] partition, int h1, int h2) {
		return -1;
	}

	public static void main(String[] args) {
	}
}
