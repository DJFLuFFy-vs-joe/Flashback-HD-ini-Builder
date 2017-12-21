package nl.vsjoe.java.fbhdiniwriter.libs;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class Loc {
	public static String view = "view/";
	public static final String TITLE = "FlashBack HD ini Builder";
	
	public static String getLayout(String layout) {
		return view + layout + ".fxml";
	}
}
