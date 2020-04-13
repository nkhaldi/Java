/*
 *	Написать программу для решения крадратный уравнений,
 *	в т.ч. с комплексными корнями.
*/

import java.util.Scanner;

public class QuadraticEquations {
	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in );

		System.out.println("Enter parameter of:");
		System.out.println("ax^2 + bx + c = 0");
		System.out.print("a = ");
		double a = scan.nextDouble();
		System.out.print("b = ");
		double b = scan.nextDouble();
		System.out.print("c = ");
		double c = scan.nextDouble();
		System.out.println();

		printEqution(a, b, c);
		if (a != 0)
			solveQuadric(a, b, c);
		else if (b != 0)
			solveLinear(b, c);
		else if (c != 0)
			System.out.println("No solutions!");
	}

	public static void solveQuadric(double a, double b, double c) {
		double diskr = b * b - 4 * a * c;

		if (diskr >= 0)
			solveReal(a, b, diskr);
		else
			solveComplex(a, b, diskr);
	}

	public static void solveReal(double a, double b, double diskr) {
		diskr = Math.sqrt(diskr);
		double x1 = (-b - diskr) / (2 * a);
		double x2 = (-b + diskr) / (2 * a);

		if (x2 > x1)
			x1 = swap(x2, x2 = x1);

		System.out.printf("x1 = %.2f\n", x1);
		System.out.printf("x2 = %.2f\n", x2);
	}

	public static void solveComplex(double a, double b, double diskr) {
		double alpha = -b / (2*a);
		double beta = Math.sqrt(-diskr) / (2*a);

		System.out.printf("x1 = %.2f + %.2fi\n", alpha, beta);
		System.out.printf("x1 = %.2f - %.2fi\n", alpha, beta);
	}

	public static void solveLinear(double b, double c) {
		double x = -c / b;
		System.out.printf("x = %.2f\n", x);
	}

	public static void printEqution(double a, double b, double c) {
			if (a == 0)
				pass();
			else
				if (a == 1)
					System.out.print("x^2");
				else if (a == -1)
					System.out.print("-x^2");
				else
					System.out.printf("%.2fx^2", a);

			if (b == 0)
				pass();
			else
				if (a != 0)
					if (b == 1)
						System.out.print(" + x");
					else if (b == -1)
						System.out.print(" - x");
					else if (b > 0)
						System.out.printf(" + %.2fx", b);
					else
						System.out.printf(" - %.2fx", -b);
				else
					if (b == 1)
							System.out.print("x");
					else if (b == -1)
						System.out.printf("-x");
					else
						System.out.printf("%.2fx", b);

			if (a != 0 || b != 0)
				if (c == 0)
					pass();
				else if (c > 0)
					System.out.printf(" + %.2f", c);
				else
					System.out.printf(" - %.2f", -c);
			else
					System.out.printf("%.2f", c);
			System.out.println(" = 0");
	}

	public static double swap(double... args) {
		return args[0];
	}

	public static void pass() {
		return;
	}
}
