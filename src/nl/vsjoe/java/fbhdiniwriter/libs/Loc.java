package nl.vsjoe.java.fbhdiniwriter.libs;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class Loc {
	public static String view = "view/";
	
	public static String getLayout(String layout) {
		return view + layout + ".fxml";
	}
}
