import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Staff extends JFrame implements ActionListener    
{  
   String tgender;
   Date dd=new Date();
   Choice gender=new Choice();
   ButtonGroup grp=new ButtonGroup();
   JRadioButton rb1=new JRadioButton("Male");
   JRadioButton rb2=new JRadioButton("Female");
   JButton bnew=new JButton("New");
   JButton bdelete=new JButton("Delete");
   JButton bclear=new JButton("Clear");
   JButton bedit=new JButton("Edit");
   JButton bsearch=new JButton("Search");
   JButton bsave=new JButton("Save");
   JButton bcancel=new JButton("Cancel");
   JLabel s1=new JLabel("/"); 
   JLabel s2=new JLabel("/"); 
JLabel lblstaff=new JLabel("Staff Form"); 
   JLabel lblseno=new JLabel("Employee No.:");
   JLabel lblsdoj=new JLabel("Date of Joining:");
   JLabel lblsname=new JLabel("Name");
   JLabel lblsadd=new JLabel("Address");
   JLabel lblsgender=new JLabel("Gender:");
   JLabel lblsquali=new JLabel("Qualification:");
   JLabel lblscontact=new JLabel("Contact No.:");
   JLabel lblsdesig=new JLabel("Designation:");  
   JLabel lblsemail=new JLabel("E-mail id:"); 
   JTextField txtseno=new JTextField();
   JTextField d=new JTextField();
   JTextField m=new JTextField();
   JTextField y=new JTextField();
   JTextField txtsname=new JTextField();
   JTextField txtsadd=new JTextField();
   JTextField txtsquali=new JTextField();
   JTextField txtscontact=new JTextField();
   JTextField txtsdesig=new JTextField();
   JTextField txtsemail=new JTextField();
   JLabel Bground=new JLabel(new ImageIcon("pic.png"));
   public static void main(String argv[])throws IOException
{
     Staff ob=new Staff();
}

   public Staff()
   {
     setLayout(null);
     setSize(2000,2000);
     lblstaff.setFont(new Font("Times New Roman",Font.BOLD,30));
     lblstaff.setBackground(new Color(200,150,100));  
	 s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     s2.setFont(new Font("Times New Roman",Font.BOLD,25));
     setVisible(true);
     bnew.setBounds(300,450,100,40);
     bdelete.setBounds(420,450,100,40);
     bedit.setBounds(540,450,100,40);
     bsearch.setBounds(660,450,100,40);
     bsave.setBounds(780,450,100,40);
     bcancel.setBounds(900,450,100,40);
     bclear.setBounds(1020,450,100,40);
     lblstaff.setBounds(550,30,300,50);
     lblseno.setBounds(300,150,100,25);
     lblsdoj.setBounds(700,150,100,25);
     lblsname.setBounds(300,200,100,25);
     lblsadd.setBounds(700,200,100,25);
     lblsgender.setBounds(300,250,100,25);
     lblsquali.setBounds(300,300,100,25);
     lblscontact.setBounds(700,300,100,25);
     lblsdesig.setBounds(300,350,100,25);
     lblsemail.setBounds(700,350,100,25);
     txtseno.setBounds(400,150,100,25); 
	 d.setBounds(800,150,25,25);
     s1.setBounds(830,150,25,25);
     m.setBounds(850,150,25,25);
     s2.setBounds(880,150,25,25);
     y.setBounds(900,150,50,25);
     txtsname.setBounds(400,200,250,25);
     txtsadd.setBounds(800,200,250,25);
	 rb1.setBounds(400,250,100,20);
	 rb2.setBounds(520,250,100,20);
     txtsquali.setBounds(400,300,250,25);
     txtscontact.setBounds(800,300,250,25);
     txtsdesig.setBounds(400,350,250,25);
     txtsemail.setBounds(800,350,250,25);
	 Bground.setBounds(0,0,1350,770);
     add(bnew);
     add(bdelete);
     add(bedit);
     add(bsearch);
     add(bsave);
     add(bcancel);
     add(bclear);
     add(lblstaff);
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
	 add(d);
	 add(s1);
	 add(m);
	 add(s2);
     add(y);
     add(txtsname);
     add(txtsadd);
     add(txtsquali);
     add(txtscontact);
     add(txtsdesig);
     add(txtsemail);
	 add(rb1);
	 add(rb2);
	 grp.add(rb1);
	 grp.add(rb2);
    add(Bground);
	bnew.addActionListener(this);
     bdelete.addActionListener(this);
     bsave.addActionListener(this);
     bcancel.addActionListener(this);
     bedit.addActionListener(this);
     bsearch.addActionListener(this);
     bclear.addActionListener(this);
	 rb1.addActionListener(this);
	 rb2.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==rb1)
		tgender="Male";
	if(e.getSource()==rb2)
		tgender="Female";
if(e.getSource()==bnew)
{
   try
   {
    int ctr=1;
      Connection con;
     con=DriverManager.getConnection("jdbc:odbc:blooddsn");
     ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("Select * from stafftbl");
 while(res.next())
   {
      ctr++;
    }
   
  txtseno.setText(""+ctr);
  DateFormat f1= new SimpleDateFormat("dd");
     d.setText(f1.format(dd));
     DateFormat f2= new SimpleDateFormat("MM");
     m.setText(f2.format(dd));
	 DateFormat f3= new SimpleDateFormat("yyyy");
     y.setText(f3.format(dd)); 
  txtsname.setText("");
  txtsadd.setText("");
  txtsquali.setText("");
  txtscontact.setText("");
  txtsdesig.setText("");
  txtsemail.setText("");
  }
 catch(Exception ee)
{
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
     Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      ResultSet  res;
      Statement st=con.createStatement();
      res=st.executeQuery("Select * from stafftbl");
      String str="insert into stafftbl(seno,sdoj,sname,sadd,sgender,squali,scontact,sdesig,semail) values(?,?,?,?,?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(str);
      ps.setInt(1,Integer.parseInt(txtseno.getText()));
      ps.setString(3,txtsname.getText());
      ps.setString(4,txtsadd.getText());
      ps.setString(5,tgender);
      ps.setString(6,txtsquali.getText());
      ps.setString(7,txtscontact.getText());
      ps.setString(8,txtsdesig.getText());
      ps.setString(9,txtsemail.getText());
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
System.out.println(eee);
}
}
if(e.getSource()==bsearch)
{
	try
	{
		int flag=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from stafftbl where seno="+txtseno.getText());
		while(res.next())
		{
		   txtseno.setText(String.valueOf(res.getInt("seno")));
		   txtsname.setText(res.getString("sname"));
		   String ch=res.getString("sgender");
		   if(ch.equalsIgnoreCase("Male"))
			rb1.setSelected(true);
		   else if(ch.equalsIgnoreCase("Female"))
			rb2.setSelected(true);
		   txtsquali.setText(res.getString("squali"));
		   txtsdesig.setText(res.getString("sdesig"));
		   String date=res.getString("sdoj");
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
		   txtsadd.setText(res.getString("sadd"));
		   txtscontact.setText(res.getString("scontact"));
		   txtsemail.setText(res.getString("semail"));
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
      String str="update stafftbl set sname='"+txtsname.getText()+"',sgender='"+tgender+"',squali='"+txtsquali.getText()+"',sdesig='"+txtsdesig.getText()+"',sdoj='"+tdate+"',sadd='"+txtsadd.getText()+"',semail='"+txtsemail.getText()+"',scontact='"+txtscontact.getText()+"'where seno="+txtseno.getText();
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
System.out.println(eea);
}
}
if(e.getSource()==bclear)
{
  txtseno.setText("");
  d.setText("");
  m.setText("");
  y.setText("");
  txtsname.setText("");
  txtsadd.setText("");
  txtsquali.setText("");
  txtscontact.setText("");
  txtsdesig.setText("");
  txtsemail.setText("");
}
if(e.getSource()==bdelete)
{
	try
	{
	
	        Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from stafftbl where seno="+txtseno.getText());
		if(res.next())
		{
		String str="delete from stafftbl where seno="+txtseno.getText();
                PreparedStatement ps=con.prepareStatement(str);
		ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
		}
		else
	        JOptionPane.showMessageDialog(null,"No such Employee No.");
	}
	catch(Exception ee)
	{
	        System.out.println(ee);
        }
} 	
}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*public void itemStateChanged(ItemEvent ie)
{
if(gender.getSelectedItem()=="Female")
  {
  tgender="Female";
  }
else
  {
  tgender="Male";
  }
}*/
public static int check_Date(int dd, int mm, int yy)
{
	int flg=0;
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
	  return(flg);
}
}