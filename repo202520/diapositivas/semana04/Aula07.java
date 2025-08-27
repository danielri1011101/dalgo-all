public class Aula07 {
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
	
	/**
	 * Computes the probability of player A being the first to win n races,
	 * assuming that his probability of winning any race is p \in (0,1).
	 * memo[i][j]= probability that A will be the champion given that it has to
	 * win i more races and B has to win j more races.
	 */
	float marioKart(float p, int n) {
		float[][] memo= new float[n+1][n+1];
		int i= 1;
		int j= 1;
		int k= i+j;
		float q= 1-p; // Probability that B wins a race
		while (k <= 2*n) {
			memo[0][j]= 1; // A has already won.
			for (int u= 1; u <= i; u++) {
				memo[i][u]= p*memo[i-1][u] + q*memo[i][u-1];
			}
			for (int v= 1; v <= j; v++) {
				memo[v][j]= p*memo[v-1][j] + q*memo[v][j-1];
			}
			i++;
			j++;
			k= i+j;
		}
		return memo[n][n];
	}
	
	public static void main(String[] args) {
		Aula07 au= new Aula07();
		float p= (float) 0.52;
		System.out.println(au.marioKart(p,10));
		System.out.println("Hola dalgo!");
	}
}
