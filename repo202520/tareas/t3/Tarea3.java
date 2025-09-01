public class Tarea3 {

	void problem00(int[] arr) {
		int n= arr.length;
		for (int i= 0; i < n; i++) {
			System.out.println(foo(arr));
		}
	}

	void problem01(int[] arr) {
		int n= arr.length;
		while (n > 0) {
			int[] temp= new int[n];
			System.out.println(foo(temp));
			n--;
		}
	}

	void problem10(int[] arr) {
		int[] temp= {-1};
		for (int v : arr) {
			temp[0]= v;
			System.out.println(foo(temp));
		}
	}

	/**
	 * @param arr sus elementos son menores o iguales a su longitud.
	 */
	void problem11(int[] arr) {
		for (int v : arr) {
			if (v < 0) {
				break;
			}
			int[] temp= new int[v];
			System.out.println(foo(temp));
		}
	}

	int[] foo(int[] arr) {
		int n= arr.length;
		int[] temp= new int[n];
		for (int i= 0; i < n; i++) {
		}
		return temp;
	}

	public static void main(String[] args) {
		Tarea3 t= new Tarea3();
		int[] arr= {2,3,5,7};
		t.problem00(arr);
		System.out.println("Tarea3");
	}
}
