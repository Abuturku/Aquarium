
public class Carp extends Fish{

	private final static String LOOK = "<><";
	private final static String REVERSED_LOOK= "><>";
	private final static int PROBABILITY_TO_CHANGE_HEIGHT = 50;

	public static int getProbabilityToChangeHeight() {
		return PROBABILITY_TO_CHANGE_HEIGHT;
	}

	public static String getLook() {
		return LOOK;
	}
	
	public Carp() {
		super(LOOK, REVERSED_LOOK, PROBABILITY_TO_CHANGE_HEIGHT);
	}
}
