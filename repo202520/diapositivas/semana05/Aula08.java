public class Aula08 {

	/**
	 * Greedy algorithm for making change. When is it incorrect or sub-optimal?
	 * @param denoms The possible values of our currency. Sorted decreasingly.
	 * @param v The value to which the coins must add up.
	 */
	int[] gMakeChange(int[] denoms, int v) {
		int n= denoms.length;
		int[] ans= new int[n];
		int i= 0;
		while (i < n && v > 0) {
			int d= denoms[i];
			while (d > v && i < n-1) {
				i++;
				d= denoms[i];
			}
			while (d <= v) {
				v-= d;
				ans[i]++;
			}
			i++;
		}
		return ans;
	}

	public static void printArray(int[] arr) {
		System.out.print("{");
		int n= arr.length;
		for (int i= 0; i < n-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[n-1] + "}");
	}

	public static void main(String[] args) {
		Aula08 au= new Aula08();
		int[] denoms= {5,4,2,1};
		int[] values= {8, 11, 18};
		for (int v : values) {
			printArray(au.gMakeChange(denoms, v));
		}
		System.out.println("Hola dalgo!");
	}
}
