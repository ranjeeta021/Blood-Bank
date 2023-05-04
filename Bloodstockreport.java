import java.sql.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.table.*;
public class Bloodstockreport extends JFrame implements ActionListener,MouseListener
{

		
		
	 Connection con;
	 Statement st;
	 ResultSet res;
	 String tselected="";
		
	 JLabel Bground=new JLabel(new ImageIcon("pic.png"));
	 JLabel searchby=new JLabel("Search By:");
	 JRadioButton bgroup=new JRadioButton("Group");
     //JRadioButton bdate=new JRadioButton("Date");
	 JRadioButton bstatus=new JRadioButton("Status");
	 ButtonGroup G1=new ButtonGroup();
	 JTextField input=new JTextField();
	 JLabel lbltotal=new JLabel("Total Units:");
	 JTextField txttotal=new JTextField();
	 JButton brefresh= new JButton("Refresh");
		
	 JLabel l1=new JLabel("Blood Stock Details"); 
	 //JLabel lblbdate=new JLabel("Date:"); 
	 JLabel lblbno=new JLabel("Blood Unit No.:");
	 JLabel lblbgroup=new JLabel("Blood Group:");
	 JLabel lblbstatus=new JLabel("Status:");
	   
     //JTextField txtbdate=new JTextField();
     JTextField txtbgroup=new JTextField();
     JTextField txtbstatus=new JTextField();
     JTextField txtbno=new JTextField();

   
	 JTable table=new JTable();
	 DefaultTableModel model=new DefaultTableModel(new String[]{"Blood Unit No.","Blood Group","Status"},0);
	 JFrame frame=new JFrame();
	 JScrollPane scrollpane;
		
		
	
	 Bloodstockreport()
	 {
	
	
	
		 //Setting Form Properties
		 l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		 setVisible(true);
		 setLayout(null);
		 setSize(2000,2000);
		 setLocation(0,0);
		 setTitle("Report");
		
		

		 searchby.setBounds(50,200,100,25);	
		 bgroup.setBounds(150,200,100,25);
	     //bdate.setBounds(150,240,100,25);
		 bstatus.setBounds(150,240,100,25);
		 input.setBounds(50,280,200,25);
		 brefresh.setBounds(110,330,100,25);
				
				
				
		 l1.setBounds(550,100,400,35);			
		 lblbno.setBounds(500,150,100,25);		
		 //lblbdate.setBounds(500,200,100,25);
		 lblbgroup.setBounds(500,200,100,25);
		 lblbstatus.setBounds(500,250,100,25);
		 
		 txtbno.setBounds(620,150,150,25);
		 //txtbdate.setBounds(620,200,150,25);
		 txtbgroup.setBounds(620,200,150,25);
		 txtbstatus.setBounds(620,250,150,25);
		 
		 lbltotal.setBounds(600,670,150,25);
		 txttotal.setBounds(750,670,150,25);
		 Bground.setBounds(0,0,1350,770);
		 
		 G1.add(bgroup);
	    //G1.add(bdate);
		 G1.add(bstatus );
		 add(bgroup);
		// add(bdate);
		 add(bstatus);
		 add(searchby);
		 add(input);
		 add(brefresh);
		 add(txttotal);
		 add(lbltotal);
		 
		 
		 add(l1);
		 add(lblbno);
		 //add(lblbdate);
		 add(lblbgroup);
		 add(lblbstatus);
		 
		 
		 add(txtbno);
		 //add(txtbdate);
		 add(txtbgroup);
		 add(txtbstatus);
		 add(Bground);
		 setBackground(new Color(100,100,100));
		bgroup.setBackground(new Color(255,242,229));
		//bdate.setBackground(new Color(255,242,229));
		bstatus.setBackground(new Color(255,242,229));
 
		
		
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
		 scrollpane.setBounds(100,450,1200,200);	
		
		 brefresh.addActionListener(this);
		 table.addMouseListener(this);
		 bgroup.addActionListener(this);
		 // bdate.addActionListener(this);
		 bstatus.addActionListener(this);

	}
	
	
	public void actionPerformed(ActionEvent e)
	{
	     if(e.getSource()==brefresh)		 
			 displaytablefun();
		 
		 if(e.getSource()==bgroup)
			 tselected="bgroup";

		 //if(e.getSource()==bdate)
			 //tselected="bddate";

		 if(e.getSource()==bstatus)
			 tselected="bstatus";
	}

    public void displaytablefun()
	{
		try
		{
			model.setRowCount(0);
			int ctr=0,ctr1=0;
			String str= input.getText();				
			res=st.executeQuery("Select * from bloodtbl where "+tselected+"='"+str+"'");
			if(res.next())
			{
				do		
				{	
					String s=res.getString("bstatus");
					model.addRow(new Object[]{res.getString("bno"),res.getString("bgroup"),s});
					if(s.equals("INP"))
					{
						ctr++;
					}
					else
						ctr1++;
				}while(res.next());					
				table.setModel(model);
				if(tselected.equals("bgroup")||str.equals("INP"))
					txttotal.setText(ctr+"");
				else
					txttotal.setText(ctr1+"");
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
		txtbno.setText(model.getValueAt(row,0).toString());
		txtbgroup.setText(model.getValueAt(row,1).toString());
		txtbstatus.setText(model.getValueAt(row,2).toString());
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
		new Bloodstockreport();
		}
}