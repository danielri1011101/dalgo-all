import java.util.Scanner;

class Ejemplo {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		//System.out.println("Enter your name:");
		String name= s.nextLine();
		//System.out.println("Enter your favourite fruit:");
		String fruit= s.nextLine();
		System.out.println("Hey " + name + "! your sister smells like "
				+ fruit + "!");
		s.close();
	}
}
