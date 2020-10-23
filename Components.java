package UiAct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Components extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton add, save, delete;
	JTextField lastNameTB, firstNameTB, birthDateTB;
	JLabel lastName, firstName, gender, birthDate;
	JComboBox<String> genderCB;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane scrollPane;
	String[] columnNames = { "ID", "Lastname", "Firstname", "Gender", "Birthdate" };
	String[] genders = { "Male", "Female" };
	Object[] data;
	int idNum = 0;

	//For initializing the components
	public Components() {
		
		lastName = new JLabel("Lastname:");
		lastNameTB = new JTextField();
		firstName = new JLabel("Firstname:");
		firstNameTB = new JTextField();
		gender = new JLabel("Gender:");
		genderCB = new JComboBox<String>(genders);
		birthDate = new JLabel("Birthdate:");
		birthDateTB = new JTextField();
		add = new JButton("Add New");
		save = new JButton("Save");
		delete = new JButton("Delete");
		dtm = new DefaultTableModel(columnNames, 0);
		table = new JTable(dtm);
		scrollPane = new JScrollPane(table);

		defaultState();
	}

	//Defines the behavior after a particular event 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String lastName = lastNameTB.getText();
		String firstName = firstNameTB.getText();
		String gender = (String) this.genderCB.getSelectedItem();
		String birthDate = birthDateTB.getText();

		if (arg0.getSource() == add) {

			lastNameTB.setEnabled(true);
			firstNameTB.setEnabled(true);
			genderCB.setEnabled(true);
			birthDateTB.setEnabled(true);
			add.setEnabled(false);
			save.setEnabled(true);

		} else if (arg0.getSource() == save) {

			idNum += 1;
			data = new Object[] { idNum, lastName, firstName, gender, birthDate };
			dtm = (DefaultTableModel) table.getModel();
			dtm.addRow(data);
			lastNameTB.setText("");
			firstNameTB.setText("");
			birthDateTB.setText("");
			lastNameTB.setEnabled(false);
			firstNameTB.setEnabled(false);
			genderCB.setEnabled(false);
			birthDateTB.setEnabled(false);
			save.setEnabled(false);
			add.setEnabled(true);
		} else if (arg0.getSource() == delete) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(table.getSelectedRow());
			delete.setEnabled(false);
		}
	}

	//Adds components into JFrame
	public void addComponents() {
		
		add(lastName).setBounds(10, 50, 60, 20);
		add(lastNameTB).setBounds(75, 50, 100, 20);
		add(firstName).setBounds(10, 80, 60, 20);
		add(firstNameTB).setBounds(75, 80, 100, 20);
		add(gender).setBounds(10, 110, 60, 20);
		add(genderCB).setBounds(75, 110, 100, 20);
		add(birthDate).setBounds(10, 140, 60, 20);
		add(birthDateTB).setBounds(75, 140, 100, 20);
		add(add).setBounds(10, 180, 100, 30);
		add(save).setBounds(120, 180, 100, 30);
		add(delete).setBounds(230, 180, 100, 30);
		add(scrollPane).setBounds(10, 220, 600, 150);
	}

	//Sets the default state of the components
	public void defaultState() {
		
		ComponentDesign cdObj = new ComponentDesign();

		addComponents();
		cdObj.getComponentColor(add, save, delete, table);
		cdObj.getBorder(lastNameTB, firstNameTB, genderCB, birthDateTB, scrollPane, add, save, delete);
		enableDelete();

		add.addActionListener(this);
		save.addActionListener(this);
		delete.addActionListener(this);

		lastNameTB.setEnabled(false);
		firstNameTB.setEnabled(false);
		genderCB.setEnabled(false);
		birthDateTB.setEnabled(false);
		save.setEnabled(false);
		delete.setEnabled(false);

		setTitle("Swing Activity");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setResizable(false);
		setVisible(true);
	}

	//enables the delete button
	public void enableDelete() {
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (table.getSelectedRow() > -1) {
					delete.setEnabled(true);
				}
			}
		});
	}

}
