package nl.vsjoe.java.fbhdiniwriter.libs;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 
 * @author DJFLuFFy vs joe
 *
 */

public class GoToWebsite {
	
	private String url;
	
	public GoToWebsite(String url) {
		this.url = url;
	}
	
	public void go() {
		try{
			if(java.awt.Desktop.isDesktopSupported() ) {
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

				if(desktop.isSupported(java.awt.Desktop.Action.BROWSE) ) {
					java.net.URI uri = new java.net.URI(url);
					desktop.browse(uri);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
