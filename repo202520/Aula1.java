public class Aula1 {
	private static void printArr(int[] aa) {
		for(int a : aa) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	public static void main (String[] args) {
		int[] r0 = {1,2,3};
		int[] r1 = {4,0,1};
		System.out.println("Hola Dalgo!");
		printArr(r0);
	}
}
