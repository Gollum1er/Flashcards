package fr.gollum1er.flashcards.oldflashcards;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FCFrameOld extends JFrame {

	private FCPanelOld fcPanel;

	public FCFrameOld() {
		this.setTitle("Anciennes collections de flashcards");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanelOld());
		this.setVisible(true);
	}

	public FCPanelOld getFcPanel() {
		return fcPanel;
	}

}
