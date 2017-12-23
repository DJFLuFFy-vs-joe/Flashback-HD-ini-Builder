package nl.vsjoe.java.fbhdiniwriter;

import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import nl.vsjoe.java.fbhdiniwriter.libs.CreateDirectories;
import nl.vsjoe.java.fbhdiniwriter.libs.IniFileCreator;
import nl.vsjoe.java.fbhdiniwriter.libs.Loc;
import nl.vsjoe.java.fbhdiniwriter.model.Game;
import nl.vsjoe.java.fbhdiniwriter.view.GamesOverviewController;
import nl.vsjoe.java.fbhdiniwriter.view.RootLayoutController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class Main extends Application {

	private ObservableList<Game> games = FXCollections.observableArrayList();

	private Stage primaryStage;
	private BorderPane rootLayout;

	public ObservableList<Game> getGames() {
		return games;
	}

	@Override
	public void start(Stage primaryStage) {
		startupSequence();

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(Loc.TITLE);

		initRootLayout();

		renderGamesOverview();
	}

	private void startupSequence() {
		new CreateDirectories();
	}

	public void renderGamesOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Loc.getLayout("GamesOverview")));
			AnchorPane gamesOverview = loader.load();

			rootLayout.setCenter(gamesOverview);

			GamesOverviewController controller = loader.getController();
			controller.setMain(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Loc.getLayout("Rootlayout")));
			rootLayout = loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			RootLayoutController controller = loader.getController();
			controller.setMain(this);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//TODO create some Logic

	}

	public void loadGames() {
		File gamesFolder = new File(Loc.GAMES_FOLDER);
		File[] gamesArray = gamesFolder.listFiles();

		for (int i=0; i < gamesArray.length; i++) {
			if (gamesArray[i].isFile()) {
				if(isBinFile(gamesArray[i].getName())) {
					Game game = new Game(gamesArray[i].getName());
					if(!isDuplicate(game)) {
						games.add(game);
					}
				}
			}
		}
	}

	private boolean isDuplicate(Game game) {
		for (Game gameobj : games) {
			if (gameobj.getGameName().equals(game.getGameName())) {
				return true;
			}
		}
		return false;
	}
	private boolean isBinFile(String file) {
		if (file.length() >= 4 ) {
			String ext = file.substring(file.length() - 4);
			if (ext.equals(".bin")) {
				return true;
			}
		}
		return false;
	}
	
	public void createIniFile() {
		new IniFileCreator(games);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
