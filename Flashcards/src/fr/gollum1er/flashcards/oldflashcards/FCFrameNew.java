package fr.gollum1er.flashcards.oldflashcards;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FCFrameNew extends JFrame {

	private FCPanelNew fcPanel;

	public FCFrameNew() {
		this.setTitle("Nouvelles flashcards");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanelNew());
		this.setVisible(true);
	}

	public FCPanelNew getFcPanel() {
		return fcPanel;
	}

}
