package fr.gollum1er.flashcards;

import java.io.File;

public class FCDirectory {
	
	public static String SAVES = new String("C:\\Flashcards\\Saves");
	
	public FCDirectory() {
		new File(SAVES).mkdirs();
	}


}
