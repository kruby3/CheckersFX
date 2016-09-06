import javafx.scene.image.Image;

public class CheckerPiece extends Piece {

	private Image currentImg;
	private boolean king;

	private static final int value = 1;
	
	//State images
	private static final Image red = new Image("/img/Checker_Red.png");
	private static final Image redKing = new Image("/img/Checker_Red_King.png");
	private static final Image white = new Image("/img/Checker_White.png");
	private static final Image whiteKing = new Image("/img/Checker_White_King.png");
	
	public CheckerPiece(Square sqr, Player p) {
		super(sqr, p, value);
		king = false;
		
	}
	
	
	public void setKing(boolean b) {
		king = b;
	}
	
	public void updateState() {
		if (getMyPlayer().isPlayer1()){
			if (king){
				currentImg = redKing;
			} else {
				currentImg = red;
			}
		} else {
			if (king){
				currentImg = whiteKing;
			} else {
				currentImg = white;
			}
		}
		setImage(currentImg);
	}
	
	public boolean isValidMove(Move m, Square[][] sqrList){
		System.out.println(validDoubleCaptureMove(m,sqrList));
		if (!m.isDiagonal()){
			return false;
		} else if (correctDirection(m) && (validCaptureMove(m,sqrList) || validDoubleCaptureMove(m,sqrList) || m.getLength() == 1)){
			
			return true;
		} else {
			return false;
		}
	}
	
	private boolean correctDirection(Move m){
		boolean player1 = getMyPlayer().isPlayer1();
		return (m.isUp() && player1) || (!m.isUp() && !player1) || king;
	}
	
	private boolean validCaptureMove(Move m,Square[][] sqrList){
		if (m.getLength() != 2){
			return false;
		}
		Square captureSqr;
		try {
			captureSqr = sqrList[m.middlePos().getX()][m.middlePos().getY()];
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		
		if (captureSqr.isFull()) {
			return captureSqr.getMyPiece().getMyPlayer() != getMyPlayer();
		} else {
			return false;
		}
	}
	
	private boolean validDoubleCaptureMove(Move m,Square[][] sqrList) {
		if (m.getLength() != 5) {
			System.out.println(m.getLength());
			return false;
		}
		
		Square midPoint = sqrList[m.middlePos().getX()][m.middlePos().getY()];
		Move m1 = new Move(getCurrentSqr(),midPoint);
		Move m2 = new Move(midPoint, m.getFinalSqr());
		
		return validCaptureMove(m1,sqrList) && validCaptureMove(m2,sqrList);
	}
	
	
	public boolean move(Square finalSqr, Board b) {
		Move m = new Move(getCurrentSqr(), finalSqr);
		Square[][] sqrList = b.getSquareList();
		
		if (!isValidMove(m, sqrList)){
			return false;
		}
		
		if (m.getLength() == 2){
			capture(sqrList[m.middlePos().getX()][m.middlePos().getY()].getMyPiece());
		} else if (m.getLength() == 5) {
			System.out.println("double jump");
			Square midPoint = sqrList[m.middlePos().getX()][m.middlePos().getY()];
			Move m1 = new Move(getCurrentSqr(),midPoint);
			Move m2 = new Move(midPoint, m.getFinalSqr());
			capture(sqrList[m1.middlePos().getX()][m1.middlePos().getY()].getMyPiece());
			capture(sqrList[m2.middlePos().getX()][m2.middlePos().getY()].getMyPiece());
		}
		
		if ((getMyPlayer().isPlayer1() && (finalSqr.getPos().getY() == 0))
				|| (!(getMyPlayer().isPlayer1()) && finalSqr.getPos().getY() == Chess.BOARD_SIZE - 1)){
			setKing(true);
			updateState();
		}
		
		getCurrentSqr().removePiece();
		finalSqr.addPiece(this);
		setCurrentSqr(finalSqr);
		return true;
		
	}
	


}
