public class Aula06 {
	/**
	 * Computes the nuber of subsets of size k in a set of size n,
	 * by summing the rows of Pascal's triangle.
	 * @assert 0 \leq k \leq n
	 */
	int bc(int n, int k) {
		int[] memo= new int[k+1];
		int m= 0;
		memo[0]= 1;
		while (m < n) {
			m++;
			int[] temp= new int[k+1];
			temp[0]= 1;
			for (int j= 1; j <= k; j++) {
				temp[j]= memo[j-1] + memo[j];
			}
			memo= temp;
		}
		return memo[k];
	}
	public static void main(String[] args) {
		Aula06 au= new Aula06();
		System.out.println("Hola dalgo!");
		System.out.println(au.bc(4,2));
		System.out.println(au.bc(5,3));
	}
}
