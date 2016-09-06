import javafx.scene.image.Image;

public class King extends Piece {

	private static final Image white = new Image("/img/KingWhite.png");
	private static final Image blue = new Image("/img/KingBlue.png");
	private static final int value = 999999999;
	
	private Player player;
	private Square sqr;
	private Image currentImg;
	
	public King(Square sqr, Player p) {
		super(sqr, p, value);
	}

	@Override
	public void updateState() {
		if(player.isPlayer1()) {
			currentImg = white;
		} else {
			currentImg = blue;
		}
		setImage(currentImg);
	}

	@Override
	public boolean isValidMove(Move m, Square[][] sqrList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean move(Square finalSqr, Board b) {
		Move move = new Move(getCurrentSqr(),finalSqr);
		// TODO Auto-generated method stub
		return false;
	}

}
