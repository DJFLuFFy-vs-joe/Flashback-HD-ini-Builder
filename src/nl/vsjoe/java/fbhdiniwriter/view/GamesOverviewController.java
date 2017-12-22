package nl.vsjoe.java.fbhdiniwriter.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import nl.vsjoe.java.fbhdiniwriter.Main;
import nl.vsjoe.java.fbhdiniwriter.model.Game;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */
public class GamesOverviewController {

	private Main main;
	
	@FXML
	private TableView<Game> gameTable;
	
	@FXML
	private TableColumn<Game, String> gameName;
	
	@FXML
	private void initialize() {
		gameName.setCellValueFactory(cellData -> cellData.getValue().getGameNameProperty());
		
	}
	
	public void setMain(Main main) {
		this.main = main;
		
		gameTable.setItems(main.getGames());
	}

}
