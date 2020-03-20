import java.util.Scanner;

class HelloWorld {
	public static void main( String []args ) {
		Scanner scan = new Scanner(System.in);

		System.out.println("What is your name?");
		String name = scan.nextLine();
		System.out.printf("Hello, %s!\n", name);
	}
}
