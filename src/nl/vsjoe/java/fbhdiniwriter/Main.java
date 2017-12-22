package nl.vsjoe.java.fbhdiniwriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import nl.vsjoe.java.fbhdiniwriter.libs.CreateDirectories;
import nl.vsjoe.java.fbhdiniwriter.libs.Loc;
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

	private Stage primaryStage;
	private BorderPane rootLayout;

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
		//TODO this is just Test code for debugging
		File gamesFolder = new File(Loc.GAMES_FOLDER);
		File[] gamesArray = gamesFolder.listFiles();
		List<String> games = new ArrayList<String>();

		for (int i=0; i < gamesArray.length; i++) {
			if (gamesArray[i].isFile()) {
				if(isBinFile(gamesArray[i].getName())) {
					games.add(gamesArray[i].getName());
					System.out.println(gamesArray[i].getName());
				}
			}
		}
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

	public static void main(String[] args) {
		launch(args);
	}
}
