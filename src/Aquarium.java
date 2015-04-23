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
				fish = new Carp(yPos, 1);
				break;
			case 1:
				fish = new Shark(yPos, 1);
				break;
			case 2:
				fish = new Blowfish(yPos, 1);
				break;
			case 3:
				fish = new Swordfish(yPos, 1);
				break;
			}

			int fishLength;
			boolean lookright = ((int) (Math.random() * 2)) % 2 == 0;
			fish.setLooksRight(lookright);
			fishLength = fish.getLOOK().length();

			int xMax = width - fishLength + 1;

			int xPosRand = (int) (Math.random() * xMax) + 1;

			fish.setxPos(xPosRand);

			char[] fishtoCharArray = fish.getLOOK().toCharArray();
			try {
				System.arraycopy(fishtoCharArray, 0, seaworld[yPos], xPosRand,
						fishtoCharArray.length);
			} catch (IndexOutOfBoundsException e) {

				System.out.println("Index was: " + xPosRand + " " + yPos
						+ " Fish: " + fish.getLOOK().length());
			}
			fishes[yPos - 1] = fish;
		}
	}

	private boolean moveFishes() {
		if (fishes == null && seaworld == null) {
			return false;
		}
		for (int i = 0; i < fishes.length-1; i++) {
			int newX, newY;
			// delete old fish

			// move horizontal - right
			if (fishes[i].isLookingRight()) {
				newX = fishes[i].getxPos() + 1;
				if (newX < width + 1) {
					// delete tail of fish
					seaworld[i + 1][fishes[i].getxPos()] = ' ';
					// move fish
					fishes[i].setxPos(newX);
				} // turn around
				else {
					fishes[i].setLooksRight(false);
				}
			} // move horizontal - left
			else {
				newX = fishes[i].getxPos() - 1;
				if (newX > 0) {
					// delete tail of fish
					seaworld[i + 1][fishes[i].getxPos()
							+ fishes[i].getLOOK().length()] = ' ';
					// move fish
					fishes[i].setxPos(newX);
				} // turn around
				else {
					fishes[i].setLooksRight(true);
				}
			}

			// move vertical

			// print fish
			char[] fishtoCharArray = fishes[i].getLOOK().toCharArray();
			try {
				System.arraycopy(fishtoCharArray, 0, seaworld[i+1], newX,
						fishtoCharArray.length);
			} catch (IndexOutOfBoundsException e) {

				System.out.println("Index was: " + newX + " " + i+1
						+ " Fish: " + fishes[i].getLOOK().length());
			}
		}

		return true;
	}

	// private Methode Fische bewegen
	//
	// abfragen -> hoch/runter? -> tun
	// links rechts immer pro zeitschritt
	// Ab wann umdrehen -> ganzen fisch umdrehen

	public void seaworlds() {
		if (!moveFishes()) {
			System.out
					.println("ERROR: Wheter there are no fishes available or the aquarium doesn't exist.");
		}

		while (moveFishes()) {
			try {
				Thread.sleep(1000,0);
				printAquarium();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// public Methode fischwelten
	// Thread.sleep(milli,nano)
}
