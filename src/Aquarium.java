public class Aquarium {
	// Attributes
	private final int width;
	private final int height;
	private Fish[] fishes;
	private char[][] seaworld;

	// Getter,setter
	public Fish[] getFishes() {
		return fishes;
	}

	public void setFishes(Fish[] fishes) {
		this.fishes = fishes;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// Constructor
	public Aquarium(int width, int height) {
		// width&height are the inner field of the aquarium without counting
		// borders
		if (width >= 12) {
			this.width = width - 2;
		} else {
			System.out
					.println("Fehler! Mindestmaße des Aquariums 12 x 3. Mindestbreite 12 wurde initialisiert.");
			this.width = 10;
		}
		if (height >= 3) {
			this.height = height - 2;
		} else {
			System.out
					.println("Fehler! Mindestmaße des Aquariums 12 x 3. Mindesthöhe 3 wurde initialisiert.");
			this.height = 1;
		}
		this.fishes = new Fish[height];
	}

	public void printEmptyAquarium() {
		seaworld = new char[height + 2][width + 2];

		// i: y-coordinate
		for (int i = 0; i < seaworld.length; i++) {
			// j: x-coordinate
			for (int j = 0; j < seaworld[i].length; j++) {
				// corners: '+' if i bottom and j right or left border
				if (i == height + 1 && ((j == 0) || (j == width + 1))) {
					seaworld[i][j] = '+';
				}// bottom: '_' if i bottom and j not border
				else if (i == height + 1) {
					seaworld[i][j] = '_';
				}// borders: '|' j is left or right border
				else if (j == 0 || j == width + 1) {
					seaworld[i][j] = '|';
				}// waves: '~' if i is top and j not border
				else if (i == 0) {
					seaworld[i][j] = '~';
				}
			}
		}
		// print
		for (int i = 0; i < seaworld.length; i++) {
			for (int j = 0; j < seaworld[i].length; j++) {
				System.out.print(seaworld[i][j]);
			}
			System.out.println();
		}

	}

	// private Methode random Fische spawnen
	// fish toString -> toCharArray
	//

	// private Methode Fische bewegen
	//
	// abfragen -> hoch/runter? -> tun
	// links rechts immer pro zeitschritt
	// Ab wann umdrehen -> ganzen fisch umdrehen

	// public Methode fischwelten
	// Thread.sleep(milli,nano)
}
