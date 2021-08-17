package fr.gollum1er.flashcards.parameters;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FCFrameParameters extends JFrame {

	private FCPanelParameters fcPanel;

	public FCFrameParameters() {
		this.setTitle("Nouvelle collection de flashcards");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanelParameters());
		this.setVisible(true);
	}

	public FCPanelParameters getFcPanel() {
		return fcPanel;
	}

}
