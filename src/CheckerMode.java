

public class CheckerMode extends GameMode {

	public CheckerMode() {
		super(2);
	}

	@Override
	public void setup(Board b) {
		Square[][] squares = b.getSquareList();
		for (int j= 0; j < Chess.BOARD_SIZE; j++){
			for (int i = 0; i < 3; i++){
				if (squares[j][i].isDark()) {
					getPlayerArray()[1].addPiece(new CheckerPiece(squares[j][i],getPlayerArray()[1]));
				}
			}
		}
		//Player 1's checkers
		for (int j= 0; j < Chess.BOARD_SIZE; j++){
			for (int i = Chess.BOARD_SIZE - 3; i < Chess.BOARD_SIZE; i++){
				if (squares[j][i].isDark()) {
					getPlayerArray()[0].addPiece(new CheckerPiece(squares[j][i],getPlayerArray()[0]));
				}
			}
		}

	}
	
	@Override
	public String toString(){
		return "Checkers";
	}


}
