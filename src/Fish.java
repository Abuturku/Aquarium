
public abstract class Fish {

	/* Attribute 
	 * toString()
	 * 
	 * Methoden
	 * public void Schwimmen
	 * 		abfragen -> hoch/runter? -> tun
	 * 		links rechts immer pro zeitschritt
	 * 		Ab wann umdrehen -> ganzen fisch umdrehen
	 * public boolean Schwimmen hoch/runter
	 */
	
	private final String LOOK_LEFT;
	private final String LOOK_RIGHT;
	private final int PROBABILITY_TO_CHANGE_HEIGHT;
	private boolean looksRight;
	private int xPos, yPos;

	public boolean isLooksRight() {
		return looksRight;
	}

	public void setLooksRight(boolean looksRight) {
		this.looksRight = looksRight;
	}

	public String getREVERSED_LOOK() {
		return LOOK_RIGHT;
	}
	
	public String getReversedLook() {
		return LOOK_RIGHT;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public String getLOOK() {
		if (looksRight) {
			return LOOK_RIGHT;
		}else {
			return LOOK_LEFT;
		}
	}

	public int getPROBABILITY_TO_CHANGE_HEIGHT() {
		return PROBABILITY_TO_CHANGE_HEIGHT;
	}
	
	public Fish(String look, String reversedLook, int probabilityToChangeHeight, int yPos, int xPos){
		this.LOOK_LEFT=look;
		this.LOOK_RIGHT=reversedLook;
		this.PROBABILITY_TO_CHANGE_HEIGHT=probabilityToChangeHeight;
		this.yPos=yPos;
		this.xPos=xPos;
		this.looksRight=false;
	}
	
	public void swim(){
		
	}
	
	public boolean willChangeHeight(){
		return (int)(Math.random()*100+1)<=PROBABILITY_TO_CHANGE_HEIGHT;
	}
	
}
