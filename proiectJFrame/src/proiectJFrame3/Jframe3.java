package proiectJFrame3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

public class Jframe3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtFilm;
	private JTextField txtActori;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe3 frame = new Jframe3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jframe3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 792);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(180, 41, 63, 13);
		lblFilm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFilm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblActori = new JLabel("Actori");
		lblActori.setBounds(198, 72, 45, 13);
		lblActori.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActori.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtFilm = new JTextField();
		txtFilm.setBounds(253, 40, 280, 19);
		txtFilm.setColumns(10);
		
		txtActori = new JTextField();
		txtActori.setBounds(253, 71, 280, 19);
		txtActori.setColumns(10);
		
		JLabel lblAn = new JLabel("An lansare");
		lblAn.setBounds(238, 133, 76, 13);
		lblAn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAn.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(2020, 2015, 2020, 1));
		spinner.setBounds(324, 125, 117, 33);
		contentPane.setLayout(null);
		contentPane.add(lblFilm);
		contentPane.add(lblActori);
		contentPane.add(txtFilm);
		contentPane.add(txtActori);
		contentPane.add(lblAn);
		contentPane.add(spinner);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Genuri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(106, 198, 495, 127);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox chckBox1 = new JCheckBox("Comendie");
		chckBox1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckBox1.setBounds(6, 26, 118, 21);
		panel.add(chckBox1);
		
		JCheckBox chckBox2 = new JCheckBox("Drama");
		chckBox2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckBox2.setBounds(155, 26, 93, 21);
		panel.add(chckBox2);
		
		JCheckBox chckBox3 = new JCheckBox("Istoric");
		chckBox3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckBox3.setBounds(270, 26, 93, 21);
		panel.add(chckBox3);
		
		JCheckBox chckBox4 = new JCheckBox("Romantic");
		chckBox4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckBox4.setBounds(379, 26, 110, 21);
		panel.add(chckBox4);
		
		JCheckBox chckBox5 = new JCheckBox("Actiune");
		chckBox5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckBox5.setBounds(193, 68, 93, 21);
		panel.add(chckBox5);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Film", "Actori", "An lansare", "Genuri"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String numeFilm=txtFilm.getText();
				String actori=txtActori.getText();
				int an=(int) spinner.getValue();
				String text="";
				if(chckBox1.isSelected())
				{
					text+=chckBox1.getText()+" ";
				}
				if(chckBox2.isSelected())
				{
					text+=chckBox2.getText()+" ";
				}
				if(chckBox3.isSelected())
				{
					text+=chckBox3.getText()+" ";
				}
				if(chckBox4.isSelected())
				{
					text+=chckBox4.getText()+" ";
				}
				if(chckBox5.isSelected())
				{
					text+=chckBox5.getText()+" ";
				}
				model.addRow(new Object[] {numeFilm,actori,an,text});
			}
		});
		btnAdauga.setBounds(109, 353, 114, 74);
		contentPane.add(btnAdauga);
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selectedIndex=table.getSelectedRows();
				if(selectedIndex.length>0)
					for(int i=selectedIndex.length-1;i>=0;i--)
					{
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.removeRow(selectedIndex[i]);
					}
				
			}
		});
		btnSterge.setBounds(484, 335, 117, 74);
		contentPane.add(btnSterge);
		
		table.setBounds(143, 473, 500, 229);
		table.setFillsViewportHeight(true);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(106, 437, 495, 268);
		contentPane.add(scrollPane);
		setVisible(true);
	}
}
