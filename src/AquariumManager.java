/**
 * @author Linda Latreider, Andreas Schick
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class AquariumManager {

	public static void main(String[] args) {
		int a = 12, b = 4;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please insert the height of the Aquarium: ");
		try {
			a = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("It has to be a number... Try again, please.");
			main(null);
		}

		System.out.println("Please insert the width of the Aquarium: ");
		try {
			b = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("It has to be a number... Try again, please.");
			main(null);
		}

		scanner.close();

		Aquarium aqua = new Aquarium(a, b);

		// see swimming fishes
		aqua.seaworlds();

	}

}
