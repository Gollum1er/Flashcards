package fr.gollum1er.flashcards.game;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FCFrameGame extends JFrame {
	
	private FCPanelGame fcPanel;

	public FCFrameGame(String name) {

		this.setTitle(name);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanelGame(name));
		this.setVisible(true);
	}

	public FCPanelGame getFcPanel() {
		return fcPanel;
	}

}
