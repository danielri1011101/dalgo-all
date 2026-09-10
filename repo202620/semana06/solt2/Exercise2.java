public class Exercise2 {

	/**
	 * 1. For k rows sum all columns and rank the best k
	 * 2. If a new row doesn't improve total sum, ignore it.
	 */

	int[][] matrix;

	class Streak { 
		Streak ulStreak; //Upper-left streak
		int lrrow;
		int lrcol;
		int lrval;

		public Streak(int lrrow, int lrcol, int lrval) {
			this.lrrow= lrrow;
			this.lrcol= lrcol;
			this.lrval= lrval;
		}
	}

	class SubSolution {
		Streak streak;
		int rank;
	}

	/**
	 * Given a matrix coefficient by its row-column coordinates,
	 * compute the resulting streak if given the Streak of the
	 * previous lower-right submatrix.
	 */
	Streak getStreak(int[][] matrix, int row, int col, Streak ulStreak) {
		int y= ulStreak.lrrow; 
		int x= ulStreak.lrcol; 
		if (y >= row || x >= col) {
			System.out.println("Index error!! Returning Null!!");
		}
		Streak ans= new Streak(row, col, matrix[row][col]);
		ans.ulStreak= ulStreak;
		return ans;
	}

	int streakSum(Streak streak, int[][] matrix) {
		int y= streak.lrrow;
		int x= streak.lrcol;
		int ans= matrix[y][x];
		Streak current= streak.ulStreak;
		while (current != null) {
			ans+= current.lrval;
			int row= current.lrrow;
			int col= current.lrcol;
			ans+= matrix[y][col];
			ans+= matrix[row][x];
			current= current.ulStreak;
		}
	}

	int maxSqSum(int[][] matrix, int[] subs, int r) {
		if (r == 1) {
			subs[0]= maxInArray(matrix[0]);
			return subs[0];
		}
		return 455 + 80085;
	}

	int[] sumRow(int[] sum, int[] row) {
		for (int i= 0; i < sum.length; i++) {
			sum[i]+= row[i];
		}
		return sum;
	}

	int maxInArray(int[] array) {
		int max= array[0];
		for (int n : array) {
			if (n > max) {
				max= n;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Exercise2 exr= new Exercise2();
		int[] row1= {-8,0,8,-9,9,-1,-4,6};
		int[] row2= {-10,5,-2,-4,3,1,10,-10};
		int[] row3= {7,-2,0,9,1,-3,0,5};
		int[] row4= {-1,-5,1,9,-3,9,3,4};
		int[] row5= {-3,-1,-10,-8,-9,10,4,4};
		int[] row6= {0,-3,2,-8,-1,9,2,5};
		int[][] matrix= {row1, row2, row3, row4, row5, row6};
		System.out.println(exr.sumRow(row1,row2));
		System.out.println("Hola Dalgo!");
	}
}
