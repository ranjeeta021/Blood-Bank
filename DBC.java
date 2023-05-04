import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class DBC extends JFrame implements ActionListener
{
	Date dd=new Date();
	JLabel Bground=new JLabel(new ImageIcon("pic.png"));
   JButton bclear=new JButton("Clear");
   JButton bedit=new JButton("Edit");
   JButton bsearch=new JButton("Search");
   JButton bsave=new JButton("Save");
   JButton bcancel=new JButton("Cancel");
   JButton brefresh=new JButton("Refresh");
   JButton bnewcamp=new JButton("New Camp?");
   
   JLabel lbldbc=new JLabel("Donation By Camp"); 
   JLabel lblcid=new JLabel("Camp ID:"); 
   JLabel lbldbcname=new JLabel("Group Name:"); 
   JLabel lbldbcorg=new JLabel("Parent Org.:");
   JLabel lbldbcadd=new JLabel("Address:"); 
   JLabel lbldbcdate=new JLabel("Date:"); 
   JLabel s1=new JLabel("/"); 
   JLabel s2=new JLabel("/"); 
   JLabel lbldbcunit=new JLabel("Units:");
   JLabel lbldbctech=new JLabel("Technical Support"); 
   
   JTextField txtcid=new JTextField();
   JTextField txtdbcname=new JTextField();
   JTextField txtdbcorg=new JTextField();
   JTextField txtdbcadd=new JTextField();
   JTextField d=new JTextField();
   JTextField m=new JTextField();
   JTextField y=new JTextField();
   JTextField txtdbcunit=new JTextField(); 
   JTextField txtdbctech=new JTextField();
   
   public static void main(String argv[])throws IOException
   {
     DBC ob=new DBC();
   }

   public DBC()
   {
     setLayout(null);
     setSize(2000,2000);
     lbldbc.setFont(new Font("Times New Roman",Font.BOLD,30));
     lbldbc.setBackground(new Color(200,150,100));  
	 s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     s2.setFont(new Font("Times New Roman",Font.BOLD,25));

     setVisible(true);

	 lbldbc.setBounds(400,30,400,50);
	 lblcid.setBounds(300,150,100,25);
	 lbldbcname.setBounds(300,200,100,25);
	 lbldbcorg.setBounds(300,250,100,25);
	 lbldbcadd.setBounds(700,200,100,25);
	 lbldbcdate.setBounds(300,350,100,25);
	 lbldbcunit.setBounds(300,400,100,25);
	 lbldbctech.setBounds(300,450,100,25);
	 
	 txtcid.setBounds(425,150,250,25);
	 txtdbcname.setBounds(425,200,250,25);
	 txtdbcorg.setBounds(425,250,250,25);
	 txtdbcadd.setBounds(825,200,250,75);
     d.setBounds(425,350,25,25);
     s1.setBounds(455,350,25,25);
     m.setBounds(475,350,25,25);
     s2.setBounds(505,350,25,25);
     y.setBounds(525,350,50,25);
	 txtdbcunit.setBounds(425,400,100,25);
	 txtdbctech.setBounds(425,450,250,50);

	 bsave.setBounds(300,550,100,40);
	 bedit.setBounds(420,550,100,40);
	 bsearch.setBounds(540,550,100,40);
	 bclear.setBounds(660,550,100,40);
     bcancel.setBounds(780,550,100,40);
     brefresh.setBounds(700,150,100,25);
	 bnewcamp.setBounds(820,150,100,25);
	 Bground.setBounds(0,0,1350,770);


	 add(bclear);
     add(bedit);
     add(bsearch);
     add(bsave);
     add(bcancel);
     add(brefresh);
	 add(bnewcamp);
	 
     add(lbldbc);
	 add(lblcid);
	 add(lbldbcname);
	 add(lbldbcorg);
	 add(lbldbcadd);
	 add(lbldbcdate);
	 add(lbldbcunit);
	 add(lbldbctech);
	 
	 add(txtcid);
	 add(txtdbcname);
	 add(txtdbcorg);
	 add(txtdbcadd);
	 add(d);
	 add(s1);
	 add(m);
	 add(s2);
     add(y);
	 add(txtdbcunit);
	 add(txtdbctech);
	 
	 add(Bground);
	 
	 bclear.addActionListener(this);
     bedit.addActionListener(this);
     bsave.addActionListener(this);
     bsearch.addActionListener(this);
     bcancel.addActionListener(this);
     brefresh.addActionListener(this);
	 bnewcamp.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e)
   {
     if(e.getSource()==bclear)
	 {
	     try
		 {
/*			 Connection con;
		     con=DriverManager.getConnection("jdbc:odbc:blooddsn");
			 Statement st=con.createStatement();
			 ResultSet res=st.executeQuery("select * from dbctbl");
			 while(res.next())
			 {
			 }*/
			 
			 /*txtcid.setText("");
			 DateFormat f1= new SimpleDateFormat("dd");
			 d.setText(f1.format(dd));
			 DateFormat f2= new SimpleDateFormat("MM");
			 m.setText(f2.format(dd));
			 DateFormat f3= new SimpleDateFormat("yyyy");
			 y.setText(f3.format(dd));*/ 
			 
			 d.setText("");
			 m.setText("");
			 y.setText("");
			 txtdbcunit.setText("");
			 txtdbctech.setText("");
			 txtcid.setText("");
			 txtdbcname.setText("");
			 txtdbcorg.setText("");
			 txtdbcadd.setText("");
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
		  flg=check_Date(dd,mm,yy);

		 Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		 Statement st=con.createStatement();
		 ResultSet res=st.executeQuery("select * from dbctbl");
		 String str="insert into dbctbl(cid,dbcdate,dbcunit,dbctech) values(?,?,?,?)";
		 PreparedStatement ps=con.prepareStatement(str);
		 ps.setString(1,txtcid.getText());
		 ps.setString(3,txtdbcunit.getText());
		 ps.setString(4,txtdbctech.getText());
		   String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
		  ps.setString(2,tdate);	  
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
		 catch(Exception eee)
		 {
		 }
	 }
	 if(e.getSource()==bsearch)
	{
		 	try
	  {
		int flag=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from dbctbl where cid='"+txtcid.getText()+"'");
		while(res.next())
		{
		   txtcid.setText(res.getString("cid"));
		   String date=res.getString("ddate");
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
		   txtdbcunit.setText(res.getString("dbcunit"));
		   txtdbctech.setText(res.getString("dbctech"));
		   flag=1;
		}
		if(flag==0)
		JOptionPane.showMessageDialog(null,"No such Data");
	  }
 	   catch(Exception eeee)
	   {
	   }

	}
    if(e.getSource()==bedit)
     {
         try
         {
			  int dd,mm,yy,flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  flg=check_Date(dd,mm,yy);

	  String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
             Connection con;
			 con=DriverManager.getConnection("jdbc:odbc:blooddsn");
			 Statement st=con.createStatement();
			 String str="update dbctbl set cid='"+txtcid.getText()+"',dbcdate='"+tdate+"',dbcunit='"+txtdbcunit.getText()+"',dbctech='"+txtdbctech.getText()+"'where cid='"+txtcid.getText()+"'";
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
     if(e.getSource()==bcancel)
     {
        
       this.dispose();     
	 }	
	if(e.getSource()==brefresh)
	{
		try
		{
			 Connection con;
			 con=DriverManager.getConnection("jdbc:odbc:blooddsn");
			 Statement st=con.createStatement();
			 ResultSet res=st.executeQuery("select * from camptbl where cid='"+txtcid.getText()+"'");
			while(res.next())
			 {
			txtdbcname.setText(res.getString("cgroup"));
			txtdbcorg.setText(res.getString("corg"));
			txtdbcadd.setText(res.getString("cadd"));
			 } 
		}
		catch(Exception ee)
		{
			
		}
	}
	if(e.getSource()==bnewcamp)
	{
		new Camp();
	}
   }

   public static int check_Date(int dd, int mm, int yy)
	{
		int flg=0;
		try
		{
/*??ERROR-->*/	  DateFormat f1= new SimpleDateFormat("dd");
	  int d1=Integer.parseInt(f1.format(dd));
	  DateFormat f2= new SimpleDateFormat("MM");
	  int m1=Integer.parseInt(f2.format(dd));
		System.out.println("Day:"+dd+"\nPresent day:"+(f1.format(dd))+"\nPresent day:"+d1+"\nMonth:"+mm+"\nPresent month:"+m1);
	  
	  if((yy>=2016) && (mm>=m1) && (dd>=d1))
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
	 // return(flg);
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	return(flg);
	}
}