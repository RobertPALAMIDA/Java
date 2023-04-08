package proiectJFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtOp1;
	private JTextField txtOp2;
	private JTextField txtRezultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe frame = new Jframe();
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
	public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 295);
		getContentPane().setLayout(null);
		
		JLabel lblOp1 = new JLabel("Operand 1");
		lblOp1.setBounds(30, 38, 61, 13);
		getContentPane().add(lblOp1);
		
		JLabel lblOp2 = new JLabel("Operand 2");
		lblOp2.setBounds(30, 61, 61, 13);
		getContentPane().add(lblOp2);
		
		txtOp1 = new JTextField();
		txtOp1.setBounds(101, 35, 165, 19);
		getContentPane().add(txtOp1);
		txtOp1.setColumns(10);
		
		txtOp2 = new JTextField();
		txtOp2.setBounds(101, 58, 165, 19);
		getContentPane().add(txtOp2);
		txtOp2.setColumns(10);
		
		JButton btnAdunare = new JButton("Adunare");
		btnAdunare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float op1=Float.parseFloat(txtOp1.getText());
				float op2=Float.parseFloat(txtOp2.getText());
				float rezultat=op1+op2;
				
				txtRezultat.setText(String.valueOf(rezultat));
			}
		});
		btnAdunare.setBounds(75, 84, 85, 37);
		getContentPane().add(btnAdunare);
		
		JButton btnScadere = new JButton("Scadere");
		btnScadere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float op1=Float.parseFloat(txtOp1.getText());
				float op2=Float.parseFloat(txtOp2.getText());
				float rezultat=op1-op2;
				
				txtRezultat.setText(String.valueOf(rezultat));
			}
		});
		btnScadere.setBounds(181, 87, 85, 34);
		getContentPane().add(btnScadere);
		
		JButton btnInmultire = new JButton("Inmultire");
		btnInmultire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float op1=Float.parseFloat(txtOp1.getText());
				float op2=Float.parseFloat(txtOp2.getText());
				float rezultat=op1*op2;
				
				txtRezultat.setText(String.valueOf(rezultat));
			}
		});
		btnInmultire.setBounds(75, 131, 85, 38);
		getContentPane().add(btnInmultire);
		
		JButton btnImpartire = new JButton("Impartire");
		btnImpartire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float op1=Float.parseFloat(txtOp1.getText());
				float op2=Float.parseFloat(txtOp2.getText());
				float rezultat=op1/op2;
				
				txtRezultat.setText(String.valueOf(rezultat));
			}
		});
		btnImpartire.setBounds(181, 131, 85, 38);
		getContentPane().add(btnImpartire);
		
		txtRezultat = new JTextField();
		txtRezultat.setColumns(10);
		txtRezultat.setBounds(101, 179, 153, 19);
		getContentPane().add(txtRezultat);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRezultat.setText("");
			}
		});
		btnClear.setBounds(124, 208, 96, 30);
		getContentPane().add(btnClear);
	}
}
