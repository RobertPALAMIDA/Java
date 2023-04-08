package mavenProiect;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JFrame() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 20, 491, 186);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nume", "Prenume", "Cod Matricol"
				}
				));
		scrollPane.setViewportView(table);

		String url = "jdbc:mysql://localhost:3306/proiect";
		Connection connection = DriverManager.getConnection (url, "root", "root");
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("Select * from facultate");
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		while(rs.next())
		{
			String cod_matricol=rs.getString(1);
			String nume=rs.getString(2);
			String prenume=rs.getString(3);
			model.addRow(new Object[] {cod_matricol,nume,prenume});
		}

		final JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField cod_matricol = new JTextField(10);
				JTextField nume = new JTextField(10);
				JTextField prenume = new JTextField(10);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Cod matricol:"));
				myPanel.add(cod_matricol);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Nume:"));
				myPanel.add(nume);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("Prenume:"));
				myPanel.add(prenume);
				int result = JOptionPane.showConfirmDialog(null, myPanel, 
			               "Please Enter Values", JOptionPane.OK_CANCEL_OPTION);
				 if (result == JOptionPane.OK_OPTION) {
			         String cod_matricol_str=cod_matricol.getText();
			         String nume_str=nume.getText();
			         String prenume_str=prenume.getText();
			         model.addRow(new Object[] {cod_matricol_str,nume_str,prenume_str});
			         try {
			        	Connection connection2 = DriverManager.getConnection (url, "root", "root");
						Statement statement2 = connection2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ResultSet rs2=statement2.executeQuery("Select * from facultate");
						rs2.moveToInsertRow();
						rs2.updateString(1, cod_matricol_str);
						rs2.updateString(2, nume_str);
						rs2.updateString(3, prenume_str);
						rs2.insertRow();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
			      }
			}
		});
		btnInsert.setBounds(31, 259, 132, 58);
		contentPane.add(btnInsert);

		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var selectedIndecies=table.getSelectedRows();
				for(int i=selectedIndecies.length-1;i>=0;i--)
				{
					model.removeRow(selectedIndecies[i]);
					Connection connection2;
					try {
						connection2 = DriverManager.getConnection (url, "root", "root");
						Statement statement2 = connection2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ResultSet rs2=statement2.executeQuery("Select * from facultate");
						rs2.absolute(selectedIndecies[i]);
						rs2.deleteRow();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		btnDelete.setBounds(390, 259, 132, 58);
		contentPane.add(btnDelete);



	}
}
