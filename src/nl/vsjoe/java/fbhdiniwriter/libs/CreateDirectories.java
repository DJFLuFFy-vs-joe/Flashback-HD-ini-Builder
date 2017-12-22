package nl.vsjoe.java.fbhdiniwriter.libs;

import java.io.File;

public class CreateDirectories {
	
	public CreateDirectories() {
		createDirectory(Loc.GAMES_FOLDER);
		createDirectory(Loc.INI_FOLDER);
	}
	
	private void createDirectory(String dir) {
		File file = new File(dir);
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println(dir + " is created");
			} else {
				System.out.println("Failed to create " + dir);
			}
		}
	}
}
