//import mypack.xyz;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Blood extends JFrame implements ActionListener
{  
   char ch1='A',ch2='A';
   int c=0;
   JButton bnew=new JButton("New");
   JButton bdelete=new JButton("Delete");
   JButton bedit=new JButton("Edit");
   JButton bsearch=new JButton("Search");
   JButton bsave=new JButton("Save");
   JButton bclear=new JButton("Clear");
   JButton bcancel=new JButton("Cancel");
   JLabel lblblood=new JLabel("Blood"); 
   JLabel lblbno=new JLabel("Blood No."); 
   JLabel lblbgroup=new JLabel("Blood Group:"); 
   JLabel lblbunit=new JLabel("No of units:");
   JTextField txtbgroup=new JTextField();
   JTextField txtbno=new JTextField();
   JTextField txtbunit=new JTextField();
   JLabel Bground=new JLabel(new ImageIcon("pic.png"));
   public static void main(String argv[])throws IOException
{
     Blood ob=new Blood();
}

   public Blood()
   {
     setLayout(null);
     setSize(2000,2000);
     lblblood.setFont(new Font("Times New Roman",Font.BOLD,30));
     lblblood.setBackground(new Color(200,150,100));  
     setVisible(true);
     bnew.setBounds(250,450,100,40);
	 bdelete.setBounds(370,450,100,40);
     bedit.setBounds(490,450,100,40);
     bsearch.setBounds(610,450,100,40);
     bsave.setBounds(730,450,100,40);
     bcancel.setBounds(850,450,100,40);
     bclear.setBounds(970,450,100,40);
     lblblood.setBounds(550,30,100,50);
     lblbno.setBounds(300,150,100,25);
     lblbgroup.setBounds(300,200,100,25);
     lblbunit.setBounds(300,250,100,25);
     txtbno.setBounds(425,150,150,25);
     txtbgroup.setBounds(425,200,50,25);
     txtbunit.setBounds(425,250,150,25);
	 
	 Bground.setBounds(0,0,1350,770);
	 
     add(bnew);
	 add(bdelete);
     add(bedit);
     add(bsearch);
     add(bsave);
     add(bcancel);
     add(bclear);
     add(lblblood);
	 add(lblbno);
     add(lblbgroup);
     add(lblbunit);
	 add(txtbno);
     add(txtbgroup);
     add(txtbunit);
	 
	 add(Bground);
	 
     bnew.addActionListener(this);
     bdelete.addActionListener(this);
     bedit.addActionListener(this);
     bsave.addActionListener(this);
     bsearch.addActionListener(this);
     bcancel.addActionListener(this);
     bclear.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bnew)
{
   try
   {
	     String sc="";
      Connection con;
     con=DriverManager.getConnection("jdbc:odbc:blooddsn");
     ResultSet  res;
     Statement st=con.createStatement();
     res=st.executeQuery("Select * from bloodtbl");
	 while(res.next())
			 {
				 sc=res.getString("bno");
				 ch1=sc.charAt(0);
				 ch2=sc.charAt(1);
				 c=Integer.parseInt(sc.substring(2));
			 }

			 c++;
			 if(c>9999)
			 {
				 if(ch1<'Z')
				 {
					 ch2++;
					 c=1;
				 }
				 else
				 {
					 ch1++;
					 ch2='A';
					 c=1;
				 }
			 }
			 if(c<10)
			 {
				 sc="000"+c;
			 }
			 else if(c>=10 && c<100)
			 {
				 sc="00"+c;
			 }
			 else if(c>=100 && c<1000)
				 sc="0"+c;
			 else
				 sc=c+"";
			 String str=ch1+""+ch2+""+sc;
     txtbgroup.setText("");
	 txtbno.setText(str);
	 txtbunit.setText("1");
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
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      ResultSet  res;
      Statement st=con.createStatement();
      res=st.executeQuery("Select * from bloodtbl");
      String str="insert into bloodtbl(bno,bgroup,bunit,bstatus)values(?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(str);
      ps.setString(1,txtbno.getText());
      ps.setString(2,txtbgroup.getText());
      ps.setString(3,txtbunit.getText());
	  ps.setString(4,"INP");
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null,"saved successfully");
	 // buno=txtbno.getText();
	  
	 // xyz obj=new xyz();
	  //obj.buno=txtbno.getText();
	  this.dispose();
	 // buno=txtbno.getText();

}
catch(Exception ee)
{
  System.out.println(ee);
}
}
if(e.getSource()==bdelete)
{
	try
	{
	
	     Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		 Statement st=con.createStatement();
		 ResultSet res=st.executeQuery("select * from bloodtbl where bno='"+txtbno.getText()+"'");
		 if(res.next())
		 {
		     String str="delete from bloodtbl where bno='"+txtbno.getText()+"'";
             PreparedStatement ps=con.prepareStatement(str);
		     ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Deleted Successfully");
		 }
		 else
	         JOptionPane.showMessageDialog(null,"No such Blood No.");
	}
	 catch(Exception ee)
	 {
	        System.out.println(ee);
     }
}
if(e.getSource()==bedit)
{
 try
 {
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      Statement st=con.createStatement();
      String str="update bloodtbl set bno='"+txtbno.getText()+"',bgroup='"+txtbgroup.getText()+"',bunit='"+txtbunit.getText()+"'where bno='"+txtbno.getText()+"'";
      PreparedStatement ps=con.prepareStatement(str);
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null,"Successfully Modified");
 
  }
catch(Exception eea)
{
System.out.println(eea);
}
}
if(e.getSource()==bsearch)
{
	try
	{
		int flag=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from bloodtbl where bno='"+txtbno.getText()+"'");
		while(res.next())
		{
		   txtbno.setText(res.getString("bno"));
		   txtbgroup.setText(res.getString("bgroup"));
		   txtbunit.setText(res.getString("bunit"));
		   flag=1;
		}
		if(flag==0)
		JOptionPane.showMessageDialog(null,"No such Data");
	}
 	catch(Exception eeee)
	{
		System.out.println(eeee);
	}
}
if(e.getSource()==bcancel)
{
this.dispose();
}
if(e.getSource()==bclear)
{
  txtbno.setText("");
  txtbgroup.setText("");
  txtbunit.setText("");
} 	
}
}



