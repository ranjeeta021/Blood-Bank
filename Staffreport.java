import java.sql.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.table.*;
public class Staffreport extends JFrame implements ActionListener,MouseListener
{

    Connection con;
		Statement st;
		ResultSet res;
		
		String tselected;
		
		JLabel Bground=new JLabel(new ImageIcon("pic.png"));
		JLabel searchby=new JLabel("Search By:");
		JRadioButton b1=new JRadioButton("Name");
		JRadioButton b2=new JRadioButton("Location");
		JRadioButton b3=new JRadioButton("Date of joining");
		ButtonGroup G1=new ButtonGroup();
		JTextField input=new JTextField();
		JButton brefresh= new JButton("Refresh");
		
		JLabel l1=new JLabel("Staff  Details"); 
		JLabel lblseno=new JLabel("Employee no. :"); 
		JLabel lblsdoj=new JLabel("Date of joining :"); 
        JLabel lblsname=new JLabel("Name:"); 
	    JLabel lblsadd=new JLabel("Address:"); 
	    JLabel lblsgender=new JLabel("Gender.:");
	    JLabel lblsquali=new JLabel("Qualification:");
	    JLabel lblscontact=new JLabel("Contact:");
	    JLabel lblsdesig=new JLabel("Designaton:");
	    JLabel lblsemail=new JLabel("E-mail:");
	   
	   JTextField txtseno=new JTextField();
	   JTextField txtsdoj=new JTextField();
	   JTextField txtsname=new JTextField();
	   JTextField txtsadd=new JTextField();
	   JTextField txtsgender=new JTextField();
	   JTextField txtsquali=new JTextField();
	   JTextField txtscontact=new JTextField();
	   JTextField txtsdesig=new JTextField();
	   JTextField txtsemail=new JTextField();
	   
	   JTable table=new JTable();;
	DefaultTableModel model=new DefaultTableModel(new String[]{"Date of joining","Name","Employee No.","Gender","Location","Contact"},0);
	JFrame frame=new JFrame();
	JScrollPane scrollpane;
	
	Staffreport()
	{
	
	
	
		//Setting Form Properties
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setForeground(new Color(200,150,100));
		setVisible(true);
		setLayout(null);
		setSize(2000,2000);
		setLocation(0,0);
		setTitle("Report");
		
		
		//Adding Objects To Form
		
		/*add(delete);
		//add(clear);
		add(exit);
		add(search);
		add(refresh);
		//add(frame);
		add(combo);*/
		//Setting Positions & Size Of Objects
	
	
	 searchby.setBounds(50,200,100,25);	
	b1.setBounds(150,200,100,25);
	b2.setBounds(150,240,100,25);
	b3.setBounds(150,280,150,25);
	input.setBounds(50,330,200,25);
	brefresh.setBounds(110,375,100,25);
	
	 l1.setBounds(600,25,200,35);			
	 lblseno.setBounds(500,100,100,25);		
	 lblsdoj.setBounds(500,140,100,25);
	 lblsname.setBounds(500,180,100,25);
	 lblsadd.setBounds(500,220,100,25);
     lblsgender.setBounds(500,260,100,25);
     lblsquali.setBounds(500,300,100,25);
     lblscontact.setBounds(500,340,100,25);
     lblsdesig.setBounds(500,380,100,25);
     lblsemail.setBounds(820,100,100,25);
			
	 txtseno.setBounds(620,100,150,25);
	 txtsdoj.setBounds(620,140,150,25);
	 txtsname.setBounds(620,180,150,25);
	 txtsadd.setBounds(620,220,150,25);
     txtsgender.setBounds(620,260,150,25);
     txtsquali.setBounds(620,300,150,25);
     txtscontact.setBounds(620,340,150,25);
     txtsdesig.setBounds(620,380,150,25);
     txtsemail.setBounds(940,100,150,25);
	 Bground.setBounds(0,0,1350,770);
     
	 G1.add(b1);
	 G1.add(b2);
	 G1.add(b3 );
	 add(b1);
	 add(b2);
	 add(b3);
	 add(searchby);
	 add(input);
	 add(brefresh);
	 
	 add(l1);
	 add(lblseno);
     add(lblsdoj);
     add(lblsname);
     add(lblsadd);
     add(lblsgender);
     add(lblsquali);
     add(lblscontact);
     add(lblsdesig);
     add(lblsemail);
    
	 add(txtseno);
     add(txtsdoj);
     add(txtsname);
     add(txtsadd);
     add(txtsgender);
     add(txtsquali);
     add(txtscontact);
     add(txtsdesig);
     add(txtsemail);
	 add(Bground);
	 
	 
	 setBackground(new Color(100,100,100));
			b1.setBackground(new Color(255,242,229));
			b2.setBackground(new Color(255,242,229));
			b3.setBackground(new Color(255,242,229));
	 
			
			
			try
			{
				
				con=DriverManager.getConnection("jdbc:odbc:blooddsn");
				st=con.createStatement();
				
			}
			catch(Exception e)
			{
			}
		
			
			table.setModel(model);
			scrollpane=new JScrollPane(table);
			add(scrollpane);
			scrollpane.setBounds(100,450,1200,250);	
			
			 brefresh.addActionListener(this);
			 table.addMouseListener(this);
			 b1.addActionListener(this);
			 b2.addActionListener(this);
			 b3.addActionListener(this);

		}
     
	 public void actionPerformed(ActionEvent e)
	{
	     if(e.getSource()==brefresh)		 
			 displaytablefun();
		 
		 if(e.getSource()==b1)
			 tselected="sname";

		 if(e.getSource()==b2)
			 tselected="sadd";

		 if(e.getSource()==b3)
			 tselected="sdoj";
	}

    public void displaytablefun()
	{
		try
		{
			model.setRowCount(0);
			String str= input.getText();
				
			res=st.executeQuery("Select * from stafftbl where "+tselected+"='"+str+"'");
			
			if(res.next())
			{
				do		
				{						
	       model.addRow(new Object[]{res.getString("sdoj"),res.getString("sname"),res.getInt("seno"),res.getString("sgender"),res.getString("sadd"),res.getString("scontact")});
					
				}while(res.next());
					
				table.setModel(model);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No Such Record!");
			}
				
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
    public void mouseClicked(MouseEvent m)
	{
		int row=table.getSelectedRow();
		try{
		String s=(model.getValueAt(row,2).toString());
		int seno=Integer.parseInt(s);
		res=st.executeQuery("Select * from stafftbl where seno="+seno);
		while(res.next())
		{
		   txtseno.setText(String.valueOf(res.getInt("seno")));
		   txtsdoj.setText(res.getString("sdoj"));
		   txtsname.setText(res.getString("sname"));
		   txtsadd.setText(res.getString("sadd"));
		   txtsgender.setText(res.getString("sgender"));
		   txtsquali.setText(res.getString("squali"));
		   txtscontact.setText(res.getString("scontact"));
		   txtsdesig.setText(res.getString("sdesig"));
		   txtsemail.setText(res.getString("semail"));
		   
		   }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	public void mouseExited(MouseEvent e)
		{
		}
		
		public void mouseEntered(MouseEvent e)
		{
		}
		
		public void mouseReleased(MouseEvent e)
		{
		}
		
		public void mousePressed(MouseEvent e)
		{
		}
		

		
		public static void main(String args[])
		{
		new Staffreport();
		}
}		
