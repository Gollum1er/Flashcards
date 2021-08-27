package fr.gollum1er.flashcards.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.gollum1er.flashcards.FCDirectory;

@SuppressWarnings("serial")
public class FCPanelGame extends JPanel {

	List<List<String>> lines = new ArrayList<>();
	JLabel fc = new JLabel("", SwingConstants.CENTER);

	JPanel panel;

	JTextField resp = new JTextField();
	JLabel label = new JLabel("Réponse :", SwingConstants.CENTER);
	JButton btn = new JButton("V");
	String reponse = "";
	int i = 0;

	public FCPanelGame(String name) {

		String collection = new String(FCDirectory.SAVES + "\\" + name);

		try {

			FileInputStream file = new FileInputStream(collection);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String[] values = line.split(",");

				lines.add(Arrays.asList(values));

			}

			scanner.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

		fcShow(fcChoose(i), this);

		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);

		label.setForeground(Color.GRAY);
		label.setBackground(Color.DARK_GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(660, 600, 530, 50);

		resp.setBounds(660, 650, 530, 50);
		resp.setForeground(Color.GRAY);
		resp.setBackground(Color.DARK_GRAY);
		resp.setBorder(null);
		resp.setCaretColor(Color.GRAY);
		resp.setFont(new Font("Arial", Font.PLAIN, 20));

		btn.setBounds(1210, 650, 50, 50);
		btn.setForeground(Color.GRAY);
		btn.setBackground(Color.DARK_GRAY);
		btn.setFont(new Font("Arial", Font.BOLD, 20));

		this.add(btn);
		this.add(resp);
		this.add(label);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (resp.getText().toLowerCase().equals(fcResponse(i))) {
					btn.setBackground(Color.GREEN);
					fcNext(i);
					resp.setText("");
					i++;
					fcShow(fcChoose(i), FCPanelGame.this);

				} else {
					btn.setBackground(Color.RED);
					fcNext(i);
					resp.setText("");
					i++;
					fcShow(fcChoose(i), FCPanelGame.this);
				}

			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		g.fillRect(660, 300, 600, 300);
		g.drawLine(660, 700, 1190, 700);

	}

	public String fcChoose(int i) {

		int f = 0;
		int g = 0;
		String f1 = "";
		int pr1 = 0;

		for (String pr : lines.get(i)) {

			if (g == 4) {
				pr1 = Integer.parseInt(pr);

				if (pr1%2 == 0) {

					for (String list : lines.get(i)) {

						if (f == 2) {
							f1 = list;
						}
						f++;
					}
				} else {
					for (String list : lines.get(i)) {

						if (f == 3) {
							f1 = list;
						}
						f++;
					}
				}
			}
			g++;
		}

		return f1;
	}

	public void fcShow(String f1, JPanel panel) {
		fc.setText(f1);
		fc.setBounds(660, 300, 600, 300);
		fc.setForeground(Color.DARK_GRAY);
		fc.setBackground(Color.GRAY);
		fc.setFont(new Font("Arial", Font.PLAIN, 40));
		fc.setVisible(true);
		panel.add(fc);
	}

	public String fcResponse(int i) {
		int f = 0;
		int g = 0;
		String f2 = "";
		int pr1 = 0;

		for (String pr : lines.get(i)) {

			if (g == 4) {
				pr1 = Integer.parseInt(pr);

				if (pr1%2 == 0) {

					for (String list : lines.get(i)) {

						if (f == 3) {
							f2 = list;
						}
						f++;
					}
				} else {
					for (String list : lines.get(i)) {

						if (f == 2) {
							f2 = list;
						}
						f++;
					}
				}
			}
			g++;
		}

		String reponses = f2.toLowerCase();
		System.out.println(reponses.replace(" ", ""));

		return reponses;

	}

	public void fcNext(int i) {
		int f =0;
		int f1 = 0;
		int f2 = 0;
		
		String[] value = {"id", "table", "f1", "f2", "try", "taux"};
		
		for (String list : lines.get(i)) {
			
			if (f == 0) {
				f2 = Integer.parseInt(list);
				f2 = f2+lines.size();
				
				value[0] = Integer.toString(f2);
			} else if (f == 1) {		
				value[1] = list;
			} else if (f == 2) {		
				value[2] = list;
			} else if (f == 3) {		
				value[3] = list;
			} else if (f == 4) {
				f1 = Integer.parseInt(list);
				f1++;
				
				value[4] = Integer.toString(f1);
			} else if (f == 5) {		
				value[5] = list;
			}
			f++;
			
		}
		
		

		lines.add(Arrays.asList(value));
	}

}
