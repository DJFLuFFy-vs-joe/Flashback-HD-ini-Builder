package nl.vsjoe.java.fbhdiniwriter.libs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javafx.collections.ObservableList;
import nl.vsjoe.java.fbhdiniwriter.model.Game;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class IniFileCreator {

	public IniFileCreator(ObservableList<Game> games) {
		try {
			PrintWriter writer = new PrintWriter(Loc.INI_FILE, "UTF-8");

			if (games.size() >=1 ) {
				for (Game game : games) {
					writer.println("[" + game.getGameName() +"]" );
					writer.println("File=/sdcard/Games/" + game.getFileName());
					writer.println("Platform=" + game.getPlatform());
					writer.println("Genre=" + game.getGenre());
					writer.println("Description=" + game.getDescription());
					writer.println("Dpad=" + game.getPadD());
					writer.println("Start=" + game.getStart());
					writer.println("A=" + game.getBtnA());
					writer.println("B=" + game.getBtnB());
					writer.println("C=" + game.getBtnC());
					writer.println("X=" + game.getBtnX());
					writer.println("Y=" + game.getBtnY());
					writer.println("Z=" + game.getBtnZ());
					writer.println("");
				}
			}
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
