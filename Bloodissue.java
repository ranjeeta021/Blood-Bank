import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Bloodissue extends JFrame implements ActionListener,ItemListener
{     
      String typ;
      Choice type=new Choice();
	  Date dd=new Date();
	  
	  JLabel Bground=new JLabel(new ImageIcon("pic.png"));
	  ButtonGroup G1=new ButtonGroup();
	  JRadioButton b1=new JRadioButton("Replacement");
	  JRadioButton b2=new JRadioButton("Voluntary");
      JButton bnew=new JButton("New");
      JButton bdelete=new JButton("Delete");
      JButton bclear=new JButton("Clear");
      JButton bedit=new JButton("Edit");
      JButton bsearch=new JButton("Search");
      JButton bsave=new JButton("Save");
      JButton bcancel=new JButton("Cancel");
	     JButton bnewpatient=new JButton("New Patient?");
	  JLabel s2=new JLabel("/"); 
	  JLabel s1=new JLabel("/"); 
	  JLabel lblbiissuetype=new JLabel("Issue type:");
	  Label lblbiissue=new Label("BLOOD ISSUE");
      JLabel lblbidate=new JLabel("Date:"); 
      JLabel lblbitype=new JLabel("Type:"); 
      JLabel lblpno=new JLabel("Issued To:"); 
	  JLabel lblbipno=new JLabel("(Patient No:)");
      JLabel lblbiunit=new JLabel("No of units:");
      JLabel lblbno=new JLabel("Blood Unit No:");  
      JLabel lblbigroup=new JLabel("Blood Group:");  
	  JTextField d=new JTextField();
	  JTextField m=new JTextField();
	  JTextField y=new JTextField();
      JTextField txtbitype=new JTextField();
      JTextField txtpno=new JTextField();
	  JTextField txtbiunit=new JTextField();
	  JTextField txtbno=new JTextField();
	  JTextField txtbigroup=new JTextField();


   public static void main(String argv[])throws IOException
{
     Bloodissue ob=new Bloodissue();
}

   public Bloodissue()
   {
     setLayout(null);
	 setTitle("Bloodissue Form");
     setSize(2000,2000);
     lblbiissue.setFont(new Font("Times New Roman",Font.BOLD,30));
     //lblbiissue.setForeground(new Color(200,150,100));  
     //lblbiissuetype.setForeground(new Color(255,0,0));
	 lblbipno.setFont(new Font("Comic Sans MS",Font.ITALIC,10));
	 setVisible(true);
     s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     s2.setFont(new Font("Times New Roman",Font.BOLD,25));
     bnew.setBounds(250,450,100,40);
	 bdelete.setBounds(370,450,100,40);
     bedit.setBounds(490,450,100,40);
     bsearch.setBounds(610,450,100,40);
     bsave.setBounds(730,450,100,40);
     bcancel.setBounds(850,450,100,40);
     bclear.setBounds(970,450,100,40);
	 bnewpatient.setBounds(450,287,110,25);
	 
     lblbiissue.setBounds(550,30,250,30);
     lblbidate.setBounds(300,150,100,25);
     lblbitype.setBounds(300,200,100,25);
	 lblbiissuetype.setBounds(650,150,100,25);
	 
     lblpno.setBounds(300,250,100,25);
	 lblbipno.setBounds(300,270,100,15);
	 lblbigroup.setBounds(300,325,100,25);
	 lblbiunit.setBounds(650,250,100,25);
	 lblbno.setBounds(650,300,100,25);
     d.setBounds(425,150,25,25);
     s1.setBounds(455,150,25,25);
     m.setBounds(475,150,25,25);
     s2.setBounds(505,150,25,25);
     y.setBounds(525,150,50,25);
	 type.setBounds(425,200,100,25);
	 b1.setBounds(775,150,100,25);
	 b2.setBounds(775,175,100,25);
     txtpno.setBounds(425,250,150,25);
	 txtbigroup.setBounds(425,325,150,25);
	 txtbiunit.setBounds(775,250,100,25);
	 txtbno.setBounds(775,300,100,25);
	 Bground.setBounds(0,0,1350,770);

     add(bnew);
	 add(bdelete);
     add(bedit);
     add(bsearch);
     add(bsave);
     add(bcancel);
     add(bclear);
	 add(bnewpatient);
     add(lblbiissue);
	 add(lblbidate);
     add(lblbitype);
	 add(lblbiissuetype);
     add(lblpno);
	 add(lblbno);
	 add(lblbipno);
	 add(lblbigroup);
	 add(lblbiunit);
	 add(d);
	 add(s1);
	 add(m);
	 add(s2);
     add(y);

	 add(type);
     add(txtpno);
	 add(txtbigroup);
	 add(txtbno);
     add(txtbiunit);
		type.add("RBC");
		type.add("Plasma");
		type.add("Platelets");	
		add(b1);
		add(b2);
//	 add(G1);
	 G1.add(b1);
	 G1.add(b2);
	 b1.setBackground(new Color(255,242,229));
	 b2.setBackground(new Color(255,242,229));
	 lblbiissue.setBackground(new Color(255,242,229));
	 add(Bground);
	 
//	 G1.addItemListener(this);
	 type.addItemListener(this);							
     bnew.addActionListener(this);
     bdelete.addActionListener(this);
     bedit.addActionListener(this);
     bsave.addActionListener(this);
     bsearch.addActionListener(this);
     bcancel.addActionListener(this);
     bclear.addActionListener(this);
	 bnewpatient.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bnew)
{
   try
   {
      Connection con;
     con=DriverManager.getConnection("jdbc:odbc:blooddsn");
     ResultSet  res;
     Statement st=con.createStatement();
     res=st.executeQuery("Select * from bloodissuetbl");
	 DateFormat f1= new SimpleDateFormat("dd");
     d.setText(f1.format(dd));
     DateFormat f2= new SimpleDateFormat("MM");
     m.setText(f2.format(dd));
	 DateFormat f3= new SimpleDateFormat("yyyy");
     y.setText(f3.format(dd)); 
	 txtpno.setText("");
	 txtbno.setText("");
	 txtbiunit.setText("");
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
	  
	  Connection con1;
      con1=DriverManager.getConnection("jdbc:odbc:blooddsn");
      ResultSet  res1;
      Statement st1=con1.createStatement();
      //res1=st1.executeQuery("Select * from bloodtbl");
      String str1="update bloodtbl set bstatus='Discharged' where bno='"+txtbno.getText()+"'";
      PreparedStatement ps1=con1.prepareStatement(str1);
	  
	  
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      ResultSet  res;
      Statement st=con.createStatement();
      res=st.executeQuery("Select * from bloodissuetbl");
      String str="insert into bloodissuetbl(bidate,bitype,pno,biunit,bno)values(?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(str);
	  ps.setString(2,typ);
      ps.setString(3,txtpno.getText());
	  ps.setString(4,txtbiunit.getText());
	  ps.setString(5,txtbno.getText());
      String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	  ps.setString(1,tdate);	  
	  if(flg==1)
	  {
		  ps1.executeUpdate();
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
if(e.getSource()==bdelete)
{
	try
	{
	
	     Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		 Statement st=con.createStatement();
	     String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();

		 ResultSet res=st.executeQuery("select * from bloodissuetbl where bidate='"+tdate+"'");
		 if(res.next())
		 {
		     String str="delete from bloodissuetbl where bidate='"+tdate+"'";
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
      String str="update bloodissuetbl set bidate='"+tdate+"',bitype='"+typ+"',pno='"+txtpno.getText()+"',biunit='"+txtbiunit.getText()+"',bno='"+txtbno.getText()+"'where bidate='"+tdate+"'";
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
if(e.getSource()==bsearch)
{
	try
	{
		int flag=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();

		ResultSet res=st.executeQuery("select * from bloodissuetbl where bidate='"+tdate+"'");
		while(res.next())
		{
           String date=res.getString("bidate");
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
		   String s=res.getString("bitype");
		   if(s.equals("RBC"))
			type.select(0);
		   else if(s.equals("Plasma"))
			type.select(1);
		   else 
			type.select(2);
		   txtpno.setText(res.getString("pno"));
		   txtbno.setText(res.getString("bno"));
		   txtbiunit.setText(res.getString("biunit"));


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
  d.setText("");
  m.setText("");
  y.setText("");
  txtpno.setText("");
  txtbno.setText("");
  txtbiunit.setText("");
}
if(e.getSource()==bnewpatient)
{
	new Patient();
}
} 	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public void itemStateChanged(ItemEvent ie)
{
	if(type.getSelectedItem()=="RBC")
	  {
	  typ="RBC";
	  }
	else if(type.getSelectedItem()=="Plasma")
	  {
	  typ="Plasma";
	  }
	  else
	  {
		  typ="Platelets";
	  }

    String sel=G1.getSelection().getActionCommand();
	if(ie.getStateChange()==ItemEvent.SELECTED)
	{
		if(sel.equals("Voluntary"))
		{
			
		}	
		else if(sel.equals("Replacement"))
		{
			
		}			
			
	}
}
}


