import java.sql.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.table.*;
public class Donorreport extends JFrame implements ActionListener,MouseListener
{
Connection con;
		Statement st;
		ResultSet res;		
		String tselected;
		JLabel Bground=new JLabel(new ImageIcon("pic.png"));
		JLabel searchby=new JLabel("Search By:");
		JRadioButton b1=new JRadioButton("Name");
		JRadioButton b2=new JRadioButton("Location");
		JRadioButton b3=new JRadioButton("Date");
		ButtonGroup G1=new ButtonGroup();
		JTextField input=new JTextField();
		JButton brefresh= new JButton("Refresh");
		JLabel l1=new JLabel("Donor Details"); 
		JLabel lblddate=new JLabel("Date:"); 
		JLabel lbldfather=new JLabel("Father's Name:"); 
	   JLabel lbldoccupation=new JLabel("Occupation:"); 
	   JLabel lbldno=new JLabel("Donor No.:");
	   JLabel lbldname=new JLabel("Donor Name:");
	   JLabel lblddob=new JLabel("D.O.B:");
	   JLabel lbldgender=new JLabel("Gender:");
	   JLabel lbldadd=new JLabel("Address:");
	   JLabel lbldcity=new JLabel("City:");
	   JLabel lbldstate=new JLabel("State:");
	   JLabel lbldpin=new JLabel("PIN:");
	   JLabel lbldcontact=new JLabel("Contact No.:");
	   JLabel lbldemail=new JLabel("E-mail id:");
       JLabel lbldblood=new JLabel("Blood Group:");
	   JLabel lbldlast=new JLabel("Last Donated");
	   JTextField txtddate=new JTextField();
	   JTextField txtdfather=new JTextField();
	   JTextField txtdoccupation=new JTextField();
	   JTextField txtdno=new JTextField();
	   JTextField txtdname=new JTextField();
	   JTextField txtddob=new JTextField();
	   JTextField txtdgender=new JTextField();
	   JTextField txtdadd=new JTextField();
	   JTextField txtdcity=new JTextField();
	   JTextField txtdstate=new JTextField();
	   JTextField txtdpin=new JTextField();
	   JTextField txtdcontact=new JTextField();
	   JTextField txtdemail=new JTextField();
	   JTextField txtdblood=new JTextField();
	   JTextField txtdlast=new JTextField();
	JTable table=new JTable();;
	DefaultTableModel model=new DefaultTableModel(new String[]{"Date","Name","Donor No.","Gender","Blood Group","Location","Contact"},0);
	JFrame frame=new JFrame();
	JScrollPane scrollpane;
	Donorreport()
	{
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		setVisible(true);
		setLayout(null);
		setSize(2000,2000);
		setLocation(0,0);
		setTitle("Report");
	 searchby.setBounds(50,200,100,25);	
	b1.setBounds(150,200,100,25);
	b2.setBounds(150,240,100,25);
	b3.setBounds(150,280,100,25);
	input.setBounds(50,330,200,25);
	brefresh.setBounds(110,375,100,25);
    l1.setBounds(670,50,200,35);			
	 lbldno.setBounds(500,100,100,25);		
	 lblddate.setBounds(500,140,100,25);
	 lbldname.setBounds(500,180,100,25);
	 lbldoccupation.setBounds(500,220,100,25);
     lbldfather.setBounds(500,260,100,25);
     lblddob.setBounds(500,300,100,25);
     lbldgender.setBounds(500,340,100,25);
     lbldadd.setBounds(500,380,100,25);
     lbldcity.setBounds(820,140,100,25);
     lbldstate.setBounds(820,180,100,25);
     lbldpin.setBounds(820,220,100,25);
     lbldcontact.setBounds(820,260,100,25);
     lbldemail.setBounds(820,300,100,25);
     lbldblood.setBounds(820,340,100,25);
	 lbldlast.setBounds(820,380,100,25);
	  txtdno.setBounds(620,100,150,25);
	 txtddate.setBounds(620,140,150,25);
	 txtdname.setBounds(620,180,150,25);
	 txtdoccupation.setBounds(620,220,150,25);
     txtdfather.setBounds(620,260,150,25);
     txtddob.setBounds(620,300,150,25);
     txtdgender.setBounds(620,340,150,25);
     txtdadd.setBounds(620,380,150,25);
     txtdcity.setBounds(940,140,150,25);
     txtdstate.setBounds(940,180,150,25);
     txtdpin.setBounds(940,220,150,25);
     txtdcontact.setBounds(940,260,150,25);
     txtdemail.setBounds(940,300,150,25);
     txtdblood.setBounds(940,340,150,25);
	 txtdlast.setBounds(940,380,150,25);
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
	 add(lbldno);
     add(lblddate);
     add(lbldname);
     add(lblddob);
     add(lbldgender);
     add(lbldadd);
     add(lbldcity);
     add(lbldstate);
     add(lbldfather);
     add(lbldoccupation);
     add(lbldpin);
     add(lbldcontact);
     add(lbldemail);
     add(lbldblood);
	 add(lbldblood);
	 add(lbldlast);
     add(txtdno);
     add(txtddate);
     add(txtdname);
     add(txtddob);
     add(txtdgender);
     add(txtdadd);
     add(txtdcity);
     add(txtdstate);
     add(txtdfather);
     add(txtdoccupation);
     add(txtdpin);
     add(txtdcontact);
     add(txtdemail);
     add(txtdblood);
	 add(txtdlast);	
	 add(Bground);
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
			scrollpane.setBackground(new Color(255,242,229));
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
			 tselected="dname";
		 if(e.getSource()==b2)
			 tselected="dadd";
		 if(e.getSource()==b3)
			 tselected="ddate";
	}
    public void displaytablefun()
	{
		try
		{
			model.setRowCount(0);
			String str= input.getText();
			res=st.executeQuery("Select * from donortbl where "+tselected+"='"+str+"'");
			if(res.next())
			{
				do		
				{						
					model.addRow(new Object[]{res.getString("ddate"),res.getString("dname"),res.getInt("dno"),res.getString("dgender"),res.getString("dblood"),res.getString("dadd"),res.getString("dcontact")});
				}
				while(res.next());
					
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
		int dno=Integer.parseInt(s);
		res=st.executeQuery("Select * from donortbl where dno="+dno);
		while(res.next())
		{		
		   txtdno.setText(String.valueOf(res.getInt("dno")));
		   txtdname.setText(res.getString("dname"));
		   txtddob.setText(res.getString("ddob"));
		   txtdadd.setText(res.getString("dadd"));
		   txtdfather.setText(res.getString("dfather"));
		   txtdoccupation.setText(res.getString("doccupation"));
		   txtdcity.setText(res.getString("dcity"));
		   txtdstate.setText(res.getString("dstate"));
		   txtdpin.setText(res.getString("dpin"));
		   txtdcontact.setText(res.getString("dcontact"));
		   txtdemail.setText(res.getString("demail"));
		   txtdblood.setText(res.getString("dblood"));
		   txtdgender.setText(res.getString("dgender"));
		   txtdlast.setText(res.getString("dlast"));
		   txtddate.setText(res.getString("ddate"));
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
		new Donorreport();
		}
}		
