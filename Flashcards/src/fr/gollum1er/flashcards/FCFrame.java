package fr.gollum1er.flashcards;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FCFrame extends JFrame {

	private static FCFrame instance;
	private FCPanel fcPanel;

	public FCFrame() {

		this.setTitle("FLASHCARDS - v.1");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanel());
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new FCDirectory();

		instance = new FCFrame();
	}

	public static FCFrame getInstance() {

		return instance;

	}

	public FCPanel getFcPanel() {

		return this.fcPanel;

	}

}
