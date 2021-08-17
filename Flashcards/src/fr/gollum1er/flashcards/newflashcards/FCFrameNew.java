package fr.gollum1er.flashcards.newflashcards;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FCFrameNew extends JFrame {

	private FCPanelNew fcPanel;

	public FCFrameNew() {
		this.setTitle("Nouvelle collection de flashcards");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanelNew());
		this.setVisible(true);
	}

	public FCPanelNew getFcPanel() {
		return fcPanel;
	}

}
