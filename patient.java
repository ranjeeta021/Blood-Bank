import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class Patient extends JFrame implements ActionListener
{  
   Date dd=new Date();
   JButton bnew=new JButton("New");
   JButton bdelete=new JButton("Delete");
   JButton bedit=new JButton("Edit");
   JButton bsearch=new JButton("Search");
   JButton bsave=new JButton("Save");
   JButton bclear=new JButton("Clear");
   JButton bcancel=new JButton("Cancel");
   JLabel lblpatient=new JLabel("Patient Information"); 
   JLabel lblpno=new JLabel("Patient No:"); 
   JLabel lblpname=new JLabel("Name:"); 
   JLabel lblpadd=new JLabel("Address:");
   JLabel lblpcontact=new JLabel("Contact No:"); 
   JLabel lblpgroup=new JLabel("Blood Group"); 
   JLabel lblpdate=new JLabel("Date");
   JLabel s1=new JLabel("/"); 
   JLabel s2=new JLabel("/"); 
   JLabel _s1=new JLabel("/"); 
   JLabel _s2=new JLabel("/"); 

   JLabel lblpdob=new JLabel("D.O.B"); 
   JLabel lblpcity=new JLabel("City"); 
   JLabel lblppin=new JLabel("Pin");
   
   JTextField txtpno=new JTextField();
   JTextField txtpname=new JTextField();
   JTextField txtpadd=new JTextField();
   JTextField txtpcontact=new JTextField();
   JTextField txtpgroup=new JTextField();
   JTextField d=new JTextField();
   JTextField m=new JTextField();
   JTextField y=new JTextField();
   JTextField _d=new JTextField();
   JTextField _m=new JTextField();
   JTextField _y=new JTextField();
//   JTextField txtpdob=new JTextField();
   JTextField txtpcity=new JTextField();
   JTextField txtppin=new JTextField();
   JLabel Bground=new JLabel(new ImageIcon("pic.png"));
   
   public static void main(String argv[])throws IOException
{
     Patient ob=new Patient();
}

   public Patient()
   {
     setLayout(null);
     setSize(2000,2000);
     lblpatient.setFont(new Font("Times New Roman",Font.BOLD,30));
     lblpatient.setBackground(new Color(200,150,100));  
     s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     s2.setFont(new Font("Times New Roman",Font.BOLD,25));
     _s1.setFont(new Font("Times New Roman",Font.BOLD,25));
     _s2.setFont(new Font("Times New Roman",Font.BOLD,25));
     setVisible(true);
     bnew.setBounds(250,450,100,40);
	 bdelete.setBounds(370,450,100,40);
     bedit.setBounds(490,450,100,40);
     bsearch.setBounds(610,450,100,40);
     bsave.setBounds(730,450,100,40);
     bcancel.setBounds(850,450,100,40);
     bclear.setBounds(970,450,100,40);
     lblpatient.setBounds(500,30,300,50);
     lblpno.setBounds(300,150,100,25);
     lblpname.setBounds(300,200,100,25);
     lblpadd.setBounds(300,250,100,25);
	 lblpcontact.setBounds(300,350,100,25);
     lblpgroup.setBounds(300,400,100,25);
     lblpdate.setBounds(725,150,100,25); 
	 lblpdob.setBounds(725,200,100,25);
     lblpcity.setBounds(725,250,100,25);
     lblppin.setBounds(725,300,100,25);
     txtpno.setBounds(425,150,250,25);
     txtpname.setBounds(425,200,250,25);
     txtpadd.setBounds(425,250,250,75);
	 txtpcontact.setBounds(425,350,250,25);
     txtpgroup.setBounds(425,400,100,25);
     d.setBounds(850,150,25,25);
     s1.setBounds(880,150,25,25);
     m.setBounds(900,150,25,25);
     s2.setBounds(930,150,25,25);
     y.setBounds(950,150,50,25);

     _d.setBounds(850,200,25,25);
     _s1.setBounds(880,200,25,25);
     _m.setBounds(900,200,25,25);
     _s2.setBounds(930,200,25,25);
     _y.setBounds(950,200,50,25);
	 
//	 txtpdob.setBounds(850,200,100,25);
     txtpcity.setBounds(850,250,250,25);
     txtppin.setBounds(850,300,250,25);
	 
	 Bground.setBounds(0,0,1350,770);
	 
     
     add(bnew);
	 add(bdelete);
     add(bedit);
     add(bsearch);
     add(bsave);
     add(bcancel);
     add(bclear);
     add(lblpatient);
	 add(lblpno);
     add(lblpname);
     add(lblpadd);
	 add(lblpcontact);
     add(lblpgroup);
     add(lblpdate);
	 add(lblpdob);
     add(lblpcity);
     add(lblppin); 
     add(txtpno);
     add(txtpname);
     add(txtpadd);
	 add(txtpcontact);
     add(txtpgroup);
	 add(d);
	 add(s1);
	 add(m);
	 add(s2);
     add(y);

	 add(_d);
	 add(_s1);
	 add(_m);
	 add(_s2);
     add(_y);
	 
 //    add(txtpdob);
     add(txtpcity);
     add(txtppin);
	 
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
      int ctr=1;
      Connection con;
     con=DriverManager.getConnection("jdbc:odbc:blooddsn");
     ResultSet  res;
     Statement st=con.createStatement();
     res=st.executeQuery("Select * from patienttbl");
     while(res.next())
     {
      ctr++;
     }
     txtpno.setText(""+ctr);
	 DateFormat f1= new SimpleDateFormat("dd");
     d.setText(f1.format(dd));
     DateFormat f2= new SimpleDateFormat("MM");
     m.setText(f2.format(dd));
	 DateFormat f3= new SimpleDateFormat("yyyy");
     y.setText(f3.format(dd)); 
     txtpname.setText("");
 //    txtpdob.setText("");
     _d.setText("");
	 _m.setText("");
	 _y.setText("");

     txtpadd.setText("");
     txtpcity.setText("");
     txtppin.setText("");
     txtpcontact.setText("");
     txtpgroup.setText("");

	 }
     catch(Exception ee)
 {
}
 }
 if(e.getSource()==bdelete)
{
	try
	{
	    
	    Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from patienttbl where pno="+txtpno.getText());
		if(res.next())
		{
		String str="delete from patienttbl where pno="+txtpno.getText();
                PreparedStatement ps=con.prepareStatement(str);
		ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
		}
		else
	        JOptionPane.showMessageDialog(null,"No such Patient No.");
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
	  int dd,mm,yy,flg=0,_flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  flg=check_Date(dd,mm,yy);
	  dd=Integer.parseInt(_d.getText());
	  mm=Integer.parseInt(_m.getText());
	  yy=Integer.parseInt(_y.getText());
	  _flg=check_Date(dd,mm,yy);

	  String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	  String _tdate=_d.getText()+"/"+_m.getText()+"/"+_y.getText();

      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      Statement st=con.createStatement();
      String str="update patienttbl set pdate='"+tdate+"',pname='"+txtpname.getText()+"',pdob='"+_tdate+"',padd='"+txtpadd.getText()+"',pcity='"+txtpcity.getText()+"',ppin='"+txtppin.getText()+"',pcontact='"+txtpcontact.getText()+"',pgroup='"+txtpgroup.getText()+"' where pno="+txtpno.getText();
      PreparedStatement ps=con.prepareStatement(str);
	  if((flg==1)&&(_flg==1))
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"Modified succesfully");
	  }
	  else
	  {
		  if(flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date!");
		  }
		  else if(_flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date Of Birth!");
		  }

	  } 
  }
catch(Exception ea)
{
System.out.println(ea);
}
}
if(e.getSource()==bsearch)
{
	try
	{
		int flag=0;
		Connection con=DriverManager.getConnection("jdbc:odbc:blooddsn");
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from patienttbl where pno="+txtpno.getText());
		while(res.next())
		{
		   txtpno.setText(String.valueOf(res.getInt("pno")));
		   txtpname.setText(res.getString("pname"));
		  /* if(gender.getSelectedItem().equals("female"))
			gender.select(0);
		   else
			gender.select(1);*/
		   String date=res.getString("pdate");
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

		   String _date=res.getString("pdob");
		   String _dd,_mm,_yy;
		   int _i1,_i2;
		   _i1=_date.indexOf('/');
		   _i2=_date.lastIndexOf('/');
		   _dd=_date.substring(0,_i1);
		   _mm=_date.substring((_i1+1),_i2);
		   _yy=_date.substring((_i2+1));
		   _d.setText(_dd);
		   _m.setText(_mm);
		   _y.setText(_yy);		   
		   
//		   txtpdob.setText(res.getString("pdob"));
		   txtpadd.setText(res.getString("padd"));
		   txtpcity.setText(res.getString("pcity"));
		   txtppin.setText(res.getString("ppin"));
		   txtpcontact.setText(res.getString("pcontact"));
		   txtpgroup.setText(res.getString("pgroup"));
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
 if(e.getSource()==bsave)
{
      try
   {
	  int dd,mm,yy,flg=0,_flg=0;
	  dd=Integer.parseInt(d.getText());
	  mm=Integer.parseInt(m.getText());
	  yy=Integer.parseInt(y.getText());
	  flg=check_Date(dd,mm,yy);
	  dd=Integer.parseInt(_d.getText());
	  mm=Integer.parseInt(_m.getText());
	  yy=Integer.parseInt(_y.getText());
	  _flg=check_Date(dd,mm,yy);  
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:blooddsn");
      ResultSet  res;
      Statement st=con.createStatement();
      res=st.executeQuery("Select * from patienttbl");
      String str="insert into patienttbl(pno,pdate,pname,pdob,padd,pcity,ppin,pcontact,pgroup)values(?,?,?,?,?,?,?,?,?)";
      PreparedStatement ps=con.prepareStatement(str);
      ps.setInt(1,Integer.parseInt(txtpno.getText()));
      ps.setString(3,txtpname.getText());
      String _tdate=_d.getText()+"/"+_m.getText()+"/"+_y.getText();
      ps.setString(4,_tdate);
      ps.setString(5,txtpadd.getText());
      ps.setString(6,txtpcity.getText());
      ps.setString(7,txtppin.getText());
      ps.setString(8,txtpcontact.getText());
      ps.setString(9,txtpgroup.getText());
      String tdate=d.getText()+"/"+m.getText()+"/"+y.getText();
	  ps.setString(2,tdate);	  
	  if((flg==1)&&(_flg==1))
	  {
		  ps.executeUpdate();
          JOptionPane.showMessageDialog(null,"saved succesfully");
		  this.dispose();
	  }
	  else
	  {
		  if(flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date!");
		  }
		  else if(_flg!=1)
		  {
			JOptionPane.showMessageDialog(null,"Invalid Date Of Birth!");
		  }
	  }
    }
    catch(Exception ee)
    {
     System.out.println(ee);
    }
}
if(e.getSource()==bcancel)
{
this.dispose();
}
if(e.getSource()==bclear)
{
  txtpno.setText("");
  txtpname.setText("");
  d.setText("");
  m.setText("");
  y.setText("");
  _d.setText("");
  _m.setText("");
  _y.setText("");

  //txtpdob.setText("");
  txtpadd.setText("");
  txtpcity.setText("");
  txtppin.setText("");
  txtpcontact.setText("");
  txtpgroup.setText("");
}
 }
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