package fr.gollum1er.flashcards;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.gollum1er.flashcards.newflashcards.FCFrameNew;
import fr.gollum1er.flashcards.oldflashcards.FCFrameOld;
import fr.gollum1er.flashcards.parameters.FCFrameParameters;

@SuppressWarnings("serial")
public class FCPanel extends JPanel {

	JLabel flashcards = new JLabel("FLASHCARDS", SwingConstants.CENTER);
	JLabel bG = new JLabel("par Gollum1er", SwingConstants.CENTER);
	JButton newFC = new JButton("Nouvelle collection de flashcards");
	JButton oldFC = new JButton("Anciennes collections de flashcards");
	JButton infosFC = new JButton("Principe des flashcards");
	JButton parameters = new JButton("Paramètres");

	public FCPanel() {
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(Color.DARK_GRAY);

		flashcards.setFont(new Font("Arial", Font.BOLD, 50));
		flashcards.setForeground(Color.GRAY);
		bG.setFont(new Font("Arial", Font.ITALIC, 25));
		bG.setForeground(Color.GRAY);
		newFC.setForeground(Color.DARK_GRAY);
		oldFC.setForeground(Color.DARK_GRAY);
		newFC.setBackground(Color.WHITE);
		infosFC.setForeground(Color.DARK_GRAY);
		infosFC.setBackground(Color.WHITE);
		parameters.setForeground(Color.DARK_GRAY);
		parameters.setBackground(Color.WHITE);
		oldFC.setBackground(Color.WHITE);
		newFC.setFont(new Font("Arial", 50, 50));
		oldFC.setFont(new Font("Arial", 50, 50));
		infosFC.setFont(new Font("Arial", 50, 50));
		parameters.setFont(new Font("Arial", 50, 50));

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

		infosFC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				openWebpage("https://fr.wikipedia.org/wiki/Carte_m%C3%A9moire_(apprentissage)");

			}

		});

		parameters.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new FCFrameParameters();

			}

		});

		this.add(flashcards);
		this.add(bG);
		this.add(newFC);
		this.add(oldFC);
		this.add(infosFC);
		this.add(parameters);

		parameters.setEnabled(false);

		this.setVisible(true);

	}

	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}
