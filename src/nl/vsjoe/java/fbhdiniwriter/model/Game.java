package nl.vsjoe.java.fbhdiniwriter.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class Game {

	private final StringProperty fileName;
	private final StringProperty gameName;
	private final StringProperty platform;
	private final StringProperty genre;
	private final StringProperty description;
	private final StringProperty padD;
	private final StringProperty start;
	private final StringProperty btnA;
	private final StringProperty btnB;
	private final StringProperty btnC;
	private final StringProperty btnX;
	private final StringProperty btnY;
	private final StringProperty btnZ;

	public Game(String filename) {
		this.fileName = new SimpleStringProperty(filename);
		this.gameName = new SimpleStringProperty(getGame(filename));

		this.platform = new SimpleStringProperty("Genesis");
		this.genre = new SimpleStringProperty("Sega");
		this.description = new SimpleStringProperty("This is " + gameName.get() + " for the Sega Genesis");
		this.padD = new SimpleStringProperty("Directional Movement");
		this.start = new SimpleStringProperty("Start, Pause");
		this.btnA = new SimpleStringProperty("does Stuff");
		this.btnB = new SimpleStringProperty("does Stuff");
		this.btnC = new SimpleStringProperty("does Stuff");
		this.btnX = new SimpleStringProperty("No function");
		this.btnY = new SimpleStringProperty("No function");
		this.btnZ = new SimpleStringProperty("No function");
	}

	public StringProperty getFileNameProperty() {
		return fileName;
	}

	public StringProperty getGameNameProperty() {
		return gameName;
	}

	public StringProperty getPlatformProperty() {
		return platform;
	}

	public StringProperty getGenreProperty() {
		return genre;
	}

	public StringProperty getDescriptionProperty() {
		return description;
	}

	public StringProperty getPadDProperty() {
		return padD;
	}

	public StringProperty getStartProperty() {
		return start;
	}

	public StringProperty getBtnAProperty() {
		return btnA;
	}

	public StringProperty getBtnBProperty() {
		return btnB;
	}

	public StringProperty getBtnCProperty() {
		return btnC;
	}

	public StringProperty getBtnXProperty() {
		return btnX;
	}

	public StringProperty getBtnYProperty() {
		return btnY;
	}

	public StringProperty getBtnZProperty() {
		return btnZ;
	}

	public String getFileName() {
		return fileName.get();
	}
	
	public void setFileName(String fileName) {
		this.fileName.set(fileName);
	}

	public String getGameName() {
		return gameName.get();
	}
	
	public void setGameName(String gameName) {
		this.gameName.set(gameName);
	}

	public String getPlatform() {
		return platform.get();
	}
	
	public void setPlatform(String platform) {
		this.platform.set(platform);
	}

	public String getGenre() {
		return genre.get();
	}
	
	public void setGenre(String genre) {
		this.genre.set(genre);
	}

	public String getDescription() {
		return description.get();
	}
	
	public void setDescription(String description) {
		this.description.set(description);
	}

	public String getPadD() {
		return padD.get();
	}
	
	public void setPadD(String padD) {
		this.padD.set(padD);
	}

	public String getStart() {
		return start.get();
	}
	
	public void setStart(String start) {
		this.start.set(start);
	}

	public String getBtnA() {
		return btnA.get();
	}
	
	public void setBtnA(String btnA) {
		this.btnA.set(btnA);
	}

	public String getBtnB() {
		return btnB.get();
	}
	
	public void setBtnB(String btnB) {
		this.btnB.set(btnB);
	}

	public String getBtnC() {
		return btnC.get();
	}
	
	public void setBtnC(String btnC) {
		this.btnC.set(btnC);
	}

	public String getBtnX() {
		return btnX.get();
	}
	
	public void setBtnX(String btnX) {
		this.btnX.set(btnX);
	}

	public String getBtnY() {
		return btnY.get();
	}
	
	public void setBtnY(String btnY) {
		this.btnY.set(btnY);
	}

	public String getBtnZ() {
		return btnZ.get();
	}
	
	public void setBtnZ(String btnZ) {
		this.btnZ.set(btnZ);
	}

	private String getGame(String filename) {
		String gameName = filename.substring(0, filename.length() - 4);
		return gameName;
	}
}
