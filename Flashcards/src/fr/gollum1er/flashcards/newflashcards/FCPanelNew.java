package fr.gollum1er.flashcards.newflashcards;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class FCPanelNew extends JPanel {

	JLabel name = new JLabel("Nom de la collection :");
	JTextField namet = new JTextField(20);

	JLabel face1 = new JLabel("Recto de la flashcard : ");
	JTextField face1t = new JTextField(20);

	JLabel face2 = new JLabel("Verso de la flashcard : ");
	JTextField face2t = new JTextField(20);

	JButton confirm = new JButton("Sauvegarder la flashcard");

	JButton save = new JButton("Sauvegarder la collection");

	String[] columns = new String[] { "Id", "Table", "Face1", "Face2", "Essais", "Taux de réussite" };

	Object data[][] = new Object[][] {};

	DefaultTableModel model = new DefaultTableModel(data, columns);

	JTable table = new JTable(model);

	JScrollPane scroll = new JScrollPane(table);

	TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());

	JLabel search = new JLabel("Rechercher dans la collection :");
	JTextField searcht = new JTextField(20);

	public FCPanelNew() {
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);

		name.setLabelFor(namet);
		face1.setLabelFor(face1t);
		face2.setLabelFor(face2t);
		search.setLabelFor(searcht);

		name.setFont(new Font("Arial", Font.BOLD, 20));
		name.setForeground(Color.GRAY);
		face1.setFont(new Font("Arial", Font.BOLD, 20));
		face1.setForeground(Color.GRAY);
		face2.setFont(new Font("Arial", Font.BOLD, 20));
		face2.setForeground(Color.GRAY);

		table.setRowSorter(sort);

		namet.setForeground(Color.GRAY);
		namet.setBackground(Color.DARK_GRAY);
		namet.setFont(new Font("Arial", Font.BOLD, 20));
		confirm.setForeground(Color.GRAY);
		confirm.setBackground(Color.WHITE);
		confirm.setFont(new Font("Arial", Font.BOLD, 20));
		save.setForeground(Color.GRAY);
		save.setBackground(Color.WHITE);
		save.setFont(new Font("Arial", Font.BOLD, 20));
		face1t.setForeground(Color.GRAY);
		face1t.setBackground(Color.DARK_GRAY);
		face1t.setFont(new Font("Arial", Font.BOLD, 20));
		face2t.setForeground(Color.GRAY);
		face2t.setBackground(Color.DARK_GRAY);
		face2t.setFont(new Font("Arial", Font.BOLD, 20));
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		scroll.setForeground(Color.WHITE);
		scroll.setBackground(Color.DARK_GRAY);
		scroll.setFont(new Font("Arial", Font.PLAIN, 15));
		search.setForeground(Color.GRAY);
		search.setBackground(Color.DARK_GRAY);
		search.setFont(new Font("Arial", Font.PLAIN, 20));
		searcht.setForeground(Color.GRAY);
		searcht.setBackground(Color.DARK_GRAY);
		searcht.setFont(new Font("Arial", Font.PLAIN, 20));

		name.setBounds(175, 50, 220, 50);
		face1.setBounds(755, 50, 220, 50);
		face2.setBounds(1335, 50, 220, 50);
		namet.setBounds(400, 50, 200, 50);
		face1t.setBounds(980, 50, 200, 50);
		face2t.setBounds(1560, 50, 200, 50);
		confirm.setBounds(560, 970, 400, 50);
		save.setBounds(1060, 970, 400, 50);
		scroll.setBounds(0, 150, 1920, 750);
		search.setBounds(10, 900, 290, 50);
		searcht.setBounds(300, 902, 1620, 50);

		this.add(name);
		this.add(namet);
		this.add(face1);
		this.add(face1t);
		this.add(face2);
		this.add(face2t);
		this.add(confirm);
		this.add(scroll);
		this.add(search);
		this.add(save);
		this.add(searcht);

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				addToTable(table, confirm, namet, face1t, face2t, model);

			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String file = "C:\\Flashcards\\Saves\\" + namet.getText() + ".xls";
				export(table, new File(file));

			}
		});

		searcht.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = searcht.getText();
				if (str.trim().length() == 0) {
					sort.setRowFilter(null);
				} else {
					sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String str = searcht.getText();
				if (str.trim().length() == 0) {
					sort.setRowFilter(null);
				} else {
					sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		this.setVisible(true);
	}

	public void addToTable(JTable table, JButton confirm, JTextField namet, JTextField face1t, JTextField face2t,
			DefaultTableModel model) {

		String nameStr = namet.getText();
		String face1Str = face1t.getText();
		String face2Str = face2t.getText();
		int number = table.getRowCount();
		int lines = 0;

		if (number == 0) {
			lines = 1;
		} else {
			lines = number + 1;
		}

		if (nameStr.length() == 0) {
			JFrame error = new JFrame();
			error.setTitle("Erreur");
			error.setResizable(false);
			error.setBackground(Color.DARK_GRAY);
			error.setLayout(new GridLayout());
			error.setSize(400, 200);
			JLabel err = new JLabel("Veuillez entrer un mot dans le champs : Nom de la collection.",
					SwingConstants.CENTER);
			err.setForeground(Color.GRAY);
			error.add(err);
			error.setVisible(true);
		} else {

			Object[] row = { lines, nameStr, face1Str, face2Str, 0, 0 };

			model.addRow(row);

			face1t.setText("");
			face2t.setText("");

		}
	}

	public void export(JTable table, File file) {
		try {
			TableModel m = table.getModel();
			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < m.getColumnCount(); i++) {
				fw.write(m.getColumnName(i) + "\t");
			}
			fw.write("\n");
			for (int i = 0; i < m.getRowCount(); i++) {
				for (int j = 0; j < m.getColumnCount(); j++) {
					fw.write(m.getValueAt(i, j).toString() + "\t");
				}
				fw.write("\n");
			}
			fw.close();

			JFrame error = new JFrame();
			error.setTitle("Succès");
			error.setResizable(false);
			error.setBackground(Color.DARK_GRAY);
			error.setLayout(new GridLayout());
			error.setSize(300, 200);
			JLabel err = new JLabel("La collection a été créée avec succès !", SwingConstants.CENTER);
			err.setForeground(Color.GRAY);
			error.add(err);
			error.setVisible(true);
		} catch (IOException e) {

			JFrame error = new JFrame();
			error.setTitle("Erreur");
			error.setResizable(false);
			error.setBackground(Color.DARK_GRAY);
			error.setLayout(new GridLayout());
			error.setSize(300, 200);
			JLabel err = new JLabel("La collection n'a pas pu être créée. Erreur :" + e, SwingConstants.CENTER);
			err.setForeground(Color.GRAY);
			error.add(err);
			error.setVisible(true);

		}
	}

}
