import java.util.ArrayList;

public class Player {
	
	private ArrayList<Piece> myPieces;
	private int score;
	private boolean player1;
	
	public Player(boolean player1) {
		setPlayer1(player1);
		setScore(0);
		myPieces = new ArrayList<Piece>();
	}
	
	public Player() {
		this(false);
	}
	
	public void addPiece(Piece p) {
		myPieces.add(p);
	}
	
	public void removePiece(Piece p){
		myPieces.remove(p);
	}
	
	public ArrayList<Piece> getMyPieces() {
		return myPieces;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addToScore(int i) {
		score += i;
	}

	/**
	 * @return the player1
	 */
	public boolean isPlayer1() {
		return player1;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayer1(boolean player1) {
		this.player1 = player1;
	}
	
	@Override
	public String toString(){
		if (player1){
			return "Player 1";
		} else {
			return "Player 2";
		}
	}
}
