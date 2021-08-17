package fr.gollum1er.flashcards.oldflashcards;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FCFrameOld extends JFrame {

	private FCPanelOld fcPanel;

	public FCFrameOld() {
		this.setTitle("Anciennes collections de flashcards");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanelOld());
		this.setVisible(true);
	}

	public FCPanelOld getFcPanel() {
		return fcPanel;
	}

}
