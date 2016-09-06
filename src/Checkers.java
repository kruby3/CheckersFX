import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Katie
 *
 */
public class Checkers extends Application{
	/**
	 * Size of square on board (SQUARE_SIZE x SQUARE_SIZE)
	 */
	public static final int SQUARE_SIZE = 75;
	
	/**
	 * Size of board in number of squares 
	 */
	public static final int BOARD_SIZE = 8;
	
	/**
	 * Location of mouse pointer
	 */


	private GameMode game;
	private StartMenu startMenu;

	/**
	 * Launches application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
		startMenu = new StartMenu();
		game = new CheckerMode();
		
		Scene startScene = new Scene(game.getGamePane());
		primaryStage.setScene(startScene);


	}

}


