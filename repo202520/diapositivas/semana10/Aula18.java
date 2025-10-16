import java.util.*;

public class Aula18 {

	static class LisGraph {
		List[] adjacency;

		LisGraph(List[] adjacency) {
			this.adjacency= adjacency;
		}
	}

	static class Connection {
		int target;
		int weight;

		/**
		 * Standard constructor
		 */
		Connection(int target, int weight) {
			this.target= target;
			this.weight= weight;
		}
	}

	public static void main(String[] args) {
		System.out.println("Aula18");


		/**
		 * Golty footballs distribution problem
		 *
		 * 0= Ráquira, 1= Villapinzón, 2= Suesca, 3= Ubaté, 4= Zipaquirá,
		 * 5= Bogotá
		 */

		int n= 6; // Number of nodes


		/**
		 * Ráquira out-of connections
		 */

		// Create the connections
		Connection rv= new Connection(1, 16); // Ráquira-Villapinzón
		Connection ru= new Connection(3, 13); // Ráquira-Ubaté

		// Create the list and add the connections
		List<Connection> rcs= new ArrayList<Connection>();
		rcs.add(rv);
		rcs.add(ru);

		/**
		 * Villapinzón out-of connections
		 */

		// Create the connections
		Connection vs= new Connection(2, 12); // Villapinzón-Suesca

		// Create the list and add the connections
		List<Connection> vcs= new ArrayList<Connection>();
		vcs.add(vs);

		/**
		 * Suesca out-of connections
		 */

		// Create the connections
		Connection su= new Connection(3, 9); // Suesca-Ubaté
		Connection sb= new Connection(5, 20); // Suesca-Bogotá

		// Create the list and add the connections
		List<Connection> scs= new ArrayList<Connection>();
		scs.add(su); 
		scs.add(sb); 

		/**
		 * Ubaté out-of connections
		 */

		// Create the connections
		Connection uv= new Connection(1, 4); // Ubaté-Villapinzón
		Connection uz= new Connection(4, 14); // Ubaté-Zipaquirá

		// Create the list and add the connections
		List<Connection> ucs= new ArrayList<Connection>();
		ucs.add(uv);
		ucs.add(uz); 

		/**
		 * Zipaquirá out-of connections
		 */

		// Create the connections
		Connection zs= new Connection(2, 7); // Zipaquirá-Suesca
		Connection zb= new Connection(5, 4); // Zipaquirá-Bogotá

		// Create the list and add the connections
		List<Connection> zcs= new ArrayList<Connection>();
		zcs.add(zs);
		zcs.add(zb);

		/**
		 * Bogotá out-of connections
		 */

		// Create the connections

		// Create the list and add the connections
		List<Connection> bcs= new ArrayList<Connection>();

		//
		
		/**
		 * Create adjacency list of the problem's graph and with it
		 * create the graph
		 */
		List[] adj= {rcs, vcs, scs, ucs, zcs, bcs};
		LisGraph golty= new LisGraph(adj);
	}
}
