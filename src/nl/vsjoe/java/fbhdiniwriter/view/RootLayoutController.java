package nl.vsjoe.java.fbhdiniwriter.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import nl.vsjoe.java.fbhdiniwriter.Main;
import nl.vsjoe.java.fbhdiniwriter.libs.GoToWebsite;
import nl.vsjoe.java.fbhdiniwriter.libs.Loc;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author DJFLuFFy vs joe
 */

public class RootLayoutController {
	
	private Main main;
	
	public void setMain (Main main) {
		this.main = main;
	}
	
	@FXML
	private void handleExit() {
		System.exit(0);
	}
	
	@FXML
	private void handleAbout() {
		 Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(Loc.TITLE);
	        alert.setHeaderText("About");
	        alert.setContentText("Author: DJFLuFFy vs joe\nVersion " + Loc.VERSION + "\nhttps://github.com/DJFLuFFy-vs-joe/Flashback-HD-ini-Builder");

	        alert.showAndWait();
	}
	
	@FXML
	private void handleOpenWiki() {
		new GoToWebsite(Loc.WIKI).go();
	}
	
	@FXML
	private void handleLoadGames() {
		main.loadGames();
	}
	
	@FXML
	private void handleCreateIni() {
		main.createIniFile();
	}
}
