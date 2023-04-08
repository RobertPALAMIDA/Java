package proiectJframe2;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe2 frame = new Jframe2();
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
	public Jframe2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultListModel listModel=new DefaultListModel();
		JList list = new JList(listModel);
		list.setBounds(80, 100, 400, 150);
		contentPane.add(list);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] index=list.getSelectedIndices();
				if (index.length > 0)
					for(int i=index.length-1;i>=0;i--)
					{
						listModel.removeElementAt(index[i]);
					}
			}
		});
		btnDelete.setBounds(186, 293, 185, 33);
		contentPane.add(btnDelete);
		
		txtString = new JTextField();
		txtString.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int k=KeyEvent.VK_ENTER;
				if(e.getKeyCode()==k)
				{
				String string=txtString.getText();
				listModel.addElement(string);	
				}
			}
		});
		txtString.setBounds(144, 24, 248, 33);
		contentPane.add(txtString);
	}
}
