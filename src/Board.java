import javafx.scene.layout.GridPane;

public class Board {
	
	private Square[][] squareList;
	private GridPane boardPane;
	
	public Board() {
		boardPane = new GridPane();
		squareList = new Square[Checkers.BOARD_SIZE][Checkers.BOARD_SIZE];
		setupBoard();
	}
	
	/**
	 * Sets up checkerboard, adds squares to a list and displays in gridpane
	 */
	private void setupBoard() {
		boolean dark = false;
		for (int i = 0; i < Checkers.BOARD_SIZE; i++) {
			for (int j = 0; j < Checkers.BOARD_SIZE; j++) {
				squareList[i][j] = new Square(i, j, dark);
				boardPane.add(squareList[i][j].getSquarePane(), i, j);
				dark = !dark;
			}
			dark = !dark;
		}
	}
	
	/*
	 * Finds square that contains a position
	 * @returns null if position is outside boundaries of the board
	 * @returns square that contains the given position
	 */
	public Square findSquare(Position p) {
		if (!p.isInBoard(this)) {
			return null;
		} else {
			return squareList[p.getX() / Checkers.SQUARE_SIZE][p.getY()/ Checkers.SQUARE_SIZE];
		}
	
	}
	
	
	/**
	 * Returns an array of squares
	 * @return squareList
	 */
	public Square[][] getSquareList() {
		return squareList;
	}

	/**
	 * @return the boardPane
	 */
	public GridPane getBoardPane() {
		return boardPane;
	}

	/**
	 * @param boardPane the boardPane to set
	 */
	public void setBoardPane(GridPane boardPane) {
		this.boardPane = boardPane;
	}

}
