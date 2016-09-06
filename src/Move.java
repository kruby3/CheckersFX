/*
 * Analyzes type of move
 */
public class Move {

	private int i_x;
	private int i_y;
	private int f_x;
	private int f_y;
	
	private int diff_x;
	private int diff_y;
	
	private Square initSqr;
	private Square finalSqr;
	
	public Move(Square initSqr, Square finalSqr) {
		i_x = initSqr.getPos().getX();
		i_y = initSqr.getPos().getY();
		f_x = finalSqr.getPos().getX();
		f_y = finalSqr.getPos().getY();
		
		setInitSqr(initSqr);
		setFinalSqr(finalSqr);
		
		diff_x = Math.abs(f_x - i_x);
		diff_y = Math.abs(f_y - i_y);
	}
	
	public boolean isDiagonal() {
		return (diff_x == diff_y);
	}
	
	public boolean isRight() {
		return (f_x > i_x);
	}
	
	public boolean isUp() {
		return (f_y < i_y);
	}
	
	public int getLength(){
		return (int) Math.sqrt((diff_x * diff_x) + (diff_y * diff_y));
	}
	
	public Position middlePos(){
		int x = (i_x + f_x) / 2;
		int y = (i_y + f_y) / 2;
		return new Position(x,y);
	}

	/**
	 * @return the initSqr
	 */
	public Square getInitSqr() {
		return initSqr;
	}

	/**
	 * @param initSqr the initSqr to set
	 */
	public void setInitSqr(Square initSqr) {
		this.initSqr = initSqr;
	}

	/**
	 * @return the finalSqr
	 */
	public Square getFinalSqr() {
		return finalSqr;
	}

	/**
	 * @param finalSqr the finalSqr to set
	 */
	public void setFinalSqr(Square finalSqr) {
		this.finalSqr = finalSqr;
	}

}
