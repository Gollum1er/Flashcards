package fr.gollum1er.flashcards;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class FCFrame extends JFrame {

	private static FCFrame instance;
	private FCPanel fcPanel;

	public FCFrame() {

		this.setTitle("FLASHCARDS - v.0.0.1");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(fcPanel = new FCPanel());
		this.setVisible(true);
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		instance = new FCFrame();
	}

	public static FCFrame getInstance() {

		return instance;

	}

	public FCPanel getFcPanel() {

		return this.fcPanel;

	}

}
