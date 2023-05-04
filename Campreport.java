import java.sql.*;
import java.awt.*;					/*THIS FORM IS NOT COMPLETE*/
import java.io.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.table.*;
public class Campreport extends JFrame implements ActionListener//,MouseListener
{

		
		
		Connection con;
		Statement st;
		
		String tselected;
		

		JLabel Bground=new JLabel(new ImageIcon("pic.png"));
		JLabel searchby=new JLabel("Search By:");
		JTextField txtsdate=new JTextField();
		JTextField txtedate=new JTextField();
		JButton brefresh= new JButton("Refresh");
		
		JLabel l1=new JLabel("Camp Details"); 
		
       JLabel lblsdate=new JLabel("Start Date:");
	   JLabel lbledate=new JLabel("End Date:");
	   
	   
	   
	JTable table=new JTable();;
	DefaultTableModel model=new DefaultTableModel(new String[]{"Date","Camp ID","Name","Address","No. of Units"},0);
	JFrame frame=new JFrame();
	JScrollPane scrollpane;
		
		
	
	Campreport()
	{
	
	
	
		//Setting Form Properties
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		setVisible(true);
		setLayout(null);
		setSize(2000,2000);
		setLocation(0,0);
		setTitle("Report");
		searchby.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		
		//Adding Objects To Form
		//Setting Positions & Size Of Objects
	
	l1.setBounds(670,30,200,35);	
    searchby.setBounds(50,200,100,25);	
	txtsdate.setBounds(150,255,100,25);
	txtedate.setBounds(150,300,100,25);
	lblsdate.setBounds(50,255,100,25);
	lbledate.setBounds(50,300,100,25);
	brefresh.setBounds(110,375,100,25);
	Bground.setBounds(0,0,1350,770);
			
			
			
     
	 
	 add(l1);
	 add(searchby);
	 add(txtsdate);
	 add(txtedate);
	 add(lblsdate);
	 add(lbledate);
	 add(brefresh);
	 add(Bground);
			setBackground(new Color(100,100,100));
			
			
			/*try
			{
				
				con=DriverManager.getConnection("jdbc:odbc:blooddsn");
				st=con.createStatement();
				
			}
			catch(Exception e)
			{
			}*/
		
			
			table.setModel(model);
			scrollpane=new JScrollPane(table);
			add(scrollpane);
			scrollpane.setBounds(100,450,1200,250);	
			
			 brefresh.addActionListener(this);
			 //table.addMouseListener(this);
			 }
	
	
	public void actionPerformed(ActionEvent e)
	{
	     if(e.getSource()==brefresh)
		 {			 
//			 displaytablefun();
			//ResultSet res;	
		try
		{
			model.setRowCount(0);
			 Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		 Statement st=con.createStatement();
			String d1= txtsdate.getText();
			String d2= txtedate.getText();
			
			 ResultSet res=st.executeQuery("SELECT camptbl.corg,camptbl.cadd,dbctbl.cid,dbctbl.dbcdate,dbctbl.dbcunit FROM camptbl INNER JOIN dbctbl ON camptbl.cid = dbctbl.cid WHERE dbctbl.dbcdate>='"+d1+"' and dbctbl.dbcdate<='"+d2+"'");
			//res.beforeFirst();
			if(res.next())
			{
				do		
				{					
				     model.addRow(new Object[]{res.getString(4),res.getString(3),res.getString(1),res.getString(2),res.getString(5)});
				}while(res.next());					
				table.setModel(model);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No Such Record!");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		 }
	}

   /* public void displaytablefun()
	{
		ResultSet res;	
		try
		{
			String d1= txtsdate.getText();
			String d2= txtedate.getText();
			
			res=st.executeQuery("SELECT camptbl.corg,camptbl.cadd,dbctbl.cid,dbctbl.dbcdate,dbctbl.dbcunit FROM camptbl INNER JOIN dbctbl ON camptbl.cid = dbctbl.cid WHERE dbctbl.dbcdate>='"+d1+"' and dbctbl.dbcdate<='"+d2+"'");
			res.first();
			if(res.next())
			{
				do		
				{					
				     model.addRow(new Object[]{res.getString(4),res.getString(3),res.getString(1),res.getString(2),res.getString(5)});
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
		}*/
		
  /*  public void mouseClicked(MouseEvent m)
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
		
*/
		
		public static void main(String args[])
		{
			new Campreport();
		}
}		
