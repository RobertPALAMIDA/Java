package jFrame;

import java.awt.EventQueue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNume;
	private JTextField txtVarsta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					frame.setTitle("Tabelul MySQL - persoane");
				} catch (Exception e) {
					e.printStackTrace();
				}	 
			}
		});	
	}

	int Id=1;
	int stare=0;
	private JTextField txtAfis;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnSave;
	private JButton btnClear;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnSearch;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Frame() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 448);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(184, 122, 319, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtNume = new JTextField();
		txtNume.setColumns(10);
		txtNume.setBounds(184, 151, 319, 19);
		contentPane.add(txtNume);

		txtVarsta = new JTextField();
		txtVarsta.setColumns(10);
		txtVarsta.setBounds(184, 180, 319, 19);
		contentPane.add(txtVarsta);

		JLabel lbl_Id = new JLabel("Id\r\n");
		lbl_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Id.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Id.setBounds(129, 125, 45, 13);
		contentPane.add(lbl_Id);

		JLabel lbl_Nume = new JLabel("Nume");
		lbl_Nume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Nume.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Nume.setBounds(129, 154, 45, 13);
		contentPane.add(lbl_Nume);

		JLabel lbl_Varsta = new JLabel("Varsta");
		lbl_Varsta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Varsta.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Varsta.setBounds(129, 184, 45, 13);
		contentPane.add(lbl_Varsta);

		String url = "jdbc:mysql://localhost:3306/proiect";
		Connection connection= DriverManager.getConnection(url, "root", "root");
		String sql="select Id,count(*) as numar_total from persoane";

		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		String str="";
		if(rs.next())
		{
			str=String.valueOf(rs.getInt("Id"))+" / "+String.valueOf(rs.getInt("numar_total"));
		}

		String sql2="select Id,Nume,Varsta from persoane where Id=?";
		PreparedStatement ps=connection.prepareStatement(sql2);
		ps.setInt(1, Id);
		ResultSet rs2=ps.executeQuery();
		String nume="";
		String varsta="";
		if(rs2.next())
		{
			nume=rs2.getString("Nume");
			varsta=String.valueOf(rs2.getInt("Varsta"));
		}
		txtId.setText(String.valueOf(Id));
		txtNume.setText(nume);
		txtVarsta.setText(varsta);

		JToolBar toolBar = new JToolBar();
		txtAfis=new JTextField();
		btnFirst=new JButton();
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/proiect";
				try {
					Connection connection= DriverManager.getConnection(url, "root", "root");
					String sql="select min(Id) as minim from persoane";
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					if(rs.next())
					{
						Id=rs.getInt("minim");
					}
					PreparedStatement pst=connection.prepareStatement("select Id,Nume,Varsta from persoane where Id=?");
					pst.setInt(1, Id);
					rs=pst.executeQuery();
					if(rs.next())
					{
						String nume=rs.getString("Nume");
						String varsta=String.valueOf(rs.getInt("Varsta"));
						txtId.setText(String.valueOf(Id));
						txtNume.setText(nume);
						txtVarsta.setText(varsta);

						String sql2="Select count(*) as numar_total from persoane";
						Statement statement2 = connection.createStatement();
						ResultSet rs2 = statement2.executeQuery(sql2);
						int nr_total=0;

						if(rs2.next())
						{
							nr_total=rs2.getInt("numar_total");
						}

						String str=String.valueOf(rs.getInt("Id"))+" / "+String.valueOf(nr_total);
						txtAfis.setText(str);
					}

					String sql3="Select min(Id) as numar_minim from persoane";
					Statement statement3 = connection.createStatement();

					ResultSet rs3 = statement3.executeQuery(sql3);
					int nr_min=0;

					if(rs3.next())
					{
						nr_min=rs3.getInt("numar_minim");
					}

					String sql4="Select max(Id) as numar_maxim from persoane";
					Statement statement4 = connection.createStatement();
					ResultSet rs4 = statement4.executeQuery(sql4);
					int nr_max=0;

					if(rs4.next())
					{
						nr_max=rs4.getInt("numar_maxim");
					}

					if(Id==nr_min)
					{
						btnPrevious.setEnabled(false);
						btnFirst.setEnabled(false);
					}

					if(Id!=nr_max)
					{
						btnNext.setEnabled(true);
						btnLast.setEnabled(true);
					}	
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnPrevious=new JButton();
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/proiect";
					Connection connection= DriverManager.getConnection(url, "root", "root");
					PreparedStatement pst=connection.prepareStatement("select Id,Nume,Varsta from persoane where Id=?");
					pst.setInt(1, --Id);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						String nume=rs.getString("Nume");
						String varsta=String.valueOf(rs.getInt("Varsta"));
						txtId.setText(String.valueOf(Id));
						txtNume.setText(nume);
						txtVarsta.setText(varsta);

						String sql="Select count(*) as numar_total from persoane";
						Statement statement = connection.createStatement();

						ResultSet rs1 = statement.executeQuery(sql);
						int nr_total=0;

						if(rs1.next())
						{
							nr_total=rs1.getInt("numar_total");
						}

						String str=String.valueOf(rs.getInt("Id"))+" / "+String.valueOf(nr_total);
						txtAfis.setText(str);
					}	

					String sql3="Select min(Id) as numar_minim from persoane";
					Statement statement3 = connection.createStatement();

					ResultSet rs3 = statement3.executeQuery(sql3);
					int nr_min=0;

					if(rs3.next())
					{
						nr_min=rs3.getInt("numar_minim");
					}

					String sql4="Select max(Id) as numar_maxim from persoane";
					Statement statement4 = connection.createStatement();
					ResultSet rs4 = statement4.executeQuery(sql4);
					int nr_max=0;

					if(rs4.next())
					{
						nr_max=rs4.getInt("numar_maxim");
					}

					if(Id==nr_min)
					{
						btnPrevious.setEnabled(false);
						btnFirst.setEnabled(false);
					}

					if(Id!=nr_max)
					{
						btnNext.setEnabled(true);
						btnLast.setEnabled(true);
					}

					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		btnNext=new JButton();
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					String url = "jdbc:mysql://localhost:3306/proiect";
					Connection connection= DriverManager.getConnection(url, "root", "root");
					PreparedStatement pst=connection.prepareStatement("select Id,Nume,Varsta from persoane where Id=?");
					pst.setInt(1, ++Id);
					ResultSet rs1=pst.executeQuery();
					if(rs1.next())
					{
						String nume=rs1.getString("Nume");
						String varsta=String.valueOf(rs1.getInt("Varsta"));
						txtId.setText(String.valueOf(Id));
						txtNume.setText(nume);
						txtVarsta.setText(varsta);

						String sql="Select count(*) as numar_total from persoane";
						Statement statement = connection.createStatement();
						ResultSet rs = statement.executeQuery(sql);
						int nr_total=0;

						if(rs.next())
						{
							nr_total=rs.getInt("numar_total");
						}

						String str=String.valueOf(rs1.getInt("Id"))+" / "+String.valueOf(nr_total);
						txtAfis.setText(str);


						String sql3="Select min(Id) as numar_minim from persoane";
						Statement statement3 = connection.createStatement();

						ResultSet rs3 = statement3.executeQuery(sql3);
						int nr_min=0;

						if(rs3.next())
						{
							nr_min=rs3.getInt("numar_minim");
						}

						String sql4="Select max(Id) as numar_maxim from persoane";
						Statement statement4 = connection.createStatement();
						ResultSet rs4 = statement4.executeQuery(sql4);
						int nr_max=0;

						if(rs4.next())
						{
							nr_max=rs4.getInt("numar_maxim");
						}

						if(Id!=nr_min)
						{
							btnPrevious.setEnabled(true);
							btnFirst.setEnabled(true);
						}

						if(Id==nr_max)
						{
							btnNext.setEnabled(false);
							btnLast.setEnabled(false);
						}

						connection.close();	
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnLast=new JButton();
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/proiect";
				try {
					Connection connection= DriverManager.getConnection(url, "root", "root");
					String sql="select max(Id) as maxim from persoane";
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(sql);

					if(rs.next())
					{
						Id=rs.getInt("maxim");
					}
					PreparedStatement pst=connection.prepareStatement("select Id,Nume,Varsta from persoane where Id=?");
					pst.setInt(1, Id);
					rs=pst.executeQuery();
					if(rs.next())
					{
						String nume=rs.getString("Nume");
						String varsta=String.valueOf(rs.getInt("Varsta"));
						txtId.setText(String.valueOf(Id));
						txtNume.setText(nume);
						txtVarsta.setText(varsta);

						String sql2="Select count(*) as numar_total from persoane";
						Statement statement2 = connection.createStatement();
						ResultSet rs2 = statement2.executeQuery(sql2);
						int nr_total=0;

						if(rs2.next())
						{
							nr_total=rs2.getInt("numar_total");
						}

						String str=String.valueOf(rs.getInt("Id"))+" / "+String.valueOf(nr_total);
						txtAfis.setText(str);
					}

					String sql3="Select min(Id) as numar_minim from persoane";
					Statement statement3 = connection.createStatement();

					ResultSet rs3 = statement3.executeQuery(sql3);
					int nr_min=0;

					if(rs3.next())
					{
						nr_min=rs3.getInt("numar_minim");
					}

					String sql4="Select max(Id) as numar_maxim from persoane";
					Statement statement4 = connection.createStatement();
					ResultSet rs4 = statement4.executeQuery(sql4);
					int nr_max=0;

					if(rs4.next())
					{
						nr_max=rs4.getInt("numar_maxim");
					}

					if(Id!=nr_min)
					{
						btnPrevious.setEnabled(true);
						btnFirst.setEnabled(true);
					}

					if(Id==nr_max)
					{
						btnNext.setEnabled(false);
						btnLast.setEnabled(false);
					}

					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd=new JButton();
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stare=2;
				txtNume.setText("");
				txtVarsta.setText("");
				String url = "jdbc:mysql://localhost:3306/proiect";
				try {
					Connection connection= DriverManager.getConnection(url, "root", "root");
					String sql="Select count(*) as numar_total from persoane";
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(sql);
					int id=0;
					if(rs.next())
					{
						id=rs.getInt("numar_total");
					}
					txtId.setText(String.valueOf(++id));
					txtAfis.setText(String.valueOf(id) + " / "+String.valueOf(id));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnFirst.setEnabled(false);
				btnPrevious.setEnabled(false);
				btnNext.setEnabled(false);
				btnLast.setEnabled(false);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnSearch.setEnabled(false);
				txtNume.setEditable(true);
				txtVarsta.setEditable(true);
				btnSave.setEnabled(true);
				btnClear.setEnabled(true);
			}
		});
		btnEdit=new JButton();
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stare=1;
				txtNume.setEditable(true);
				txtVarsta.setEditable(true);

				btnFirst.setEnabled(false);
				btnPrevious.setEnabled(false);
				btnNext.setEnabled(false);
				btnLast.setEnabled(false);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnSearch.setEnabled(false);

				btnSave.setEnabled(true);
				btnClear.setEnabled(true);
			}
		});

		btnDelete=new JButton();
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Yes","No"};
				JFrame frame=new JFrame();
				int n = JOptionPane.showOptionDialog(frame,
						"Sunteti sigur ca vreti sa stergeti persoana curenta?",
						"Confirmare stergere",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,     //do not use a custom Icon
						options,  //the titles of buttons
						options[0]);
				int id=Integer.valueOf(txtId.getText());
				String url = "jdbc:mysql://localhost:3306/proiect";
				try {
					if(n==0)
					{
						Connection connection= DriverManager.getConnection(url, "root", "root");
						CallableStatement cs=connection.prepareCall("{call stergere(?)}");
						cs.setInt(1, id);
						cs.execute();
						cs.close();

						List<Persoana>listaPersoane=new ArrayList<Persoana>();
						String sql2="Select Nume,Varsta from persoane";
						Statement statement2 = connection.createStatement();
						ResultSet rs2 = statement2.executeQuery(sql2);

						int index=0;
						String nume="";
						int varsta=0;

						while(rs2.next())
						{
							index++;
							nume=rs2.getString("Nume");
							varsta=rs2.getInt("varsta");
							Persoana p=new Persoana(index,nume,varsta);
							listaPersoane.add(p);
						}
						statement2.executeUpdate("Drop table persoane");
						String sql = "CREATE TABLE persoane" +
								"(id INTEGER not NULL, " +
								" nume VARCHAR(45), " + 
								" varsta INTEGER, " + 
								" PRIMARY KEY ( id ))"; 
						statement2.executeUpdate(sql);

						for(Persoana p : listaPersoane)
						{
							CallableStatement cs1=connection.prepareCall("{call adaugare(?,?,?)}");
							cs1.setInt(1, p.getIndex());
							cs1.setString(2, p.getNume());
							cs1.setInt(3,p.getVarsta());
							cs1.execute();
							cs1.close();
						}

						String sql3="select count(*) as numar_total from persoane";

						Statement statement = connection.createStatement();
						ResultSet rs = statement.executeQuery(sql3);
						String str="";
						if(rs.next())
						{
							str=String.valueOf("1"+" / "+String.valueOf(rs.getInt("numar_total")));
							txtAfis.setText(str);
						}

						String sql4="select Id,Nume,Varsta from persoane where Id=?";
						PreparedStatement ps=connection.prepareStatement(sql4);
						ps.setInt(1, 1);
						ResultSet rs4=ps.executeQuery();
						String nume4="";
						String varsta4="";
						if(rs4.next())
						{
							nume4=rs4.getString("Nume");
							varsta4=String.valueOf(rs4.getInt("Varsta"));
						}
						txtId.setText("1");
						txtNume.setText(nume4);
						txtVarsta.setText(varsta4);
						
						btnNext.setEnabled(true);
						btnLast.setEnabled(true);
						btnFirst.setEnabled(false);
						btnPrevious.setEnabled(false);
						Id=1;
						
						connection.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} 
		});
		btnSearch=new JButton();
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = JOptionPane.showInputDialog("Numele: ");
				String url = "jdbc:mysql://localhost:3306/proiect";
				int varsta;
				int id;
				Connection connection;
				try {
					connection = DriverManager.getConnection(url, "root", "root");
					String sql="Select Id,Varsta from persoane where Nume=?";
					PreparedStatement ps=connection.prepareStatement(sql);
					ps.setString(1, m);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						varsta=rs.getInt("Varsta");
						id=rs.getInt("Id");
						txtId.setText(String.valueOf(id));
						txtNume.setText(m);
						txtVarsta.setText(String.valueOf(varsta));

						String sql2="Select count(*) as numar_total from persoane";
						Statement statement2 = connection.createStatement();
						ResultSet rs2 = statement2.executeQuery(sql2);
						int nr_total=0;

						if(rs2.next())
						{
							nr_total=rs2.getInt("numar_total");
						}

						String str=String.valueOf(rs.getInt("Id"))+" / "+String.valueOf(nr_total);
						txtAfis.setText(str);

						String sql3="Select min(Id) as numar_minim from persoane";
						Statement statement3 = connection.createStatement();

						ResultSet rs3 = statement3.executeQuery(sql3);
						int nr_min=0;

						if(rs3.next())
						{
							nr_min=rs3.getInt("numar_minim");
						}

						String sql4="Select max(Id) as numar_maxim from persoane";
						Statement statement4 = connection.createStatement();
						ResultSet rs4 = statement4.executeQuery(sql4);
						int nr_max=0;

						if(rs4.next())
						{
							nr_max=rs4.getInt("numar_maxim");
						}

						if(id == nr_min)
						{
							btnPrevious.setEnabled(false);
							btnFirst.setEnabled(false);
						}

						if(id == nr_max)
						{
							btnNext.setEnabled(false);
							btnLast.setEnabled(false);
						}

						if(id != nr_min)
						{
							btnPrevious.setEnabled(true);
							btnFirst.setEnabled(true);
						}

						if(id != nr_max)
						{
							btnNext.setEnabled(true);
							btnLast.setEnabled(true);
						}
						Id=id;
					}
					else
					{
						JFrame frame=new JFrame();
						JOptionPane.showMessageDialog(frame,"Persoana cautata nu se afla in baza de date");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSave=new JButton();
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.valueOf(txtId.getText());
				String nume=txtNume.getText();
				int varsta=Integer.valueOf(txtVarsta.getText());
				String url = "jdbc:mysql://localhost:3306/proiect";
				if(stare==1)
				{
					try {
						Connection connection= DriverManager.getConnection(url, "root", "root");
						String sql="update persoane set nume=?,varsta=? where id=?";
						PreparedStatement ps=connection.prepareStatement(sql);
						ps.setString(1, nume);
						ps.setInt(2, varsta);
						ps.setInt(3, id);
						ps.executeUpdate();

						String sql3="Select min(Id) as numar_minim from persoane";
						Statement statement3 = connection.createStatement();

						ResultSet rs3 = statement3.executeQuery(sql3);
						int nr_min=0;

						if(rs3.next())
						{
							nr_min=rs3.getInt("numar_minim");
						}

						String sql4="Select max(Id) as numar_maxim from persoane";
						Statement statement4 = connection.createStatement();
						ResultSet rs4 = statement4.executeQuery(sql4);
						int nr_max=0;

						if(rs3.next())
						{
							nr_max=rs4.getInt("numar_maxim");
						}

						if(Id==nr_min)
						{
							btnPrevious.setEnabled(false);
							btnFirst.setEnabled(false);
						}

						if(Id!=nr_min)
						{
							btnPrevious.setEnabled(true);
							btnFirst.setEnabled(true);
						}

						if(Id==nr_max)
						{
							btnNext.setEnabled(false);
							btnLast.setEnabled(false);
						}

						if(Id!=nr_max)
						{
							btnNext.setEnabled(true);
							btnLast.setEnabled(true);
						}
						btnAdd.setEnabled(true);
						btnEdit.setEnabled(true);
						btnDelete.setEnabled(true);
						btnSearch.setEnabled(true);
						txtNume.setEditable(false);
						txtVarsta.setEditable(false);
						btnSave.setEnabled(false);
						btnClear.setEnabled(false);
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(stare==2)
				{
					try {
						Connection connection= DriverManager.getConnection(url, "root", "root");
						CallableStatement cs=connection.prepareCall("{call adaugare(?,?,?)}");
						cs.setInt(1, id);
						cs.setString(2, nume);
						cs.setInt(3,varsta);
						cs.execute();
						cs.close();
						connection.close();	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					btnFirst.setEnabled(true);
					btnPrevious.setEnabled(true);
					btnNext.setEnabled(false);
					btnLast.setEnabled(false);
					btnAdd.setEnabled(true);
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
					btnSearch.setEnabled(true);
					txtNume.setEditable(false);
					txtVarsta.setEditable(false);
					btnSave.setEnabled(false);
					btnClear.setEnabled(false);
				}
			}
		});
		btnClear=new JButton();
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/proiect";
				try {
					Connection connection= DriverManager.getConnection(url, "root", "root");
					String sql="Select Nume,Varsta from persoane where Id=?";
					PreparedStatement ps=connection.prepareStatement(sql);
					ps.setInt(1, Id);
					ResultSet rs=ps.executeQuery();
					String nume="";
					String varsta="";
					int nr_total=0;
					if(rs.next())
					{
						nume=rs.getString("Nume");
						varsta=String.valueOf(rs.getInt("Varsta"));

						String sql2="Select count(*) as numar_total from persoane";
						Statement statement2 = connection.createStatement();
						ResultSet rs2 = statement2.executeQuery(sql2);

						if(rs2.next())
						{
							nr_total=rs2.getInt("numar_total");
						}
					}
					txtId.setText(String.valueOf(Id));
					txtNume.setText(nume);
					txtVarsta.setText(varsta);
					txtAfis.setText(String.valueOf(Id)+" / "+String.valueOf(nr_total));

					String sql3="Select min(Id) as numar_minim from persoane";
					Statement statement3 = connection.createStatement();

					ResultSet rs3 = statement3.executeQuery(sql3);
					int nr_min=0;

					if(rs3.next())
					{
						nr_min=rs3.getInt("numar_minim");
					}

					String sql4="Select max(Id) as numar_maxim from persoane";
					Statement statement4 = connection.createStatement();
					ResultSet rs4 = statement4.executeQuery(sql4);
					int nr_max=0;

					if(rs3.next())
					{
						nr_max=rs4.getInt("numar_maxim");
					}

					if(Id!=nr_min)
					{
						btnPrevious.setEnabled(true);
						btnFirst.setEnabled(true);
					}

					if(Id!=nr_max)
					{
						btnNext.setEnabled(true);
						btnLast.setEnabled(true);
					}

					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnSearch.setEnabled(true);
				txtNume.setEditable(false);
				txtVarsta.setEditable(false);

				btnSave.setEnabled(false);
				btnClear.setEnabled(false);
			}
		});

		btnFirst.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\MoveFirst.png"));
		btnPrevious.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\MovePrevious.png"));
		btnNext.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\MoveNext.png"));
		btnLast.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\MoveLast.png"));
		btnAdd.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\Add.png"));
		btnEdit.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\Edit.png"));
		btnDelete.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\Delete.png"));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\Search.png"));
		btnSave.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\Save.png"));
		btnClear.setIcon(new ImageIcon("C:\\Users\\palam\\OneDrive\\Desktop\\Aplicatii Facultate\\An 3 sem 1\\PJ\\Proiecte\\JDBC_Maven\\src\\main\\resources\\Reset.png"));

		toolBar.setBounds(44, 0, 560, 40);



		toolBar.add(btnFirst);
		toolBar.add(btnPrevious);
		toolBar.add(txtAfis);
		toolBar.add(btnNext);
		toolBar.add(btnLast);
		toolBar.add(btnAdd);
		toolBar.add(btnEdit);
		toolBar.add(btnDelete);
		toolBar.add(btnSearch);
		toolBar.add(btnSave);
		toolBar.add(btnClear);
		contentPane.add(toolBar);
		txtAfis.setText(str);

		String sql3="Select min(Id) as numar_minim from persoane";
		Statement statement3 = connection.createStatement();

		ResultSet rs3 = statement3.executeQuery(sql3);
		int nr_min=0;

		if(rs3.next())
		{
			nr_min=rs3.getInt("numar_minim");
		}

		String sql4="Select max(Id) as numar_maxim from persoane";
		Statement statement4 = connection.createStatement();
		ResultSet rs4 = statement4.executeQuery(sql4);
		int nr_max=0;

		if(rs4.next())
		{
			nr_max=rs4.getInt("numar_maxim");
		}

		if(Id==nr_min)
		{
			btnPrevious.setEnabled(false);
			btnFirst.setEnabled(false);
		}

		if(Id==nr_max)
		{
			btnNext.setEnabled(false);
			btnLast.setEnabled(false);
		}

		btnSave.setEnabled(false);
		btnClear.setEnabled(false);

		txtNume.setEditable(false);
		txtVarsta.setEditable(false);

		connection.close();
		statement.close();
		rs.close();
	}
}
