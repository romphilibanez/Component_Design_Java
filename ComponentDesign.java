package UiAct;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ComponentDesign {

	//sets the background and foreground of the components
	public void getComponentColor(JButton add, JButton save, JButton delete, JTable table) {

		Color white = Color.WHITE;

		add.setBackground(new Color(102, 255, 102));
		add.setForeground(white);
		getFontFormat(add, save, delete, table);
		save.setBackground(new Color(51, 153, 255));
		save.setForeground(white);
		delete.setBackground(Color.RED);
		delete.setForeground(white);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(102, 178, 255));
	}

	//Format the texts for buttons and table header
	public void getFontFormat(JButton add, JButton save, JButton delete, JTable table) {

		Font font = new Font("Arial", Font.BOLD, 14);

		add.setFont(font);
		save.setFont(font);
		delete.setFont(font);
		table.getTableHeader().setFont(font);
	}

	//Produces a border for the components
	public void getBorder(JTextField lastNameTB, JTextField firstNameTB, JComboBox<String> genderCB,
			JTextField birthDateTB, JScrollPane scrollpane, JButton add, JButton save, JButton delete) {

		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);

		lastNameTB.setBorder(border);
		firstNameTB.setBorder(border);
		genderCB.setBorder(border);
		birthDateTB.setBorder(border);
		scrollpane.setBorder(border);
		add.setBorder(border);
		save.setBorder(border);
		delete.setBorder(border);
	}

}
