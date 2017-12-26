package nl.vsjoe.java.fbhdiniwriter.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import nl.vsjoe.java.fbhdiniwriter.MainApp;
import nl.vsjoe.java.fbhdiniwriter.model.Game;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class GamesOverviewController {

	private MainApp main;

	@FXML
	private TableView<Game> gameTable;
	
	@FXML
	private TableColumn<Game, String> gameName;
	
	@FXML
	private Label fileNameLabel;
	
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
	
	@FXML
	private void handleSaveGame() {
		Game selectedGame = gameTable.getSelectionModel().getSelectedItem();
		if(selectedGame != null) {
			selectedGame.setGameName(gameNameTextField.getText());
			selectedGame.setPlatform(systemTextField.getText());
			selectedGame.setGenre(genreTextField.getText());
			selectedGame.setDescription(descriptionTextField.getText());
			selectedGame.setPadD(dPadTextField.getText());
			selectedGame.setStart(startTextField.getText());
			selectedGame.setBtnA(buttonATextField.getText());
			selectedGame.setBtnB(buttonBTextField.getText());
			selectedGame.setBtnC(buttonCTextField.getText());
			selectedGame.setBtnX(buttonXTextField.getText());
			selectedGame.setBtnY(buttonYTextField.getText());
			selectedGame.setBtnZ(buttonZTextField.getText());
		}
	}
	
	private void showGameDetails(Game game) {
		if (game != null) {
			fileNameLabel.setText(game.getFileName());
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
		} else {
			fileNameLabel.setText("");
			gameNameTextField.setText("");
			systemTextField.setText("");
			genreTextField.setText("");
			descriptionTextField.setText("");
			dPadTextField.setText("");
			startTextField.setText("");
			buttonATextField.setText("");
			buttonBTextField.setText("");
			buttonCTextField.setText("");
			buttonXTextField.setText("");
			buttonYTextField.setText("");
			buttonZTextField.setText("");
		}
	}
	
	public void setMain(MainApp main) {
		this.main = main;
		
		gameTable.setItems(main.getGames());
	}

}
