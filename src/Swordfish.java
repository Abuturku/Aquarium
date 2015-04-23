
public class Swordfish extends Fish {

	private final static String LOOK = "-<><";
	private final static String REVERSED_LOOK= "><>-";
	private final static int PROBABILITY_TO_CHANGE_HEIGHT = 20;

	public static int getProbabilityToChangeHeight() {
		return PROBABILITY_TO_CHANGE_HEIGHT;
	}

	public static String getLook() {
		return LOOK;
	}
	
	public Swordfish(int yPos, int xPos) {
		super(LOOK, REVERSED_LOOK, PROBABILITY_TO_CHANGE_HEIGHT, yPos, xPos);
	}
}
