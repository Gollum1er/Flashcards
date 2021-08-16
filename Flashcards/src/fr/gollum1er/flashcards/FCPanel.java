package fr.gollum1er.flashcards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.gollum1er.flashcards.newflashcards.FCFrameOld;
import fr.gollum1er.flashcards.oldflashcards.FCFrameNew;

@SuppressWarnings("serial")
public class FCPanel extends JPanel {

	JLabel flashcards = new JLabel("FLASHCARDS", SwingConstants.CENTER);
	JButton newFC = new JButton("Nouvelles flashcards");
	JButton oldFC = new JButton("Anciennes flashcards");

	public FCPanel() {
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(Color.BLACK);

		flashcards.setFont(new Font("Arial", Font.BOLD, 50));
		flashcards.setForeground(Color.WHITE);
		newFC.setForeground(Color.BLACK);
		oldFC.setForeground(Color.BLACK);
		newFC.setBackground(Color.BLACK);
		oldFC.setBackground(Color.BLACK);
		newFC.setFont(new Font("Arial", 50, 50));
		oldFC.setFont(new Font("Arial", 50, 50));

		newFC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FCFrameNew();

			}

		});

		oldFC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FCFrameOld();

			}

		});

		this.add(flashcards);
		this.add(newFC);
		this.add(oldFC);

		this.setVisible(true);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}
