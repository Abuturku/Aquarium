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
		if (width >= 10) {
			this.width = width;
		} else {
			System.out
					.println("Fehler! Mindestmaße des Aquariums 10 x 1. Mindestbreite 10 wurde initialisiert.");
			this.width = 10;
		}
		if (height >= 1) {
			this.height = height;
		} else {
			System.out
					.println("Fehler! Mindestmaße des Aquariums 10 x 1. Mindesthöhe 1 wurde initialisiert.");
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
				if (i == height + 1 && (j == 0) || (j == width + 1)) {
					seaworld[i][j] = '+';
				}// bottom: '_' if i bottom and j not border
				else if (i == height + 1) {
					seaworld[i][j] = '_';
				}// borders: '|' j is left or right border
				else if (j == 0 || j == width + 1) {
					seaworld[i][j] = '|';
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

	// private Methode Fische bewegen

	// public Methode fischwelten
	// Thread.sleep(milli,nano)
}
