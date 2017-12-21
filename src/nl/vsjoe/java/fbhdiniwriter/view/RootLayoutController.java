package nl.vsjoe.java.fbhdiniwriter.view;

import javafx.fxml.FXML;
import nl.vsjoe.java.fbhdiniwriter.Main;

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
		
	}
	
	@FXML
	private void handleAbout() {
		
	}
	
	@FXML
	private void handleLoadGames() {
		
	}
	
	@FXML
	private void handleCreateIni() {
		
	}
}