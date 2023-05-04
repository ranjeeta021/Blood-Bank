import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Camp extends JFrame implements ActionListener
{
	Date dd=new Date();
	JButton bnew=new JButton("New");
	JButton bclear=new JButton("Clear");
	JButton bdelete=new JButton("Delete");
	JButton bedit=new JButton("Edit");
	JButton bsearch=new JButton("Search");
	JButton bsave=new JButton("Save");
	JButton bcancel=new JButton("Cancel");
	JLabel lblccamp=new JLabel("Collection Camp");
	JLabel lblcdate=new JLabel("Date:"); 
	JLabel s1=new JLabel("/"); 
    JLabel s2=new JLabel("/"); 

	JLabel lblcid=new JLabel("Camp ID:"); 
	JLabel lblcorg=new JLabel("Parent Org.:");
	JLabel lblcadd=new JLabel("Address:");
	JLabel lblcgroup=new JLabel("Group Name");
	JLabel lblccontact=new JLabel("Contact:");
	JLabel lblcperson1=new JLabel("Person 1:");
	JLabel lblcphone1=new JLabel("Phone No.1:");
	JLabel lblcperson2=new JLabel("Person 2:");
	JLabel lblcphone2=new JLabel("Phone No.2:");
	JLabel lblcperson3=new JLabel("Person 3:"); 					   
	JLabel lblcphone3=new JLabel("Phone No.3:"); 
    JTextField d=new JTextField();
    JTextField m=new JTextField();
    JTextField y=new JTextField();
	JTextField txtcid=new JTextField();
	JTextField txtcorg=new JTextField();
	JTextField txtcadd=new JTextField();
	JTextField txtcgroup=new JTextField();
	JTextField txtcperson1=new JTextField();
	JTextField txtcphone1=new JTextField();
	JTextField txtcperson2=new JTextField();
	JTextField txtcphone2=new JTextField();
	JTextField txtcperson3=new JTextField();
	JTextField txtcphone3=new JTextField();
    JLabel Bground=new JLabel(new ImageIcon("pic.png"));

   
	 public static void main(String argv[])throws IOException
	{
		Camp ob=new Camp();
	}

	public Camp()
    {
		setLayout(null);
		setSize(2000,2000);
		lblccamp.setFont(new Font("Times New Roman",Font.BOLD,30));
		lblccamp.setBackground(new Color(200,150,100));  
		 s1.setFont(new Font("Times New Roman",Font.BOLD,25));
		 s2.setFont(new Font("Times New Roman",Font.BOLD,25));
		setVisible(true);
		bnew.setBounds(300,550,100,40);
		bedit.setBounds(420,550,100,40);
		bsearch.setBounds(540,550,100,40);
		bsave.setBounds(660,550,100,40);
		bdelete.setBounds(900,550,100,40);
		bclear.setBounds(1040,550,100,40);
		bcancel.setBounds(780,550,100,40);
		lblccamp.setBounds(550,30,300,50);
		lblcdate.setBounds(660,150,100,25);
		lblcid.setBounds(300,200,100,25);
		lblcorg.setBounds(660,200,100,25);
		lblcadd.setBounds(300,250,100,25);
		lblcgroup.setBounds(660,250,100,25);
		lblccontact.setBounds(300,300,100,25);
		lblcperson1.setBounds(300,350,100,25);
		lblcphone1.setBounds(660,350,100,25);
		lblcperson2.setBounds(300,400,100,25);
		lblcphone2.setBounds(660,400,100,25);
		lblcperson3.setBounds(300,450,100,25);
		lblcphone3.setBounds(660,450,100,25);
		d.setBounds(780,150,25,25);
		s1.setBounds(810,150,25,25);
	    m.setBounds(830,150,25,25);
		s2.setBounds(860,150,25,25);
		y.setBounds(880,150,50,25);
		txtcid.setBounds(420,200,100,25);
		txtcorg.setBounds(780,200,100,25);
		txtcadd.setBounds(420,250,100,25);
		txtcgroup.setBounds(780,250,100,25);
		txtcperson1.setBounds(420,350,100,25);
		txtcphone1.setBounds(780,350,100,25);
		txtcperson2.setBounds(420,400,100,25);
		txtcphone2.setBounds(780,400,100,25);
		txtcperson3.setBounds(420,450,100,25);
		txtcphone3.setBounds(780,450,100,25);

        Bground.setBounds(0,0,1350,770);

		add(bnew);
		add(bedit);
		add(bsearch);
		add(bsave);
		add(bclear);
		add(bdelete);
		add(bcancel);
		add(lblccamp);
	 add(d);
	 add(s1);
	 add(m);
	 add(s2);
     add(y);
		add(lblcid);
		add(lblcorg);
		add(lblcadd);
		add(lblcgroup);
		add(lblccontact);
		add(lblcperson1);
		add(lblcphone1);
		add(lblcperson2);
		add(lblcphone2);
		add(lblcperson3);
		add(lblcphone3);


		add(lblcdate);
		add(txtcid);
		add(txtcorg);
		add(txtcadd);
		add(txtcgroup);
		add(txtcperson1);
		add(txtcphone1);
		add(txtcperson2);
		add(txtcphone2);
		add(txtcperson3);
		add(txtcphone3);
		
		add(Bground);

		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bedit.addActionListener(this);
		bdelete.addActionListener(this);
		bclear.addActionListener(this);
		bcancel.addActionListener(this);
		bsearch.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
		   try
		   {
			   int ctr=0;
			 Connection con;
			 con=DriverManager.getConnection("jdbc:odbc:blooddsn");
			 ResultSet  res;
			 Statement st=con.createStatement();
			 res=st.executeQuery("Select * from camptbl");
			 while(res.next())
			 {
				 ctr++;
			 }
			 
			  	 DateFormat f1= new SimpleDateFormat("dd");
				 d.setText(f1.format(dd));
				 DateFormat f2= new SimpleDateFormat("MM");
				 m.setText(f2.format(dd));
				 DateFormat f3= new SimpleDateFormat("yyyy");
				 y.setText(f3.format(dd));
				 DateFormat f4= new SimpleDateFormat("yy");
				 String s=(f4.format(dd))+(ctr+1);				 
				 

			  txtcid.setText(""+s);
			  txtcorg.setText("");
			  txtcadd.setText("");
			  txtcgroup.setText("");
			  txtcperson1.setText("");
			  txtcphone1.setText("");
			  txtcperson2.setText("");
			  txtcphone2.setText("");
			  txtcperson3.setText("");
			  txtcphone3.setText("");


			}
								
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		
		}
		if(e.getSource()==bsave)
		{
		   try
		   {
		  int dd,mm,yy,flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  if(yy<=2016)
	  {
		  if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
		  {
			  if(dd<=31)
			  {
				  flg=1;
			  }
		  }
		  if(mm==4||mm==6||mm==9||mm==11)
		  {
			  if(dd<=30)
			  {
				  flg=1;
			  }
		  }
		  if(mm==2)
		  {
			  if(yy%4==0)
			  {
				  if(dd<=29)
				  {
					  flg=1;
				  }
			  }
			  else
			  {
				  if(dd<=28)
				  {
					  flg=1;
				  }
			  }
		  }
	  }

			  Connection con;
			  con=DriverManager.getConnection("jdbc:odbc:blooddsn");
			  ResultSet  res;
			  Statement st=con.createStatement();
			  res=st.executeQuery("Select * from camptbl");
			  String str="insert into camptbl(cdate,cid,corg,cadd,cgroup,cperson1,cphone1,cperson2,cphone2,cperson3,cphone3)values(?,?,?,?,?,?,?,?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(str);
			  ps.setString(2,txtcid.getText());
			  ps.setString(3,txtcorg.getText());
			  ps.setString(4,txtcadd.getText());
			  ps.setString(5,txtcgroup.getText());	
			  ps.setString(6,txtcperson1.getText());
			  ps.setString(7,txtcphone1.getText());
			  ps.setString(8,txtcperson2.getText());
			  ps.setString(9,txtcphone2.getText());	
			  ps.setString(10,txtcperson3.getText());
			  ps.setString(11,txtcphone3.getText());
      String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	  ps.setString(1,tdate);	  
	  if(flg==1)
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"saved succesfully");
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null,"Invalid Date!");
	  }
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
//----------------------------------------------------------------------------------------------------------------------------------------		
		if(e.getSource()==bsearch)
		{
			try
			{
				int flag=0;
				Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from camptbl where cid='"+txtcid.getText()+"'");
				while(res.next())
				{
					
		   String date=res.getString("cdate");
		   String dd,mm,yy;
		   int i1,i2;
		   i1=date.indexOf('/');
		   i2=date.lastIndexOf('/');
		   dd=date.substring(0,i1);
		   mm=date.substring((i1+1),i2);
		   yy=date.substring((i2+1));
		   d.setText(dd);
		   m.setText(mm);
		   y.setText(yy);		   
				   txtcid.setText(res.getString("cid"));
				   txtcorg.setText(res.getString("corg"));
				   txtcadd.setText(res.getString("cadd"));
				   txtcgroup.setText(res.getString("cgroup"));
				   txtcperson1.setText(res.getString("cperson1"));
				   txtcphone1.setText(res.getString("cphone1"));
				   txtcperson2.setText(res.getString("cperson2"));
				   txtcphone2.setText(res.getString("cphone2"));
				   txtcperson3.setText(res.getString("cperson3"));
				   txtcphone3.setText(res.getString("cphone3"));


				   flag=1;
				}
				if(flag==0)
				JOptionPane.showMessageDialog(null,"No such Data");
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
        }
//_______________________________________________________________________________________________________________

		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
//________________________________________________________________________________________________________________

		if(e.getSource()==bedit)
		{
		 try
		 {
			  int dd,mm,yy,flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  if(yy<=2016)
	  {
		  if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12)
		  {
			  if(dd<=31)
			  {
				  flg=1;
			  }
		  }
		  if(mm==4||mm==6||mm==9||mm==11)
		  {
			  if(dd<=30)
			  {
				  flg=1;
			  }
		  }
		  if(mm==2)
		  {
			  if(yy%4==0)
			  {
				  if(dd<=29)
				  {
					  flg=1;
				  }
			  }
			  else
			  {
				  if(dd<=28)
				  {
					  flg=1;
				  }
			  }
		  }
	  }
	          String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
			  Connection con;
			  con=DriverManager.getConnection("jdbc:odbc:blooddsn");
			  Statement st=con.createStatement();
			  String str="update camptbl set cdate='"+tdate+"',cid='"+txtcid.getText()+"',corg='"+txtcorg.getText()+"',cadd='"+txtcadd.getText()+"',cgroup='"+txtcgroup.getText()+"',cperson1='"+txtcperson1.getText()+"',cphone1='"+txtcphone1.getText()+"',cperson2='"+txtcperson2.getText()+"',cphone2='"+txtcphone2.getText()+"',cperson3='"+txtcperson3.getText()+"',cphone3='"+txtcphone3.getText()+"'where cid='"+txtcid.getText()+"'";
			  PreparedStatement ps=con.prepareStatement(str);
	  if(flg==1)
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"Modified succesfully");
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null,"Invalid Date!");
	  }		 
		  }
		catch(Exception eea)
		{
		}
		}
//_______________________________________________________________________________________________________________
		if(e.getSource()==bclear)
		{
		  d.setText("");
		  m.setText("");
		  y.setText("");
		  txtcid.setText("");
		  txtcorg.setText("");
		  txtcadd.setText("");
		  txtcgroup.setText("");
		  txtcperson1.setText("");
		  txtcphone1.setText("");
		  txtcperson2.setText("");
		  txtcphone2.setText("");
		  txtcperson3.setText("");
		  txtcphone3.setText("");


		}
	
//_______________________________________________________________________________________________________________

		if(e.getSource()==bdelete)
		{
			try
			{
			
				Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
				Statement st=con.createStatement();
				ResultSet res=st.executeQuery("select * from camptbl where cid='"+txtcid.getText()+"'");
				if(res.next())
				{
					String str="delete from camptbl where cid='"+txtcid.getText()+"'";
					PreparedStatement ps=con.prepareStatement(str);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"Deleted Successfully");
				}
				else
					JOptionPane.showMessageDialog(null,"No such Code No.");
			}
			catch(Exception ee)
			{
					
			}

		}
	}
}				