import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public abstract class GameMode {
	
	private static Player[] playerArray;
	private static int numPlayers;
	private static Player currentPlayer;
	private static int numTurns;
	private Board gameBoard;
	private static Position mousePos;
	private Piece selPiece;
	private Square selSquare;
	private HBox gamePane;
	private GameInfoPane infoPane;
	private Text gameModeText;
	private Text currentPlayerText;
	private Text scores;
	
	
	public GameMode(int numPlayers) {
		setNumPlayers(numPlayers);
		setPlayerArray(new Player[numPlayers]);
		addPlayers();
		setCurrentPlayer(playerArray[0]);
		gameBoard = new Board();
		gameBoard.getBoardPane().setOnMouseClicked(new SelectionHandler());
		numTurns = 1;
		setup(gameBoard);
		gamePane = new HBox();
		infoPane = new GameInfoPane(this);
		gamePane.getChildren().addAll(gameBoard.getBoardPane(), infoPane.getInfoPane());
	}

	
	/**
	 * @return the numPlayers
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * @param numPlayers the numPlayers to set
	 */
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	/**
	 * Sets up board with pieces
	 */
	public abstract void setup(Board b);
	
	/**
	 * Switches turn to next player
	 */
	public static void nextTurn() {
		currentPlayer = playerArray[numTurns % numPlayers];
		numTurns++;
	}
	
	
	/**
	 * @return the playerArray
	 */
	public Player[] getPlayerArray() {
		return playerArray;
	}




	/**
	 * @param playerArray the playerArray to set
	 */
	public void setPlayerArray(Player[] playerArray) {
		this.playerArray = playerArray;
	}


	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}


	/**
	 * @param currentPlayer the currentPlayer to set
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


	/**
	 * @return the numTurns
	 */
	public int getNumTurns() {
		return numTurns;
	}


	/**
	 * @param numTurns the numTurns to set
	 */
	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}
	
	private void addPlayers() {
		playerArray[0] = new Player(true);
		
		for (int i = 1; i < numPlayers; i++) {
			playerArray[i] = new Player();
		}
	}


	/**
	 * @return the gameBoard
	 */
	public Board getGameBoard() {
		return gameBoard;
	}


	/**
	 * @param gameBoard the gameBoard to set
	 */
	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}


	/**
	 * @return the mousePos
	 */
	public static Position getMousePos() {
		return mousePos;
	}


	/**
	 * @param mousePos the mousePos to set
	 */
	public static void setMousePos(Position mousePos) {
		GameMode.mousePos = mousePos;
	}


	/**
	 * @return the selPiece
	 */
	public Piece getSelPiece() {
		return selPiece;
	}


	/**
	 * @param selPiece the selPiece to set
	 */
	public void setSelPiece(Piece selPiece) {
		this.selPiece = selPiece;
	}


	/**
	 * @return the selSquare
	 */
	public Square getSelSquare() {
		return selSquare;
	}


	/**
	 * @param selSquare the selSquare to set
	 */
	public void setSelSquare(Square selSquare) {
		this.selSquare = selSquare;
	}
	
	public boolean  endGame() {
		for(Player p: playerArray){
			if (p.getMyPieces().isEmpty()){
				
			}
		}
		return false;
	}
	
	//private boolean check
	public class SelectionHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent e) {
			Position mousePos = new Position((int)e.getSceneX(), (int)e.getSceneY());
			
			//disregard mouse click if outside of board
			if (!mousePos.isInBoard(gameBoard)){
				return;
			}
			Square selSqr = gameBoard.findSquare(mousePos);
			System.out.println(selSqr);
			//Select piece if piece is not already selected
			if (selSqr.isFull() && selPiece == null) {
				selPiece = selSqr.getMyPiece();
				selPiece.setSelected(true);
			//Select piece if piece is already selected
			} else if (selSqr.isFull() && selPiece != null) {
				selPiece.setSelected(false);
				selPiece = selSqr.getMyPiece();
				selPiece.setSelected(true);
			//Select square to move to
			} else if ((!selSqr.isFull()) && (selPiece != null) && (selPiece.getMyPlayer() == currentPlayer)) {
				if(selPiece.move(selSqr, gameBoard)) {
					nextTurn();
				}
				selPiece.setSelected(false);
			}
			infoPane.updateInfoPane();
		}
	}
	
	
	public HBox getGamePane() {
		return gamePane;
	}
	
}
