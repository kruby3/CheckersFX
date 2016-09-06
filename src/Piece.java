import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.util.Duration;

public abstract class Piece {
	
	private Square currentSqr;


	private Player myPlayer;
	private ImageView imgView;
	private boolean selected;
	private HBox pieceHolder;
	private int value;
	
	/**
	 * Constructor for a piece
	 * @param sqr
	 * @param p
	 */
	public Piece(Square sqr, Player p, int v) {
		currentSqr = sqr;
		myPlayer = p;
		value = v;
		
		setSelected(false);
		
		imgView = new ImageView();
		pieceHolder = new HBox(imgView);
		
		updateState();
		
		sqr.addPiece(this);
		
	}
	
	/**
	 * Gets image view for piece
	 * @return imgView Image View for piece
	 */
	public ImageView getImgView() {
		return imgView;
	}

	/**
	 * Sets image view for piece
	 * @param imgView Image View for piece
	 */
	public void setImgView(ImageView imgView) {
		this.imgView = imgView;
	}
	
	/**
	 * Gets HBox piece holder that contains image view of piece
	 * @return the pieceHolder
	 */
	public HBox getPieceHolder() {
		return pieceHolder;
	}

	/**
	 * Sets HBox piece holder that contains image view of piece
	 * @param pieceHolder the pieceHolder to set
	 */
	public void setPieceHolder(HBox pieceHolder) {
		this.pieceHolder = pieceHolder;
	}
	
	
	public abstract void updateState();
	
	private Position getCenter(Square sqr) {
		return new Position(sqr.getPos().getX() + (Chess.SQUARE_SIZE / 2),sqr.getPos().getY() + (Chess.SQUARE_SIZE / 2));
	}
	
	/*
	 * Sets image of piece
	 */
	public void setImage(Image img) {
		imgView.setImage(img);
	}
	
	/**
	 * Moves piece from current square to given square
	 * @param finalSqr
	 */
	
	
	/**
	 * Gets the current square that the piece is on
	 * @return currentSqr 
	 */
	public Square getCurrentSqr() {
		return currentSqr;
	}
	
	/**
	 * @param currentSqr the currentSqr to set
	 */
	public void setCurrentSqr(Square currentSqr) {
		this.currentSqr = currentSqr;
	}

	/**
	 * @return the myPlayer
	 */
	public Player getMyPlayer() {
		return myPlayer;
	}

	/**
	 * @param myPlayer the myPlayer to set
	 */
	public void setMyPlayer(Player myPlayer) {
		this.myPlayer = myPlayer;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
		if (selected) {
			pieceHolder.setEffect(addSelectionEffect());
		}else {
			try {
				if (pieceHolder.getEffect() != null) {
					pieceHolder.setEffect(null);
				}	
			} catch (NullPointerException e) {
			}
		}
	}

	/**
	 * Adds border glow to piece holder
	 */
	private DropShadow addSelectionEffect() {
		int depth = 70; //Setting the uniform variable for the glow width and height
		 
		DropShadow borderGlow= new DropShadow();
		borderGlow.setOffsetY(0f);
		borderGlow.setOffsetX(0f);
		borderGlow.setColor(Color.YELLOW);
		borderGlow.setWidth(depth);
		borderGlow.setHeight(depth);
		
		return borderGlow;
	}
	
	public void capture(Piece capturedPiece){	
		//Get piece's owner
		Player capturedPlayer = capturedPiece.getMyPlayer();
		//Remove piece from owner's piece arraylist
		capturedPlayer.getMyPieces().remove(capturedPiece);
		//Remove piece from square on board
		capturedPiece.getCurrentSqr().removePiece();
		//add point to player's score
		getMyPlayer().addToScore(value);
	}
	
	public abstract boolean isValidMove(Move m, Square[][] sqrList);
	public abstract boolean move(Square finalSqr, Board b);

	
}
