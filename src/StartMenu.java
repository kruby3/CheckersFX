import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StartMenu {
	private StackPane startPane;
	private VBox contentPane;
	private ImageView bgImgView;
	private Button chessButton;
	private Button checkerButton;
	private GameModes selectedGameMode;
	
	private final Image bgImg = new Image("/img/StartScreen_BG.png");
	private final Text title = new Text("Chess and Checkers");
	
	public StartMenu() {
		System.out.println("start menu constructor");
		startPane = new StackPane();
		contentPane = new VBox();
		bgImgView = new ImageView();
		bgImgView.setImage(bgImg);
		System.out.println("adding bg");
		selectedGameMode = GameModes.NONE;
		
		chessButton = new Button("Chess");
		chessButton.setOnAction(e -> selectGameMode(GameModes.CHESS));
		
		checkerButton = new Button("Checkers");
		checkerButton.setOnAction(e -> selectGameMode(GameModes.CHECKERS));
		System.out.println("buttons");
		contentPane.getChildren().addAll(title, chessButton, checkerButton);
		startPane.getChildren().addAll(bgImgView, contentPane);
		System.out.println("------end const");
	}
	
	private void selectGameMode(GameModes gameMode){
		selectedGameMode = gameMode;
	}
	
	public GameModes getGameMode() {
		System.out.println("gamemode: " + selectedGameMode);
		return selectedGameMode;
	}
	
	public StackPane getStartMenuPane() {
		System.out.println("returning pane");
		return startPane;
	}

}
