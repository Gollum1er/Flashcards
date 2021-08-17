package fr.gollum1er.flashcards.parameters;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FCPanelParameters extends JPanel {

	JTextField name = new JTextField("Nom de votre collection de flashcards");

	public FCPanelParameters() {
		this.setLayout(new GridLayout());
		this.setBackground(Color.DARK_GRAY);
	}

}
