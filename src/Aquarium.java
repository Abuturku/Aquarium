public class Aquarium {
	// Attributes
	private final int width;
	private final int height;
	private Fish[] fishes;
	private char[][] seaworld = null;

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

	public char[][] getSeaworld() {
		return seaworld;
	}

	public void setSeaworld(char[][] seaworld) {
		this.seaworld = seaworld;
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

	private char[][] createAquarium() {
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
		spawnFishes();
		return seaworld;
	}

	public void printAquarium() {
		if (seaworld == null) {
			createAquarium();
		}
		// print
		for (int i = 0; i < seaworld.length; i++) {
			for (int j = 0; j < seaworld[i].length; j++) {
				System.out.print(seaworld[i][j]);
			}
			System.out.println();
		}
	}

	private void spawnFishes() {

		Fish fish = null;

		for (int yPos = 1; yPos <= height; yPos++) {
			fish = null;
			int rand = (int) (Math.random() * 4);
			switch (rand) {
			case 0:
				fish = new Carp();
				break;
			case 1:
				fish = new Shark();
				break;
			case 2:
				fish = new Blowfish();
				break;
			case 3:
				fish = new Swordfish();
				break;
			}

			int fishLength;
			boolean lookright = ((int) (Math.random() * 2)) % 2 == 0;
			fish.setLooksRight(lookright);
			fishLength = fish.getLOOK().length();

			int xMax = width - fishLength+1;

			int xPosRand = (int) (Math.random() * xMax) + 1;

			char[] fishtoCharArray = fish.getLOOK().toCharArray();
			try {
				System.arraycopy(fishtoCharArray, 0, seaworld[yPos], xPosRand, fishtoCharArray.length);
			} catch (IndexOutOfBoundsException e) {

				System.out.println("Index was: " + xPosRand + " " + yPos + " Fish: " + fish.getLOOK().length());
			}
			fishes[yPos-1] = fish;
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
