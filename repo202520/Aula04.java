public class Aula04 {
	/**
	 * Computes the sequence of moves required to solve the Hanoi puzzle with
	 * three pegs, m rings, source peg s, and target peg t.
	 * @assert s /= t, {s,t} \subset {1,2,3}
	 * @return The sequence of moves as a string.
	 */
	public static String hanoi(int m, int s, int t) {
		if (m < 1) {
			return "";
		}
		String seq= "";
		seq+= hanoi(m-1, s, 6-s-t);
		seq+= "ring " + m + ": " + s + "->" + t + "; ";
		seq+= hanoi(m-1, 6-s-t, t);
		return seq;
	}
	public static void main(String[] args) {
		System.out.println(hanoi(4,1,2));
	}
} // check for pat regen.
