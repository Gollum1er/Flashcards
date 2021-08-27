package fr.gollum1er.flashcards.oldflashcards;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.gollum1er.flashcards.FCDirectory;
import fr.gollum1er.flashcards.game.FCFrameGame;

@SuppressWarnings("serial")
public class FCPanelOld extends JPanel {

	int filecount = 0;

	public FCPanelOld() {
		this.setLayout(new GridLayout(6, 2));
		this.setBackground(Color.DARK_GRAY);

		createButtonForFiles();
	}

	public void createButtonForFiles() {

		File file = new File(FCDirectory.SAVES);
		File[] files = file.listFiles();

		ArrayList<String> list = new ArrayList<String>();

		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				list.add(files[i].getName());
				this.filecount++;
			}
		}

		for (String string : list) {
			JButton btn = new JButton(string);
			JScrollPane scroll = new JScrollPane(btn);
			FCPanelOld.this.add(scroll);

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					new FCFrameGame(string);

				}
			});

		}

	}

}
