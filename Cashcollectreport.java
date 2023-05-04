import java.sql.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.table.*;
public class Cashcollectreport extends JFrame implements ActionListener,MouseListener //,ItemListener
{
		
		Connection con;
		Statement st;		
		ResultSet res;
		
		String tselected;
		
		JLabel Bground=new JLabel(new ImageIcon("pic.png"));
	    JLabel searchby=new JLabel("Search By:");	
        ButtonGroup G1=new ButtonGroup();
        JRadioButton rb1=new JRadioButton("Date");
        JRadioButton rb2=new JRadioButton("Patient No.");
		JRadioButton rb3=new JRadioButton("Blood Type");
		JTextField input=new JTextField();
		JButton brefresh= new JButton("Refresh");
		
		JLabel l1=new JLabel("Cash Collection Details"); 
		JLabel l2=new JLabel("Bill No.:");
		JLabel l3=new JLabel("Date:");
		JLabel l4=new JLabel("Reffered By:");
		JLabel l5=new JLabel("Patient No:");
		JLabel l6=new JLabel("Blood Type:");
		JLabel l7=new JLabel("Amount:");		
		JLabel l8=new JLabel("Status :");		
		
		JTextField bino=new JTextField();
		JTextField bidate=new JTextField();
		JTextField bireferred=new JTextField();
		JTextField pno=new JTextField();
		JTextField bitype=new JTextField();
		JTextField biamount=new JTextField();
		JTextField bistatus=new JTextField();

		JTable table=new JTable();;
		DefaultTableModel model=new DefaultTableModel(new String[]{"Bill No.","Date","Reffered By","Patient No.","Blood Type","Amount","Status"},0);
		JFrame frame=new JFrame();
		JScrollPane scrollpane;
		
		
		Cashcollectreport()
		{					
			setVisible(true);
			setLayout(null);
			setSize(2000,2000);
			setLocation(0,0);
			l1.setFont(new Font("Comic Sans MS",Font.BOLD,40));
			setBackground(new Color(100,100,100));
			setTitle("Cash Report");
			searchby.setBounds(50,200,100,25);	
			rb1.setBounds(150,200,100,25);
			rb2.setBounds(150,240,100,25);
			rb3.setBounds(150,280,100,25);
			input.setBounds(50,330,200,25);
			brefresh.setBounds(110,375,100,25);
			
            l1.setBounds(450,20,500,50);								
			l2.setBounds(500,100,100,25);
			l3.setBounds(500,140,100,25);
			l4.setBounds(500,180,100,25);
			l5.setBounds(500,220,100,25);
			l6.setBounds(500,260,100,25);
			l7.setBounds(500,300,100,25);
			l8.setBounds(500,340,100,25);
		
			bino.setBounds(620,100,100,25);
			bidate.setBounds(620,140,100,25);
			bireferred.setBounds(620,180,100,25);
			pno.setBounds(620,220,100,25);
			bitype.setBounds(620,260,100,25);
			biamount.setBounds(620,300,100,25);
			bistatus.setBounds(620,340,100,25);
			Bground.setBounds(0,0,1350,770);
		
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(l5);
			add(l6);
			add(l7);
			add(l8);
			
				add(bino);
				add(bidate);
				add(bireferred);
				add(pno);
				add(bitype);
				add(biamount);
				add(bistatus);
				 G1.add(rb1);
				 G1.add(rb2);
				 G1.add(rb3 );
				 add(rb1);
				 add(rb2);
				 add(rb3);
				 add(searchby);
				 add(input);
				 add(brefresh);
				 add(Bground);
				 
			
			/*l1.setForeground(new Color(200,100,150));  
			*/
			rb1.setBackground(new Color(255,242,229));
			rb2.setBackground(new Color(255,242,229));
			rb3.setBackground(new Color(255,242,229));
			
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
			 rb1.addActionListener(this);
			 rb2.addActionListener(this);
			 rb3.addActionListener(this);

		}
	
	public void actionPerformed(ActionEvent e)
	{
	     if(e.getSource()==brefresh)		 
			 displaytablefun();
		 
		 if(e.getSource()==rb1)
			 tselected="bidate";

		 if(e.getSource()==rb2)
			 tselected="pno";

		 if(e.getSource()==rb3)
			 tselected="bitype";
	}
	
	
	   public void displaytablefun()
	{
		try
		{
			model.setRowCount(0);
			String str= input.getText();
		if(tselected.equals("bitype") || tselected.equals("bidate"))
			res=st.executeQuery("Select * from billtbl where "+tselected+"='"+str+"'");
		else
			res=st.executeQuery("Select * from billtbl where "+tselected+"="+str);
			
			if(res.next())
			{
				do		
				{						
					model.addRow(new Object[]{res.getString("bino"),res.getString("bidate"),res.getString("bireferred"),res.getInt("pno"),res.getString("bitype"),res.getString("biamount"),res.getString("bistatus")});
					
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
		try
		{
			String bill=(model.getValueAt(row,0).toString());
			  //int bino=Integer.parseInt(s);
		      ResultSet res=st.executeQuery("select * from billtbl where bino='"+bill+"'");
			while(res.next())
		        {
				   bino.setText(res.getString("bino"));
				   bidate.setText(res.getString("bidate"));
				   bireferred.setText(res.getString("bireferred"));
		           pno.setText(String.valueOf(res.getInt("pno")));
				   bitype.setText(res.getString("bitype"));
				   biamount.setText(res.getString("biamount"));
				   bistatus.setText(res.getString("bistatus"));
				
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
		new Cashcollectreport();
		}
}		
