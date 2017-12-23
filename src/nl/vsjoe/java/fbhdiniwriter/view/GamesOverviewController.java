package nl.vsjoe.java.fbhdiniwriter.view;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
	private TextField gameNameTextField;
	
	@FXML
	private TextField systemTextField;
	
	@FXML
	private TextField genreTextField;
	
	@FXML
	private TextField descriptionTextField;
	
	@FXML
	private TextField dPadTextField;
	
	@FXML
	private TextField startTextField;
	
	@FXML
	private TextField buttonATextField;
	
	@FXML
	private TextField buttonBTextField;
	
	@FXML
	private TextField buttonCTextField;
	
	@FXML
	private TextField buttonXTextField;
	
	@FXML
	private TextField buttonYTextField;
	
	@FXML
	private TextField buttonZTextField;
	
	@FXML
	private void initialize() {
		gameName.setCellValueFactory(cellData -> cellData.getValue().getGameNameProperty());
		
		showGameDetails(null);
		
		gameTable.getSelectionModel().selectedItemProperty().addListener(
				(Observable, oldValue, newValue) -> showGameDetails(newValue));
		
	}
	
	private void showGameDetails(Game game) {
		if (game != null) {
			gameNameTextField.setText(game.getGameName());
			systemTextField.setText(game.getPlatform());
			genreTextField.setText(game.getGenre());
			descriptionTextField.setText(game.getDescription());
			dPadTextField.setText(game.getPadD());
			startTextField.setText(game.getStart());
			buttonATextField.setText(game.getBtnA());
			buttonBTextField.setText(game.getBtnB());
			buttonCTextField.setText(game.getBtnC());
			buttonXTextField.setText(game.getBtnX());
			buttonYTextField.setText(game.getBtnY());
			buttonZTextField.setText(game.getBtnZ());
		}
	}
	
	public void setMain(Main main) {
		this.main = main;
		
		gameTable.setItems(main.getGames());
	}

}
