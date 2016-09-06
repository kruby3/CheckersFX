import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameInfoPane {
	private GameMode game;
	private VBox infoPane;
	private Text gameModeText;
	private Text currentPlayerText;
	private Text scoresText;
	private String scoresString;
	
	private final Text gameMode = new Text("GameMode:"); 
	private final Text currentPlayer = new Text("Current Player:");
	private final Text score = new Text("Scores:");
	
	public GameInfoPane(GameMode game) {
		this.game = game;
		infoPane = new VBox();
		gameModeText = new Text(game.toString());
		currentPlayerText = new Text(game.getCurrentPlayer().toString());
		
		scoresString = new String();
		updateScoresText();
		scoresText = new Text(scoresString);
		
		addToInfoPane();
		
	}

	private void updateScoresText() {
		Player[] playerArray = game.getPlayerArray();
		scoresString = "";
		for (Player player : playerArray) {
			scoresString += player.toString() + ": " + player.getScore() + "\n";
		}
	}
	
	public void updateInfoPane() {
		gameModeText.setText(game.toString());
		currentPlayerText.setText(game.getCurrentPlayer().toString());
		updateScoresText();
		scoresText.setText(scoresString);
	}
	
	private void addToInfoPane() {
		infoPane.getChildren().addAll(gameMode,gameModeText,currentPlayer,
				currentPlayerText,score,scoresText);
	}
	
	public VBox getInfoPane() {
		return infoPane;
	}
}
