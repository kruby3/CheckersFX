import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {
	
	private Position pos;
	private Position endPos;
	private Rectangle sqr;
	private Piece myPiece;
	private boolean dark;
	private boolean full;
	private StackPane squarePane;

	/**
	 * Constructor for a square
	 * @param x
	 * @param y
	 * @param dark
	 */
	public Square(int x, int y, boolean dark) {
		sqr = new Rectangle(x * Checkers.SQUARE_SIZE, y * Checkers.SQUARE_SIZE, Checkers.SQUARE_SIZE, Checkers.SQUARE_SIZE);
		pos = new Position(x, y);
		endPos = updateEndPos();
		squarePane = new StackPane();
		this.dark = dark;
		
		setColor();
		setFull(false);
		setMyPiece(null);
		
		squarePane.getChildren().add(sqr);
		
	}
	
	
	/**
	 * Returns position of square
	 */
	public Position getPos() {
		return pos;
	}
	
	/**
	 * Checks if position is within square boundaries
	 * @param p position to be checked
	 */
	public boolean isInSquare(Position p) {
        return p.getX() >= pos.getX() && p.getY() >= pos.getY() && p.getX() <= endPos.getX() && p.getY() <= endPos.getY();
	}
	
	/**
	 * Returns y position of square
	 */
	public void setPos(int x, int y) {
		if (pos != null) {
			pos.setXY(x, y);
		} else {
			pos = new Position(x,y);
		}
		endPos = updateEndPos();
	}

	/**
	 * Returns true if square is dark, false if light
	 * @return
	 */
	public boolean isDark() {
		return dark;
	}
	
	/**
	 * Sets color of square
	 */
	public void setColor() {
		if (dark){
			sqr.setFill(Color.rgb(54,118,127,.5));
		} else {
			sqr.setFill(Color.rgb(229,252,255,.5));
		}
	}
	
	/**
	 * @return the full
	 */
	public boolean isFull() {
		return full;
	}


	/**
	 * @param full the full to set
	 */
	public void setFull(boolean full) {
		this.full = full;
	}

	
	/**
	 * Removes piece from square 
	 * @param piece to be removed
	 */
	public void removePiece() {
		if (full) {
			System.out.println("REMOVING" + this);
			squarePane.getChildren().remove(myPiece.getPieceHolder());
			setFull(false);
			setMyPiece(null);
		}
		
	}
	/*
	 * Adds piece to the square
	 * @param piece to be added
	 */
	public void addPiece(Piece p) {
		if (!full) {
			squarePane.getChildren().add(p.getPieceHolder());
			setFull(true);
			setMyPiece(p);
		} 
	}
	
	/*
	 * Updates end position (lower right corner) of square
	 */
	private Position updateEndPos() {
		return new Position( pos.getX() + Checkers.SQUARE_SIZE , pos.getY() + Checkers.SQUARE_SIZE);
	}
	
	/**
	 * @return the myPiece
	 */
	public Piece getMyPiece() {
		return myPiece;
	}


	/**
	 * @param myPiece the myPiece to set
	 */
	public void setMyPiece(Piece myPiece) {
		this.myPiece = myPiece;
	}


	/**
	 * @return the squarePane
	 */
	public StackPane getSquarePane() {
		return squarePane;
	}


	/**
	 * @param squarePane the squarePane to set
	 */
	public void setSquarePane(StackPane squarePane) {
		this.squarePane = squarePane;
	}


	/***
	 * Overrides to string
	 */
	@Override
	public String toString() {
		return "Square @ " + getPos();
	}
	
}
